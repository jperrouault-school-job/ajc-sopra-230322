package fr.formation.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.access.expression.method.DefaultMethodSecurityExpressionHandler;
import org.springframework.security.access.expression.method.MethodSecurityExpressionHandler;
import org.springframework.security.access.hierarchicalroles.RoleHierarchy;
import org.springframework.security.access.hierarchicalroles.RoleHierarchyImpl;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableMethodSecurity(prePostEnabled = true) // Activer les annotations PrePost pour les accès
public class SecurityConfig {
	
	@Bean
	public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
		// Mise en place des authorisations
		http.authorizeHttpRequests(authorize -> {
//			authorize.requestMatchers("/api/hello").permitAll(); // Autorisé à tout le monde
//			authorize.requestMatchers("/api/utilisateur/**").permitAll(); // Autorisé à tout le monde
			
			authorize.requestMatchers("/api/hello", "/api/utilisateur/**").permitAll(); // Autorisé à tout le monde
			
			// Les accès seront configurés via les annotations PrePost
//			authorize.requestMatchers("/api/fournisseur/**").hasRole("ADMIN"); // Autotisé aux utilisateurs "admin"
			
			authorize.requestMatchers("/**").authenticated(); // Autorisé aux utilisateurs connectés
		});
		
		// Méthode d'authentification par formulaire HTML
//		http.formLogin();
		
		// Méthode d'authentification par HTTP Basic
		http.httpBasic();
		
		// Désactiver la protection CSRF
		http.csrf().disable();
		
		return http.build();
	}
	
	
	@Bean
	public PasswordEncoder passwordEncoder() {
		// Pas d'encadage sur les mots de passe - PAS BIEN
//		return NoOpPasswordEncoder.getInstance();
		
//		System.out.println(new BCryptPasswordEncoder().encode("123456"));
		
		// Encodage Blowfish
		return new BCryptPasswordEncoder();
	}
	
	@Bean
	public static MethodSecurityExpressionHandler methodExpressionHandler(RoleHierarchy roleHierarchy) {
		DefaultMethodSecurityExpressionHandler hdlr = new DefaultMethodSecurityExpressionHandler();
		
		hdlr.setRoleHierarchy(roleHierarchy);		
		
		return hdlr;
	}
	
	@Bean
	public RoleHierarchy roleHierarchy() {
		String hierarchy = "ROLE_ADMIN > ROLE_USER";
		
		RoleHierarchyImpl roleHierarchy = new RoleHierarchyImpl();
		
		roleHierarchy.setHierarchy(hierarchy);
		
		return roleHierarchy;
	}
	

//	@Bean
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
