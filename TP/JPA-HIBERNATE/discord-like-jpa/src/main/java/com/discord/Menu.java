package com.discord;

public class Menu {
	public static int print(boolean connected) {
		System.out.println("--------------------------");
		
		System.out.println("-- 1. S'inscrire");
		System.out.println("-- 2. Se connecter");
		System.out.println("-- 3. Lister les salons");
		System.out.println("-- 4. Créer un salon");
		System.out.println("-- 5. Lire les messages d'un salon");
		
		if (connected) {
			System.out.println("-- 6. Ajouter un message");
		}
		
		System.out.println("-- 0. Quitter");
		
		System.out.println("--------------------------");
		
		return Saisie.nextInt("Choisir le menu");
	}
}
