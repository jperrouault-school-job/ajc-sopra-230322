package fr.formation.musique;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class Piano implements IInstrument {
	@Value("${musique.instrument.piano.son}")
	private String son;
	
	@Override
	public String son() {
		return son;
	}
}
