package fr.formation.musique;

import org.springframework.stereotype.Component;

@Component
public class Piano implements IInstrument {
	@Override
	public String son() {
		return "PLAK PLAK PLAK";
	}
}
