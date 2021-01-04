package es.salesianos.repository;

import es.salesianos.connection.ConnectionH2;
import es.salesianos.connection.ConnectionManager;

public class Repository {
	protected static final String jdbcUrl = "jdbc:h2:file:./src/main/resources/test";
	ConnectionManager manager = new ConnectionH2();
}
