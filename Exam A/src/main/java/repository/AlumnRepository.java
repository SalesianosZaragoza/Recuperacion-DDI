package repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import connection.ConnectionH2;
import connection.ConnectionManager;
import models.Alumn;

public class AlumnRepository {
	private static final String SQL_SEARCH = "SELECT ALUMN.name, ENTERPRISE.name FROM USER INNER JOIN ENTERPRISE ON ALUMN.enterprise=ENTERPRISE.id;";
	private static final String jdbcUrl = "jdbc:h2:file:./src/main/resources/test";
	ConnectionManager manager = new ConnectionH2();

	public Alumn searchAlumn(Alumn userFormulario) {
		Alumn userInDatabase = null;
		ResultSet resultSet = null;
		PreparedStatement prepareStatement = null;
		Connection conn = manager.open(jdbcUrl);
		try {
			prepareStatement = conn.prepareStatement("SELECT * FROM ALUMN WHERE name = ?");
			prepareStatement.setString(1, userFormulario.getName());
			resultSet = prepareStatement.executeQuery();
			while (resultSet.next()) {
				userInDatabase = new Alumn();
				userInDatabase.setName(resultSet.getString(1));
				userInDatabase.setAge(resultSet.getInt(2));
				userInDatabase.setAsistFct(resultSet.getString(3));
			}
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		} finally {
			close(resultSet);
			close(prepareStatement);

		}
		manager.close(conn);
		return userInDatabase;
	}

	private void close(PreparedStatement prepareStatement) {
		if (null != prepareStatement) {
			try {
				prepareStatement.close();
			} catch (SQLException e) {
				e.printStackTrace();
				throw new RuntimeException(e);
			}
		}
	}

	private void close(ResultSet resultSet) {
		if (null != resultSet) {

			try {
				resultSet.close();
			} catch (SQLException e) {
				e.printStackTrace();
				throw new RuntimeException(e);
			}
		}
	}

	public void insertAlumn(Alumn userFormulario) {
		Connection conn = manager.open(jdbcUrl);
		PreparedStatement preparedStatement = null;
		try {
			preparedStatement = conn
					.prepareStatement("INSERT INTO ALUMN (name, age, asistFCT, enerprise)" + "VALUES (?, ?, ?, ?)");
			preparedStatement.setString(1, userFormulario.getName());
			preparedStatement.setInt(2, userFormulario.getAge());
			preparedStatement.setBoolean(3, userFormulario.isFct());
			preparedStatement.setInt(4, userFormulario.getEnterprise());
			preparedStatement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		} finally {
			close(preparedStatement);
		}

		manager.close(conn);
	}

	public void updateAlumn(Alumn userFormulario) {
		Connection conn = manager.open(jdbcUrl);

		PreparedStatement preparedStatement = null;
		try {
			preparedStatement = conn.prepareStatement(
					"UPDATE ALUMN SET name = ?, age = ?, asistFCT =  ?, enterprise = ? WHERE name = ?");
			preparedStatement.setString(1, userFormulario.getName());
			preparedStatement.setInt(2, userFormulario.getAge());
			preparedStatement.setBoolean(3, userFormulario.isFct());
			preparedStatement.setInt(4, userFormulario.getEnterprise());

			preparedStatement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		} finally {
			close(preparedStatement);
			manager.close(conn);
		}

	}

}
