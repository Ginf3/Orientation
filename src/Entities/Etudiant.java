package Entities;

import javax.persistence.*;
import java.time.Year;

/**
 * Created by ismailrei on 1/23/17.
 */
@Entity
@Table( name = "etudiant")
public class Etudiant {
    private String cne;
    private String nom;
    private String prenom;
    private String annee;
    private String email;
    private int note = 0;
    private int classement = 0;
    private String choix = "";
    private Filiere affected;
    private User oneToOne;

    @Id
    @Column(name = "cne")
    public String getCne() {
        return cne;
    }

    public void setCne(String cne) {
        this.cne = cne;
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
    @Column(name = "year")
    public String getAnnee() {
        return annee;
    }

    public void setAnnee(String annee) {
        this.annee = annee;
    }

    @Basic
    @Column(name = "email")
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Basic
    @Column(name = "prenom")
    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    @Basic
    @Column(name = "note")
    public int getNote() {
        return note;
    }

    public void setNote(int note) {

        this.note = note;
    }

    @Basic
    @Column(name = "classement")
    public int getClassement() {
        return classement;
    }

    public void setClassement(int classement) {
        this.classement = classement;
    }

    @Basic
    @Column(name = "choix")
    public String getChoix() {
        return choix;
    }

    public void setChoix(String choix) {
        this.choix = choix;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Etudiant etudiant = (Etudiant) o;

        if (note != etudiant.note) return false;
        if (classement != etudiant.classement) return false;
        if (cne != null ? !cne.equals(etudiant.cne) : etudiant.cne != null) return false;
        if (nom != null ? !nom.equals(etudiant.nom) : etudiant.nom != null) return false;
        if (prenom != null ? !prenom.equals(etudiant.prenom) : etudiant.prenom != null) return false;
        if (choix != null ? !choix.equals(etudiant.choix) : etudiant.choix != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = cne != null ? cne.hashCode() : 0;
        result = 31 * result + (nom != null ? nom.hashCode() : 0);
        result = 31 * result + (prenom != null ? prenom.hashCode() : 0);
        result = 31 * result + note;
        result = 31 * result + classement;
        result = 31 * result + (choix != null ? choix.hashCode() : 0);
        return result;
    }


    @ManyToOne
    @JoinColumn(name = "affected", referencedColumnName = "id")
    public Filiere getAffected() {
        return affected;
    }

    public void setAffected(Filiere affected) {
        this.affected = affected;
    }

    @OneToOne
    @JoinColumn(name = "user_id", referencedColumnName = "id")
    public User getOneToOne() {
        return oneToOne;
    }

    public void setOneToOne(User oneToOne) {
        this.oneToOne = oneToOne;
    }
}
