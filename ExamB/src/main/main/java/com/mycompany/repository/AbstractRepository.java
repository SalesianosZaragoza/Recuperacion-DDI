package com.mycompany.repository;

import com.mycompany.connection.AbstractConnection;
import com.mycompany.connection.H2Connection;

public abstract class AbstractRepository {

	protected static final String jdbcUrl = "jdbc:h2:file:./src/main/resources/test;INIT=RUNSCRIPT FROM 'classpath:scripts/create.sql'";
	protected AbstractConnection manager = new H2Connection();

}
