package fr.formation;

import java.util.ArrayList;

import fr.formation.jeu.Carte;

public class Application {

	public static void main(String[] args) {
		// Instancier la collection de Carte
		ArrayList<Carte> mesCartes = new ArrayList<>();

		Carte maCarte;

		// Fabrication des 32 cartes
		for (int i = 0; i < 32; i++) {
		    // Instanciation d'une nouvelle Carte
		    maCarte = new Carte();
//		    maCarte.valeur = i;
//		    maCarte.nom = "Carte #" + i;
		    
		    maCarte.setValeur(i);
		    maCarte.setNom("Carte #" + i);
		    
		    // Ajouter la carte à la collection
		    mesCartes.add(maCarte);
		}

		// Afficher la taille de la collection
		System.out.println("Taille : " + mesCartes.size());

		// Parcourir la collection avec une boucle "Pour" classique
		for (int i = 0; i < mesCartes.size(); i++) {
		    Carte c = mesCartes.get(i);
//		    System.out.println(c.nom);
		    System.out.println(c.getNom());
		}

		// Parcourir la collection avec une boucle "PourChaque"
		// Pour chaque Carte "c" contenues dans "mesCartes"
		for (Carte c : mesCartes) {
//		    System.out.println(c.nom);
		    System.out.println(c.getNom());
		}
	}
}
