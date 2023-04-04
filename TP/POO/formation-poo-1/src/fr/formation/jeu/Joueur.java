package fr.formation.jeu;

public class Joueur {
	private String nom;
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
		if (age > 0) {
			this.age = age;
		}
	}
	
	
	// Constructeur
	public Joueur(int age) {
		System.out.println("CREATION D'UN JOUEUR");
		
		// Choisir d'initialiser les données
		this.nom = "Par défaut";
		this.age = age;
	}
	
	
}
