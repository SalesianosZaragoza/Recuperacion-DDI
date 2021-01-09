package repository;

import java.sql.Connection;


import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import connection.AbstractConnection;
import connection.H2Connection;
import model.Warehouse;



public class WareHouseRepository implements Repository<Warehouse> {
	private AbstractConnection manager = new H2Connection();
	protected static final String jdbcUrl = "jdbc:h2:file:./src/main/resources/test;INIT=RUNSCRIPT FROM 'classpath:scripts/create.sql'";

	
	@Override
	public void insertOldWarehouse(Warehouse oldWarehouse) {
		Connection conn = manager.open(jdbcUrl);
		PreparedStatement preparedStatement = null;
		try {
			preparedStatement = conn.prepareStatement("INSERT INTO ALMACEN_OLD (nombre)" + "VALUES (?)");
			preparedStatement.setString(1, oldWarehouse.getName());
			preparedStatement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		} finally {
			manager.close(preparedStatement);
			manager.close(conn);
		}
	}
	
	
	@Override
	public void insertNewWarehouse(Warehouse newWarehouse) {
		Connection conn = manager.open(jdbcUrl);
		PreparedStatement preparedStatement = null;
		try {
			preparedStatement = conn.prepareStatement("INSERT INTO ALMACEN_NEW (nombre)" + "VALUES (?)");
			preparedStatement.setString(1, newWarehouse.getName());
			preparedStatement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		} finally {
			manager.close(preparedStatement);
			manager.close(conn);
		}
	}
	

	@Override
	public List<Warehouse> listAll() {
		Connection conn = manager.open(jdbcUrl);
		PreparedStatement preparedStatement = null;
		ArrayList<Warehouse> oldWarehouse = new ArrayList<Warehouse>();
		try {
			preparedStatement = conn.prepareStatement("SELECT * FROM ALMACEN_OLD");
			ResultSet resultSet = preparedStatement.executeQuery();
			while (resultSet.next()) {
				Warehouse warehouse = new Warehouse();
				warehouse.setId(resultSet.getInt("id"));
				warehouse.setOldWarehouse(resultSet.getBoolean("true"));
				warehouse.add(oldWarehouse);
			}

		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		} finally {
			manager.close(preparedStatement);
			manager.close(conn);
		}
		return oldWarehouse;
	}


	public void deleteOldWarehouse(Integer idoldWarehouse) {
		Connection conn = manager.open(jdbcUrl);
		PreparedStatement preparedStatement = null;
		try {
			preparedStatement = conn.prepareStatement("DELETE FROM ALMACEN_OLD WHERE id=?");
			preparedStatement.setInt(1, idoldWarehouse);
			preparedStatement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		} finally {
			manager.close(preparedStatement);
			manager.close(conn);
		}
	}

	
	@Override
	public void deleteNewWarehouse(Integer idnewWarehouse) {
		Connection conn = manager.open(jdbcUrl);
		PreparedStatement preparedStatement = null;
		try {
			preparedStatement = conn.prepareStatement("DELETE FROM ALMACEN_NEW WHERE id=?");
			preparedStatement.setInt(1, idnewWarehouse);
			preparedStatement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		} finally {
			manager.close(preparedStatement);
			manager.close(conn);
		}
	}
	
	@Override
	public void update(Warehouse element) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void insert(Warehouse element) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Warehouse findByIdOldWarehouse(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Warehouse findByIdNewWarehouse(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public void delete(Integer id) {
		// TODO Auto-generated method stub
		
	}

}
