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
		return this.repoUtilisateur.findAll()
			// Transforme la liste en Stream
			.stream()
			
			// Transformer chaque Utilisateur en UtilisateurResponse
			// > Donc on prend chaque Utilisateur, et on appelle la méthode convert de UtilisateurResponse, qui retourne un UtilisateurResponse
			// > Donc à l'issu, on se retrouve avec un Stream de UtilisateurResponse
			.map(UtilisateurResponse::convert)
			
			// Transforme le Stream en Liste
			.toList();
	}
	
	@GetMapping("/old")
	public List<UtilisateurResponse> findAllOld() {
		List<UtilisateurResponse> response = new ArrayList<>();
		List<Utilisateur> utilisateurs = this.repoUtilisateur.findAll();
		
		// Convertir les utilisateurs en UtilisateurResponse
		for (Utilisateur utilisateur : utilisateurs) {
//			UtilisateurResponse utilisateurResponse = new UtilisateurResponse();

//			utilisateurResponse.setId(utilisateur.getId());
//			utilisateurResponse.setUsername(utilisateur.getUsername());
			
			// Permer de recopier les infos communes de utilisateur vers utilisateurResponse
//			BeanUtils.copyProperties(utilisateur, utilisateurResponse);
			
//			response.add(utilisateurResponse);
			response.add(UtilisateurResponse.convert(utilisateur));
		}
		
		return response;
	}
	
}
