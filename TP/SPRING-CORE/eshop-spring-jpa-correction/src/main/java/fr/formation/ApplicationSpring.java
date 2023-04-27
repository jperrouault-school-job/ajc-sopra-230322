package fr.formation;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import fr.formation.config.AppConfig;
import fr.formation.repo.IProduitRepository;

public class ApplicationSpring {
	public static void main(String[] args) {
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
		
		IProduitRepository repoProduit = context.getBean(IProduitRepository.class);
	}
}
