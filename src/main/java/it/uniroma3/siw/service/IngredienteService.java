package it.uniroma3.siw.service;

import it.uniroma3.siw.model.Ingrediente;
import it.uniroma3.siw.repository.IngredienteRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;

@Service
public class IngredienteService {
    @Autowired
    private IngredienteRepository ingredienteRepository;
    public List<Ingrediente> findAll() {
        List<Ingrediente> ingredienti = this.ingredienteRepository.findAll();
        Collections.sort(ingredienti);
        return ingredienti;
    }
    public Ingrediente findById(Long id) {
        return this.ingredienteRepository.findById(id);
    }
    public Ingrediente save(Ingrediente ingrediente) {
        return this.ingredienteRepository.save(ingrediente);
    }
    public void delete(Ingrediente ingrediente) {
        this.ingredienteRepository.delete(ingrediente);
    }
    public List<Ingrediente> findByNome(String nome) {
        return this.ingredienteRepository.findByNome(nome);
    }

    @Transactional
    public void deleteById(Long id) {
        this.ingredienteRepository.deleteById(id);
    }
}
