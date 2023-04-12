package fr.formation.biblio;

import java.util.ArrayList;
import java.util.List;

public class PersonneRepositorySql {
	public List<Personne> findAll() {
		List<Personne> personnes = new ArrayList<>();
		
		Personne p1 = new Personne();
		Personne p2 = new Personne();
		Personne p3 = new Personne();
		

		p1.setId(1);
		p2.setId(2);
		p3.setId(3);

		p1.setNom("P1");
		p2.setNom("P2");
		p3.setNom("P3");

		personnes.add(p1);
		personnes.add(p2);
		personnes.add(p3);
		
		return personnes;
	}
}
