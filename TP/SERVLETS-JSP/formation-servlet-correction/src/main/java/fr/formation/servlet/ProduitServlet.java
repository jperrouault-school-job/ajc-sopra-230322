package fr.formation.servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import fr.formation.model.Produit;
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
		
		List<Produit> produits = new ArrayList<>();
		Produit p1 = new Produit(1, "GoPRO HERO 12", 550);
		Produit p2 = new Produit(2, "Chaise", 54);
		Produit p3 = new Produit(3, "Table", 239);
		
		produits.add(p1);
		produits.add(p2);
		produits.add(p3);
		
		// On ajoute la liste de produits au scope Request
		req.setAttribute("produits", produits);
		
		this.getServletContext()
			.getRequestDispatcher("/WEB-INF/views/produits.jsp")
			.forward(req, resp);
	}
}
