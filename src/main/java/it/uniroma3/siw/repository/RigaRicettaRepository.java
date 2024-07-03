package it.uniroma3.siw.repository;
import it.uniroma3.siw.model.RigaRicetta;

import org.springframework.data.repository.CrudRepository;

public interface RigaRicettaRepository extends CrudRepository<RigaRicetta, Integer> {
    void delete(RigaRicetta rigaRicetta);
}
