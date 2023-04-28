package fr.formation;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import fr.formation.config.AppConfig;
import fr.formation.repo.IAdresseRepository;
import fr.formation.repo.IClientRepository;
import fr.formation.repo.IFournisseurRepository;
import fr.formation.repo.IUtilisateurRepository;

public class ApplicationDataJpa {
	public static void main(String[] args) {
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
		
		// Récupère les Repositories
		IFournisseurRepository repoFournisseur = context.getBean(IFournisseurRepository.class);
		IClientRepository repoClient = context.getBean(IClientRepository.class);
		IUtilisateurRepository repoUtilisateur = context.getBean(IUtilisateurRepository.class);
		IAdresseRepository repoAdresse = context.getBean(IAdresseRepository.class);
		
		
		repoClient.findAllByEmailEndingWith("@gmail.com").forEach(c -> System.out.println(c.getEmail()));
		
		repoFournisseur.findByResponsable("Albert").forEach(f -> System.out.println(f.getResponsable()));
		
		repoUtilisateur.findByUsername("toto").ifPresentOrElse(
			u -> System.out.println("Présent !"),
			() -> System.out.println("Absent !")
		);
		
		repoAdresse.findByFournisseurId(1).ifPresentOrElse(
			u -> System.out.println("Adresse trouvée !"),
			() -> System.out.println("Adresse pas trouvée !")
		);
		
		context.close();
	}
}
