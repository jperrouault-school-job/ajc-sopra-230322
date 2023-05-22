package fr.formation.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import fr.formation.model.Client;

public interface IClientRepository extends JpaRepository<Client, Integer> {
	public List<Client> findAllByEmailEndingWith(String email);
}
