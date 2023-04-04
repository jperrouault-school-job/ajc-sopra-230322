package fr.formation.zoo;

public class Chien extends Canide implements ISoignable {
	@Override
	public void chasser(IChassable proie) {
		System.out.println("Le chien chasse ...");
	}

	@Override
	public void courir() {
		System.out.println("Le chien court ...");
	}
}
