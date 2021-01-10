package repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import connection.ConnectionH2;
import connection.ConnectionManager;
import model.OldStorehouse;

public class OldStorehouseRepository {

	private static final String jdbcUrl = "jdbc:h2:file:./src/main/resources/test";
	ConnectionManager manager = new ConnectionH2();

	public OldStorehouse searchStorehouse(OldStorehouse storehouseForm) {
		OldStorehouse storehouseDatabase = null;
		ResultSet resultSet = null;
		PreparedStatement prepareStatement = null;
		Connection conn = manager.open(jdbcUrl);
		try {
			prepareStatement = conn.prepareStatement("SELECT * FROM OLDSTOREHOUSE WHERE name = ?");
			prepareStatement.setString(1, storehouseForm.getName());
			resultSet = prepareStatement.executeQuery();
			while (resultSet.next()) {
				storehouseDatabase = new OldStorehouse();
				storehouseDatabase.setName(resultSet.getString(1));
			}
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		} finally {
			close(resultSet);
			close(prepareStatement);

		}
		manager.close(conn);
		return storehouseDatabase;
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

	public void insertOldStorehouse(OldStorehouse storehouseForm) {
		Connection conn = manager.open(jdbcUrl);
		PreparedStatement preparedStatement = null;
		try {
			preparedStatement = conn.prepareStatement("INSERT INTO OLDSTOREHOUSE (name)" + "VALUES (?)");
			preparedStatement.setString(1, storehouseForm.getName());
			preparedStatement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		} finally {
			close(preparedStatement);
		}

		manager.close(conn);
	}

	public void updateOldStorehouse(OldStorehouse storehouseForm) {
		Connection conn = manager.open(jdbcUrl);

		PreparedStatement preparedStatement = null;
		try {
			preparedStatement = conn.prepareStatement("UPDATE OLDSTOREHOUSE SET name = ? WHERE name = ?");
			preparedStatement.setString(1, storehouseForm.getName());
			preparedStatement.setString(2, storehouseForm.getName());

			preparedStatement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		} finally {
			close(preparedStatement);
			manager.close(conn);
		}

	}

	public List<OldStorehouse> searchAll() {
		List<OldStorehouse> listOldStorehouse = new ArrayList<OldStorehouse>();
		Connection conn = manager.open(jdbcUrl);
		ResultSet resultSet = null;
		PreparedStatement prepareStatement = null;
		try {
			prepareStatement = conn.prepareStatement("SELECT * FROM OLDSTOREHOUSE");
			resultSet = prepareStatement.executeQuery();
			while (resultSet.next()) {
				OldStorehouse dto = new OldStorehouse();
				dto.setName(resultSet.getString(1));
				listOldStorehouse.add(dto);
			}

		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		} finally {
			close(resultSet);
			close(prepareStatement);
			manager.close(conn);
		}

		return listOldStorehouse;
	}

}
