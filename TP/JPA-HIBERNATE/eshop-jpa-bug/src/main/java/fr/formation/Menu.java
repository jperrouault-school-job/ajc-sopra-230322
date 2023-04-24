package fr.formation;

public class Menu {
	public static int print() {
		System.out.println("--------------------------");
		
		System.out.println("-- 10. Lister les clients");
		System.out.println("-- 20. Lister les fournisseurs");
		System.out.println("-- 30. Lister les produits");

		System.out.println("-- 11. Ajouter un client");
		System.out.println("-- 21. Ajouter un fournisseur");
		System.out.println("-- 31. Ajouter un produit");

		System.out.println("-- 12. Modifier un client");
		System.out.println("-- 22. Modifier un fournisseur");
		System.out.println("-- 32. Modifier un produit");

		System.out.println("-- 13. Supprimer un client");
		System.out.println("-- 23. Supprimer un fournisseur");
		System.out.println("-- 33. Supprimer un produit");
		
		System.out.println("-- 0. Quitter");
		
		System.out.println("--------------------------");
		
		return Saisie.nextInt("Choisir le menu");
	}
}
