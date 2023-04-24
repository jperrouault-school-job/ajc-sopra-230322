package com.discord.factory;

import com.discord.repo.IMessageRepository;
import com.discord.repo.ISalonRepository;
import com.discord.repo.IUtilisateurRepository;
import com.discord.repo.jpa.MessageRepositoryJpa;
import com.discord.repo.jpa.SalonRepositoryJpa;
import com.discord.repo.jpa.UtilisateurRepositoryJpa;

public class RepositoryFactory {
	public static IUtilisateurRepository createUtilisateurRepository() {
		return new UtilisateurRepositoryJpa();
	}
	
	public static IMessageRepository createMessageRepository() {
		return new MessageRepositoryJpa();
	}
	
	public static ISalonRepository createSalonRepository() {
		return new SalonRepositoryJpa();
	}
}
