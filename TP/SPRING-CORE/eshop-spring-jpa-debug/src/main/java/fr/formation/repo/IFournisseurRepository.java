package fr.formation.repo;

import fr.formation.model.Fournisseur;

public interface IFournisseurRepository extends IRepository<Fournisseur, Integer> {
	public Fournisseur findByNom(String nom);
}
