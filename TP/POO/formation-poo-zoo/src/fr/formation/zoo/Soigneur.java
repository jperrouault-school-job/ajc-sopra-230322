package fr.formation.zoo;

import java.util.List;

public class Soigneur {
	public void soigner(Chat chat) {
		System.out.println("Le soigneur soigne le chat ...");
	}
	
//	public void soigner(Chien chien) {
//		System.out.println("Le soigneur soigne le chien ...");
//	}
//
//	public void soigner(Cheval cheval) {
//		System.out.println("Le soigneur soigne le cheval ...");
//	}
	

	public void soigner(ISoignable animal) {
		if (animal instanceof Chat) {
			System.out.println("Tiens, un chat !");
		}
		
		System.out.println("Le soigneur soigne ...");
	}
	
	
	public void soigner(List<ISoignable> soignables) {
		for (ISoignable s : soignables) {
			this.soigner(s);
		}
	}
	
}
