package fr.formation.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fr.formation.model.Fournisseur;
import fr.formation.repo.IFournisseurRepository;
import jakarta.transaction.Transactional;

@Service
public class FournisseurService {
	@Autowired
	private IFournisseurRepository repoFournisseur;
	
	@Transactional
	public void showFournisseurs() {
		for (Fournisseur f : repoFournisseur.findAll()) {
			System.out.println(f.getNom());
//			System.out.println(f.getProduits().size() + " produits.");
		}
	}
}
