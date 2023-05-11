package fr.formation.servlet;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/demo-form")
public class DemoFormServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		this.getServletContext()
			.getRequestDispatcher("/WEB-INF/views/demo-form.jsp")
			.forward(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		String username = req.getParameter("username");
		
		System.out.println("l'utilisateur " + username);
		
		// Je réaffiche le formulaire
//		this.getServletContext()
//			.getRequestDispatcher("/WEB-INF/views/demo-form.jsp")
//			.forward(req, resp);
		
//		this.getServletContext()
//			.getRequestDispatcher("/WEB-INF/views/accueil.jsp")
//			.forward(req, resp);
		
		// Je redirige
		resp.sendRedirect("accueil");
	}
	
}
