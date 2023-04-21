package fr.formation;

import fr.formation.model.Produit;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class ApplicationJpql {
	public static void main(String[] args) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("EShopUnit");
		EntityManager em = emf.createEntityManager();
		
		// JPQL => JPA Query Language
		
		// Sélectionner tous les produits
		// > select p from Produit p
		
		// Sélectionner le produit id 1
		// > select p from Produit p where p.id = ?1
		
		em	.createQuery("select p from Produit p where p.id = ?1 or p.id = ?2", Produit.class)
			.setParameter(1, 10) // On cherche l'id 10
			.setParameter(2, 13)
//			.getResultList() // Pour récupérer une liste
			.getSingleResult() // Pour récupérer UN SEUL élément
		;
		
		
		// La navigation des relations
		
		// > Dans le cas où c'est une relation ToOne, PAS besoin de jointure
		// >> On cherche les produits du fournisseur #1
		// >>> select p from Produit p where p.fournisseur.id = 1
		
		// >> On cherche les produits du fournisseur dont le code postal est 35000
		// >>> select p from Produit p where p.fournisseur.adresse.codePostal = 35000
		
		// > Dans le cas où c'est une relation ToMany, BESOIN de jointure
		// >> On cherche le fournisseur qui a le produit id 1
		// >>> select f from Fournisseur f left join f.produits p where p.id = 1
		// >>>> !!! SAUF que dans ce cas, on récupèrera un fournisseur SANS la liste des produits
		
		// >> On cherche le fournisseur qui a le produit id 1 (AVEC sa liste de produits)
		// >>> select f from Fournisseur f left join fetch f.produits p where p.id = 1
		// >>>> Dans ce cas, on aura le fournisseur avec sa liste de produits
	}
}
