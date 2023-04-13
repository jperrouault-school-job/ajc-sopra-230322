package fr.formation.repo.sql;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import fr.formation.model.Client;
import fr.formation.repo.IClientRepository;

public class RepositoryClientSql extends AbstractRepositorySql implements IClientRepository {
	@Override
	public List<Client> findAll() {
		List<Client> clients = new ArrayList<>();
		
		try {
			String query = "SELECT * FROM client";
			PreparedStatement statement = connection.prepareStatement(query);
			ResultSet result = statement.executeQuery();
			
			while (result.next()) {
				clients.add(this.map(result));
			}
		}
		
		catch (SQLException ex) {
			ex.printStackTrace();
		}
		
		return clients;
	}

	@Override
	public Optional<Client> findById(int id) {
		try {
			String query = "SELECT * FROM client WHERE cli_id = ?";
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
	public Client save(Client entity) {
		try {
			if (entity.getId() == 0) { // INSERT
				String query = "INSERT INTO client (cli_nom, cli_prenom, cli_email) VALUES (?, ?, ?)";
				PreparedStatement statement = connection.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
	
				statement.setString(1, entity.getNom());
				statement.setString(2, entity.getPrenom());
				statement.setString(3, entity.getEmail());
				
				statement.executeUpdate();
				
				// On récupère l'ID généré
				ResultSet result = statement.getGeneratedKeys();
				
				if (result.next()) {
					entity.setId(result.getInt(1));
				}
			}
			
			else { // UPDATE
				String query = "UPDATE client SET cli_nom = ?, cli_prenom = ?, cli_email WHERE cli_id = ?";
				PreparedStatement statement = connection.prepareStatement(query);

				statement.setString(1, entity.getNom());
				statement.setString(2, entity.getPrenom());
				statement.setString(3, entity.getEmail());
				statement.setInt(4, entity.getId());
				
				statement.executeUpdate();
			}
		}
		
		catch (SQLException ex) {
			ex.printStackTrace();
		}
		
		return entity;
	}

	@Override
	public void deleteById(int id) {
		try {
			String query = "DELETE FROM client WHERE cli_id = ?";
			PreparedStatement statement = connection.prepareStatement(query);

			statement.setInt(1, id);
			
			statement.executeUpdate();
		}
		
		catch (SQLException ex) {
			ex.printStackTrace();
		}
	}
	
	private Client map(ResultSet result) throws SQLException {
		Client client = new Client();

		client.setId(result.getInt("cli_id"));
		client.setNom(result.getString("clinom"));
		client.setPrenom(result.getString("cli_prenom"));
		client.setEmail(result.getString("cli_email"));
		
		return client;
	}
}
