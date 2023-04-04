package fr.formation.model;

public class CommandeDetail {
    private int quantite;
    private Commande commande;
    private Produit produit;

    public int getQuantite() {
        return quantite;
    }

    public void setQuantite(int quantite) {
        this.quantite = quantite;
    }

    public Commande getCommande() {
        return commande;
    }

    public void setCommande(Commande commande) {
        this.commande = commande;
    }

    public Produit getProduit() {
        return produit;
    }

    public void setProduit(Produit produit) {
        this.produit = produit;
    }

    public CommandeDetail(Commande commande, Produit produit) {
        this.commande = commande;
        this.produit = produit;
    }
}
