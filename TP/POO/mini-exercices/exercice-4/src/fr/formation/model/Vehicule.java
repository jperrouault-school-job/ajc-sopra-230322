package fr.formation.model;

public abstract class Vehicule {
    protected String nom;
    protected float prix;

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public float getPrix() {
        return prix;
    }

    public void setPrix(float prix) {
        this.prix = prix;
    }

    public abstract void rouler();
}
