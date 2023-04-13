package fr.formation.model;

import java.time.LocalDateTime;

public class Commentaire {
	private int id;
	private LocalDateTime date;
	private int note;
	private String texte;
	private Produit produit;
	private Client client;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public LocalDateTime getDate() {
		return date;
	}

	public void setDate(LocalDateTime date) {
		this.date = date;
	}

	public int getNote() {
		return note;
	}

	public void setNote(int note) {
		this.note = note;
	}

	public String getTexte() {
		return texte;
	}

	public void setTexte(String texte) {
		this.texte = texte;
	}

	public Produit getProduit() {
		return produit;
	}

	public void setProduit(Produit produit) {
		this.produit = produit;
	}

	public Client getClient() {
		return client;
	}

	public void setClient(Client client) {
		this.client = client;
	}
	
	@Override
	public String toString() {
		if (this.client != null && this.produit != null) {
			return this.texte + " (" + this.note + "), écrit par " + this.client.getPrenom() + " pour le produit " + this.produit.getNom();
		}
		
		return this.texte + " (" + this.note + ")";
	}
}
