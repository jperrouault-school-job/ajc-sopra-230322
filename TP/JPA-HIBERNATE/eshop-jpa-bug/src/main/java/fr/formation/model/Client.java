package fr.formation.model;

import java.util.List;

import jakarta.persistence.AttributeOverride;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "client")
@AttributeOverride(name = "id", column = @Column(name = "cli_id"))
@AttributeOverride(name = "nom", column = @Column(name = "cli_nom", length = 100, nullable = false))
public class Client extends Personne {
	@Column(name = "cli_prenom", length = 100, nullable = false)
	private String prenom;

	@Column(name = "cli_email", length = 100, nullable = false)
	private String email;
	
	@OneToMany(mappedBy = "commande")
	private List<Commande> commandes;

	public String getPrenom() {
		return prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
}
