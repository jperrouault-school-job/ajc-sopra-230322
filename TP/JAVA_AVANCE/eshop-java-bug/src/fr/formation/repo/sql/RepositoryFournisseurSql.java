package fr.formation.repo.sql;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import fr.formation.model.Fournisseur;
import fr.formation.repo.IFournisseurRepository;

public class RepositoryFournisseurSql extends AbstractRepositorySql implements IFournisseurRepository {
	@Override
	public List<Fournisseur> findAll() {
		List<Fournisseur> fournisseurs = new ArrayList<>();

		try {
			String query = "SELECT * FROM fournisseur";
			PreparedStatement statement = connection.prepareStatement(query);
			ResultSet result = statement.executeQuery();
			
			while (result.next()) {
				fournisseurs.add(this.map(result));
			}
		}
		
		catch (SQLException ex) {
			ex.printStackTrace();
		}
		
		return fournisseurs;
	}

	@Override
	public Fournisseur findByNom(String nom) {
		return null;
	}

	@Override
	public Fournisseur save(Fournisseur entity) {
		try {
			if (entity.getId() == 0) { // INSERT
				String query = "INSERT INTO fournisseur (fou_nom, fou_responsable) VALUES (?, ?)";
				PreparedStatement statement = connection.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
	
				statement.setString(1, entity.getNom());
				statement.setString(1, entity.getResponsable());
				
				statement.executeUpdate();
				
				// On récupère l'ID généré
				ResultSet result = statement.getGeneratedKeys();
				
				if (result.next()) {
					entity.setId(result.getInt(1));
				}
			}
			
			else { // UPDATE
				String query = "UPDATE fournisseur SET fou_nom = ?, fou_responsable = ? WHERE fou_id = ?";
				PreparedStatement statement = connection.prepareStatement(query);

				statement.setString(1, entity.getNom());
				statement.setString(2, entity.getResponsable());
				statement.setInt(3, entity.getId());
				
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
			String query = "DELETE FROM fournisseur WHERE fou_id = ?";
			PreparedStatement statement = connection.prepareStatement(query);

			statement.setInt(1, id);
			
			statement.executeUpdate();
		}
		
		catch (SQLException ex) {
			ex.printStackTrace();
		}
	}

	@Override
	public Optional<Fournisseur> findById(int id) {
		try {
			String query = "SELECT * FROM fournisseur WHERE fou_id = ?";
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
	
	// Avec le "throws", on ne gère pas l'Exception ici, mais on demande au niveau supérieur de la gérer
	private Fournisseur map(ResultSet result) throws SQLException {
		Fournisseur fournisseur = new Fournisseur();
		
		fournisseur.setId(result.getInt("fou_id"));
		fournisseur.setNom(result.getString("fou_nom"));
		fournisseur.setResponsable(result.getString("fou_responsable"));
		
		return fournisseur;
	}
}
