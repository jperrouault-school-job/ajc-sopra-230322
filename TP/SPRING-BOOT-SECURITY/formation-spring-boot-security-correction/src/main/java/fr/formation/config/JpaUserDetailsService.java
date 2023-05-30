package fr.formation.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.User.UserBuilder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import fr.formation.model.Utilisateur;
import fr.formation.repo.IUtilisateurRepository;

@Service
public class JpaUserDetailsService implements UserDetailsService {
	@Autowired
	private IUtilisateurRepository repoUtilisateur;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		Utilisateur utilisateur = this.repoUtilisateur
					.findByUsername(username)
					.orElseThrow(() -> new UsernameNotFoundException("L'utilisateur n'existe pas."));
		
		// Si l'utilisateur n'a pas été trouvé, l'exception sera jetée, et on s'arrêtera là
		
		UserBuilder userBuilder = User.withUsername(username).password(utilisateur.getPassword());
		
		if (utilisateur.getAdmin() != null && utilisateur.getAdmin() == true) {
			userBuilder.roles("ADMIN", "USER");
		}
		
		else {
			userBuilder.roles("USER");
		}
		
		return userBuilder.build();
	}
}
