package it.uniroma3.siw.model;

import jakarta.persistence.*;
import java.time.LocalDate;
import java.util.*;

@Entity
public class Cuoco {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name;
    private String surname;
    private LocalDate dateOfBirth;
    @OneToMany
    private List<Ricetta> ricette;

    public Cuoco() {
        this.ricette = new ArrayList<>();
    }

    public void addRicetta(Ricetta ricetta){
        this.ricette.add(ricetta);
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public LocalDate getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(LocalDate dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public List<Ricetta> getRicette() {
        return this.ricette;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Cuoco cuoco = (Cuoco) o;
        return Objects.equals(id, cuoco.id) && Objects.equals(name, cuoco.name) && Objects.equals(surname, cuoco.surname) && Objects.equals(dateOfBirth, cuoco.dateOfBirth);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, surname, dateOfBirth);
    }
}
