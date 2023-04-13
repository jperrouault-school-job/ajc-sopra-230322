package fr.meteofrance.repo.sql;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public abstract class AbstractRepositorySql {
	protected Connection connection;
	
	public AbstractRepositorySql() {
		try {
			this.connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/meteofrance", "postgres", "root");
		}
		
		catch (SQLException ex) {
			ex.printStackTrace();
		}
	}
}
