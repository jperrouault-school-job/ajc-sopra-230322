package fr.formation;

import java.util.Optional;
import java.util.Scanner;

import fr.formation.model.Fournisseur;
import fr.formation.repo.IFournisseurRepository;
import fr.formation.repo.sql.RepositoryFournisseurSql;

public class ApplicationFournisseur {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		IFournisseurRepository repoFournisseur = new RepositoryFournisseurSql();
		
		System.out.println("Saisir l'id du fournisseur à modifier :");
		int id = sc.nextInt();
		
		Optional<Fournisseur> optFournisseur = repoFournisseur.findById(id);
		
		if (optFournisseur.isEmpty()) {
			System.out.println("Le fournisseur n'existe pas.");
		}
		
		else {
			// Faut vider la touche entrée
			sc.nextLine();
			
			Fournisseur fournisseur = optFournisseur.get();
			
			System.out.println("Le fournisseur à modifier est : " + fournisseur.getNom());
			System.out.println("Choisir son nouveau nom :");
			String nouveauNom = sc.nextLine();
			
			fournisseur.setNom(nouveauNom);
			
			repoFournisseur.save(fournisseur);
		}
		
		sc.close();
	}
}
