package fr.formation;

import java.util.List;

import fr.formation.model.Administrateur;
import fr.formation.model.Fournisseur;
import fr.formation.model.Produit;
import fr.formation.model.Reparateur;
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
			.createQuery("select p from Produit p left join fetch p.fournisseur", Produit.class)
			.getResultList();
		
		em.close();
		
		// Parcours
		for (Produit p : produits) {
			System.out.println(p.getNom() + ", fourni par " + p.getFournisseur().getNom());
		}
		
		System.exit(0);
		
		// Récupérer la liste des réparateurs
		List<Reparateur> reparateurs = em
			.createQuery("select r from Reparateur r", Reparateur.class)
			.getResultList();
		
		// Parcours
		for (Reparateur r : reparateurs) {
			System.out.println(r.getNom());
		}
		
		// Lambda
		em
			.createQuery("select a from Administrateur a", Administrateur.class)
			.getResultList()
			.forEach(a -> System.out.println(a.getUsername()));
		
		
		List<Fournisseur> fournisseurs = em
			.createQuery("select f from Fournisseur f", Fournisseur.class)
			.getResultList();
		
		for (Fournisseur f : fournisseurs) {
			System.out.println(f.getNom() + ", " + f.getProduits().size() + " produit(s).");
			
			for (Produit p : f.getProduits()) {
				System.out.println(p.getNom());
			}
		}
	}
}
