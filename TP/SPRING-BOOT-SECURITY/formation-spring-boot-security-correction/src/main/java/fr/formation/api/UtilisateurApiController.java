package fr.formation.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import fr.formation.api.request.InscriptionRequest;
import fr.formation.api.response.UtilisateurResponse;
import fr.formation.model.Utilisateur;
import fr.formation.repo.IUtilisateurRepository;

@RestController
@RequestMapping("/api/utilisateur")
public class UtilisateurApiController {
	@Autowired
	private IUtilisateurRepository repoUtilisateur;
	
	@Autowired
	private PasswordEncoder passwordEncoder;
	
	@PostMapping
	public UtilisateurResponse inscription(@RequestBody InscriptionRequest inscriptionRequest) {
		Utilisateur utilisateur = new Utilisateur();
		String password = inscriptionRequest.getPassword();
		String passwordEncode = this.passwordEncoder.encode(password);
		
		utilisateur.setUsername(inscriptionRequest.getUsername());
//		utilisateur.setPassword(this.passwordEncoder.encode(inscriptionRequest.getPassword()));
		utilisateur.setPassword(passwordEncode);
		
		this.repoUtilisateur.save(utilisateur);
		
		UtilisateurResponse response = new UtilisateurResponse();
		
		response.setId(utilisateur.getId());
		response.setUsername(utilisateur.getUsername());
		
		return response;
	}
}
