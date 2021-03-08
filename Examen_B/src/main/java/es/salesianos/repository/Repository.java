package es.salesianos.repository;

import es.salesianos.connection.H2Connection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import es.salesianos.connection.AbstractConnection;

public abstract class Repository {

	private static final String jdbcUrl = "jdbc:h2:file:./src/main/resources/test;INIT=RUNSCRIPT FROM 'classpath:scripts/create.sql'";
	private AbstractConnection manager = new H2Connection();
	

	protected Connection createConnection() {
		return manager.open(jdbcUrl);
	}

	protected void closeConnection(Connection conn) {
		manager.close(conn);
	}

	protected void close(PreparedStatement prepareStatement) {
		if (null != prepareStatement) {
			try {
				prepareStatement.close();
			} catch (SQLException e) {
				e.printStackTrace();
				throw new RuntimeException(e);
			}
		}
	}

	protected void close(ResultSet resultSet) {
		if (null != resultSet) {

			try {
				resultSet.close();
			} catch (SQLException e) {
				e.printStackTrace();
				throw new RuntimeException(e);
			}
		}
	}

} 