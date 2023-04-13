package fr.formation.repo.sql;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import fr.formation.model.Client;
import fr.formation.model.Commentaire;
import fr.formation.model.Produit;
import fr.formation.repo.ICommentaireRepository;

public class RepositoryCommentaireSql extends AbstractRepositorySql implements ICommentaireRepository {
	@Override
	public List<Commentaire> findAll() {
		List<Commentaire> commentaires = new ArrayList<>();
		
		try {
			String query = """
					SELECT * FROM commentaire
					INNER JOIN produit ON pro_id = com_produit_id
					INNER JOIN client ON cli_id = com_client_id
					""";
			PreparedStatement statement = connection.prepareStatement(query);
			ResultSet result = statement.executeQuery();
			
			while (result.next()) {
				commentaires.add(this.map(result));
			}
		}
		
		catch (SQLException ex) {
			ex.printStackTrace();
		}
		
		return commentaires;
	}

	@Override
	public Optional<Commentaire> findById(int id) {
		try {
			String query = "SELECT * FROM commentaire WHERE com_id = ?";
			PreparedStatement statement = connection.prepareStatement(query);
			
			statement.setInt(1, id);
			
			ResultSet result = statement.executeQuery();
			
			if (result.next()) {
				return Optional.of(this.map(result));
			}
		}
		
		catch (SQLException ex) {
			ex.printStackTrace();
		}
		
		return Optional.empty();
	}

	@Override
	public Commentaire save(Commentaire entity) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void deleteById(int id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<Commentaire> findByClientId(int clientId) {
		List<Commentaire> commentaires = new ArrayList<>();

		try {
			String query = "SELECT * FROM commentaire WHERE com_client_id = ?";
			PreparedStatement statement = connection.prepareStatement(query);
			
			statement.setInt(1, clientId);
			
			ResultSet result = statement.executeQuery();
			
			while (result.next()) {
				commentaires.add(this.map(result));
			}
		}
		
		catch (SQLException ex) {
			ex.printStackTrace();
		}
		
		return commentaires;
	}
	
	private Commentaire map(ResultSet result) throws SQLException {
		Commentaire commentaire = new Commentaire();
		Client client = new Client();
		Produit produit = new Produit();
		
		commentaire.setId(result.getInt("com_id"));
		commentaire.setDate(result.getTimestamp("com_date").toLocalDateTime());
		commentaire.setNote(result.getInt("com_note"));
		commentaire.setTexte(result.getString("com_commentaire"));
		commentaire.setProduit(produit);
		commentaire.setClient(client);

		produit.setId(result.getInt("com_produit_id"));
		client.setId(result.getInt("com_client_id"));
		
		try {
			// Informations du client
			client.setNom(result.getString("cli_nom"));
			client.setPrenom(result.getString("cli_prenom"));
			
			// Informations du produit
			produit.setNom(result.getString("pro_nom"));
			produit.setPrix(result.getFloat("pro_prix_vente"));
		}
		
		catch (SQLException ex) {
			
		}
		
		return commentaire;
	}
}
