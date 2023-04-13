package fr.formation;

import java.util.Optional;
import java.util.Scanner;

import fr.formation.model.Commentaire;
import fr.formation.repo.ICommentaireRepository;
import fr.formation.repo.sql.RepositoryCommentaireSql;

public class ApplicationCommentaire {
	public static void main(String[] args) {
		ICommentaireRepository repoCommentaire = new RepositoryCommentaireSql();
		Scanner sc = new Scanner(System.in);
		
		for (Commentaire c : repoCommentaire.findAll()) {
			System.out.println(c);
		}
		
		System.out.println("Saisir un ID commentaire :");
		int commentaireId = sc.nextInt();
		
		Optional<Commentaire> optCommentaire = repoCommentaire.findById(commentaireId);
		
		if (optCommentaire.isPresent()) {
			Commentaire commentaire = optCommentaire.get();
			
			System.out.println(commentaire);
		}
		
		else {
			System.out.println("Ce commentaire n'existe pas.");
		}
		
		System.out.println("Saisir un ID client :");
		int clientId = sc.nextInt();
		
		for (Commentaire c : repoCommentaire.findByClientId(clientId)) {
			System.out.println(c);
		}
		
		sc.close();
	}
}
