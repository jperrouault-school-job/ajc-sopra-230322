package fr.formation.musique;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component // Que c'est une classe "Composant de Spring"
// > Demander à Spring de l'instancier, et de la gérer
//@Lazy // Tant qu'on demande l'instance, Spring ne créera pas l'instance
@Scope("prototype") // Demander à Spring une nouvelle instance à chaque demande d'instance
public class Guitariste implements IMusicien {
	@Autowired // Spring : si tu gère une instance de IInstrument, donne-la moi !
	@Qualifier("guitare")
	private IInstrument instrument;
	
	public Guitariste() {
		System.out.println("CREATION D'UN GUITARISTE");
	}
	
//	public void setInstrument(IInstrument instrument) {
//		this.instrument = instrument;
//	}
	
	@Override
	public void jouer() {
		System.out.println("Le guitariste joue : " + instrument.son());
	}
}
