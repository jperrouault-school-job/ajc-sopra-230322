package fr.formation;

import fr.formation.model.Client;
import fr.formation.model.Fournisseur;
import fr.formation.model.Produit;
import fr.formation.repo.IClientRepository;
import fr.formation.repo.IFournisseurRepository;
import fr.formation.repo.IProduitRepository;
import fr.formation.repo.sql.RepositoryClientSql;
import fr.formation.repo.sql.RepositoryFournisseurSql;
import fr.formation.repo.sql.RepositoryProduitSql;

public class Application {
	public static void main(String[] args) {
		int choixMenu = 0;
		
		do {
			choixMenu = Menu.print();
			
			switch (choixMenu) {
				case 1: listerClients(); break;
				case 2: listerFournisseurs(); break;
				case 3: listerProduits(); break;
				
				case 4: ajouterClient(); break;
				case 5: ajouterFournisseur(); break;
				case 6: ajouterProduit(); break;
			}
		} while (choixMenu != 0);
		
		Saisie.sc.close();
	}
	
	public static void listerClients() {
		IClientRepository repoClient = new RepositoryClientSql();
		
		for (Client c : repoClient.findAll()) {
			System.out.println(c.getId() + "- " + c.getNom() + " " + c.getPrenom());
		}
	}
	
	public static void listerFournisseurs() {
		IFournisseurRepository repoFournisseur = new RepositoryFournisseurSql();
		
		for (Fournisseur f : repoFournisseur.findAll()) {
			System.out.println(f.getId() + "- " + f.getNom() + ", " + f.getResponsable());
		}
	}
	
	public static void listerProduits() {
		IProduitRepository repoProduit = new RepositoryProduitSql();
		
		for (Produit p : repoProduit.findAll()) {
			System.out.println(p.getId() + "- " + p.getNom() + ", " + p.getPrix() + " euros.");
		}
	}
	
	public static void ajouterClient() {
		IClientRepository repoClient = new RepositoryClientSql();
		Client client = new Client();

		String nom = Saisie.next("Son nom :");
		String prenom = Saisie.next("Son prénom :");
		String email = Saisie.next("Son adresse mail :");
		
		client.setNom(nom);
		client.setPrenom(prenom);
		client.setEmail(email);
		
		repoClient.save(client);
		
		System.out.println("Client #" + client.getId() + " ajouté !");
	}
	
	public static void ajouterFournisseur() {
		IFournisseurRepository repoFournisseur = new RepositoryFournisseurSql();
		Fournisseur fournisseur = new Fournisseur();

		String nom = Saisie.next("Son nom :");
		String responsable = Saisie.next("Son nom de responsable :");
		
		fournisseur.setNom(nom);
		fournisseur.setResponsable(responsable);
		
		repoFournisseur.save(fournisseur);
		
		System.out.println("Fournisseur #" + fournisseur.getId() + " ajouté !");
	}
	
	public static void ajouterProduit() {
		IProduitRepository repoProduit = new RepositoryProduitSql();
		Produit produit = new Produit();
		
		String nom = Saisie.next("Son nom :");
		float prix = Saisie.nextFloat("Son prix :");
		String modele = Saisie.next("Son modèle :");
		String reference = Saisie.next("Sa référence :");
		int fournisseurId = Saisie.nextInt("L'identifiant de son fournisseur :");
		
		produit.setNom(nom);
		produit.setPrix(prix);
		produit.setModele(modele);
		produit.setReference(reference);
		produit.setFournisseur(new Fournisseur());
		produit.getFournisseur().setId(fournisseurId);
		
		repoProduit.save(produit);
		
		System.out.println("Produit #" + produit.getId() + " ajouté !");
	}
}
