package fr.formation.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import fr.formation.api.request.ConnexionRequest;
import fr.formation.api.request.InscriptionRequest;
import fr.formation.api.response.ConnexionResponse;
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
	
	@Autowired // Par défaut, ce manager n'existe pas dans le contexte, donc on le configure dans SecurityConfig
	private AuthenticationManager authenticationManager;
	
	@GetMapping
	@PreAuthorize("hasRole('ADMIN')")
	public List<UtilisateurResponse> findAll() {
		return this.repoUtilisateur.findAll()
				.stream()
				.map(u -> {
					UtilisateurResponse resp = new UtilisateurResponse();
					
					resp.setId(u.getId());
					resp.setUsername(u.getUsername());
					
					return resp;
				})
				.toList();
	}
	
	@PostMapping("/connexion")
	public ConnexionResponse connexion(@RequestBody ConnexionRequest connexionRequest) {
		// On va demander à SPRING SECURITY de vérifier le username / password
		// On a besoin d'un AuthenticationManager
		// On utilisera la méthode authenticate, qui attend un Authentication
		// Et on utilisera le type UsernamePasswordAuthenticationToken pour donner le username & le password
		Authentication authentication =
				new UsernamePasswordAuthenticationToken(connexionRequest.getUsername(), connexionRequest.getPassword());
		
		// On demande à SPRING SECURITY de vérifier ces informations de connexion
		this.authenticationManager.authenticate(authentication);
		
		// Si on arrive ici, c'est que la connexion a fonctionné
		ConnexionResponse response = new ConnexionResponse();
		
		response.setSuccess(true);
		response.setToken("petitjeton");
		
		return response;
	}
	
	@PostMapping("/inscription")
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
