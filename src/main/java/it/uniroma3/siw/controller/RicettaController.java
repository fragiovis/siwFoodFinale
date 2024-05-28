package it.uniroma3.siw.controller;

import it.uniroma3.siw.model.Cuoco;
import it.uniroma3.siw.model.Ricetta;
import it.uniroma3.siw.service.CuocoService;
import it.uniroma3.siw.service.RicettaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class RicettaController {
    @Autowired
    private CuocoService cuocoService;
    @Autowired
    private RicettaService ricettaService;

    @GetMapping("/ricetta/{id}")
    public String getRicetta(@PathVariable("id") Long id, Model model) {
        model.addAttribute("ricetta", this.ricettaService.findById(id));
        return "ricetta.html";
    }

    @GetMapping("/ricette")
    public String showRicette(Model model) {
        model.addAttribute("ricette", this.ricettaService.findAll());
        return "ricette.html";
    }

    @GetMapping("/formNewRicetta")
    public String formNewRicetta(Model model) {
        model.addAttribute("ricetta", new Ricetta());
        return "formNewRicetta.html";
    }

    @PostMapping("/ricetta")
    public String newRicetta(@ModelAttribute("ricetta") Ricetta ricetta, Model model) {
        this.ricettaService.save(ricetta);
        model.addAttribute("ricetta", ricetta);
        return "redirect:ricetta/"+ricetta.getId();
    }

    @GetMapping("/formSearchRicette")
    public String formSearchRicette() {
        return "formSearchRicette.html";
    }

    @PostMapping("/searchRicette")
    public String searchRicette(Model model, @RequestParam String name) {
        model.addAttribute("ricette", this.ricettaService.findByName(name));
        return "foundRicette.html";
    }

    @GetMapping("/indexRicetta")
    public String indexRicetta() {
        return "indexRicetta.html";
    }

    /*
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
    }*/
}
