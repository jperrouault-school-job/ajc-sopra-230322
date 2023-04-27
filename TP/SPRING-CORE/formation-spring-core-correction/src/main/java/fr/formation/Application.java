package fr.formation;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import fr.formation.config.AppConfig;
import fr.formation.musique.IMusicien;

public class Application {
	public static void main(String[] args) {
		// Créer et charger le contexte de SPRING à partir de la classe de configuration AppConfig
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);

		IMusicien guitariste = context.getBean("guitariste", IMusicien.class);
//		IMusicien guitariste2 = context.getBean("guitariste", IMusicien.class);
//		
//		if (guitariste == guitariste2) {
//			System.out.println("C PAREIL");
//		}
//		
//		else {
//			System.out.println("C PAS PAREIL");
//		}
		
		IMusicien pianiste = context.getBean("pianiste", IMusicien.class);
		
		guitariste.jouer();
		pianiste.jouer();
	}
}
