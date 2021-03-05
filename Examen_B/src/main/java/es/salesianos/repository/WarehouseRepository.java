package es.salesianos.repository;

import java.sql.Connection;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.management.RuntimeErrorException;

import es.salesianos.model.Book;
import es.salesianos.model.Warehouse;
@org.springframework.stereotype.Repository("WarehouseRepository")
public class WarehouseRepository extends Repository {
	
	public void insert(Warehouse warehouse) {
		Connection conn = createConnection();
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

		closeConnection(conn);
	}
	
	public void delete(Warehouse warehouse) {
		Connection conn = createConnection();
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
		}
		closeConnection(conn);
	}
	
	public void update(Warehouse warehouse) {
		Connection conn = createConnection();
		PreparedStatement preparedStatement = null;
		try {
			preparedStatement = conn.prepareStatement(String.format("UPDATE %s SET nombre=? WHERE id=?" , getWarehouseTableName(warehouse.isOld())));
			preparedStatement.setString(1, warehouse.getName());
			preparedStatement.setInt(2, warehouse.getId());
			preparedStatement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		} finally {
			close(preparedStatement);
			closeConnection(conn);
		}
	}
	public String getWarehouseTableName(boolean isOldWarehouse) {
		return (isOldWarehouse) ? "ALMACEN_OLD" : "ALMACEN_NEW";
	}
	
	public Warehouse findByOld(Integer id) {
		Warehouse warehouse = null;
		Connection conn = createConnection();
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
		} finally {
			close(resultSet);
			close(prepareStatement);
			
		}
		closeConnection(conn);
		return warehouse;
		
	}
	
	
	public Warehouse findByNew(Integer id) {
		Warehouse warehouse = null;
		Connection conn = createConnection();
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
		} finally {
			close(resultSet);
			close(prepareStatement);
			
		}
		closeConnection(conn);
		return warehouse;
		
	}
	
	
	public List<Warehouse> listOld() {
		List<Warehouse> listWarehouses = new ArrayList<Warehouse>();
		Connection conn = createConnection();
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
			
		}
		closeConnection(conn);
		return listWarehouses;
		
	}
	
	public List<Warehouse> listNew() {
		List<Warehouse> listWarehouses = new ArrayList<Warehouse>();
		Connection conn = createConnection();
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
			
		}
		closeConnection(conn);
		return listWarehouses;
		
	}
	
	public List<Book> getBooks(Warehouse warehouse) {
		List<Book> listBooks = new ArrayList<Book>();
		Connection conn = createConnection();
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
			
		}
		closeConnection(conn);
		return listBooks;
	}
	public String getWarehouseColumnName(boolean isOldWarehouse) {
		return (isOldWarehouse) ? "almacen_old" : "almacen_new";
	}
	

	
}
