package fr.formation.model;

import java.time.LocalDateTime;
import java.util.List;

import fr.formation.enumerator.CommandeEtat;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "commande")
public class Commande {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "cmd_id")
	private int id;

	@Column(name = "cmd_date")
	private LocalDateTime date;

	@Column(name = "cmd_etat", nullable = false)
	@Enumerated(EnumType.ORDINAL) // Sous forme d'entiers
//	@Enumerated(EnumType.STRING) // Sous forme de String
	private CommandeEtat etat;

	@Column(name = "cmd_quantite", nullable = false)
	private int quantite;

	@ManyToOne
	@JoinColumn(name = "cmd_client_id")
	private Client client;

	@OneToMany(mappedBy = "commande")
	private List<Achat> achats;

	// Si on veut absolument lire l'id du client depuis la classe commande ..
	@Column(name = "cmd_client_id", insertable = false, updatable = false)
	private int clientId;

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

	public CommandeEtat getEtat() {
		return etat;
	}

	public void setEtat(CommandeEtat etat) {
		this.etat = etat;
	}

	public int getQuantite() {
		return quantite;
	}

	public void setQuantite(int quantite) {
		this.quantite = quantite;
	}

	public Client getClient() {
		return client;
	}

	public void setClient(Client client) {
		this.client = client;
	}

	public List<Achat> getAchats() {
		return achats;
	}

	public void setAchats(List<Achat> achats) {
		this.achats = achats;
	}

	public int getClientId() {
		return clientId;
	}

	public void setClientId(int clientId) {
		this.clientId = clientId;
	}
}
