package fr.formation;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ApplicationListeFournisseur {
	public static void main(String[] args) {
		// 1- Une connexion SQL JDBC
		// 2- Un Statement
		// 3- Un ResultSet
		// 4- On peut parcourir
		
		
		try {
			// La connexion
			Connection connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/eshop", "postgres", "root");
			System.out.println("Connexion OK !");
			
			String query = "SELECT * FROM fournisseur";
			
			// Le statement avec la requête
			PreparedStatement statement = connection.prepareStatement(query);
			
			// Le ResultSet pour le résultat de la requête
			ResultSet result = statement.executeQuery();
			
			// Tant qu'on a une ligne de résultat
			while (result.next()) {
				String nom = result.getString("fou_nom");
				
				System.out.println(nom);
			}
		}
		
		catch (SQLException ex) {
			ex.printStackTrace();
		}
		
	}
}
