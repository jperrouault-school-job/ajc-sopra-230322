package fr.formation;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import fr.formation.model.Moto;
import fr.formation.model.Vehicule;
import fr.formation.model.Voiture;

public class Application {
    public static void main(String[] args) {
        List<Vehicule> vehicules = new ArrayList<>();

        Voiture voiture1 = new Voiture();
        Voiture voiture2 = new Voiture();
        Moto moto1 = new Moto("Honda");

        voiture1.setNom("Peugeot");
        voiture2.setNom("Citroen");

        vehicules.add(voiture1);
        vehicules.add(voiture2);
        vehicules.add(moto1);

        // Mélanger la liste
        Collections.shuffle(vehicules);

        // Parcours de la liste
        for (Vehicule v : vehicules) {
            v.rouler();
        }
    }
}
