package fr.meteofrance.repo.sql;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

import fr.meteofrance.enumerator.TypeMeteo;
import fr.meteofrance.model.Prevision;
import fr.meteofrance.repo.IPrevisionRepository;

public class PrevisionRepositorySql extends AbstractRepositorySql implements IPrevisionRepository {
	@Override
	public List<Prevision> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Optional<Prevision> findById(int id) {
		// TODO Auto-generated method stub
		return Optional.empty();
	}

	@Override
	public Prevision save(Prevision entity) {
		try {
			String query = "INSERT INTO prevision (prev_meteo, prev_ville) VALUES (?, ?)";
			PreparedStatement statement = this.connection.prepareStatement(query);
			
			statement.setInt(1, entity.getMeteo().ordinal());
			statement.setString(2, entity.getVille());
			
			statement.execute();
		}
		
		catch (SQLException ex) {
			ex.printStackTrace();
		}
		
		return entity;
	}

	@Override
	public void deleteById(int id) {
		try {
			String query = "DELETE FROM prevision WHERE prev_id = ?";
			PreparedStatement statement = this.connection.prepareStatement(query);
			
			statement.setInt(1, id);
			
			statement.execute();
		}
		
		catch (SQLException ex) {
			ex.printStackTrace();
		}
	}

	@Override
	public Optional<Prevision> findByVille(String ville) {
		try {
			String query = "SELECT * FROM prevision WHERE LOWER(prev_ville) = ?";
			PreparedStatement statement = this.connection.prepareStatement(query);
			
			statement.setString(1, ville.toLowerCase());
			
			ResultSet result = statement.executeQuery();
			
			if (result.next()) {
				Prevision prevision = new Prevision();
				int indexMeteo = result.getInt("prev_meteo");
				
				prevision.setId(result.getInt("prev_id"));
				prevision.setVille(result.getString("prev_ville"));
				prevision.setMeteo(TypeMeteo.values()[indexMeteo]);
				
				return Optional.of(prevision);
			}
		}
		
		catch (SQLException ex) {
			ex.printStackTrace();
		}
		
		return Optional.empty();
	}
}
