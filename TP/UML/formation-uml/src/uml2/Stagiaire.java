package uml2;

import uml1.Ordinateur;

public class Stagiaire extends Personne {
	private int age;

	private Ordinateur ordinateur;
	private Matiere matiere;

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public Ordinateur getOrdinateur() {
		return ordinateur;
	}

	public void setOrdinateur(Ordinateur ordinateur) {
		this.ordinateur = ordinateur;
	}

	public Matiere getMatiere() {
		return matiere;
	}

	public void setMatiere(Matiere matiere) {
		this.matiere = matiere;
	}

	public Stagiaire(Ordinateur ordinateur) {
		this.ordinateur = ordinateur;
	}

	public void anniversaire() {

	}
	
	@Override
	public void question() {
		super.question();
	}
	
	@Override
	public void reponse() {
		super.reponse();
	}
}
