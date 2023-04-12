package fr.formation;

import java.util.InputMismatchException;
import java.util.Scanner;

public class LireChiffre {
	// Le "throws" permet de prévenir ceux qui appellent la méthode lireEntier que potentiellement, y'aura une Exception de type ChiffreFormatException
	public int lireEntier() throws ChiffreFormatException {
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Veuillez saisir un chiffre :");
		
		try {
			int saisie = sc.nextInt();
			
			if (saisie < 0) {
//				throw new ChiffreInvalidException();
				ChiffreInvalidException ex = new ChiffreInvalidException();
				throw ex;
			}
			
			return saisie;
		}
		
		catch (InputMismatchException ex) {
			throw new ChiffreFormatException(); // On jète une nouvelle instance de ChiffreFormatException
		}
		
		finally {
			sc.close();
		}
	}
	
	
	public int lireEntierSyntaxOpenClose() throws ChiffreFormatException {
		System.out.println("Veuillez saisir un chiffre :");
		
		// Cette syntaxe permet d'ajouter automatique un "finally" qui appelera la méthode "close"
		try (Scanner sc = new Scanner(System.in)) {
			int saisie = sc.nextInt();
			
			if (saisie < 0) {
//				throw new ChiffreInvalidException();
				ChiffreInvalidException ex = new ChiffreInvalidException();
				throw ex;
			}
			
			return saisie;
		}
		
		catch (InputMismatchException ex) {
			throw new ChiffreFormatException(); // On jète une nouvelle instance de ChiffreFormatException
		}
	}
}
