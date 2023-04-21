package fr.formation;

import java.util.List;

import fr.formation.model.Produit;
import fr.formation.repo.IProduitRepository;
import fr.formation.repo.jpa.ProduitRepositoryJpa;

public class ApplicationRepo {
	public static void main(String[] args) {
		// Couplage faible !!
		IProduitRepository repoProduit = new ProduitRepositoryJpa();
		
		List<Produit> produits = repoProduit.findAll();
		
		System.out.println("-- Liste des produits --");
		for (Produit p : produits) {
			System.out.println(p.getId() + "- " + p.getNom() + ", " + p.getPrix() + " euros.");
		}
	}
}
