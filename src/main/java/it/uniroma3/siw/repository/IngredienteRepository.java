package it.uniroma3.siw.repository;

import it.uniroma3.siw.model.Ingrediente;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface IngredienteRepository extends CrudRepository<Ingrediente, Integer> {
    List<Ingrediente> findByNome(String nome);
    List<Ingrediente> findAll();
    Ingrediente findById(Long id);
    void deleteById(Long id);
}
