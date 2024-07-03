package it.uniroma3.siw.model;

import jakarta.persistence.*;
import java.time.LocalDate;
import java.util.*;

@Entity
public class Cuoco implements Comparable<Cuoco> {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "cuoco_seq")
    @SequenceGenerator(name = "cuoco_seq", sequenceName = "cuoco_sequence", allocationSize = 1)
    private Long id;
    private String name;
    private String surname;
    private Date dateOfBirth;
    @OneToMany(mappedBy = "cuoco", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Ricetta> ricette;
    @OneToOne(cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "account_id")
    private Account account;


    public Cuoco(String name, String surname, Date dateOfBirth, Account account) {
        this.name = name;
        this.surname = surname;
        this.dateOfBirth = dateOfBirth;
        this.ricette = new ArrayList<>();
        this.account = account;
    }

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

    public Date getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(Date dateOfBirth) {
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

    public void setAccount(Account account) {
        this.account = account;
    }

    @Override
    public int compareTo(Cuoco o) {
        return this.name.compareTo(o.name);
    }

    public Account getAccount() {
        return account;
    }
}
