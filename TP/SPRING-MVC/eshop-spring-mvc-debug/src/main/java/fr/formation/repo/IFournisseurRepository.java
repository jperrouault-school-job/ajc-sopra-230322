package fr.formation.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import fr.formation.model.Fournisseur;

public interface IFournisseurRepository extends JpaRepository<Fournisseur, Integer> {
	public Fournisseur findByNom(String nom);
	
	public List<Fournisseur> findByResponsable(String responsable);
	
	@Query("select f from Fournisseur f left join fetch f.produits p")
	public List<Fournisseur> findAllWithProduits();
}
