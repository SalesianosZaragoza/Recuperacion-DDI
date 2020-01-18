package es.salesianos.connection;

public class H2Connection extends AbstractConnection {

	public String getDriver() {
		return "org.h2.Driver";
	}

	public String getDatabaseUser() {
		return "sa";
	}

	public String getDatabasePassword() {
		return "";
	}
}