package fr.formation;

import java.util.ArrayList;
import java.util.List;

import fr.formation.model.Moto;

public class Application {
    public static void main(String[] args) {
        List<Moto> motos = new ArrayList<>();

        Moto moto1 = new Moto("Honda");
        Moto moto2 = new Moto("Kawa");
        Moto moto3 = new Moto("Yam");

        motos.add(moto1);
        motos.add(moto2);
        motos.add(moto3);

        // Parcours de la liste
        for (Moto m : motos) {
            System.out.println(m.getNom());
        }
    }
}
