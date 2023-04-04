package fr.formation.zoo;

public class Cheval extends Equide implements ISoignable {
	@Override
	public void courir() {
		System.out.println("Le cheval galope ...");
	}
	
	@Override
	public void defendre(IChasseur predateur) {
		System.out.println("Le cheval se laisse faire ... :(");
	}
}
