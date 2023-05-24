package fr.formation.api.request;

import jakarta.validation.constraints.NotBlank;

public class FournisseurRequest {
	@NotBlank
	private String nom;
	
	@NotBlank
	private String responsable;

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
}
