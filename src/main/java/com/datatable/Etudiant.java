package com.datatable;

public class Etudiant {
    private int numero;
    private String nom;
    private String prenom;
    private String email;

    public Etudiant(int numero, String nom, String prenom, String email) {
        this.numero = numero;
        this.nom = nom;
        this.prenom = prenom;
        this.email = email;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
