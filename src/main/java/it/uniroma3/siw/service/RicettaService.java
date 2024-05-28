package it.uniroma3.siw.service;

import it.uniroma3.siw.model.Ricetta;
import it.uniroma3.siw.repository.RicettaRepository;
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

    public List<Ricetta> findAll() {
        return (List<Ricetta>) this.ricettaRepository.findAll();
    }
    public Ricetta save(Ricetta ricetta) {
        return this.ricettaRepository.save(ricetta);
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
}
