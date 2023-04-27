package fr.formation;

import fr.formation.model.Fournisseur;
import fr.formation.model.Produit;
import fr.formation.model.Reparateur;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class ApplicationGenerateur {
	public static void main(String[] args) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("EShopUnit");
		EntityManager em = emf.createEntityManager();
		
		// CREATION D'UN NOUVEAU FOURNISSEUR
		Fournisseur fournisseur = new Fournisseur();
		
		fournisseur.setNom("NEW FROM JPA");
		fournisseur.setResponsable("Le nom ici");
		
		em.getTransaction().begin();
		
		try {
			em.persist(fournisseur);
			em.getTransaction().commit();
		}
		
		catch (Exception ex) {
			ex.printStackTrace();
			em.getTransaction().rollback();
		}
		
		
		// CREATION D'UN NOUVEAU REPARATEUR
		Reparateur reparateur = new Reparateur();
		
		reparateur.setNom("SUPER REP");
		
		em.getTransaction().begin();
		
		try {
			em.persist(reparateur);
			em.getTransaction().commit();
		}
		
		catch (Exception ex) {
			ex.printStackTrace();
			em.getTransaction().rollback();
		}
		
		
		// CREATION D'UN NOUVEAU PRODUIT
		Produit produit = new Produit();
		
		produit.setNom("FROM JPA");
		produit.setModele("Mode");
		produit.setReference("Ref");
		produit.setPrix(150.5f);
		produit.setFournisseur(fournisseur);
		produit.setReparateur(reparateur);
		
		em.getTransaction().begin();
		
		try {
			em.persist(produit);
			em.getTransaction().commit();
		}
		
		catch (Exception ex) {
			ex.printStackTrace();
			em.getTransaction().rollback();
		}
	}
}
