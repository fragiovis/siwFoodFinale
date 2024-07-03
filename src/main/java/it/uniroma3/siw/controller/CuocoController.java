package it.uniroma3.siw.controller;

import java.util.ArrayList;
import java.util.List;

import it.uniroma3.siw.model.Account;
import it.uniroma3.siw.model.Credentials;
import it.uniroma3.siw.model.Cuoco;
import it.uniroma3.siw.model.Ricetta;
import it.uniroma3.siw.repository.CredentialsRepository;
import it.uniroma3.siw.service.CredentialsService;
import it.uniroma3.siw.service.CuocoService;
import it.uniroma3.siw.service.RicettaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class CuocoController {
    @Autowired
    private CuocoService cuocoService;
    @Autowired
    private RicettaService ricettaService;


    @GetMapping("/cuoco/{id}")
    public String getCuoco(@PathVariable("id") Long id, Model model) {
        Cuoco cuoco = this.cuocoService.findById(id);
        model.addAttribute("cuoco", cuoco);
        List<Ricetta> ricette = cuoco.getRicette();
        model.addAttribute("ricette", ricette);
        return "cuoco.html";
    }

    @GetMapping("/admin/cuoco/{id}")
    public String getCuocoAdmin(@PathVariable("id") Long id, Model model) {
        Cuoco cuoco = this.cuocoService.findById(id);
        model.addAttribute("cuoco", cuoco);
        List<Ricetta> ricette = cuoco.getRicette();
        model.addAttribute("ricette", ricette);
        return "cuoco-admin.html";
    }

    @GetMapping("/chef/cuoco/{id}")
    public String getCuocoChef(@PathVariable("id") Long id, Model model) {
        Cuoco cuoco = this.cuocoService.findById(id);
        model.addAttribute("cuoco", cuoco);
        List<Ricetta> ricette = cuoco.getRicette();
        model.addAttribute("ricette", ricette);
        return "cuoco-chef.html";
    }

    @GetMapping("/cuochi")
    public String showCuochi(Model model) {
        model.addAttribute("cuochi", this.cuocoService.findAll());
        return "cuochi.html";
    }

    @GetMapping("/formNewCuoco")
    public String formNewCuoco(Model model) {
        model.addAttribute("cuoco", new Cuoco());
        return "formNewCuoco.html";
    }

    @PostMapping("/cuoco")
    public String newCuoco(@ModelAttribute("cuoco") Cuoco cuoco, Model model) {
        this.cuocoService.save(cuoco);
        model.addAttribute("cuoco", cuoco);
        return "redirect:cuoco/"+cuoco.getId();
    }

    @GetMapping("/formSearchCuochi")
    public String formSearchCuochi() {
        return "formSearchCuochi.html";
    }

    @PostMapping("/searchCuochi")
    public String searchCuochi(Model model, @RequestParam String surname) {
        model.addAttribute("cuochi", this.cuocoService.findBySurname(surname));
        return "foundCuochi.html";
    }

    @GetMapping("/indexCuoco")
    public String indexCuoco(Model model) {
        model.addAttribute("cuochi", this.cuocoService.findAll());
        return "indexCuoco.html";
    }
    @GetMapping("/admin/indexCuoco")
    public String indexCuocoAdmin(Model model) {
        model.addAttribute("cuochi", this.cuocoService.findAll());
        return "indexCuoco-admin.html";
    }

    @GetMapping("/chef/indexCuoco")
    public String indexCuocoChef(Model model) {
        model.addAttribute("cuochi", this.cuocoService.findAll());
        return "indexCuoco-chef.html";
    }


    @GetMapping("/admin/deleteCuoco/{id}")
    public String showDeleteConfirmation(@PathVariable("id") Long id, Model model) {
        Cuoco cuoco = cuocoService.findById(id);
        if (cuoco == null) {
            // Gestisci il caso in cui il cuoco non sia trovato (ad esempio, reindirizza a una pagina di errore o gestisci l'errore in altro modo)
            return "redirect:/admin/indexCuoco";
        }
        model.addAttribute("cuoco", cuoco);
        return "confirmDeleteCuoco.html";
    }

    @PostMapping("/admin/deleteCuoco/{id}")
    public String deleteCuoco(@PathVariable("id") Long id, RedirectAttributes redirectAttributes) {
        try {
            cuocoService.deleteById(id);
            redirectAttributes.addFlashAttribute("successMessage", "Cuoco cancellato con successo!");
        } catch (Exception e) {
            redirectAttributes.addFlashAttribute("errorMessage", "Errore nella cancellazione del cuoco: " + e.getMessage());
        }
        return "redirect:/admin/indexCuoco";
    }

}
