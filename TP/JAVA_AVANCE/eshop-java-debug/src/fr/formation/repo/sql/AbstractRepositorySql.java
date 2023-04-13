package fr.formation.repo.sql;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public abstract class AbstractRepositorySql {
	protected Connection connection;
	
	public AbstractRepositorySql() {
		try {
			this.connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/eshop", "postgres", "root");
		}
		
		catch (SQLException ex) {
			ex.printStackTrace();
		}
	}
}
