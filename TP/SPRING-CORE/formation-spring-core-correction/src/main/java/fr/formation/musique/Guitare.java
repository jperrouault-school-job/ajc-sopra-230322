package fr.formation.musique;

import org.springframework.stereotype.Component;

@Component
public class Guitare implements IInstrument {
	@Override
	public String son() {
		return "GLINK GLINK GLINK";
	}
}
