package it.uniroma3.siw.model;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
public class Ingrediente implements Comparable<Ingrediente>{
    @Id
    @GeneratedValue
    private Long id;
    private String nome;
    @OneToMany(mappedBy = "ingrediente", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<RigaRicetta> righeRicetta = new ArrayList<>();

    public Ingrediente() {
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }
    public String getNome() {
        return nome;
    }
    @Override
    public int compareTo(Ingrediente other) {
        return this.nome.compareTo(other.nome);
    }

}
