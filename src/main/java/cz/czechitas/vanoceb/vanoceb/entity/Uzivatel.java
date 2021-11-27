package cz.czechitas.vanoceb.vanoceb.entity;

import java.util.*;
import javax.persistence.*;
import lombok.*;

@Getter
@Setter
@Entity
@Table(name="UZIVATEL")
public class Uzivatel {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String jmeno;

    /**
     * seznam jednoho obdarovavaneho
     */
    @OneToMany(mappedBy="proKoho")
    private List<Prani> seznamMojichPrani;

    /**
     * muj seznam, ktery obsahuje vybrane darky ke koupi
     */
    @OneToMany(mappedBy="navrhl")
    private List<Prani> seznamSplnenychPrani;

    /**
     * seznam prani, ktere chci pridat nejakemu clenovi rodiny
     */
    @OneToMany(mappedBy="kupuje")
    private List<Prani> seznamNavrzenychDarku;

    @Version
    private int version;

    public Uzivatel(){
    }


    @Override
    public String toString() {
        return "Uzivatel " +
                "id=" + id + ", " +
                "jmeno=\"" + jmeno + "\"" + ", " +
                "version=" + version;
    }
}
