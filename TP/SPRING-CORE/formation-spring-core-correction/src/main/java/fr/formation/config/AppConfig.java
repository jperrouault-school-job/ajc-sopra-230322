package fr.formation.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration // Classe de configuration SPRING
@ComponentScan("fr.formation") // On demande à SPRING de scanner les classes de ce package
public class AppConfig {
//	@Bean // Pour que SPRING exécute la méthode, et conserve son résultat dans son contexte
//	// > On aura un Instrument dans le contexte de SPRING
//	public IInstrument guitare() {
//		return new Guitare();
//	}
//	
////	@Bean
////	public IMusicien guitariste() {
////		Guitariste guitariste = new Guitariste();
////		
////		guitariste.setInstrument(guitare());
////		
////		return guitariste;
////	}
//	
//	@Bean
//	public IMusicien guitariste(IInstrument guitare) {
//		Guitariste guitariste = new Guitariste();
//		
////		guitariste.setInstrument(guitare);
//		
//		return guitariste;
//	}
}
