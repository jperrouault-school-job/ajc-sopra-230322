package fr.formation.model;

import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Inheritance;
import jakarta.persistence.InheritanceType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;

@Entity
@Table(name = "utilisateur")
@Inheritance(strategy = InheritanceType.JOINED)
public class Utilisateur {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "uti_id")
	private int id;
	
	@Column(name = "uti_username", length = 50, nullable = false)
	@NotBlank(message = "Le nom d'utilisateur est forcément obligatoire")
	private String username;
	
	@Column(name = "uti_password", length = 200, nullable = false)
	@NotBlank(message = "Un mot de passe doit être saisi")
	private String password;
	
	@ManyToMany
	@JoinTable(
		name = "gestion",
		joinColumns = @JoinColumn(name = "gest_utilisateur_id"),
		inverseJoinColumns = @JoinColumn(name = "gest_produit_id")
	)
	private List<Produit> produits;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public List<Produit> getProduits() {
		return produits;
	}

	public void setProduits(List<Produit> produits) {
		this.produits = produits;
	}
}
