package fr.formation.zoo;

public abstract class Felide extends Mammifere implements IChasseur {
	private boolean tache;
	
	public boolean isTache() {
		return tache;
	}

	public void setTache(boolean tache) {
		this.tache = tache;
	}

	public Felide() {
		System.out.println("Création d'un Félidé ...");
	}
	
	@Override
	public void dormir() {
		System.out.println("Le félidé dort ...");
	}
	
	@Override
	public void courir() {
		System.out.println("Le félidé court ...");	
	}
	
	@Override
	public void chasser(IChassable proie) {
		proie.defendre(this);
	}
}
