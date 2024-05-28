package it.uniroma3.siw.controller;

import it.uniroma3.siw.model.Account;
import it.uniroma3.siw.model.Credentials;
import it.uniroma3.siw.repository.CredentialsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MainController {
    @Autowired
    private CredentialsRepository credentialsRepository;

    @GetMapping("/")
    public String index() {
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
        return "index-admin";
    }

    @GetMapping("/chef/index")
    public String showChefIndex(Model model) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if (authentication != null && authentication.isAuthenticated()) {
            String username = authentication.getName();
            Credentials credentials = credentialsRepository.findByUsername(username);
            Account account = credentials.getAccount();
            if (account != null) {
                model.addAttribute("account", account);
            }

        }
        return "index-chef";
    }
}