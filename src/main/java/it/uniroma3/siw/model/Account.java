package it.uniroma3.siw.model;

import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.Date;

@Entity
public class Account {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    public String name;
    public String surname;
    public Date dateOfBirth;
    @OneToOne(mappedBy = "account", cascade = CascadeType.ALL)
    private Credentials credentials;

    public Credentials getCredentials() {
        return credentials;
    }
    public void setCredentials(Credentials credentials) {
        this.credentials = credentials;
    }

    public void setName(String name) {
        this.name = name;
    }
    public void setSurname(String surname) {
        this.surname = surname;
    }

    public void setDate(Date dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }
}
