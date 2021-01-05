package repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import connection.ConnectionH2;
import connection.ConnectionManager;
import models.Enterprise;

public class EnterpriseRepository {
	private static final String SQL_SEARCH = "SELECT ALUMN.name, ENTERPRISE.name FROM USER INNER JOIN ENTERPRISE ON ALUMN.enterprise=ENTERPRISE.id;";
	private static final String jdbcUrl = "jdbc:h2:file:./src/main/resources/test";
	ConnectionManager manager = new ConnectionH2();

	public Enterprise searchEnterprise(Enterprise userFormulario) {
		Enterprise userInDatabase = null;
		ResultSet resultSet = null;
		PreparedStatement prepareStatement = null;
		Connection conn = manager.open(jdbcUrl);
		try {
			prepareStatement = conn.prepareStatement("SELECT * FROM ENTERPRISE WHERE name = ?");
			prepareStatement.setString(1, userFormulario.getName());
			resultSet = prepareStatement.executeQuery();
			while (resultSet.next()) {
				userInDatabase = new Enterprise();
				userInDatabase.setName(resultSet.getString(1));
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

	public void insertEnterprise(Enterprise enterpriseFormulario) {
		Connection conn = manager.open(jdbcUrl);
		PreparedStatement preparedStatement = null;
		try {
			preparedStatement = conn
					.prepareStatement("INSERT INTO ENTERPRISE (name)" + "VALUES (?)");
			preparedStatement.setString(1, enterpriseFormulario.getName());
			preparedStatement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		} finally {
			close(preparedStatement);
		}

		manager.close(conn);
	}

	public void updateEnterprise(Enterprise enterpriseFormulario) {
		Connection conn = manager.open(jdbcUrl);

		PreparedStatement preparedStatement = null;
		try {
			preparedStatement = conn.prepareStatement(
					"UPDATE ENTERPRISE SET name = ? WHERE name = ?");
			preparedStatement.setString(1, enterpriseFormulario.getName());
			preparedStatement.setString(2, enterpriseFormulario.getName());

			preparedStatement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		} finally {
			close(preparedStatement);
			manager.close(conn);
		}

	}

	public List<Enterprise> searchAll() {
		List<Enterprise> listEnterprises = new ArrayList<Enterprise>();
		Connection conn = manager.open(jdbcUrl);
		ResultSet resultSet = null;
		PreparedStatement prepareStatement = null;
		try {
			prepareStatement = conn.prepareStatement("SELECT *  FROM ENTERPRISE");
			resultSet = prepareStatement.executeQuery();
			while (resultSet.next()) {
				Enterprise dto = new Enterprise();
				dto.setName(resultSet.getString(1));
				listEnterprises.add(dto);
			}

		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		} finally {
			close(resultSet);
			close(prepareStatement);
			manager.close(conn);
		}

		return listEnterprises;
	}

}
