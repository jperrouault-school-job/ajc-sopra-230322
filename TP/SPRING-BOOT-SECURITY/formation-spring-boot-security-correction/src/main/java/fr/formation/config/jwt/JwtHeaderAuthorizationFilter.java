package fr.formation.config.jwt;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@Component
public class JwtHeaderAuthorizationFilter extends OncePerRequestFilter {
	@Override
	protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
		String authHeader = request.getHeader("Authorization");
		
		System.out.println(authHeader);
		
		// Simuler la connexion grâce au jeton
		
		// Créer la liste des rôles
		List<GrantedAuthority> authorities = new ArrayList<>();
		
		// Le préfix "ROLE_" permet d'indiquer à SPRING SECURITY qu'il s'agit d'un rôle
		authorities.add(new SimpleGrantedAuthority("ROLE_ADMIN"));
		
		// Recréer un nouvel Authentication
		Authentication authentication = new UsernamePasswordAuthenticationToken("nomUtilisateur", null, authorities);
		
		// Injecter cet Authentication dans le contexte de sécurité
		SecurityContextHolder.getContext().setAuthentication(authentication);
		
		// Important, pour passer à la suite
		filterChain.doFilter(request, response);
	}
}
