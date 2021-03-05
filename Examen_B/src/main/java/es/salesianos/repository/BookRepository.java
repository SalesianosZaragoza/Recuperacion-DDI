package es.salesianos.repository;

import java.sql.Connection;


import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import es.salesianos.model.Book;
@org.springframework.stereotype.Repository("BookRepository")
public class BookRepository extends Repository {
	
	public void delete(Book book) {
		Connection conn = createConnection();
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
			
		}
		closeConnection(conn);
	}
	
	public void delete(Integer id) {
		Connection conn = createConnection();
		PreparedStatement prepareStatement = null;
		try {
			prepareStatement = conn.prepareStatement("DELETE FROM LIBRO WHERE id=?");
			prepareStatement.setInt(1, id);
			prepareStatement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		} finally {
			close(prepareStatement);
			
		}
		closeConnection(conn);
	}
	
	public void insert(Book book) {
		Connection conn = createConnection();
		PreparedStatement preparedStatement = null;
		try {
			preparedStatement = conn.prepareStatement("INSERT INTO LIBRO (isbn, fechaEdicion, almacen_old, almacen_new)" + "VALUES (?, ?, ?, ?)");
			preparedStatement.setString(1, book.getIsbn());
			preparedStatement.setDate(2, new java.sql.Date(book.getEditionDate().getTime()));
			if (book.isWarehouseOld()) {
				preparedStatement.setInt(3, book.getWarehouseOldId());
				preparedStatement.setNull(4, java.sql.Types.NULL); 
			} else {
				preparedStatement.setNull(3, java.sql.Types.NULL);
				preparedStatement.setInt(4, book.getWarehouseNewId());
			}
			preparedStatement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		} finally {
			close(preparedStatement);
			
		}
		closeConnection(conn);
	}
	
	public List<Book> listAll() {
		List<Book> StudentList = new ArrayList<Book>();
		Connection conn = createConnection();
		ResultSet resultSet = null;
		PreparedStatement prepareStatement = null;
		try {
			prepareStatement = conn.prepareStatement("SELECT * FROM LIBRO");
			resultSet = prepareStatement.executeQuery();
			while (resultSet.next()) {
				Book book = new Book(
						resultSet.getInt(1),
						resultSet.getString(2),
						resultSet.getString(3),
						resultSet.getInt(4),
						resultSet.getInt(5)
				);
				StudentList.add(book);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(resultSet);
			close(prepareStatement);
		}
		closeConnection(conn);
		return StudentList;
	}
}
