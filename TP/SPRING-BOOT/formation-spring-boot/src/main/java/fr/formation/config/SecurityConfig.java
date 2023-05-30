package fr.formation.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;

@Configuration
public class SecurityConfig {

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
		
		return manager;
	}
}
