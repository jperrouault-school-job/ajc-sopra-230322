package fr.meteofrance;

import java.util.InputMismatchException;
import java.util.Optional;
import java.util.Scanner;

import fr.meteofrance.enumerator.TypeMeteo;
import fr.meteofrance.model.Prevision;
import fr.meteofrance.repo.IPrevisionRepository;
import fr.meteofrance.repo.sql.PrevisionRepositorySql;

public class ApplicationAdmin {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		IPrevisionRepository repoPrevision = new PrevisionRepositorySql();
		
		System.out.println("---- AJOUTER UNE PREVISION ----");
		System.out.println("Saisir le nom de la ville :");
		
		String ville = sc.nextLine();
		Optional<Prevision> optPrevision = repoPrevision.findByVille(ville);
		Prevision prevision = new Prevision();
		
		if (optPrevision.isPresent()) {
			repoPrevision.deleteById(optPrevision.get().getId());
		}
		
		System.out.println("Saisir la prévision :");
		System.out.println("1. Pluie");
		System.out.println("2. Nuage");
		System.out.println("3. Vent");
		System.out.println("4. Soleil-nuage");
		System.out.println("5. Soleil");
		
		int indexMeteo = -1;
		
		while (indexMeteo < 0 || indexMeteo > 4) {
			try {
				indexMeteo = sc.nextInt() - 1;
			}
			
			catch (InputMismatchException ex) {
				sc.next();
			}
		}
		
		prevision.setVille(ville);
		prevision.setMeteo(TypeMeteo.values()[indexMeteo]);
		
		repoPrevision.save(prevision);
		System.out.println("Prévision ajoutée !");
		
		sc.close();
	}
}
