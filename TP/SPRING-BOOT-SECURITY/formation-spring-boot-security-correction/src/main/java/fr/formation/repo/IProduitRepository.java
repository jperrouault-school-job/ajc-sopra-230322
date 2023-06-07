package fr.formation.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import fr.formation.model.Produit;

public interface IProduitRepository extends JpaRepository<Produit, Integer> {
	
}
