package fr.meteofrance;

import java.util.Optional;
import java.util.Scanner;

import fr.meteofrance.model.Prevision;
import fr.meteofrance.repo.IPrevisionRepository;
import fr.meteofrance.repo.sql.PrevisionRepositorySql;

public class Application {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		IPrevisionRepository repoPrevision = new PrevisionRepositorySql();
		
		System.out.println("---- VOIR UNE PREVISION ----");
		System.out.println("Saisir le nom de la ville :");
		
		String ville = sc.nextLine();
		Optional<Prevision> optPrevision = repoPrevision.findByVille(ville);
		
		if (optPrevision.isPresent()) {
			Prevision prevision = optPrevision.get();
			
			System.out.println("Voici les prévisions météo pour la ville " + prevision.getVille());
			
			switch (prevision.getMeteo()) {
				case PLUIE: System.out.println("- Pluvieux :("); break;
				case NUAGE: System.out.println("- Nuageux :/"); break;
				case VENT: System.out.println("- Venteux :/"); break;
				case SOLEILNUAGE: System.out.println("- Un peu de soleil, un peu de nuages :)"); break;
				case SOLEIL: System.out.println("- Soleil ! :D"); break;
			}
		}
		
		else {
			System.out.println("Pas de prévision pour " + ville);
		}
		
		sc.close();
	}
}
