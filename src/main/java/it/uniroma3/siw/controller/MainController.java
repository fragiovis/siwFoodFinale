package it.uniroma3.siw.controller;

import it.uniroma3.siw.model.Account;
import it.uniroma3.siw.model.Credentials;
import it.uniroma3.siw.model.Cuoco;
import it.uniroma3.siw.repository.CredentialsRepository;
import it.uniroma3.siw.service.CuocoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.ArrayList;
import java.util.List;

@Controller
public class MainController {
    @Autowired
    private CredentialsRepository credentialsRepository;
    @Autowired
    private CuocoService cuocoService;

    @GetMapping("/")
    public String index(Model model) {
        List<Cuoco> cuochi = new ArrayList<>();
        Long idHeinz= 4200L;
        Long idBarbieri = 4300L;
        Long idMassari = 4400L;
        cuochi.add(cuocoService.findById(idHeinz));
        cuochi.add(cuocoService.findById(idBarbieri));
        cuochi.add(cuocoService.findById(idMassari));
        model.addAttribute("cuochi", cuochi);
        return "index.html";
    }

    @GetMapping("/admin/index")
    public String showAdminIndex(Model model) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if (authentication != null && authentication.isAuthenticated()) {
            String username = authentication.getName();
            Credentials credentials = credentialsRepository.findByUsername(username);
            Account account = credentials.getAccount();
            if (account != null) {
                model.addAttribute("account", account);
            }

        }
        List<Cuoco> cuochi = new ArrayList<>();
        Long idRamsay= 4200L;
        Long idBarbieri = 4300L;
        Long idMassari = 4400L;
        cuochi.add(cuocoService.findById(idRamsay));
        cuochi.add(cuocoService.findById(idBarbieri));
        cuochi.add(cuocoService.findById(idMassari));
        model.addAttribute("cuochi", cuochi);
        return "index-admin";
    }

    @GetMapping("/chef/index")
    public String showChefIndex(Model model) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if (authentication != null && authentication.isAuthenticated()) {
            String username = authentication.getName();
            Credentials credentials = credentialsRepository.findByUsername(username);
            Account account = credentials.getAccount();
            Cuoco cuoco = account.getCuoco();
            if (cuoco != null) {
                model.addAttribute("cuoco", cuoco);
            }

        }
        List<Cuoco> cuochi = new ArrayList<>();
        Long idRamsay= 4200L;
        Long idBarbieri = 4300L;
        Long idMassari = 4400L;
        cuochi.add(cuocoService.findById(idRamsay));
        cuochi.add(cuocoService.findById(idBarbieri));
        cuochi.add(cuocoService.findById(idMassari));
        model.addAttribute("cuochi", cuochi);
        return "index-chef";
    }

    @GetMapping("/chef/profilo")
    public String showProfiloCuoco(Model model) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if (authentication != null && authentication.isAuthenticated()) {
            String username = authentication.getName();
            Credentials credentials = credentialsRepository.findByUsername(username);
            Account account = credentials.getAccount();
            Cuoco cuoco = account.getCuoco();
            if (cuoco != null) {
                model.addAttribute("cuoco", cuoco);
            }
        }
        return "profilo-chef.html";
    }

    @GetMapping("/admin/profilo")
    public String showProfiloAdmin(Model model) {
            Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
            if (authentication != null && authentication.isAuthenticated()) {
                String username = authentication.getName();
                Credentials credentials = credentialsRepository.findByUsername(username);
                Account account = credentials.getAccount();
                model.addAttribute("account", account);
            }
        return "profilo-admin.html";
    }
}