package fr.formation.repo;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import fr.formation.model.Produit;

public interface IProduitRepository extends JpaRepository<Produit, Integer> {
	public List<Produit> findByPrixBetween(float a, float b);
	
	@Query("select p from Produit p where p.reference = ?1")
	public Optional<Produit> findByReference(String ref);
}
