package fr.formation.musique;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;

import fr.formation.config.AppConfig;

//Permet d'exécute le test dans le contexte de SPRING à partir de la configuration AppConfig
@SpringJUnitConfig(AppConfig.class)
public class GuitareTest {
	@Autowired
	private Guitare guitare;
	
	@Test
	public void shouldPlaySound() {
		
		String result = guitare.son();
		
		Assertions.assertEquals("GLINK GLINK GLINK", result);
	}
}
