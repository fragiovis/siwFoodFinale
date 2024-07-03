package it.uniroma3.siw.controller;

import it.uniroma3.siw.model.Account;
import it.uniroma3.siw.model.Cuoco;
import it.uniroma3.siw.service.AccountService;
import it.uniroma3.siw.service.CuocoService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.util.Date;
import java.util.List;

@Controller
public class AuthenticationController {

    @Autowired
    private AccountService accountService;
    @Autowired
    private CuocoService cuocoService;

    @GetMapping("/login")
    public String showLoginForm() {
        return "login"; // Nome del file HTML della pagina di login
    }

    @PostMapping("/login")
    public String login() {
        // Questa mappatura è gestita automaticamente da Spring Security
        return "redirect:/welcome"; // Successo di login
    }



    @GetMapping("/register")
    public String showRegisterForm() {
        return "register";
    }

    @PostMapping("/register")
    public String registerUser(@RequestParam String username,
                               @RequestParam String password,
                               @RequestParam String name,
                               @RequestParam String surname,
                               @RequestParam("dateOfBirth") @DateTimeFormat(pattern = "yyyy-MM-dd") Date dateOfBirth,
                               @RequestParam("immagine") MultipartFile immagine,
                               RedirectAttributes redirectAttributes,
                               Model model) {
        try {
            String immagineFileName = saveImage(immagine);
            accountService.registerUser(username, password, name, surname, dateOfBirth, immagineFileName);
            List<Cuoco> cuochi = cuocoService.findAll();
            model.addAttribute("cuochi", cuochi);
            return "/login";
        } catch (Exception e) {
            model.addAttribute("error", "Username già esistente");
            return "register";  // Assumi che ci sia una pagina di registrazione per gestire gli errori
        }
    }

    @GetMapping("/admin/register")
    public String showRegisterFormAdmin() {
        return "register-admin";
    }

    @PostMapping("/admin/register")
    public String registerUserAdmin(@RequestParam String username,
                                    @RequestParam String password,
                                    @RequestParam String name,
                                    @RequestParam String surname,
                                    @RequestParam("dateOfBirth") @DateTimeFormat(pattern = "yyyy-MM-dd") Date dateOfBirth,
                                    @RequestParam("immagine") MultipartFile immagine,
                                    RedirectAttributes redirectAttributes,
                                    Model model) {
        try {
            String immagineFileName = saveImage(immagine);
            accountService.registerUser(username, password, name, surname, dateOfBirth, immagineFileName);
            List<Cuoco> cuochi = cuocoService.findAll();
            model.addAttribute("cuochi", cuochi);
            return "indexCuoco-admin";
        } catch (Exception e) {
            model.addAttribute("error", "Username già esistente");
            return "register-admin";  // Assumi che ci sia una pagina di registrazione per gestire gli errori
        }
    }

    private String saveImage(MultipartFile immagine) throws IOException {
        String immagineFileName = System.currentTimeMillis() + "_" + immagine.getOriginalFilename(); // Assicurati che il nome del file sia unico
        Path uploadPath = Paths.get("src/main/resources/static/images/uploads/account-photos"); // Percorso assoluto

        if (!Files.exists(uploadPath)) {
            Files.createDirectories(uploadPath);
            System.out.println("Created directories: " + uploadPath.toString());
        }

        Path imageFilePath = uploadPath.resolve(immagineFileName);
        Files.write(imageFilePath, immagine.getBytes());
        System.out.println("Image saved at: " + imageFilePath.toString());

        return immagineFileName;
    }

    @GetMapping("/logout")
    public String logout(HttpServletRequest request, HttpServletResponse response) {
        HttpSession session = request.getSession(false);
        if (session != null) {
            session.invalidate(); // Invalida la sessione esistente
        }
        return "redirect:/"; // Reindirizza alla pagina home dopo il logout
    }



}
