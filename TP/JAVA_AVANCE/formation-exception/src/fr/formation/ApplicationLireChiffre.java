package fr.formation;

public class ApplicationLireChiffre {
	public static void main(String[] args) {
		LireChiffre lecteur = new LireChiffre();
		
		try {
			int saisie = lecteur.lireEntier();
			System.out.println("Vous avez saisi : " + saisie);
		}
		
		catch (ChiffreFormatException ex) {
			System.out.println("La saisie n'est pas bonne.");
		}
		
		catch (ChiffreInvalidException ex) {
			System.out.println("Le chiffre doit être positif.");
		}
	}
}
