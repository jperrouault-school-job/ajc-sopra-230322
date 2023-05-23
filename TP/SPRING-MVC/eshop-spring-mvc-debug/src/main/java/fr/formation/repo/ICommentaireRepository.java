package fr.formation.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import fr.formation.model.Commentaire;

public interface ICommentaireRepository extends JpaRepository<Commentaire, Integer> {
	public List<Commentaire> findByClientId(int clientId);
}
