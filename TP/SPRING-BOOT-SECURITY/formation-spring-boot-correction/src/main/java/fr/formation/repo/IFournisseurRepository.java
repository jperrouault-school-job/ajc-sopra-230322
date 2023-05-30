package fr.formation.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import fr.formation.model.Fournisseur;

public interface IFournisseurRepository extends JpaRepository<Fournisseur, Integer> {
	
}
