package fr.formation;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.InputMismatchException;
import java.util.Scanner;

public class ApplicationSupprimerProduit {
	public static void main(String[] args) {
		// 1- Demander à l'utilisateur un ID
		// 2- Se connecter
		// 3- Préparer la requête de suppression
		// 4- Exécuter la requête
		
		
		try {
			Scanner sc = new Scanner(System.in);
			
			System.out.println("Saisir un ID produit à supprimer :");
			
			int id = sc.nextInt();
			
			Connection connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/eshop", "postgres", "root");
			
			String query = "DELETE FROM produit WHERE pro_id = ?";
			
			PreparedStatement statement = connection.prepareStatement(query);
			
			statement.setInt(1, id);
			
			int rows = statement.executeUpdate();
			System.out.println(rows + " ligne(s) supprimée(s) ...");
		}
		
		catch (InputMismatchException ex) {
			System.out.println("Problème dans la saisie");
		}
		
		catch (SQLException ex) {
			ex.printStackTrace();
		}
		
	}
}
