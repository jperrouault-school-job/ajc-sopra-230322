package fr.formation;

import java.util.Optional;

import fr.formation.model.Produit;
import fr.formation.repo.IProduitRepository;
import fr.formation.repo.sql.RepositoryProduitSql;

public class ApplicationFindById {
	public static void main(String[] args) {
		IProduitRepository repoProduit = new RepositoryProduitSql();
		
		// Recherche d'un produit qui existe
		Optional<Produit> optProduit = repoProduit.findById(1);
		
		if (optProduit.isPresent()) {
			Produit produit = optProduit.get();
			
			System.out.println("OK, le produit existe, et il s'appelle " + produit.getNom());
		}
		
		else {
			System.out.println("Attention, le produit n'existe pas !");
		}
	}
}
