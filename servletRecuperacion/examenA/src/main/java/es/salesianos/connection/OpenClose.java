package es.salesianos.connection;

import java.sql.Connection;

public interface OpenClose {

	Connection open(String ruta);

	void close(Connection conn);

}
