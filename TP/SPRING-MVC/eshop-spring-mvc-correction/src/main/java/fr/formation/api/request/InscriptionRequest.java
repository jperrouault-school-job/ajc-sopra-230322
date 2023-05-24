package fr.formation.api.request;

import jakarta.validation.constraints.NotBlank;

public class InscriptionRequest {
	@NotBlank
	private String username;
	
	@NotBlank
	private String password;
	
	@NotBlank
	private String passwordVerif;

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

	public String getPasswordVerif() {
		return passwordVerif;
	}

	public void setPasswordVerif(String passwordVerif) {
		this.passwordVerif = passwordVerif;
	}
}
