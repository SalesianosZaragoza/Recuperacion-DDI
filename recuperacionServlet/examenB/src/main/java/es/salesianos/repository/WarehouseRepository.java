package es.salesianos.repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import es.salesianos.model.Warehouse;
import es.salesianos.model.Book;

public class WarehouseRepository extends Repository {
	
	public void insert(Warehouse warehouse) {
		Connection conn = manager.open(jdbcUrl);
		PreparedStatement preparedStatement = null;
		try {
			preparedStatement = conn.prepareStatement(String.format("INSERT INTO %s(nombre) VALUES (?)", getWarehouseTableName(warehouse.isOld())));
			preparedStatement.setString(1, warehouse.getName());
			preparedStatement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		} finally {
			close(preparedStatement);
		}

		manager.close(conn);
	}
	
	public void delete(Warehouse warehouse) {
		Connection conn = manager.open(jdbcUrl);
		PreparedStatement prepareStatement = null;
		try {
			prepareStatement = conn.prepareStatement(String.format("DELETE FROM %s WHERE id=?", getWarehouseTableName(warehouse.isOld())));
			prepareStatement.setInt(1, warehouse.getId());
			prepareStatement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		} finally {
			close(prepareStatement);
			manager.close(conn);
		}
	}
	
	public String getWarehouseTableName(boolean isOldWarehouse) {
		return (isOldWarehouse) ? "ALMACEN_OLD" : "ALMACEN_NEW";
	}
	
	public Warehouse findByOld(Integer id) {
		Warehouse warehouse = null;
		Connection conn = manager.open(jdbcUrl);
		ResultSet resultSet = null;
		PreparedStatement prepareStatement = null;
		try {
			prepareStatement = conn.prepareStatement("SELECT * FROM ALMACEN_OLD WHERE id=?");
			prepareStatement.setInt(1, id);
			resultSet = prepareStatement.executeQuery();
			while (resultSet.next()) {
				warehouse = new Warehouse(
						resultSet.getInt(1),
						resultSet.getString(2),
						true
				);
				warehouse.setBooks(getBooks(warehouse));
			}
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		} finally {
			close(resultSet);
			close(prepareStatement);
			manager.close(conn);
		}

		return warehouse;
	}
	
	public Warehouse findByNew(Integer id) {
		Warehouse warehouse = null;
		Connection conn = manager.open(jdbcUrl);
		ResultSet resultSet = null;
		PreparedStatement prepareStatement = null;
		try {
			prepareStatement = conn.prepareStatement("SELECT * FROM ALMACEN_NEW WHERE id=?");
			prepareStatement.setInt(1, id);
			resultSet = prepareStatement.executeQuery();
			while (resultSet.next()) {
				warehouse = new Warehouse(
						resultSet.getInt(1),
						resultSet.getString(2),
						false
				);
				warehouse.setBooks(getBooks(warehouse));
			}
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		} finally {
			close(resultSet);
			close(prepareStatement);
			manager.close(conn);
		}

		return warehouse;
	}
	
	public List<Warehouse> listOld() {
		List<Warehouse> listWarehouses = new ArrayList<Warehouse>();
		Connection conn = manager.open(jdbcUrl);
		ResultSet resultSet = null;
		PreparedStatement prepareStatement = null;
		try {
			prepareStatement = conn.prepareStatement("SELECT * FROM ALMACEN_OLD");
			resultSet = prepareStatement.executeQuery();
			while (resultSet.next()) {
				Warehouse warehouse = new Warehouse(
						resultSet.getInt(1),
						resultSet.getString(2),
						true
				);
				warehouse.setBooks(getBooks(warehouse));
				listWarehouses.add(warehouse);
			}
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		} finally {
			close(resultSet);
			close(prepareStatement);
			manager.close(conn);
		}

		return listWarehouses;
	}
	
	public List<Warehouse> listNew() {
		List<Warehouse> listWarehouses = new ArrayList<Warehouse>();
		Connection conn = manager.open(jdbcUrl);
		ResultSet resultSet = null;
		PreparedStatement prepareStatement = null;
		try {
			prepareStatement = conn.prepareStatement("SELECT * FROM ALMACEN_NEW");
			resultSet = prepareStatement.executeQuery();
			while (resultSet.next()) {
				Warehouse warehouse = new Warehouse(
						resultSet.getInt(1),
						resultSet.getString(2),
						false
				);
				warehouse.setBooks(getBooks(warehouse));
				listWarehouses.add(warehouse);
			}
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		} finally {
			close(resultSet);
			close(prepareStatement);
			manager.close(conn);
		}

		return listWarehouses;
	}
	
	public List<Book> getBooks(Warehouse warehouse) {
		List<Book> listBooks = new ArrayList<Book>();
		Connection conn = manager.open(jdbcUrl);
		ResultSet resultSet = null;
		PreparedStatement prepareStatement = null;
		try {
			prepareStatement = conn.prepareStatement(String.format("SELECT * FROM LIBRO WHERE %s=?", getWarehouseColumnName(warehouse.isOld())));
			prepareStatement.setInt(1, warehouse.getId());
			resultSet = prepareStatement.executeQuery();
			while (resultSet.next()) {
				Book book = new Book(
						resultSet.getInt(1),
						resultSet.getString(2),
						resultSet.getString(3),
						warehouse
				);
				listBooks.add(book);
			}
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		} finally {
			close(resultSet);
			close(prepareStatement);
			manager.close(conn);
		}

		return listBooks;
	}
	
	public String getWarehouseColumnName(boolean isOldWarehouse) {
		return (isOldWarehouse) ? "almacen_old" : "almacen_new";
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
}
