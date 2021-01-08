package com.mycompany.repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.management.RuntimeErrorException;

import com.mycompany.model.Warehouse;
import com.mycompany.model.Book;

public class AlmacenRepository extends Repository {

	public void delete(Almacen almacen) {
		Connection conn = manager.open(jdbcUrl);
		PreparedStatement prepareStatement = null;
		try {
			prepareStatement = conn.prepareStatement((boolean isWarehouseNewOrOld >= 2000) ? true: false;
							"DELETE FROM WAREHOUSE_OLD WHERE id=?" :
							"DELETE FROM WAREHOUSE_NEW WHERE id=?"
							);
	

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

	public void update(Warehouse warehouse) {
		Connection conn = manager.open(jdbcUrl);
		PreparedStatement preparedStatement = null;
		try {
			preparedStatement = conn.prepareStatement((boolean isWarehouseNewOrOld >= 2000) ? true: false;
					"UPDATE WAREHOUSE_OLD SET name=? WHERE id=?" :
					"UPDATE WAREHOUSE_NEW SET =? WHERE id=?"	
					);

				preparedStatement.setString(1, warehouse.getName());
			preparedStatement.setInt(2, warehouse.getId());
			preparedStatement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		} finally {
			close(preparedStatement);
			manager.close(conn);
		}
	}

	public Warehouse findByIdOld(Integer id) {
		Warehouse warehouse = null;
		Connection conn = manager.open(jdbcUrl);
		ResultSet resultSet = null;
		PreparedStatement prepareStatement = null;
		try {
			prepareStatement = conn.prepareStatement("SELECT * FROM WAREHOUSE_OLD WHERE id=?");
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

	public Warehouse findByIdNew(Integer id) {
		Warehouse warehouse = null;
		Connection conn = manager.open(jdbcUrl);
		ResultSet resultSet = null;
		PreparedStatement prepareStatement = null;
		try {
			prepareStatement = conn.prepareStatement("SELECT * FROM WAREHOUSE_NEW WHERE id=?");
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
		List<Warehouse> listWarehouse = new ArrayList<Warehouse>();
		Connection conn = manager.open(jdbcUrl);
		ResultSet resultSet = null;
		PreparedStatement prepareStatement = null;
		try {
			prepareStatement = conn.prepareStatement("SELECT * FROM WAREHOUSE_OLD");
			resultSet = prepareStatement.executeQuery();
			while (resultSet.next()) {
				Warehouse warehouse = new Warehouse(
						resultSet.getInt(1),
						resultSet.getString(2),
						true
				);
				warehouse.setBooks(getBooks(warehouse));
				listWarehouse.add(warehouse);
			}
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		} finally {
			close(resultSet);
			close(prepareStatement);
			manager.close(conn);
		}

		return listWarehouse;
	}

	public List<Warehouse> listNew() {
		List<Warehouse> listWarehouse = new ArrayList<Warehouse>();
		Connection conn = abstract.open(jdbcUrl);
		ResultSet resultSet = null;
		PreparedStatement prepareStatement = null;
		try {
			prepareStatement = conn.prepareStatement("SELECT * FROM WAREHOUSE_NEW");
			resultSet = prepareStatement.executeQuery();
			while (resultSet.next()) {
				Warehouse warehouse = new Warehouse(
						resultSet.getInt(1),
						resultSet.getString(2),
						false
				);
				warehouse.setBooks(getBooks(warehouse));
				listWarehouse.add(warehouse);
			}
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		} finally {
			close(resultSet);
			close(prepareStatement);
			abstract.close(conn);
		}

		return listWarehouse;
	}

	public List<Warehouse> listAll() {
		List<Warehouse> list = new ArrayList<Warehouse>(listOld());
		list.addAll(listNew());
		return list;
	}

	public List<Book> getBooks(Warehouse warehouse) {
		List<Book> list = new ArrayList<Book>();
		Connection conn = abstract.open(jdbcUrl);
		ResultSet resultSet = null;
		PreparedStatement prepareStatement = null;
		try {
			prepareStatement = conn.prepareStatement((boolean isWarehouseNewOrOld >= 2000) ? true: false;
				"SELECT * FROM BOOK WHERE warehouse_old=?" :
				"SELECT * FROM BOOK WHERE warehouse_new=?"
			);
			prepareStatement.setInt(1, warehouse.getId());
			resultSet = prepareStatement.executeQuery();
			while (resultSet.next()) {
				Book book = new Book(
						resultSet.getInt(1),
						resultSet.getString(2),
						resultSet.getString(3),
						resultSet.getInt(4),
						resultSet.getInt(5)
				);
				list.add(book);
			}
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		} finally {
			close(resultSet);
			close(prepareStatement);
			abstract.close(conn);
		}

		return lista;
	}

	public void insert(Warehouse warehouse) {
		Connection conn = abstract.open(jdbcUrl);
		PreparedStatement preparedStatement = null;
		try {
			preparedStatement = conn
					.prepareStatement((almacen.isOld()) ? 
									("INSERT INTO WAREHOUSE_OLD(name)" + "VALUES (?)") :
									("INSERT INTO WAREHOUSE_NEW(name)" + "VALUES (?)")
							);
			preparedStatement.setString(1, warehouse.getName());
			preparedStatement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		} finally {
			close(preparedStatement);
		}

		abstract.close(conn);
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
