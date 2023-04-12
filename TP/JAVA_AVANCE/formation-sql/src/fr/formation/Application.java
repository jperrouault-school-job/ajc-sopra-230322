package fr.formation;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Application {
	public static void main(String[] args) {
		
		// Pour effectuer une requête SQL
		// 1- Se connecter au serveur SQL
		// 1.1- Il faudra fournir une adresse URL au format JDBC (Java DataBase Connection)
		// > jdbc:typesql://nomhote:port/base_de_donnees
		// > jdbc:postgresql://localhost:5432/eshop
		
		// 2- Utiliser un Statement pour exécuter une requête SQL, qu'on récupère sur la connexion
		
		// 3- A partir du Statement, exécuter la requête
		
		// 4- Si la requête retourne un résultat (requête SELECT par exemple), utiliser un ResultSet
		
		
		try {
			Connection connection = DriverManager
					.getConnection("jdbc:postgresql://localhost:5432/eshop", "postgres", "root");
			
			System.out.println("Connexion OK !");
			
			// On récupère le Statement
			Statement statement = connection.createStatement();
			
			// On exécute la requête
			ResultSet result = statement.executeQuery("SELECT * FROM produit");
			
			// Il existe également les méthodes execute() et executeUpdate() qu'on utilise quand c'est pas des SELECT
			String queryInsertNoTextBlock = "INSERT INTO blabla ..."
					+ " sans oublier l'espace"
					+ " et la suite ici"
					+ " etc ...";
			
			String queryInsertTextBlock = """
					INSERT INTO blabla
					en oubliant les espaces
					et la suite ici
					etc ....
					""";
			
			// Les 3 guillemets, c'est du Java "Text Block"
			String queryInsert = """
				INSERT INTO produit
				(pro_nom, pro_reference, pro_modele, pro_prix_achat, pro_prix_vente, pro_fournisseur_id)
				VALUES (?, ?, ?, ?, ?, ?)""";
			
			PreparedStatement statement2 = connection.prepareStatement(queryInsert);
			
			// On précise les différentes valeurs de ces paramètres
			statement2.setString(1, "FR'OM JAVA PREPARED");
			statement2.setString(2, "REFJAVA");
			statement2.setString(3, "MODJAVA");
			statement2.setFloat(4, 30);
			statement2.setFloat(5, 300);
			statement2.setInt(6, 1);
			
			statement2.executeUpdate();
			
			
			// On peut parcourir l'ensemble des résultats
			// On parcourt ligne par ligne
			// Et le next() permet de passer à la ligne suivante, en nous indique par vrai ou faux si elle existe
			while (result.next()) {
				// Pour accéder à une information, on peut y aller par son index (0, 1, 2, ...) ou par le nom de la colonne
				// Pour faire ça, on utiliser les méthodes get
				
				int id = result.getInt("pro_id");
				String nom = result.getString("pro_nom");
				float prixVente = result.getFloat("pro_prix_vente");
				
				System.out.println(id +  "- " + nom + ", " + prixVente + " euros.");
			}
		}
		
		catch (SQLException ex) {
			System.out.println("Erreur de connexion ...");
			ex.printStackTrace();
		}
	}
}
