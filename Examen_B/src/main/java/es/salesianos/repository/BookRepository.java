package es.salesianos.repository;

import java.sql.Connection;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import es.salesianos.model.Book;
import es.salesianos.model.Warehouse;

public class BookRepository extends Repository {
	
	public void delete(Book book) {
		Connection conn = manager.open(jdbcUrl);
		PreparedStatement prepareStatement = null;
		try {
			prepareStatement = conn.prepareStatement("DELETE FROM LIBRO WHERE id=?");
			prepareStatement.setInt(1, book.getId());
			prepareStatement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		} finally {
			close(prepareStatement);
			manager.close(conn);
		}
	}
	
	public void insert(Book book) {
		Connection conn = manager.open(jdbcUrl);
		PreparedStatement preparedStatement = null;
		try {
			preparedStatement = conn.prepareStatement("INSERT INTO LIBRO (isbn, fechaEdicion, almacen_old, almacen_new)" + "VALUES (?, ?, ?, ?)");
			preparedStatement.setString(1, book.getIsbn());
			preparedStatement.setDate(2, new java.sql.Date(book.getEditionDate().getTime()));
			if (book.isWarehouseOld()) {
				preparedStatement.setInt(3, book.getWarehouseId());
				preparedStatement.setNull(4, java.sql.Types.NULL); 
			} else {
				preparedStatement.setNull(3, java.sql.Types.NULL);
				preparedStatement.setInt(4, book.getWarehouseId());
			}
			preparedStatement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		} finally {
			close(preparedStatement);
			manager.close(conn);
		}
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
}
