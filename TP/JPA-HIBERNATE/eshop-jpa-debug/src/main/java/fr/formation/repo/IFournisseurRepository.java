package fr.formation.repo;

import java.util.List;

import fr.formation.model.Fournisseur;

public interface IFournisseurRepository extends IRepository<Fournisseur, Integer> {
	public Fournisseur findByNom(String nom);
	public List<Fournisseur> findAllWithProduits();
}
