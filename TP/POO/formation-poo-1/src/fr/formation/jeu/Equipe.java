package fr.formation.jeu;

public class Equipe {
	String nom;
	Joueur[] joueurs;
	
	static Equipe creerEquipe(String nom, Joueur j1, Joueur j2) {
        Equipe equipe = new Equipe();

        equipe.nom = nom;
//        equipe.joueurs = { j1, j2 };

        return equipe;
    }
}
