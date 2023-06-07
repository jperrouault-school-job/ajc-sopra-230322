package fr.formation.api.response;

import org.springframework.beans.BeanUtils;

import fr.formation.model.Fournisseur;

public class FournisseurResponse {
	private int id;
	private String nom;
	private String responsable;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}
	
	public String getResponsable() {
		return responsable;
	}

	public void setResponsable(String responsable) {
		this.responsable = responsable;
	}

	public FournisseurResponse(Fournisseur fournisseur) {
		BeanUtils.copyProperties(fournisseur, this);
	}
}
