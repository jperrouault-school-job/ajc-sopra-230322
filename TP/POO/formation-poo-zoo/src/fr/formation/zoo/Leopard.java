package fr.formation.zoo;

public class Leopard extends Felide {
	@Override
	public void manger() {
		// TODO Auto-generated method stub
		super.manger();
	}
	
	@Override
	public void dormir() {
		System.out.println("Le léopard cherche le danger ...");
		super.dormir();
	}
	
	@Override
	public void courir() {
		// TODO Auto-generated method stub
		super.courir();
	}
	
	public void chasser(IChassable proie) {
		System.out.println("Le léopard chasse ... " + proie);
		super.chasser(proie);
	}
}
