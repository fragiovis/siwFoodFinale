package it.uniroma3.siw.service;

import it.uniroma3.siw.model.Cuoco;
import it.uniroma3.siw.repository.CuocoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;

@Service
public class CuocoService {
    @Autowired
    private CuocoRepository cuocoRepository;

    public List<Cuoco> findAll() {
        List<Cuoco> cuochi = this.cuocoRepository.findAll();
        Collections.sort(cuochi);
        return cuochi;
    }
    public Cuoco findById(Long id) {
        return this.cuocoRepository.findById(id).orElse(null);
    }
    public Cuoco save(Cuoco cuoco) {
        return this.cuocoRepository.save(cuoco);
    }
    public void delete(Cuoco cuoco) {
        this.cuocoRepository.delete(cuoco);
    }
    //Cosi ho fixato un problema che credevo fosse nell'html
    public List<Cuoco> findBySurname(String surname) {
        return (List<Cuoco>) this.cuocoRepository.findBySurname(surname);
    }
    public void deleteById(Long id) {
        this.cuocoRepository.deleteById(id);
    }

}
