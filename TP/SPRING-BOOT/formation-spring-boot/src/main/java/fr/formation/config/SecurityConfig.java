package fr.formation.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfig {
	
	@Bean
	public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
		// Mise en place des authorisations
		http.authorizeHttpRequests(authorize -> {
			authorize.requestMatchers("/api/hello").permitAll(); // Autorisé à tout le monde
			authorize.requestMatchers("/api/fournisseur/**").hasRole("ADMIN"); // Autotisé aux utilisateurs "admin"
			authorize.requestMatchers("/**").authenticated(); // Autorisé aux utilisateurs connectés
		});
		
		// Méthode d'authentification par formulaire HTML
		http.formLogin();
		
		// Méthode d'authentification par HTTP Basic
//		http.httpBasic();
		
		// Désactiver la protection CSRF
//		http.csrf().disable();
		
		return http.build();
	}
	
	

	@Bean
	public UserDetailsService inMemory() {
		InMemoryUserDetailsManager manager = new InMemoryUserDetailsManager();
		
		// Création d'un utilisateur
		manager.createUser(
			User.withUsername("user")
				.password("{noop}123456")
				.roles("USER")
				.build()
		);
		
		// Création d'un administrateur
		manager.createUser(
			User.withUsername("admin")
				.password("{noop}123456")
				.roles("ADMIN")
				.build()
		);
		
		return manager;
	}
}
