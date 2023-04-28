package fr.formation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.stereotype.Component;

import fr.formation.config.AppConfig;
import fr.formation.model.Fournisseur;
import fr.formation.repo.IAdresseRepository;
import fr.formation.repo.IClientRepository;
import fr.formation.repo.IFournisseurRepository;
import fr.formation.repo.IProduitRepository;
import fr.formation.repo.IUtilisateurRepository;

@Component
public class ApplicationDataJpa {
	@Autowired
	private IFournisseurRepository repoFournisseur;
	
	@Autowired
	private IClientRepository repoClient;
	
	@Autowired
	private IUtilisateurRepository repoUtilisateur;
	
	@Autowired
	private IAdresseRepository repoAdresse;
	
	@Autowired
	private IProduitRepository repoProduit;
	
	public static void main(String[] args) {
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
		
		ApplicationDataJpa app = context.getBean(ApplicationDataJpa.class);
		app.run();
//		context.getBean(ApplicationDataJpa.class).run();
		
		context.close();
	}
	
	public void run() {
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
		
		for (Fournisseur f : repoFournisseur.findAllWithProduits()) {
			System.out.println(f.getNom() + ", " + f.getProduits().size() + " produit(s).");
		}
		
		repoProduit.findByReference("REF0");
	}
}
