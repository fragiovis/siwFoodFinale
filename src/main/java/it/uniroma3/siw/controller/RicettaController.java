package it.uniroma3.siw.controller;

import it.uniroma3.siw.model.*;
import it.uniroma3.siw.service.*;
import it.uniroma3.siw.validator.CredentialsValidator;
import it.uniroma3.siw.validator.RicettaValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
public class RicettaController {
    @Autowired
    private CuocoService cuocoService;
    @Autowired
    private RicettaService ricettaService;
    @Autowired
    private IngredienteService ingredienteService;
    @Autowired
    private CredentialsService credentialsService;
    @Autowired
    private RigaRicettaService rigaRicettaService;



    @GetMapping("/ricetta/{id}")
    public String getRicetta(@PathVariable("id") Long id, Model model) {
        model.addAttribute("ricetta", this.ricettaService.findById(id));
        return "ricetta.html";
    }

    @GetMapping("/admin/ricetta/{id}")
    public String getRicettaAdmin(@PathVariable("id") Long id, Model model) {
        model.addAttribute("ricetta", this.ricettaService.findById(id));
        return "ricetta-admin.html";
    }

    @GetMapping("/chef/ricetta/{id}")
    public String getRicettaChef(@PathVariable("id") Long id, Model model) {
        model.addAttribute("ricetta", this.ricettaService.findById(id));
        return "ricetta-chef.html";
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

    @GetMapping("/admin/indexIngrediente")
    public String getAllIngredientiAdmin(Model model) {
        List<Ingrediente> ingredienti = ingredienteService.findAll();
        model.addAttribute("ingredienti", ingredienti);
        return "indexIngrediente-admin";
    }

    @GetMapping("/chef/indexIngrediente")
    public String getAllIngredientiChef(Model model) {
        List<Ingrediente> ingredienti = ingredienteService.findAll();
        model.addAttribute("ingredienti", ingredienti);
        return "indexIngrediente-chef";
    }

    @GetMapping("/indexIngrediente")
    public String getAllIngredienti(Model model) {
        List<Ingrediente> ingredienti = ingredienteService.findAll();
        model.addAttribute("ingredienti", ingredienti);
        return "indexIngrediente";
    }

    @PostMapping("/admin/addIngrediente")
    public String addIngrediente(@RequestParam("nome") String nome, RedirectAttributes redirectAttributes) {
        if (nome == null || nome.trim().isEmpty()) {
            redirectAttributes.addFlashAttribute("errorMessage", "Il campo ingrediente non può essere vuoto.");
            return "redirect:/admin/indexIngrediente";
        }
        Ingrediente ingrediente = new Ingrediente();
        ingrediente.setNome(nome.trim());
        ingredienteService.save(ingrediente);
        redirectAttributes.addFlashAttribute("successMessage", "Ingrediente aggiunto con successo.");
        return "redirect:/admin/indexIngrediente";
    }

    @PostMapping("/admin/deleteIngrediente/{id}")
    public String deleteIngrediente(@PathVariable("id") Long id, RedirectAttributes redirectAttributes) {
        ingredienteService.deleteById(id);
        redirectAttributes.addFlashAttribute("successMessage", "Ingrediente eliminato con successo.");
        return "redirect:/admin/indexIngrediente";
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

    @GetMapping("/admin/formSearchRicette")
    public String formSearchRicetteAdmin() {
        return "formSearchRicette-admin.html";
    }

    @PostMapping("/admin/searchRicette")
    public String searchRicetteAdmin(Model model, @RequestParam String name) {
        model.addAttribute("ricette", this.ricettaService.findByName(name));
        return "foundRicette-admin.html";
    }

    @GetMapping("/indexRicetta")
    public String indexRicetta(Model model) {
        model.addAttribute("ricette",this.ricettaService.findAll());
        return "indexRicetta.html";
    }

    @GetMapping("/admin/indexRicetta")
    public String indexRicettaAdmin(Model model) {
        model.addAttribute("ricette",this.ricettaService.findAll());
        return "indexRicetta-admin.html";
    }

    @GetMapping("/chef/indexRicetta")
    public String indexRicettaChef(Model model) {
        model.addAttribute("ricette",this.ricettaService.findAll());
        return "indexRicetta-chef.html";
    }



    @GetMapping("/chef/{cuocoId}/ricette")
    public String getRicetteByCuoco(@PathVariable Long cuocoId, Model model) {
        List<Ricetta> ricette = ricettaService.getRicetteByCuocoId(cuocoId);
        model.addAttribute("ricette", ricette);
        model.addAttribute("ricetta", new Ricetta());
        model.addAttribute("cuoco", this.cuocoService.findById(cuocoId));

        return "leTueRicette.html";
    }

    @GetMapping("/chef/mieRicette")
    public String getRicetteByCuocoChef(Model model) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if (authentication != null && authentication.isAuthenticated()) {
            String username = authentication.getName();
            Credentials credentials = credentialsService.findByUsername(username);
            Account account = credentials.getAccount();
            Cuoco cuoco = account.getCuoco();
            if (cuoco != null) {
                model.addAttribute("cuoco", cuoco);
                model.addAttribute("ricette", cuoco.getRicette());
            }
        }
        return "leTueRicette.html";
    }

    @GetMapping("/chef/{cuocoId}/aggiungiRicetta")
    public String showAggiungiRicettaForm(@PathVariable Long cuocoId, Model model) {
        Cuoco cuoco = cuocoService.findById(cuocoId);
        model.addAttribute("cuoco", cuoco);
        List<Ingrediente> ingredientiDisponibili = ingredienteService.findAll();
        model.addAttribute("ingredientiDisponibili",ingredientiDisponibili);
        return "formAggiungiRicetta";
    }

    @PostMapping("/chef/{cuocoId}/aggiungiRicetta")
    public String aggiungiRicetta(@PathVariable Long cuocoId,
                                  @RequestParam String name,
                                  @RequestParam String descrizione,
                                  @RequestParam("immagine") MultipartFile immagine,
                                  @RequestParam("ingredienteId") List<Long> ingredienteIds,
                                  @RequestParam("quantita") List<String> quantitaList,
                                  Model model) {



        // Ottieni il cuoco dal servizio
        Cuoco cuoco = cuocoService.findById(cuocoId);
        if (cuoco == null) {
            model.addAttribute("error", "Cuoco non trovato con id: " + cuocoId);
            return "redirect:/error"; // Gestione caso di cuoco non trovato
        }

        // Salva l'immagine della ricetta e ottieni il nome del file
        String immagineFileName;
        try {
            immagineFileName = saveImageRicetta(immagine);
        } catch (IOException e) {
            model.addAttribute("error", "Errore durante il salvataggio dell'immagine della ricetta: " + e.getMessage());
            return "redirect:/error"; // Gestione errore salvataggio immagine
        }

        // Crea una nuova ricetta e imposta i suoi attributi
        Ricetta ricetta = new Ricetta();
        ricetta.setName(name);
        ricetta.setDescrizione(descrizione);
        ricetta.setImmagine("/images/uploads/ricetta-photos/" + immagineFileName);
        ricetta.setCuoco(cuoco);

        // Costruisci la lista delle righe della ricetta
        List<RigaRicetta> righeRicetta = new ArrayList<>();
        for (int i = 0; i < ingredienteIds.size(); i++) {
            Long ingredienteId = ingredienteIds.get(i);
            String quantita = quantitaList.get(i);

            Ingrediente ingrediente = ingredienteService.findById(ingredienteId);
            if (ingrediente != null) {
                righeRicetta.add(new RigaRicetta(ricetta, ingrediente, quantita));
            }
        }

        ricetta.setRigheRicetta(righeRicetta);

        try {
            ricettaService.saveAndValidate(ricetta);
            return "redirect:/chef/" + cuocoId + "/ricette";
        } catch (Exception e) {
            model.addAttribute("error", "Hai già inserito questa ricetta");
            return "formAggiungiRicetta";
        }
    }



    private String saveImageRicetta(MultipartFile immagine) throws IOException {
        String immagineFileName = System.currentTimeMillis() + "_" + immagine.getOriginalFilename();
        Path uploadPath = Paths.get("src/main/resources/static/images/uploads/ricetta-photos");

        if (!Files.exists(uploadPath)) {
            Files.createDirectories(uploadPath);
            System.out.println("Created directories: " + uploadPath.toString());
        }

        Path imageFilePath = uploadPath.resolve(immagineFileName);
        Files.write(imageFilePath, immagine.getBytes());
        System.out.println("Image saved at: " + imageFilePath.toString());

        return immagineFileName;
    }



    @PostMapping("/chef/{cuocoId}/eliminaRicetta/{ricettaId}")
    public String eliminaRicetta(@PathVariable Long cuocoId, @PathVariable Long ricettaId) {
        Cuoco cuoco = cuocoService.findById(cuocoId);
        Ricetta ricetta = ricettaService.findById(ricettaId);

        if (cuoco != null && ricetta != null) {
            cuoco.getRicette().remove(ricetta); // Rimuovi la ricetta dalla lista del cuoco
            cuocoService.save(cuoco); // Salva il cuoco aggiornato
            ricettaService.deleteById(ricettaId); // Elimina la ricetta
        }

        return "redirect:/chef/" + cuocoId + "/ricette";
    }

    @PostMapping("/admin/{cuocoId}/eliminaRicetta/{ricettaId}")
    public String eliminaRicettaAdmin(@PathVariable Long cuocoId, @PathVariable Long ricettaId) {
        Cuoco cuoco = cuocoService.findById(cuocoId);
        Ricetta ricetta = ricettaService.findById(ricettaId);

        if (cuoco != null && ricetta != null) {
            cuoco.getRicette().remove(ricetta); // Rimuovi la ricetta dalla lista del cuoco
            cuocoService.save(cuoco); // Salva il cuoco aggiornato
            ricettaService.deleteById(ricettaId); // Elimina la ricetta
        }

        return "redirect:/admin/cuoco/" + cuocoId;
    }

    @PostMapping("/admin/aggiungiRicetta")
    public String aggiungiRicettaAdmin(@RequestParam Long cuocoId,
                                       @RequestParam String name,
                                       @RequestParam String descrizione,
                                       @RequestParam("immagine") MultipartFile immagine,
                                       @RequestParam("ingredienteId") List<Long> ingredienteIds,
                                       @RequestParam("quantita") List<String> quantitaList,
                                       Model model) {

        // Recupera il cuoco dal servizio
        Cuoco cuoco = cuocoService.findById(cuocoId);
        if (cuoco == null) {
            model.addAttribute("error", "Cuoco non trovato");
            return "redirect:/error"; // Gestione errore cuoco non trovato
        }

        // Salva l'immagine della ricetta e ottieni il nome del file
        String immagineFileName;
        try {
            immagineFileName = saveImageRicetta(immagine);
        } catch (IOException e) {
            model.addAttribute("error", "Errore durante il salvataggio dell'immagine della ricetta: " + e.getMessage());
            return "redirect:/error"; // Gestione errore salvataggio immagine
        }

        // Crea una nuova ricetta e imposta i suoi attributi
        Ricetta ricetta = new Ricetta();
        ricetta.setName(name);
        ricetta.setDescrizione(descrizione);
        ricetta.setImmagine("/images/uploads/ricetta-photos/" + immagineFileName);
        ricetta.setCuoco(cuoco); // Associa il cuoco salvato alla ricetta

        // Costruisci la lista delle righe della ricetta
        List<RigaRicetta> righeRicetta = new ArrayList<>();
        for (int i = 0; i < ingredienteIds.size(); i++) {
            Long ingredienteId = ingredienteIds.get(i);
            String quantita = quantitaList.get(i);

            Ingrediente ingrediente = ingredienteService.findById(ingredienteId);
            if (ingrediente != null) {
                righeRicetta.add(new RigaRicetta(ricetta, ingrediente, quantita));
            }
        }

        ricetta.setRigheRicetta(righeRicetta);

        try {
            ricettaService.saveAndValidate(ricetta);
            return "redirect:/admin/cuoco" + cuocoId;
        } catch (Exception e) {
            model.addAttribute("error", "Ricetta già esistente per questo cuoco");
            return "formAggiungiRicetta";
        }
    }



    @GetMapping("/admin/aggiungiRicetta")
    public String aggiungiRicettaForm(Model model) {
        List<Cuoco> cuochi = cuocoService.findAll();
        List<Ingrediente> ingredientiDisponibili = ingredienteService.findAll();
        model.addAttribute("cuochi", cuochi);
        model.addAttribute("ingredientiDisponibili", ingredientiDisponibili);
        model.addAttribute("ricetta", new Ricetta());
        return "aggiungiRicetta-admin.html";
    }


    @GetMapping("/chef/{cuocoId}/modificaRicetta/{ricettaId}")
    public String modificaRicetta(Model model, @PathVariable Long cuocoId, @PathVariable Long ricettaId) {
        Ricetta ricetta = ricettaService.findById(ricettaId);
        model.addAttribute("ricetta", ricetta);
        List<Ingrediente> ingredientiDisponibili = ingredienteService.findAll();
        model.addAttribute("ingredientiDisponibili",ingredientiDisponibili);
        return "formModificaRicetta";
    }

    @PostMapping("/chef/{cuocoId}/modificaRicetta/{ricettaId}")
    public String modificaRicetta(@PathVariable Long cuocoId, @PathVariable Long ricettaId, @ModelAttribute Ricetta ricettaModificata) {
        // Trova la ricetta esistente da modificare
        Ricetta ricetta = ricettaService.findById(ricettaId);

        // Trova il cuoco dal servizio
        Cuoco cuoco = cuocoService.findById(cuocoId);

        // Aggiorna i dati principali della ricetta
        ricetta.setName(ricettaModificata.getName());
        ricetta.setDescrizione(ricettaModificata.getDescrizione());
        ricetta.setCuoco(cuoco);

        // Rimuove le righe esistenti
        List<RigaRicetta> righeEsistenti = new ArrayList<>(ricetta.getRigheRicetta());
        ricetta.getRigheRicetta().clear();
        for (RigaRicetta riga : righeEsistenti) {
            riga.setRicetta(null); // Rimuovi la relazione con la ricetta
            rigaRicettaService.delete(riga); // Elimina la riga ricetta
        }

        // Aggiunge le righe modificate
        for (RigaRicetta rigaModificata : ricettaModificata.getRigheRicetta()) {
            if (rigaModificata.getIngrediente() != null && rigaModificata.getQuantita()!=null) {
                RigaRicetta riga = new RigaRicetta();
                riga.setIngrediente(rigaModificata.getIngrediente());
                riga.setQuantita(rigaModificata.getQuantita());
                riga.setRicetta(ricetta);
                ricetta.getRigheRicetta().add(riga);
            }
        }

        // Salvataggio della ricetta aggiornata
        ricettaService.save(ricetta);

        // Redirect alla pagina delle ricette del cuoco
        return "redirect:/chef/" + cuocoId + "/ricette";
    }


    @GetMapping("/admin/{cuocoId}/modificaRicetta/{ricettaId}")
    public String modificaRicettaAdmin(Model model, @PathVariable Long cuocoId, @PathVariable Long ricettaId) {
        Ricetta ricetta = ricettaService.findById(ricettaId);
        model.addAttribute("ricetta", ricetta);
        List<Ingrediente> ingredientiDisponibili = ingredienteService.findAll();
        model.addAttribute("ingredientiDisponibili",ingredientiDisponibili);
        return "formModificaRicetta-admin";
    }

    @PostMapping("/admin/{cuocoId}/modificaRicetta/{ricettaId}")
    public String modificaRicettaAdmin(@PathVariable Long cuocoId, @PathVariable Long ricettaId, @ModelAttribute Ricetta ricettaModificata) {
        // Trova la ricetta esistente da modificare
        Ricetta ricetta = ricettaService.findById(ricettaId);

        // Trova il cuoco dal servizio
        Cuoco cuoco = cuocoService.findById(cuocoId);

        // Aggiorna i dati principali della ricetta
        ricetta.setName(ricettaModificata.getName());
        ricetta.setDescrizione(ricettaModificata.getDescrizione());
        ricetta.setCuoco(cuoco);

        // Rimuove le righe esistenti
        List<RigaRicetta> righeEsistenti = new ArrayList<>(ricetta.getRigheRicetta());
        for (RigaRicetta riga : righeEsistenti) {
            riga.setRicetta(null); // Rimuovi la relazione con la ricetta
            rigaRicettaService.delete(riga); // Elimina la riga ricetta
        }
        ricetta.getRigheRicetta().clear();

        // Aggiunge le righe modificate
        for (RigaRicetta rigaModificata : ricettaModificata.getRigheRicetta()) {
            if (rigaModificata.getIngrediente() != null && rigaModificata.getQuantita()!=null) {
                RigaRicetta riga = new RigaRicetta();
                riga.setIngrediente(rigaModificata.getIngrediente());
                riga.setQuantita(rigaModificata.getQuantita());
                riga.setRicetta(ricetta);
                ricetta.getRigheRicetta().add(riga);
            }
        }

        // Salvataggio della ricetta aggiornata
        ricettaService.save(ricetta);

        // Redirect alla pagina delle ricette del cuoco
        return "redirect:/admin/cuoco/" + cuocoId;
    }

    /*@PostMapping("/chef/{cuocoId}/eliminaRigaRicetta/{rigaIndex}")
    public String eliminaRigaRicetta(@PathVariable("cuocoId") Long cuocoId,
                                     @PathVariable("rigaIndex") Integer rigaIndex,
                                     @ModelAttribute("ricetta") Ricetta ricetta) {
        // Implementa la logica per eliminare la riga della ricetta dal database
        // RicettaRepository deve essere autowired nel controller

        // Esempio di come potrebbe essere implementato:
        ricetta.getRigheRicetta().remove(rigaIndex.intValue()); // Rimuovi la riga dalla lista

        ricettaService.save(ricetta); // Salva la ricetta aggiornata nel database

        // Redirect alla pagina di modifica della ricetta
        return "redirect:/chef/" + cuocoId + "/modificaRicetta/" + ricetta.getId();
    }*/

    @GetMapping("/admin/aggiungiIngrediente")
    public String showAggiungiIngredienteFormAdmin(Model model) {
        model.addAttribute("ingrediente", new Ingrediente());
        return "aggiungiIngrediente-admin"; // Nome del template HTML
    }

    @PostMapping("/admin/aggiungiIngrediente")
    public String aggiungiIngredienteAdmin(@ModelAttribute Ingrediente ingrediente, RedirectAttributes redirectAttributes) {
        List<Ingrediente> ingredienti = ingredienteService.findAll();
        boolean exists = ingredienti.stream().anyMatch(ing -> ing.getNome().equalsIgnoreCase(ingrediente.getNome()));

        if (!exists) {
            ingredienteService.save(ingrediente);
            redirectAttributes.addFlashAttribute("message", "Ingrediente aggiunto con successo!");
        } else {
            redirectAttributes.addFlashAttribute("message", "Ingrediente già esistente!");
        }

        return "redirect:/admin/ricette";
    }

    @GetMapping("/chef/{cuocoId}/aggiungiIngrediente")
    public String showAggiungiIngredienteFormChef(@PathVariable Long cuocoId, Model model) {
        model.addAttribute("ingrediente", new Ingrediente());
        model.addAttribute("cuocoId", cuocoId);
        return "aggiungiIngrediente-chef"; // Nome del template HTML
    }

    @PostMapping("/chef/{cuocoId}/aggiungiIngrediente")
    public String aggiungiIngredienteChef(@ModelAttribute Ingrediente ingrediente, @PathVariable Long cuocoId, RedirectAttributes redirectAttributes) {
        List<Ingrediente> ingredienti = ingredienteService.findAll();
        boolean exists = ingredienti.stream().anyMatch(ing -> ing.getNome().equalsIgnoreCase(ingrediente.getNome()));

        if (!exists) {
            ingredienteService.save(ingrediente);
            redirectAttributes.addFlashAttribute("message", "Ingrediente aggiunto con successo!");
        } else {
            redirectAttributes.addFlashAttribute("message", "Ingrediente già esistente!");
        }

        return "indexIngrediente-chef";
    }



















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

