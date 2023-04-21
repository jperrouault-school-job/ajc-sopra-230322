package fr.formation.repo;

import java.util.List;

import fr.formation.model.Produit;

public interface IProduitRepository extends IRepository<Produit, Integer> {
	public List<Produit> findByPrixBetween(float a, float b);
}
