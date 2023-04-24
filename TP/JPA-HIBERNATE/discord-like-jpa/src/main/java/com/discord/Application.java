package com.discord;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Optional;

import com.discord.factory.RepositoryFactory;
import com.discord.model.Message;
import com.discord.model.Salon;
import com.discord.model.Utilisateur;
import com.discord.repo.IMessageRepository;
import com.discord.repo.ISalonRepository;
import com.discord.repo.IUtilisateurRepository;

public class Application {
	private static Utilisateur utilisateurConnecte;
	
	public static void main(String[] args) {
		int choixMenu = 0;
		
		do {
			choixMenu = Menu.print(utilisateurConnecte != null);
			
			switch (choixMenu) {
				case 1: inscription(); break;
				case 2: connexion(); break;
				case 3: listerSalons(); break;
				case 4: ajouterSalon(); break;
				case 5: listerMessages(); break;
				case 6: ajouterMessage(); break;
			}
		} while (choixMenu != 0);
		
		Saisie.sc.close();
	}
	
	public static void inscription() {
		IUtilisateurRepository repoUtilisateur = RepositoryFactory.createUtilisateurRepository();
		Utilisateur utilisateur = new Utilisateur();

		String username = Saisie.next("Nom d'utilisateur :");
		String password = Saisie.next("Mot de passe :");
		
		utilisateur.setUsername(username);
		utilisateur.setPassword(password);
		
		utilisateur = repoUtilisateur.save(utilisateur);
		
		System.out.println("Inscription OK !");
	}
	
	public static void connexion() {
		IUtilisateurRepository repoUtilisateur = RepositoryFactory.createUtilisateurRepository();
		
		String username = Saisie.next("Nom d'utilisateur :");
		String password = Saisie.next("Mot de passe :");
		
		Optional<Utilisateur> optUtilisateur = repoUtilisateur.findByUsername(username);
		
		if (optUtilisateur.isPresent()) {
			if (optUtilisateur.get().getPassword().equals(password)) {
				System.out.println("Connexion OK !");
				utilisateurConnecte = optUtilisateur.get();
				return;
			}
		}
		
		utilisateurConnecte = null;
		System.out.println("Echec de connexion ...");
	}
	
	public static void listerSalons() {
		ISalonRepository repoSalon = RepositoryFactory.createSalonRepository();
		
		repoSalon.findAll().forEach(System.out::println);
	}
	
	public static void ajouterSalon() {
		ISalonRepository repoSalon = RepositoryFactory.createSalonRepository();
		Salon salon = new Salon();

		String nom = Saisie.next("Nom du salon :");
		
		salon.setNom(nom);
		
		salon = repoSalon.save(salon);
		
		System.out.println("Salon ajouté !");
	}
	
	public static void listerMessages() {
		IMessageRepository repoMessage = RepositoryFactory.createMessageRepository();
		int salonId = Saisie.nextInt("Saisir l'id du salon :");
		
		for (Message m : repoMessage.findAllTop10BySalonId(salonId)) {
			DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");
			
			System.out.println("[" + formatter.format(m.getDate()) + "] <" + m.getExpediteur().getUsername() + "> " + m.getContenu());
		}
	}
	
	public static void ajouterMessage() {
		if (utilisateurConnecte == null) {
			System.out.println("Vous devez être connecté !");
			return;
		}
		
		IMessageRepository repoMessage = RepositoryFactory.createMessageRepository();
		ISalonRepository repoSalon = RepositoryFactory.createSalonRepository();
		
		int salonId = Saisie.nextInt("Saisir l'id du salon :");
		Optional<Salon> optSalon = repoSalon.findById(salonId);
		
		if (optSalon.isEmpty()) {
			System.out.println("Ce salon n'existe pas ...");
			return;
		}
		
		Message message = new Message();

		String contenu = Saisie.next("Message :");
		
		message.setContenu(contenu);
		message.setExpediteur(utilisateurConnecte);
		message.setDate(LocalDateTime.now());
		message.setSalon(optSalon.get());
		
		message = repoMessage.save(message);
		
		System.out.println("Message ajouté !");
	}
}
