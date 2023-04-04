package fr.formation.model;

public class Voiture extends Vehicule {
    @Override
    public void rouler() {
        System.out.println("La voiture " + this.nom + " roule avec ses 4 roues ...");
    }
}
