package fr.formation.zoo;

public class Chat extends Felide implements ISoignable {
	// Constructeur
	public Chat(String nom) {
		this.nom = nom;
		System.out.println("Création du chat " + nom + " ...");
	}
	
	public Chat() {
		System.out.println("Création d'un chat sans nom");
	}
	
	public Chat(String nom, boolean ok) {
		this.nom = nom;
		System.out.println("Création du chat " + nom + " ...");
	}
	
	
	@Override
	public void courir() {
		// TODO Auto-generated method stub
		super.courir();
	}
	
	@Override
	public void manger() {
		// TODO Auto-generated method stub
		super.manger();
	}

	// On réécrit quelque chose qui a été écrit au niveau supérieur
	@Override
	public String toString() {
		return "Chat " + this.nom;
	}

	@Override
	public void chasser(IChassable proie) {
		System.out.println("Le chachasse " + proie);
		super.chasser(proie);
	}
	
	@Override
	public void defendre(IChasseur predateur) {
		System.out.println("Le chat se défend contre " + predateur);
	}
}
