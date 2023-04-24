package fr.formation;

import java.util.Optional;

import fr.formation.factory.RepositoryFactory;
import fr.formation.model.Client;
import fr.formation.model.Fournisseur;
import fr.formation.model.Produit;
import fr.formation.repo.IClientRepository;
import fr.formation.repo.IFournisseurRepository;
import fr.formation.repo.IProduitRepository;

public class Application {
	public static void main(String[] args) {
		int choixMenu = 0;
		
		do {
			choixMenu = Menu.print();
			
			switch (choixMenu) {
				case 10: listerClients(); break;
				case 20: listerFournisseurs(); break;
				case 30: listerProduits(); break;
				
				case 11: ajouterClient(); break;
				case 21: ajouterFournisseur(); break;
				case 31: ajouterProduit(); break;
				
				case 12: modifierClient(); break;
				case 22: modifierFournisseur(); break;
				case 32: modifierProduit(); break;
				
				case 13: supprimerClient(); break;
				case 23: supprimerFournisseur(); break;
				case 33: supprimerProduit(); break;
			}
		} while (choixMenu != 0);
		
		Saisie.sc.close();
	}
	
	public static void listerClients() {
		IClientRepository repoClient = RepositoryFactory.createClientRepository();
		
		for (Client c : repoClient.findAll()) {
			System.out.println(c.getId() + "- " + c.getNom() + " " + c.getPrenom());
		}
	}
	
	public static void listerFournisseurs() {
		IFournisseurRepository repoFournisseur = RepositoryFactory.createFournisseurRepository();
		
		for (Fournisseur f : repoFournisseur.findAllWithProduits()) {
			System.out.println(f.getId() + "- " + f.getNom() + ", " + f.getResponsable());
			System.out.println(" > Ce fournisseur livre " + f.getProduits().size() + " produit(s).");
		}
	}
	
	public static void listerProduits() {
		IProduitRepository repoProduit = RepositoryFactory.createProduitRepository();
		
		for (Produit p : repoProduit.findAll()) {
			System.out.println(p.getId() + "- " + p.getNom() + ", " + p.getPrix() + " euros.");
		}
	}
	
	public static void ajouterClient() {
		IClientRepository repoClient = RepositoryFactory.createClientRepository();
		Client client = new Client();

		String nom = Saisie.next("Son nom :");
		String prenom = Saisie.next("Son prénom :");
		String email = Saisie.next("Son adresse mail :");
		
		client.setNom(nom);
		client.setPrenom(prenom);
		client.setEmail(email);
		
		client = repoClient.save(client);
		
		System.out.println("Client #" + client.getId() + " ajouté !");
	}
	
	public static void ajouterFournisseur() {
		IFournisseurRepository repoFournisseur = RepositoryFactory.createFournisseurRepository();
		Fournisseur fournisseur = new Fournisseur();

		String nom = Saisie.next("Son nom :");
		String responsable = Saisie.next("Son nom de responsable :");
		
		fournisseur.setNom(nom);
		fournisseur.setResponsable(responsable);
		
		fournisseur = repoFournisseur.save(fournisseur);
		
		System.out.println("Fournisseur #" + fournisseur.getId() + " ajouté !");
	}
	
	public static void ajouterProduit() {
		IProduitRepository repoProduit = RepositoryFactory.createProduitRepository();
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
		
		produit = repoProduit.save(produit);
		
		System.out.println("Produit #" + produit.getId() + " ajouté !");
	}
	
	public static void modifierClient() {
		IClientRepository repoClient = RepositoryFactory.createClientRepository();
		int clientId = Saisie.nextInt("Identifiant du client à modifier :");
		
		Optional<Client> optClient = repoClient.findById(clientId);
		
		if (optClient.isEmpty()) {
			System.out.println("Ce client n'existe pas.");
			return;
		}
		
		Client client = optClient.get();

		String nom = Saisie.next("Son nom :");
		String prenom = Saisie.next("Son prénom :");
		String email = Saisie.next("Son adresse mail :");
		
		client.setNom(nom);
		client.setPrenom(prenom);
		client.setEmail(email);
		
		client = repoClient.save(client);
		
		System.out.println("Client #" + client.getId() + " modifié !");
	}
	
	public static void modifierFournisseur() {
		IFournisseurRepository repoFournisseur = RepositoryFactory.createFournisseurRepository();
		int fournisseurId = Saisie.nextInt("Identifiant du fournisseur à modifier :");
		
		Optional<Fournisseur> optFournisseur = repoFournisseur.findById(fournisseurId);
		
		if (optFournisseur.isEmpty()) {
			System.out.println("Ce fournisseur n'existe pas.");
			return;
		}
		
		Fournisseur fournisseur = optFournisseur.get();

		String nom = Saisie.next("Son nom :");
		String responsable = Saisie.next("Son nom de responsable :");
		
		fournisseur.setNom(nom);
		fournisseur.setResponsable(responsable);
		
		fournisseur = repoFournisseur.save(fournisseur);
		
		System.out.println("Fournisseur #" + fournisseur.getId() + " modifié !");
	}
	
	public static void modifierProduit() {
		IProduitRepository repoProduit = RepositoryFactory.createProduitRepository();
		int produitId = Saisie.nextInt("Identifiant du produit à modifier :");
		
		Optional<Produit> optProduit= repoProduit.findById(produitId);
		
		if (optProduit.isEmpty()) {
			System.out.println("Ce produit n'existe pas.");
			return;
		}
		
		Produit produit = optProduit.get();
		
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
		
		produit = repoProduit.save(produit);
		
		System.out.println("Produit #" + produit.getId() + " modifié !");
	}
	
	public static void supprimerClient() {
		IClientRepository repoProduit = RepositoryFactory.createClientRepository();
		int clientId = Saisie.nextInt("Identifiant du client à supprimer :");
		
		repoProduit.deleteById(clientId);
	}
	
	public static void supprimerFournisseur() {
		IFournisseurRepository repoProduit = RepositoryFactory.createFournisseurRepository();
		int fournisseurId = Saisie.nextInt("Identifiant du fournisseur à supprimer :");
		
		repoProduit.deleteById(fournisseurId);
	}
	
	public static void supprimerProduit() {
		IProduitRepository repoProduit = RepositoryFactory.createProduitRepository();
		int produitId = Saisie.nextInt("Identifiant du produit à supprimer :");
		
		repoProduit.deleteById(produitId);
	}
}
