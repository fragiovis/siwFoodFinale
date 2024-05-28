package it.uniroma3.siw.model;

import jakarta.persistence.*;
import java.util.*;

@Entity
public class Ricetta {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name;

    @ManyToOne
    private Cuoco cuoco;
    @ElementCollection
    public Map<String,Integer> ingredienti;

    public Ricetta() {
        this.ingredienti = new HashMap<>();
    }

    public Map<String,Integer> getIngredienti() {
        return ingredienti;
    }

    public Ricetta(Long id, String name, Cuoco cuoco) {
        this.id = id;
        this.name = name;
        this.ingredienti = new HashMap<String,Integer>();
        this.cuoco = cuoco;
    }

    public void setIngredienti(Map<String,Integer> ingredienti) {
        this.ingredienti = ingredienti;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Cuoco getCuoco() {
        return cuoco;
    }

    public void setCuoco(Cuoco cuoco) {
        this.cuoco = cuoco;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Ricetta ricetta = (Ricetta) o;
        return Objects.equals(id, ricetta.id) && Objects.equals(name, ricetta.name) && Objects.equals(cuoco, ricetta.cuoco) && Objects.equals(ingredienti, ricetta.ingredienti);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, cuoco, ingredienti);
    }
}
