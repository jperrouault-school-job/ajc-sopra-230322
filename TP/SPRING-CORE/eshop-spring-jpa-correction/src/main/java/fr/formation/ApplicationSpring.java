package fr.formation;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import fr.formation.config.AppConfig;
import fr.formation.model.Fournisseur;
import fr.formation.repo.IFournisseurRepository;
import fr.formation.repo.IProduitRepository;
import fr.formation.service.FournisseurService;

public class ApplicationSpring {
	public static void main(String[] args) {
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);

		IProduitRepository repoProduit = context.getBean(IProduitRepository.class);
		IFournisseurRepository repoFournisseur = context.getBean(IFournisseurRepository.class);
		
//		repoProduit.findAll().forEach(p -> System.out.println(p.getNom()));
		
		Fournisseur nouveauFournisseur = new Fournisseur();
		
		nouveauFournisseur.setNom("FROM SPRING JPA");
		nouveauFournisseur.setResponsable("Le responsable");
		
		repoFournisseur.save(nouveauFournisseur);
		
		for (Fournisseur f : repoFournisseur.findAll()) {
			System.out.println(f.getNom());
		}
		
		
		FournisseurService srvFournisseur = context.getBean(FournisseurService.class);
		srvFournisseur.showFournisseurs();
	}
}
