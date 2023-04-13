package fr.formation;

import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

import fr.formation.model.Fournisseur;
import fr.formation.model.Produit;
import fr.formation.repo.IFournisseurRepository;
import fr.formation.repo.IProduitRepository;
import fr.formation.repo.sql.RepositoryFournisseurSql;
import fr.formation.repo.sql.RepositoryProduitSql;

public class Application {
	public static void main(String[] args) {
		// Couplage faible !!
		IProduitRepository repoProduit = new RepositoryProduitSql();
		IFournisseurRepository repoFournisseur = new RepositoryFournisseurSql();
		Scanner sc = new Scanner(System.in);

		List<Produit> produits = repoProduit.findAll();
		List<Fournisseur> fournisseurs = repoFournisseur.findAll();
		
		System.out.println("-- Liste des produits --");
		for (Produit p : produits) {
			System.out.println(p.getId() + "- " + p.getNom() + ", " + p.getPrix() + " euros.");
		}

		System.out.println("-- Liste des fournisseurs --");
		for (Fournisseur f : fournisseurs) {
			System.out.println(f.getId() + "- " + f.getNom() + ", " + f.getResponsable());
		}
		
		System.out.println("-- Créer un nouveau fournisseur");

		System.out.println("Saisir le nom du fournisseur :");
		String nom = sc.nextLine();
		
		System.out.println("Saisir le nom du responsable :");
		String responsable = sc.nextLine();
		
		Fournisseur fournisseur = new Fournisseur();

		fournisseur.setNom(nom);
		fournisseur.setResponsable(responsable);
		
		repoFournisseur.save(fournisseur);
		System.out.println("Fournisseur #" + fournisseur.getId() + " ajouté !");
		

		System.out.println("-- Supprimer un fournisseur");

		try {
			System.out.println("Saisir l'id du fournisseur à supprimer :");
			int id = sc.nextInt();
			
			repoFournisseur.deleteById(id);
		}
		
		catch (InputMismatchException ex) {
			System.out.println("Mauvaise saisie !");
		}
		
		sc.close();
	}
}
