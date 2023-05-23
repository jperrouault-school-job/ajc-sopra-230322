package fr.formation.repo;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import fr.formation.model.Adresse;
import fr.formation.model.Fournisseur;

public interface IAdresseRepository extends JpaRepository<Adresse, Integer> {
	public Optional<Adresse> findByFournisseurId(int id);
	public Optional<Adresse> findByFournisseur(Fournisseur fournisseur);
}
