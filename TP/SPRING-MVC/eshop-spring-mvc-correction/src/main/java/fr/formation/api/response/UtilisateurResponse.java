package fr.formation.api.response;

import org.springframework.beans.BeanUtils;

import fr.formation.model.Utilisateur;

public class UtilisateurResponse {
	private int id;
	private String username;

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
	
	public static UtilisateurResponse convert(Utilisateur utilisateur) {
		UtilisateurResponse response = new UtilisateurResponse();
		
		// Permer de recopier les infos communes de utilisateur vers response
		BeanUtils.copyProperties(utilisateur, response);
		
		return response;
	}
}
