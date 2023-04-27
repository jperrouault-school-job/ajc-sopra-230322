package fr.formation.musique;

import org.springframework.beans.factory.annotation.Autowired;

public class Guitariste implements IMusicien {
	@Autowired // Spring : si tu gère une instance de IInstrument, donne-la moi !
//	@Qualifier("guitare")
	private IInstrument instrument;
	
//	public void setInstrument(IInstrument instrument) {
//		this.instrument = instrument;
//	}
	
	@Override
	public void jouer() {
		System.out.println("Le guitariste joue : " + instrument.son());
	}
}
