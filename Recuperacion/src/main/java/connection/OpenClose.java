package connection;

import java.sql.Connection;

public interface OpenClose {
	Connection open(String route);

	void close(Connection conn);
}