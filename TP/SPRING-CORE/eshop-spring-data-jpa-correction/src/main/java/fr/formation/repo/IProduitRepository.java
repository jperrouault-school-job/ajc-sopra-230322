package fr.formation.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import fr.formation.model.Produit;

public interface IProduitRepository extends JpaRepository<Produit, Integer> {
	public List<Produit> findByPrixBetween(float a, float b);
}
