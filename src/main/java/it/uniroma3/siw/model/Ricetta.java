package it.uniroma3.siw.model;

import jakarta.persistence.*;
import java.util.*;

@Entity
public class Ricetta {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_ricetta")
    @SequenceGenerator(name = "seq_ricetta", sequenceName = "seq_ricetta", allocationSize = 1)
    private Long id;
    private String name;

    @ManyToOne
    @JoinColumn(name = "cuoco_id")
    private Cuoco cuoco;
    @OneToMany(mappedBy = "ricetta", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<RigaRicetta> righeRicetta;
    private String descrizione;
    private String immagine;

    public Ricetta() {
        this.righeRicetta = new ArrayList<>();
    }

    public List<RigaRicetta> getRigheRicetta() {
        return righeRicetta;
    }

    public Ricetta(Long id, String name, Cuoco cuoco) {
        this.id = id;
        this.name = name;
        this.righeRicetta = new ArrayList<>();
        this.cuoco = cuoco;
    }

    public void setIngredienti(List<RigaRicetta> righeRicetta) {
        this.righeRicetta = righeRicetta;
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
    public int hashCode() {
        return Objects.hash(id, name, cuoco, righeRicetta);
    }

    public void setRigheRicetta(List<RigaRicetta> righeRicetta) {
        this.righeRicetta = righeRicetta;
    }
    public String getDescrizione() {
        return descrizione;
    }
    public void setDescrizione(String descrizione) {
        this.descrizione = descrizione;
    }
    public String getImmagine() {
        return immagine;
    }
    public void setImmagine(String immagine) {
        this.immagine = immagine;
    }
}
