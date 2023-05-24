package fr.formation.api;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import fr.formation.api.response.UtilisateurResponse;
import fr.formation.model.Utilisateur;
import fr.formation.repo.IUtilisateurRepository;

@RestController
@RequestMapping("/api/utilisateur")
public class UtilisateurApiController {
	// DTO : Data Transform Object
	// Le principe, c'est de créer une instance spécialement dédiée pour le transfert d'information
	
	@Autowired
	private IUtilisateurRepository repoUtilisateur;
	
	@GetMapping
	public List<UtilisateurResponse> findAll() {
		List<UtilisateurResponse> response = new ArrayList<>();
		List<Utilisateur> utilisateurs = this.repoUtilisateur.findAll();
		
		// Convertir les utilisateurs en UtilisateurResponse
		for (Utilisateur utilisateur : utilisateurs) {
			UtilisateurResponse utilisateurResponse = new UtilisateurResponse();

//			utilisateurResponse.setId(utilisateur.getId());
//			utilisateurResponse.setUsername(utilisateur.getUsername());
			
			// Permer de recopier les infos communes de utilisateur vers utilisateurResponse
			BeanUtils.copyProperties(utilisateur, utilisateurResponse);
			
			response.add(utilisateurResponse);
		}
		
		return response;
	}
	
}
