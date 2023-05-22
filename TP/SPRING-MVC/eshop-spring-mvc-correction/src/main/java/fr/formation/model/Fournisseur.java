package fr.formation.model;

import java.util.List;

import jakarta.persistence.AttributeOverride;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;

@Entity
@Table(name = "fournisseur")
@AttributeOverride(name = "id", column = @Column(name = "fou_id"))
@AttributeOverride(name = "nom", column = @Column(name = "fou_nom", length = 100, nullable = false))
public class Fournisseur extends Personne {
	@Column(name = "fou_responsable", length = 200, nullable = false)
	@NotBlank(message = "Le nom du responsable est obligatoire")
	private String responsable;

	@OneToMany(mappedBy = "fournisseur")
	private List<Produit> produits;
	
	@OneToOne
	@JoinColumn(name = "fou_adresse_id")
	private Adresse adresse;

	public String getResponsable() {
		return responsable;
	}

	public void setResponsable(String responsable) {
		this.responsable = responsable;
	}

	public List<Produit> getProduits() {
		return produits;
	}

	public void setProduits(List<Produit> produits) {
		this.produits = produits;
	}

	public Adresse getAdresse() {
		return adresse;
	}

	public void setAdresse(Adresse adresse) {
		this.adresse = adresse;
	}
}
