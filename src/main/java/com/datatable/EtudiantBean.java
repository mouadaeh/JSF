package com.datatable;

import com.datatable.Etudiant;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Named;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Named
@ApplicationScoped
public class EtudiantBean implements Serializable {

    private static final List<Etudiant> etudiants = new ArrayList<>();

    static {
        etudiants.add(new Etudiant(1, "Ahmed", "Mouad", "ahmed.mouad@example.com"));
        etudiants.add(new Etudiant(2, "Fatima", "Dupont", "fatima.dupont@example.com"));
    }

    public List<Etudiant> getEtudiants() {
        return etudiants;
    }
    public void ajouterEtudiant(int numero, String nom, String prenom, String email) {
        etudiants.add(new Etudiant(numero, nom, prenom, email));
    }
    public void supprimerEtudiant(int numero) {
        etudiants.removeIf(etudiant -> etudiant.getNumero() == numero);
    }
    public void updateEtudiant(int numero, String nom, String prenom, String email) {
        for (Etudiant etudiant : etudiants) {
            if (etudiant.getNumero() == numero) {
                etudiant.setNom(nom);
                etudiant.setPrenom(prenom);
                etudiant.setEmail(email);
                break;
            }
        }
    }
}
