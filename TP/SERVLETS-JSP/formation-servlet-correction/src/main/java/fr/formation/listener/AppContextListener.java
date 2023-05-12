package fr.formation.listener;

import java.util.ArrayList;
import java.util.List;

import fr.formation.model.Produit;
import jakarta.servlet.ServletContextEvent;
import jakarta.servlet.ServletContextListener;
import jakarta.servlet.annotation.WebListener;

@WebListener
public class AppContextListener implements ServletContextListener {
	@Override
	public void contextInitialized(ServletContextEvent sce) {
		
		System.out.println("DEMARRAGE DE TOMCAT !!");
		
		sce.getServletContext()
			.setAttribute("attributApp", "Une valeur application");
		
		List<Produit> produits = new ArrayList<>();
		Produit p1 = new Produit(1, "GoPRO HERO 12", 550);
		Produit p2 = new Produit(2, "Chaise", 54);
		Produit p3 = new Produit(3, "Table de jardin", 239);
		
		produits.add(p1);
		produits.add(p2);
		produits.add(p3);
		
		// On ajoute la liste de produits au scope Application
		sce.getServletContext()
			.setAttribute("produits", produits);
	}
}
