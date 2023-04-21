package fr.formation;

import java.time.LocalDateTime;

import fr.formation.model.Achat;
import fr.formation.model.Client;
import fr.formation.model.Commande;
import fr.formation.model.Produit;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class ApplicationGenerateurCommande {
	public static void main(String[] args) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("EShopUnit");
		EntityManager em = emf.createEntityManager();
		
		// CREATION D'UNE NOUVELLE COMMANDE
		Commande commande = new Commande();
		Client client = em.find(Client.class, 1); // On cherche le client avec l'id #1
		
		commande.setDate(LocalDateTime.now());
		commande.setEtat(0);
		commande.setQuantite(1);
		commande.setClient(client);
		
		// CREATION DES 2 ACHATS
		Achat achat1 = new Achat();
		Achat achat2 = new Achat();

		achat1.setCommande(commande);
		achat2.setCommande(commande);

		achat1.setProduit( em.find(Produit.class, 1) ); // On cherche le produit avec l'id #1 et on l'associé à l'achat
		achat2.setProduit( em.find(Produit.class, 2) ); // On cherche le produit avec l'id #2 et on l'associé à l'achat

		achat1.setQuantite(1);
		achat2.setQuantite(1);
		
		achat1.setMontant(50);
		achat2.setMontant(50);
		
		em.getTransaction().begin();
		
		try {
			em.persist(commande);
			em.persist(achat1);
			em.persist(achat2);
			
			em.getTransaction().commit();
		}
		
		catch (Exception ex) {
			ex.printStackTrace();
			em.getTransaction().rollback();
		}
	}
}
