package Entities;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

/**
 * Created by ismailrei on 1/23/17.
 */
@Entity
public class Archive {
    private String cne;
    private String login;
    private String password;
    private String email;
    private byte admin;
    private String nom;
    private String prenom;
    private int note;
    private int classement;
    private String affected;
    private String choix;

    @Id
    @Column(name = "cne")
    public String getCne() {
        return cne;
    }

    public void setCne(String cne) {
        this.cne = cne;
    }

    @Basic
    @Column(name = "login")
    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    @Basic
    @Column(name = "password")
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
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
    @Column(name = "admin")
    public byte getAdmin() {
        return admin;
    }

    public void setAdmin(byte admin) {
        this.admin = admin;
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
    @Column(name = "affected")
    public String getAffected() {
        return affected;
    }

    public void setAffected(String affected) {
        this.affected = affected;
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

        Archive archive = (Archive) o;

        if (admin != archive.admin) return false;
        if (note != archive.note) return false;
        if (classement != archive.classement) return false;
        if (cne != null ? !cne.equals(archive.cne) : archive.cne != null) return false;
        if (login != null ? !login.equals(archive.login) : archive.login != null) return false;
        if (password != null ? !password.equals(archive.password) : archive.password != null) return false;
        if (email != null ? !email.equals(archive.email) : archive.email != null) return false;
        if (nom != null ? !nom.equals(archive.nom) : archive.nom != null) return false;
        if (prenom != null ? !prenom.equals(archive.prenom) : archive.prenom != null) return false;
        if (affected != null ? !affected.equals(archive.affected) : archive.affected != null) return false;
        if (choix != null ? !choix.equals(archive.choix) : archive.choix != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = cne != null ? cne.hashCode() : 0;
        result = 31 * result + (login != null ? login.hashCode() : 0);
        result = 31 * result + (password != null ? password.hashCode() : 0);
        result = 31 * result + (email != null ? email.hashCode() : 0);
        result = 31 * result + (int) admin;
        result = 31 * result + (nom != null ? nom.hashCode() : 0);
        result = 31 * result + (prenom != null ? prenom.hashCode() : 0);
        result = 31 * result + note;
        result = 31 * result + classement;
        result = 31 * result + (affected != null ? affected.hashCode() : 0);
        result = 31 * result + (choix != null ? choix.hashCode() : 0);
        return result;
    }
}
