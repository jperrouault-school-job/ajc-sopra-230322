package fr.formation.repo.sql;

import java.util.ArrayList;
import java.util.List;

import fr.formation.model.Produit;
import fr.formation.repo.IProduitRepository;

public class RepositoryProduitSql implements IProduitRepository {
	public List<Produit> findByPrixBetween(float a, float b) {
		return null;
	}
	
	@Override
	public List<Produit> findAll() {
		List<Produit> produits = new ArrayList<>();
		
		Produit p1 = new Produit();
		Produit p2 = new Produit();
		
		
		p1.setId(1);
		p2.setId(2);

		p1.setNom("PRODUIT 1");
		p2.setNom("PRODUIT 2");

		produits.add(p1);
		produits.add(p2);
		
		return produits;
	}
}
