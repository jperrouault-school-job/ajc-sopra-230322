package fr.formation.factory;

import fr.formation.repo.IClientRepository;
import fr.formation.repo.IFournisseurRepository;
import fr.formation.repo.IProduitRepository;
import fr.formation.repo.jpa.ClientRepositoryJpa;
import fr.formation.repo.jpa.FournisseurRepositoryJpa;
import fr.formation.repo.jpa.ProduitRepositoryJpa;

public class RepositoryFactory {
	public static IProduitRepository createProduitRepository() {
		return new ProduitRepositoryJpa();
	}

	public static IFournisseurRepository createFournisseurRepository() {
		return new FournisseurRepositoryJpa();
	}
	
	public static IClientRepository createClientRepository() {
		return new ClientRepositoryJpa();
	}
}
