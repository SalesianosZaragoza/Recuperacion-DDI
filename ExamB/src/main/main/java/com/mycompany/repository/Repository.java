package com.mycompany.repository;

import com.mycompany.connection.ConnectionH2;
import com.mucompany.connection.AbstractConnection;

public class Repository {
	protected static final String jdbcUrl = "jdbc:h2:file:./src/main/resources/test";
	ConnectionManager manager = new ConnectionH2();
}