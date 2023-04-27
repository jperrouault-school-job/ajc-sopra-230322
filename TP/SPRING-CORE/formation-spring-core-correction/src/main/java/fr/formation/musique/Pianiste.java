package fr.formation.musique;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
public class Pianiste implements IMusicien {
	@Autowired
	@Qualifier("piano")
	private IInstrument instrument;
	
	@Override
	public void jouer() {
		System.out.println("Le pianiste joue : " + instrument.son());
	}

}
