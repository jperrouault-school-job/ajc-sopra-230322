package fr.formation;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Saisie {
	public static Scanner sc = new Scanner(System.in);
	
	public static int nextInt(String message) {
		System.out.println(message);
		
		try {
			return sc.nextInt();
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
			return sc.nextFloat();
		}
		
		catch (InputMismatchException ex) {
			sc.next();
			System.out.println("Cette saisie est incorrecte.");
			return nextFloat(message);
		}
	}
	
	public static String next(String message) {
		System.out.println(message);
		
		return sc.next();
	}
}
