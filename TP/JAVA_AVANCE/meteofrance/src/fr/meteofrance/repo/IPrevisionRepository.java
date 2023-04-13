package fr.meteofrance.repo;

import java.util.Optional;

import fr.meteofrance.model.Prevision;

public interface IPrevisionRepository extends IRepository<Prevision> {
	public Optional<Prevision> findByVille(String ville);
}
