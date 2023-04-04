package fr.formation.zoo;

public class Loup extends Canide {
	@Override
	public void chasser(IChassable proie) {
		System.out.println("Le loup chasse ...");
	}

	@Override
	public void courir() {
		System.out.println("Le loup court ...");
	}
}
