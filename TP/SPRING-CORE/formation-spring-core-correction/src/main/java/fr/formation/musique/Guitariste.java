package fr.formation.musique;

public class Guitariste implements IMusicien {
	private IInstrument instrument;
	
	public void setInstrument(IInstrument instrument) {
		this.instrument = instrument;
	}
	
	@Override
	public void jouer() {
		System.out.println("Le guitariste joue : " + instrument.son());
	}
}
