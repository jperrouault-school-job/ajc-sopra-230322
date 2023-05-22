package fr.formation.model;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Positive;

public class Produit {
	private int id;
	
	@NotBlank(message = "Le nom doit être saisi")
	private String nom;
	
	@Positive(message = "Le prix doit être positif")
	private float prix;

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

	public float getPrix() {
		return prix;
	}

	public void setPrix(float prix) {
		this.prix = prix;
	}
}
