package Entities;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

/**
 * Created by ismailrei on 1/23/17.
 */
@Entity
public class Filiere {
    private String id;
    private String nom;
    private int effictif;

    @Id
    @Column(name = "id")
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    @Basic
    @Column(name = "nom")
    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    @Basic
    @Column(name = "effictif")
    public int getEffictif() {
        return effictif;
    }

    public void setEffictif(int effictif) {
        this.effictif = effictif;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Filiere filiere = (Filiere) o;

        if (effictif != filiere.effictif) return false;
        if (id != null ? !id.equals(filiere.id) : filiere.id != null) return false;
        if (nom != null ? !nom.equals(filiere.nom) : filiere.nom != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (nom != null ? nom.hashCode() : 0);
        result = 31 * result + effictif;
        return result;
    }
}
