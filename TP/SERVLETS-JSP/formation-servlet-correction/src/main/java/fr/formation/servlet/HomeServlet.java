package fr.formation.servlet;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/accueil") // Mapping d'URL
public class HomeServlet extends HttpServlet { // Hérite de HttpServlet => Serlvet
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		// getParameter qui permet de récupérer un paramètre de requête ; on aura TOUJOURS du String
		String username = req.getParameter("username");
		
		// Pour récupérer la session de l'utilisateur
		HttpSession session = req.getSession();
		
		// Pour ajouter des informations DANS la session
		session.setAttribute("utilisateur", username);

//		resp.getWriter().println("Hello " + username + "!");
		
		// Pour transférer des informations de la Servlet (Controller) vers la Vue JSP
		// > On va utiliser le scope request
		
		req.setAttribute("unAttribut", "une valeur");
		
		// Délégation de la requête vers la vue JSP
		this.getServletContext()
			.getRequestDispatcher("/WEB-INF/views/accueil.jsp")
			.forward(req, resp);
	}
}
