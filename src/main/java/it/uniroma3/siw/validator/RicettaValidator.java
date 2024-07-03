package it.uniroma3.siw.validator;

import it.uniroma3.siw.model.Ricetta;
import it.uniroma3.siw.repository.RicettaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class RicettaValidator {

    @Autowired
    private RicettaRepository ricettaRepository;

    public void validate(Ricetta ricetta) {
        if (ricettaRepository.findByNameAndCuocoNameAndCuocoSurname(ricetta.getName(), ricetta.getCuoco().getName(), ricetta.getCuoco().getSurname()).isPresent()) {
            throw new IllegalArgumentException("Ricetta già esistente per questo cuoco.");
        }
    }
}
