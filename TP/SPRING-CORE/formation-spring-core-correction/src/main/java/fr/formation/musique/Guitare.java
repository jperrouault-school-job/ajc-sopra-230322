package fr.formation.musique;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class Guitare implements IInstrument {
	@Value("${musique.instrument.guitare.son:GLINK GLINK GLINK}")
	private String son;
	
	@Override
	public String son() {
		return son;
	}
}
