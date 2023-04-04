package uml2;

import java.util.ArrayList;
import java.util.List;

public class Formateur extends Personne {
	// List => Interface implémentée par ArrayList
	// > Permet d'avoir un "couplage faible" -> Si demain, on décide de passer à une LinkedList, on a que le new à remplacer
	
	// List<Matiere> => Liste d'éléments de type Matiere
	
	// new ArrayList -> Concrètement, la List sera de type ArrayList (un tableau derrière)
	// ArrayList<> -> Syntaxe Java (8) qui nous évite de réécrire la spécialité de la liste
	// -> Avant Java 8, on utilisait cette syntaxe : new ArrayList<Matiere>();
	private List<Matiere> matieres = new ArrayList<>();

	public List<Matiere> getMatieres() {
		return matieres;
	}

	public void setMatieres(List<Matiere> matieres) {
		this.matieres = matieres;
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
