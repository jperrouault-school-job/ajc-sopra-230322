package fr.formation.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import fr.formation.model.Fournisseur;

public interface IFournisseurRepository extends JpaRepository<Fournisseur, Integer> {
	public Fournisseur findByNom(String nom);
	
	public List<Fournisseur> findByResponsable(String responsable);
}
