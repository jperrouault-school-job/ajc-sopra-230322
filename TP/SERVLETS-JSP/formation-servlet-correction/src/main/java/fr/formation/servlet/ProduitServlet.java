package fr.formation.servlet;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/produits")
public class ProduitServlet extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//		req.setAttribute("produit", "Un nom de produit exemple");
		
		
		this.getServletContext()
			.getRequestDispatcher("/WEB-INF/views/produits.jsp")
			.forward(req, resp);
	}
}
