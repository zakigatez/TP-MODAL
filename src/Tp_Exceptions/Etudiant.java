package Tp_Exceptions;

import java.io.Serializable;

public class Etudiant implements Serializable {

    private String nom;
    private String prenom;
    private String matricule;
    private Niveau niveau;
    private Specialite specialite;
    private static final long serialVersionUID = 1L;


    public Etudiant(String nom, String prenom, String matricule, Niveau niveau, Specialite specialite) {
        this.nom = nom;
        this.prenom = prenom;
        this.matricule = matricule;
        this.niveau = niveau;
        this.specialite = specialite;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public String getMatricule() {
        return matricule;
    }

    public void setMatricule(String matricule) {
        this.matricule = matricule;
    }

    public Niveau getNiveau() {
        return niveau;
    }

    public void setNiveau(Niveau niveau) {
        this.niveau = niveau;
    }

    public Specialite getSpecialite() {
        return specialite;
    }

    public void setSpecialite(Specialite specialite) {
        this.specialite = specialite;
    }

    public boolean equals(Etudiant e) {
        if (this.matricule == e.getMatricule())
            return true;
        else {
            return false;
        }
    }

    public String toString() {
        return "Carte Etudiant: \n"+" Nom: "+this.nom+" \n Prenom: "+this.prenom +" \n Matricule: "+this.matricule+"\n Specialite: "+this.specialite+" \n Niveau: "+this.niveau+"\n\n";
    }
}
