package com.discord.repo;

import java.util.Optional;

import com.discord.model.Utilisateur;

public interface IUtilisateurRepository extends IRepository<Utilisateur, Integer> {
	public Optional<Utilisateur> findByUsername(String username);
}
