package it.uniroma3.siw.service;

import it.uniroma3.siw.model.Ricetta;
import it.uniroma3.siw.model.RigaRicetta;
import it.uniroma3.siw.repository.RigaRicettaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RigaRicettaService {
    @Autowired
    private RigaRicettaRepository rigaRicettaRepository;


    public void delete(RigaRicetta rigaRicetta) {
        rigaRicettaRepository.delete(rigaRicetta);
    }
}
