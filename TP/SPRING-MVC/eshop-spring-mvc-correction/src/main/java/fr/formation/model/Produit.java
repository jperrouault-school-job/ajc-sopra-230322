package fr.formation.model;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonView;

import fr.formation.api.Views;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Positive;

@Entity
@Table(name = "produit")
public class Produit {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "pro_id")
//	@JsonView({ Views.Common.class, Views.Produit.class })
	@JsonView(Views.Common.class)
	private int id;

	@Column(name = "pro_nom", length = 255, nullable = false)
	@NotBlank
	@JsonView(Views.Produit.class)
	private String nom;

	@Column(name = "pro_prix_vente", nullable = false)
	@Positive
	@JsonView(Views.Produit.class)
	private float prix;

	@Column(name = "pro_modele", length = 100, nullable = false)
	@JsonView(Views.ProduitDetail.class)
	private String modele;

	@Column(name = "pro_reference", length = 100, nullable = false)
	@JsonView(Views.ProduitDetail.class)
	private String reference;

	@ManyToOne
	@JoinColumn(name = "pro_fournisseur_id") // Nom de la clé étrangère
//	@OnDelete(action = OnDeleteAction.CASCADE)
	private Fournisseur fournisseur;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "pro_reparateur_id")
	private Reparateur reparateur;
	
	@OneToMany(mappedBy = "produit")
	private List<Achat> achats;
	
	@ManyToMany(mappedBy = "produits")
	private List<Utilisateur> gestionnaires;

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

	public Fournisseur getFournisseur() {
		return fournisseur;
	}

	public void setFournisseur(Fournisseur fournisseur) {
		this.fournisseur = fournisseur;
	}

	public Reparateur getReparateur() {
		return reparateur;
	}

	public void setReparateur(Reparateur reparateur) {
		this.reparateur = reparateur;
	}
}
