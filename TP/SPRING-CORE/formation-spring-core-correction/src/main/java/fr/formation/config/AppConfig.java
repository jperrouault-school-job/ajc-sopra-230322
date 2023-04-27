package fr.formation.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import fr.formation.musique.Guitare;
import fr.formation.musique.Guitariste;
import fr.formation.musique.IInstrument;
import fr.formation.musique.IMusicien;

@Configuration // Classe de configuration SPRING
public class AppConfig {
	@Bean // Pour que SPRING exécute la méthode, et conserve son résultat dans son contexte
	// > On aura un Instrument dans le contexte de SPRING
	public IInstrument guitare() {
		return new Guitare();
	}
	
//	@Bean
//	public IMusicien guitariste() {
//		Guitariste guitariste = new Guitariste();
//		
//		guitariste.setInstrument(guitare());
//		
//		return guitariste;
//	}
	
	@Bean
	public IMusicien guitariste(IInstrument guitare) {
		Guitariste guitariste = new Guitariste();
		
		guitariste.setInstrument(guitare);
		
		return guitariste;
	}
}
