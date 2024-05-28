package it.uniroma3.siw.controller;

import java.util.ArrayList;
import java.util.List;

import it.uniroma3.siw.model.Cuoco;
import it.uniroma3.siw.model.Ricetta;
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

@Controller
public class CuocoController {
    @Autowired
    private CuocoService cuocoService;
    @Autowired
    private RicettaService ricettaService;

    @GetMapping("/cuoco/{id}")
    public String getCuoco(@PathVariable("id") Long id, Model model) {
        model.addAttribute("cuoco", this.cuocoService.findById(id));
        return "cuoco.html";
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
    public String indexCuoco() {
        return "indexCuoco.html";
    }
    @GetMapping("/admin/indexCuoco")
    public String indexCuocoAdmin(Model model) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String username = authentication.getName(); // Ottiene il nome dell'utente autenticato
        model.addAttribute("username", username);
        return "indexCuoco-admin.html";
    }


    @GetMapping("/managerCuochi")
    public String cuocoManager(Model model) {
        model.addAttribute("cuochi", this.cuocoService.findAll());
        return "managerCuochi.html";
    }

    @GetMapping("/formUpdateCuoco/{id}")
    public String update(@PathVariable("id") Long id, Model model) {
        model.addAttribute("cuoco", this.cuocoService.findById(id));
        return "formUpdateCuoco.html";
    }

    @GetMapping("addRicetta/{id}")
    public String addRicetta(@PathVariable("id") Long id, Model model) {
        model.addAttribute("ricette", this.ricettaService.findAll());
        model.addAttribute("cuoco", this.cuocoService.findById(id));
        return "directorsToAdd.html";
    }

    @GetMapping("setRicettaToCuoco/{ricettaId}/{cuocoId}")
    public String setRicettaToCuoco(@PathVariable("ricettaId") Long ricettaId, @PathVariable("cuocoId") Long cuocoId, Model model) {

        Ricetta ricetta = this.ricettaService.findById(ricettaId);
        Cuoco cuoco = this.cuocoService.findById(cuocoId);
        cuoco.addRicetta(ricetta);
        this.cuocoService.save(cuoco);

        model.addAttribute("cuoco", cuoco);
        return "formUpdateCuoco.html";
    }

    @GetMapping("updateRicette/{id}")
    public String updateRicette(@PathVariable("id") Long id, Model model) {

        List<Ricetta> ricetteToAdd = this.ricetteToAdd(id);
        model.addAttribute("ricetteToAdd", ricetteToAdd);
        model.addAttribute("cuoco", this.cuocoService.findById(id));
        return "updateActors.html";
    }
//lista di ricette che non appartengono al cuoco
    private List<Ricetta> ricetteToAdd(Long cuocoId) {
        List<Ricetta> ricetteToAdd = new ArrayList<>();

        for (Ricetta r : ricettaService.findRicetteNotInCuoco(cuocoId)) {
            ricetteToAdd.add(r);
        }
        return ricetteToAdd;
    }


    @GetMapping("addRicettaToCuoco/{ricettaId}/{cuocoId}")
    public String addRicettaToCuoco(@PathVariable("ricettaId") Long ricettaId, @PathVariable("cuocoId") Long cuocoId, Model model) {

        Ricetta ricetta = this.ricettaService.findById(ricettaId);
        Cuoco cuoco = this.cuocoService.findById(cuocoId);
        List<Ricetta> ricette = cuoco.getRicette();

        ricette.add(ricetta);
        this.cuocoService.save(cuoco);

        List<Ricetta> ricetteToAdd = this.ricetteToAdd(cuocoId);
        model.addAttribute("ricetteToAdd", ricetteToAdd);
        model.addAttribute("cuoco", this.cuocoService.findById(cuocoId));
        return "updateRicette.html";
    }

    @GetMapping("removeRicettaFromCuoco/{ricettaId}/{cuocoId}")
    public String removeRicettaFromCuoco(@PathVariable("ricettaId") Long ricettaId, @PathVariable("cuocoId") Long cuocoId, Model model) {

        Cuoco cuoco = this.cuocoService.findById(cuocoId);
        Ricetta ricetta = this.ricettaService.findById(ricettaId);
        List<Ricetta> ricette = cuoco.getRicette();
        ricette.remove(ricetta);
        this.cuocoService.save(cuoco);

        List<Ricetta> ricetteToAdd = ricetteToAdd(cuocoId);

        model.addAttribute("ricetteToAdd", ricetteToAdd);
        model.addAttribute("cuoco", this.cuocoService.findById(cuocoId));

        return "updateRicette.html";
    }

}
