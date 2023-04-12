package fr.formation;

import java.util.Scanner;

public class ApplicationSaisie {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		boolean saisieOk = false;
		
		while (saisieOk == false) {
			System.out.println("Saisir un chiffre :");
			
			try {
				int saisie = sc.nextInt();
				System.out.println("Vous avez saisi " + saisie);
				saisieOk = true;
			}
			
	//		catch (InputMismatchException ex) { // catch Exception OK aussi
	//			System.out.println("Ce n'est pas un entier !");
	//		}
			
			catch (Exception ex) {
				System.out.println(ex.getClass().getName());
//				ex.printStackTrace();
				sc.next(); // Permet de vider le caractère "retour à la ligne" qui reste si la saisie est pas bonne
			}
		}
		
		System.out.println("FIN !");
		sc.close();
	}
}
