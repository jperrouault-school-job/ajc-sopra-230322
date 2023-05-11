package fr.formation.servlet;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/connexion")
public class LoginServlet extends HttpServlet {
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// Affichage du formulaire
		this.getServletContext()
			.getRequestDispatcher("/WEB-INF/views/connexion.jsp")
			.forward(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// Récupérer les paramètres
		String username = req.getParameter("username");
		String password = req.getParameter("password");
		
		// Vérifier si le login est OK
		if (username.equals("Admin") && password.equals("123456$")) { // On est OK
			// On récupère la session de l'utilisateur
			HttpSession session = req.getSession();
			
			// On injecte dans la session le nom d'utilisateur
			session.setAttribute("userSession", username);
			
			// Rediriger vers la page d'accueil
			resp.sendRedirect("accueil");
		}
		
		else { // On est PAS OK
			// TODO montrer avec redirection
			
			// Gestion du message d'erreur
			req.setAttribute("error", "Le nom d'utilisateur ou le mot de passe est incorrect.");
			
			// On réaffiche le formulaire
			this.doGet(req, resp);
		}
		
	}
	
}
