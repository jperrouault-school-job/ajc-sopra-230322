package fr.formation;

import java.util.List;

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

		List<Produit> produits = repoProduit.findByPrixBetween(10, 100);
		List<Fournisseur> fournisseurs = repoFournisseur.findAll();
		
		for (Produit p : produits) {
			System.out.println(p.getNom());
		}
		
		for (Fournisseur f : fournisseurs) {
			System.out.println(f.getNom());
		}
		
		
	}
}
