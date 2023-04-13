package fr.formation.repo.sql;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import fr.formation.model.Produit;
import fr.formation.repo.IProduitRepository;

public class RepositoryProduitSql extends AbstractRepositorySql implements IProduitRepository {
	public List<Produit> findByPrixBetween(float a, float b) {
		return null;
	}
	
	@Override
	public List<Produit> findAll() {
		List<Produit> produits = new ArrayList<>();
		
		try {
			String query = "SELECT * FROM produit";
			PreparedStatement statement = connection.prepareStatement(query);
			ResultSet result = statement.executeQuery();
			
			while (result.next()) {
				Produit produit = new Produit();

				produit.setId(result.getInt("pro_id"));
				produit.setNom(result.getString("pro_nom"));
				produit.setPrix(result.getFloat("pro_prix_vente"));
				
				produits.add(produit);
			}
		}
		
		catch (SQLException ex) {
			ex.printStackTrace();
		}
		
		return produits;
	}

	@Override
	public Produit save(Produit entity) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void deleteById(int id) {
		// TODO Auto-generated method stub
	}

	@Override
	public Optional<Produit> findById(int id) {
		try {
			String query = "SELECT * FROM produit WHERE pro_id = ?";
			PreparedStatement statement = connection.prepareStatement(query);
			
			statement.setInt(1, id);
			
			ResultSet result = statement.executeQuery();
			
			// SOIT on a UN produit, SOIT on a RIEN
			if (result.next()) {
				Produit produit = new Produit();
				
				produit.setId(result.getInt("pro_id"));
				produit.setNom(result.getString("pro_nom"));
				produit.setPrix(result.getFloat("pro_prix_vente"));
				
				// Retourner un Optional avec le produit à l'intérieur
				return Optional.of(produit);
			}
		}
		
		catch (SQLException ex) {
			ex.printStackTrace();
		}
		
		// Si on arrive ici, c'est qu'on aura pas trouvé de Produit, donc on retourne un Optional vide
		return Optional.empty();
	}
}
