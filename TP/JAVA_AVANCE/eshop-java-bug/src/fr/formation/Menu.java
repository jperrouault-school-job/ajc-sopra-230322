package fr.formation;

public class Menu {
	public static int print() {
		System.out.println("--------------------------");
		
		System.out.println("-- 1. Lister les clients");
		System.out.println("-- 2. Lister les fournisseurs");
		System.out.println("-- 3. Lister les produits");

		System.out.println("-- 4. Ajouter un client");
		System.out.println("-- 5. Ajouter un fournisseur");
		System.out.println("-- 6. Ajouter un produit");
		
		System.out.println("-- 0. Quitter");
		
		System.out.println("--------------------------");
		
		return Saisie.nextInt("Choisir le menu");
	}
}
