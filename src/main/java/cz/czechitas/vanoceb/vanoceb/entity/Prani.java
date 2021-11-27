package cz.czechitas.vanoceb.vanoceb.entity;

import java.util.*;
import javax.persistence.*;
import lombok.*;

@Getter
@Setter
@Entity
@Table(name="PRANI")
public class Prani {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String nazevPrani;

    /**
     * komu je darek urcen
     */
    @ManyToOne
    @JoinColumn(name="pro_koho_id", nullable=false)
    private Uzivatel proKoho;

    /**
     * navhuje nove prani
     */
    @ManyToOne
    @JoinColumn(name="navrhl_id", nullable=true)
    private Uzivatel navrhl;

    /**
     * vybrane prani
     */
    @ManyToOne
    @JoinColumn(name="kupuje_id", nullable=true)
    private Uzivatel kupuje;


    @Version
    private int version;

    public Prani (){
    }


    @Override
    public String toString() {
        return "Prani " +
                "id=" + id + ", " +
                "nazevPrani=\"" + nazevPrani + "\"" + ", " +
                "version=" + version;
    }
}
