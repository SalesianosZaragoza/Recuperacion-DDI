package com.mycompany.connection;

public class H2Connection extends AbstractConnection {

	@Override
	public String getDriver() {
		return "org.h2.Driver";
	}

	@Override
	public String getDatabaseStudent() {
		return "sa";
	}

	@Override
	public String getDatabasePassword() {
		return "";
	}

}
