package fr.formation.repo;

import java.util.List;

import fr.formation.model.Commentaire;

public interface ICommentaireRepository extends IRepository<Commentaire, Integer> {
	public List<Commentaire> findByClientId(int clientId);
}
