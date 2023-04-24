package com.discord;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Saisie {
	public static Scanner sc = new Scanner(System.in);
	
	public static int nextInt(String message) {
		System.out.println(message);
		
		try {
			int saisie = sc.nextInt();
			sc.nextLine(); // On supprime le retour à la ligne qui reste
			return saisie;
		}
		
		catch (InputMismatchException ex) {
			sc.next();
			System.out.println("Cette saisie est incorrecte.");
			return nextInt(message);
		}
	}
	
	public static float nextFloat(String message) {
		System.out.println(message);
		
		try {
			float saisie = sc.nextFloat();
			sc.nextLine(); // On supprime le retour à la ligne qui reste
			return saisie;
		}
		
		catch (InputMismatchException ex) {
			sc.next();
			System.out.println("Cette saisie est incorrecte.");
			return nextFloat(message);
		}
	}
	
	public static String next(String message) {
		System.out.println(message);
		
		return sc.nextLine();
	}
}
