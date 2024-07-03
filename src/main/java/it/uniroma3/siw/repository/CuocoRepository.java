package it.uniroma3.siw.repository;

import it.uniroma3.siw.model.Cuoco;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CuocoRepository extends CrudRepository<Cuoco,Long> {

    List<Cuoco> findAll();

    List<Cuoco>findBySurname(String surname);
}
