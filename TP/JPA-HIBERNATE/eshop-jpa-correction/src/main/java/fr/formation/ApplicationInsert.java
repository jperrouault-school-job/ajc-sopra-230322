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
		
		System.out.println(nouveauFournisseur.getId());
		
		// Pour les UPDATES
		
		nouveauFournisseur.setResponsable("Un autre responsable");
		
		// IL NOUS FAUT TOUJOURS UNE TRANSACTION
		
		em.getTransaction().begin();
		
		try {
			nouveauFournisseur = em.merge(nouveauFournisseur);
			em.getTransaction().commit();
		}
		
		catch (Exception ex) {
			em.getTransaction().rollback();
		}
		
		
		
		// Pour les DELETES
		
		em.getTransaction().begin();
		
		try {
			// SOLUTION #1, on a déjà le fournisseur à supprimer
//			em.remove(nouveauFournisseur); 

			// SOLUTION #2, on a pas le fournisseur, on va le chercher
//			Fournisseur fournisseurASupprimer = em.find(Fournisseur.class, 12);
//			em.remove(fournisseurASupprimer);
			
			// SOLUTION #3 (pas à privilégier), on a pas le fournisseur, on va le créer
			Fournisseur fournisseurASupprimer2 = new Fournisseur();
			
			fournisseurASupprimer2.setId(13);
			fournisseurASupprimer2 = em.merge(fournisseurASupprimer2);
			em.remove(fournisseurASupprimer2);
			
			em.getTransaction().commit();
		}
		
		catch (Exception ex) {
			em.getTransaction().rollback();
		}
		
	}
}
