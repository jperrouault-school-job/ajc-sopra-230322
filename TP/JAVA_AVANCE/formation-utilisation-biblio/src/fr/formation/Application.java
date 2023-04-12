package fr.formation;

import java.util.List;

import fr.formation.biblio.Personne;
import fr.formation.biblio.PersonneRepositorySql;

public class Application {
	public static void main(String[] args) {
		PersonneRepositorySql repoPersonne = new PersonneRepositorySql();
		List<Personne> personnes = repoPersonne.findAll();
		
		for (Personne p : personnes) {
			System.out.println(p.getId() + " - " + p.getNom());
		}
	}
}
