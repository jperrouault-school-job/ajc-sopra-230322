package fr.formation;

public class Application {
	public static void main(String[] args) {
		System.out.println("DEBUT");

		try {
			System.out.println("Tentative ....");
			Integer.parseInt("azerty");
			System.out.println("Tentative OK !"); // Dès qu'il y a l'Exception, il sort du try ...
//			return;
		}

		// A chaque bloc try, il est obligatoire d'avoir au moins un bloc catch

		// Dans le catch, on indique la nature de l'Exception a attraper
		catch (NumberFormatException ex) {
			System.out.println("Attention, ceci n'est pas un entier valide ..");
//			return;
		}

		// ... On peut attraper plusieurs natures d'Exception (mais attention, l'ordre a
		// une importance)
		catch (Exception ex) {
			System.out.println("Erreur inconnue ...");
		}

		finally { // Optionnel, s'exécutera dans tous les cas
			System.out.println("Qui s'affiche dans tous les cas, AVANT le retour !");
		}

		System.out.println("FIN");

		try {
			demoCheckedException();
		}

		catch (Exception e) {
			e.printStackTrace();
		}

		demoUncheckedException();
	}

	public static void demoCheckedException() throws Exception {
		throw new Exception();
	}

	public static void demoUncheckedException() {
		throw new RuntimeException();
	}

}
