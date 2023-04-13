package fr.formation.repo.sql;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public abstract class AbstractRepositorySql {
	private Connection connection;
	
	public AbstractRepositorySql() {
		try {
			this.connection = DriverManager.getConnection("jbdc:postgresql://localhost:5432/eshop", "postgres", "root");
		}
		
		catch (SQLException ex) {
			ex.printStackTrace();
		}
	}
}
