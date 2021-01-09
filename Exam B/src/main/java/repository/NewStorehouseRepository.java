package repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import connection.ConnectionH2;
import connection.ConnectionManager;
import model.NewStorehouse;

public class NewStorehouseRepository {

	private static final String jdbcUrl = "jdbc:h2:file:./src/main/resources/test";
	ConnectionManager manager = new ConnectionH2();

	public NewStorehouse searchStorehuse(NewStorehouse storehouseForm) {
		NewStorehouse storehouseDatabase = null;
		ResultSet resultSet = null;
		PreparedStatement prepareStatement = null;
		Connection conn = manager.open(jdbcUrl);
		try {
			prepareStatement = conn.prepareStatement("SELECT * FROM NEWSTOREHOUSE WHERE name = ?");
			prepareStatement.setString(1, storehouseForm.getName());
			resultSet = prepareStatement.executeQuery();
			while (resultSet.next()) {
				storehouseDatabase = new NewStorehouse();
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

	public void insertNewStorehouse(NewStorehouse storehouseForm) {
		Connection conn = manager.open(jdbcUrl);
		PreparedStatement preparedStatement = null;
		try {
			preparedStatement = conn.prepareStatement("INSERT INTO NEWSOTREHOUSE (name)" + "VALUES (?)");
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

	public void updateNewStorehouse(NewStorehouse storehouseForm) {
		Connection conn = manager.open(jdbcUrl);

		PreparedStatement preparedStatement = null;
		try {
			preparedStatement = conn.prepareStatement("UPDATE NEWSTOREHOUSE SET name = ? WHERE name = ?");
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

	public List<NewStorehouse> searchAll() {
		List<NewStorehouse> listNewStorehouse = new ArrayList<NewStorehouse>();
		Connection conn = manager.open(jdbcUrl);
		ResultSet resultSet = null;
		PreparedStatement prepareStatement = null;
		try {
			prepareStatement = conn.prepareStatement("SELECT * FROM NEWSTOREHOUSE");
			resultSet = prepareStatement.executeQuery();
			while (resultSet.next()) {
				NewStorehouse dto = new NewStorehouse();
				dto.setName(resultSet.getString(1));
				listNewStorehouse.add(dto);
			}

		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		} finally {
			close(resultSet);
			close(prepareStatement);
			manager.close(conn);
		}

		return listNewStorehouse;
	}

}
