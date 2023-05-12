package fr.formation.filter;

import java.io.IOException;

import jakarta.servlet.Filter;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebFilter("/*")
public class SecurityFilter implements Filter {
	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		HttpServletRequest req = (HttpServletRequest) request;
		HttpServletResponse resp = (HttpServletResponse) response;
		
		
		// Si on va sur la page de connexion ... rien à faire si ce n'est chainer
		if (req.getRequestURI().endsWith("/connexion")) {
			chain.doFilter(request, response);
		}
		
		else {
			HttpSession session = req.getSession(); // On récupère la session de l'utilisateur
			
			// On vérifie si on est connecté
			if (session.getAttribute("userSession") != null) {
				chain.doFilter(request, response);
			}
			
			// L'utilisateur est pas connecté, donc on le redirige vers la page de connexion
			else {
				resp.sendRedirect("connexion");
			}
		}
	}
}
