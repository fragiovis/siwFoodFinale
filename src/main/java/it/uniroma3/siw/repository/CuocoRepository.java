package it.uniroma3.siw.repository;

import it.uniroma3.siw.model.Cuoco;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CuocoRepository extends CrudRepository<Cuoco,Long> {

    Iterable<Cuoco> findAll();

    Iterable<Cuoco>findBySurname(String surname);
}
