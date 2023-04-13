package fr.meteofrance.model;

import fr.meteofrance.enumerator.TypeMeteo;

public class Prevision {
	private int id;
	private String ville;
	private TypeMeteo meteo;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getVille() {
		return ville;
	}

	public void setVille(String ville) {
		this.ville = ville;
	}

	public TypeMeteo getMeteo() {
		return meteo;
	}

	public void setMeteo(TypeMeteo meteo) {
		this.meteo = meteo;
	}
}
