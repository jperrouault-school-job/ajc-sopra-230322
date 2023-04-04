package fr.formation.model;

public class Moto extends Vehicule {
    public Moto(String nom) {
        this.nom = nom;
    }

    @Override
    public void rouler() {
        System.out.println("La moto " + this.nom + " roule avec ses 2 roues ...");
    }
}
