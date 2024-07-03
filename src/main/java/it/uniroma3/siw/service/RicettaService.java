package it.uniroma3.siw.service;

import it.uniroma3.siw.model.Cuoco;
import it.uniroma3.siw.model.Ricetta;
import it.uniroma3.siw.model.RigaRicetta;
import it.uniroma3.siw.repository.CuocoRepository;
import it.uniroma3.siw.repository.RicettaRepository;
import it.uniroma3.siw.repository.RigaRicettaRepository;
import it.uniroma3.siw.validator.RicettaValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Service;

import java.util.AbstractList;
import java.util.ArrayList;
import java.util.List;

@Service
public class RicettaService {
    @Autowired
    private RicettaRepository ricettaRepository;
    @Autowired
    private CuocoRepository cuocoRepository;
    @Autowired
    private RigaRicettaRepository rigaRicettaRepository;
    @Autowired
    private RicettaValidator ricettaValidator;

    public List<Ricetta> findAll() {
        return (List<Ricetta>) this.ricettaRepository.findAll();
    }
    public Ricetta saveAndValidate(Ricetta ricetta) {
        this.ricettaValidator.validate(ricetta);
        return this.ricettaRepository.save(ricetta);
    }
    public Ricetta save(Ricetta ricetta) {
        this.ricettaRepository.save(ricetta);
        return ricetta;
    }
    public Ricetta findById(Long ricettaId) {
        return this.ricettaRepository.findById(ricettaId).orElse(null);
    }
    public List<Ricetta> findByName(String name) {
        return (List<Ricetta>) this.ricettaRepository.findByName(name);
    }

    public List<Ricetta> findRicetteNotInCuoco(Long cuocoId) {
        return (List<Ricetta>) this.ricettaRepository.findRicetteNotInCuoco(cuocoId);
    }

    public List<Ricetta> getRicetteByCuocoId(Long cuocoId) {
        Cuoco cuoco = cuocoRepository.findById(cuocoId).orElse(null);
        if (cuoco != null) {
            return ricettaRepository.findByCuoco(cuoco);
        }
        return null;
    }

    public void deleteById(Long ricettaId) {
        this.ricettaRepository.deleteById(ricettaId);
    }
    public RigaRicetta save(RigaRicetta rigaRicetta) {
        return this.rigaRicettaRepository.save(rigaRicetta);
    }



}
