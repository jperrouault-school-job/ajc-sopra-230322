package fr.formation.model;

import java.util.ArrayList;
import java.util.List;

public class Fournisseur extends Personne {
    private List<Produit> produits = new ArrayList<>();

    public List<Produit> getProduits() {
        return produits;
    }

    public void setProduits(List<Produit> produits) {
        this.produits = produits;
    }
}
