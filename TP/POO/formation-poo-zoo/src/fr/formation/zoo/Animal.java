package fr.formation.zoo;

public abstract class Animal implements IChassable {
	protected String nom;
	private int age;

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}
	
	public void manger() {
		
	}
	
	public void dormir() {
		System.out.println("L'animal dort ...");
	}
	
	@Override
	public void defendre(IChasseur predateur) {
		System.out.println("L'animal se sauve ...");
	}
	
	@Override
	public String toString() {
		return this.getClass().getSimpleName();
	}
}
