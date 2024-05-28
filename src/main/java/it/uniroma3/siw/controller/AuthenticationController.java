package it.uniroma3.siw.controller;

import it.uniroma3.siw.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Date;

@Controller
public class AuthenticationController {

    @Autowired
    private AccountService accountService;

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
                               @RequestParam("dateOfBirth") @DateTimeFormat(pattern = "yyyy-MM-dd") Date dateOfBirth){
        accountService.registerUser(username, password, name, surname, dateOfBirth);
        return "index-chef";
    }


}
