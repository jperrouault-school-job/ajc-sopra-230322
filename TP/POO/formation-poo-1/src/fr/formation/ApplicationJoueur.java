package fr.formation;

import fr.formation.jeu.Joueur;

public class ApplicationJoueur {
	public static void main(String[] args) {
		
		Joueur j1 = new Joueur(4);
		Joueur j2 = new Joueur(50);
		Joueur j3 = new Joueur(14);
		Joueur j4 = new Joueur(32);
		
		// Instancier un nouveau joueur
		Joueur joueur = new Joueur(14);

		j4.setAge(41);
		j3.setAge(12);
		
//		joueur.age = -5;
		joueur.setAge(-5);
		
//		System.out.println(joueur.age);
		System.out.println(joueur.getAge());
		
		
		joueur.setAge(40);
		System.out.println("L'age est " + joueur.getAge());
	}
}
