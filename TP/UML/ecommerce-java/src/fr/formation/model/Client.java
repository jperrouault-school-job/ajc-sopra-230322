package fr.formation.model;

import java.util.ArrayList;
import java.util.List;

public class Client extends Personne {
    private String prenom;
    private List<Commande> commandes = new ArrayList<>();

    public String getPrenom() {
        return prenom;
    }
    
    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public List<Commande> getCommandes() {
        return commandes;
    }

    public void setCommandes(List<Commande> commandes) {
        this.commandes = commandes;
    }
}
