package it.uniroma3.siw.model;

import it.uniroma3.siw.model.Ingrediente;
import it.uniroma3.siw.model.Ricetta;
import jakarta.persistence.*;

@Entity
@SequenceGenerator(name = "rigaRicettaSeq", sequenceName = "seq_riga_ricetta", allocationSize = 1)
public class RigaRicetta {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "rigaRicettaSeq")
    private Long id;

    @ManyToOne
    @JoinColumn(name = "ricetta_id")
    private Ricetta ricetta;

    @ManyToOne
    @JoinColumn(name = "ingrediente_id")
    private Ingrediente ingrediente;
    private String quantita;

    public RigaRicetta() {
    }

    public RigaRicetta(Ricetta ricetta,Ingrediente ingrediente, String quantita){
        this.ricetta = ricetta;
        this.ingrediente = ingrediente;
        this.quantita = quantita;
    }
    // Getters and Setters

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Ricetta getRicetta() {
        return ricetta;
    }

    public void setRicetta(Ricetta ricetta) {
        this.ricetta = ricetta;
    }

    public Ingrediente getIngrediente() {
        return ingrediente;
    }

    public void setIngrediente(Ingrediente ingrediente) {
        this.ingrediente = ingrediente;
    }

    public String getQuantita() {
        return quantita;
    }

    public void setQuantita(String quantita) {
        this.quantita = quantita;
    }
}
