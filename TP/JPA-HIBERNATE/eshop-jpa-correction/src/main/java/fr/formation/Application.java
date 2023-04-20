package fr.formation;

import java.util.List;

import fr.formation.model.Produit;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class Application {
	public static void main(String[] args) {
		// Création de l'EntityManagerFactory
		// Notre unité de persistance s'appelle EShopUnit
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("EShopUnit");
		
		// Une fois qu'on a l'EMF, on peut créer un EntityManager
		EntityManager em = emf.createEntityManager();
		
		
		// Récupération de la liste des produits
		List<Produit> produits = em
			.createQuery("select p from Produit p", Produit.class)
			.getResultList();
		
		// Parcours
		for (Produit p : produits) {
			System.out.println(p.getNom());
		}
	}
}
