package fr.formation.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.PrimaryKeyJoinColumn;
import jakarta.persistence.Table;

@Entity
@Table(name = "super_admin")
@PrimaryKeyJoinColumn(name = "sad_id")
public class SuperAdministrateur extends Utilisateur {
	@Column(name = "sad_telephone", length = 20)
	private String telephone;

	@Column(name = "sad_ip", length = 30)
	private String ip;

	public String getTelephone() {
		return telephone;
	}

	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}

	public String getIp() {
		return ip;
	}

	public void setIp(String ip) {
		this.ip = ip;
	}
}
