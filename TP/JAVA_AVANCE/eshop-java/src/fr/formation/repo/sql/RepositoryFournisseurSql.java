package fr.formation.repo.sql;

import java.util.ArrayList;
import java.util.List;

import fr.formation.model.Fournisseur;
import fr.formation.repo.IFournisseurRepository;

public class RepositoryFournisseurSql implements IFournisseurRepository {
	@Override
	public List<Fournisseur> findAll() {
		List<Fournisseur> fournisseurs = new ArrayList<>();

		Fournisseur f1 = new Fournisseur();
		Fournisseur f2 = new Fournisseur();
		
		f1.setId(1);
		f2.setId(2);

		f1.setNom("F1");
		f2.setNom("F2");

		fournisseurs.add(f1);
		fournisseurs.add(f2);
		
		return fournisseurs;
	}

	@Override
	public Fournisseur findByNom(String nom) {
		return null;
	}
}
