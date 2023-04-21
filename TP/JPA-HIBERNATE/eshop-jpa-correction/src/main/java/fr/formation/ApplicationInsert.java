package fr.formation;

import fr.formation.model.Fournisseur;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class ApplicationInsert {
	public static void main(String[] args) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("EShopUnit");
		EntityManager em = emf.createEntityManager();
		
		// Pour les sélections
//		em.createQuery("...")
		Fournisseur fournisseur = em.find(Fournisseur.class, 1); // ID 1 du fournisseur
		System.out.println(fournisseur.getNom());
		
		
		// Pour les INSERT
		Fournisseur nouveauFournisseur = new Fournisseur();
		
		nouveauFournisseur.setNom("FROM JPA");
		nouveauFournisseur.setResponsable("Le responsable ici, c'est moi.");
		
		// TOUTES LES REQUETES DE MODIFS DE DONNEES (INSERT, UPDATE, DELETE)
		// IL FAUT UNE TRANSACTION ... A DEMERRER, PUIS A COMMITER (appliquer les changements)
		
		em.getTransaction().begin(); // On démarre la transaction
		
		try {
			em.persist(nouveauFournisseur);	
			em.getTransaction().commit(); // On applique les changements
		}
		
		catch (Exception ex) {
			em.getTransaction().rollback(); // On annule les changements si Exception
		}
	}
}
