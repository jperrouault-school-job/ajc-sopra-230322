package fr.formation.api.response;

import org.springframework.beans.BeanUtils;

import fr.formation.model.Produit;

public class ProduitResponse {
	private int id;
	private String nom;
	private float prix;
	private String modele;
	private String reference;
	private int fournisseurId;
	private String fournisseurNom;

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

	public String getModele() {
		return modele;
	}

	public void setModele(String modele) {
		this.modele = modele;
	}

	public String getReference() {
		return reference;
	}

	public void setReference(String reference) {
		this.reference = reference;
	}

	public int getFournisseurId() {
		return fournisseurId;
	}

	public void setFournisseurId(int fournisseurId) {
		this.fournisseurId = fournisseurId;
	}

	public String getFournisseurNom() {
		return fournisseurNom;
	}

	public void setFournisseurNom(String fournisseurNom) {
		this.fournisseurNom = fournisseurNom;
	}
	
	public ProduitResponse(Produit produit) {
		BeanUtils.copyProperties(produit, this);
		
		if (produit.getFournisseur() != null) {
			this.fournisseurId = produit.getFournisseur().getId();
			this.fournisseurNom = produit.getFournisseur().getNom();
		}
	}
}
