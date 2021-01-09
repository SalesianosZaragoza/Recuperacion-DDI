package repository;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import connection.ConnectionH2;
import connection.ConnectionManager;
import model.Book;

public class BookRepository {

	private static final String jdbcUrl = "jdbc:h2:file:./src/main/resources/test";
	ConnectionManager manager = new ConnectionH2();

	public Book searchBook(Book bookForm) {
		Book bookDataBase = null;
		ResultSet resultSet = null;
		PreparedStatement prepareStatement = null;
		Connection conn = manager.open(jdbcUrl);
		try {
			prepareStatement = conn.prepareStatement("SELECT * FROM BOOK WHERE isbn = ?");
			prepareStatement.setString(1, bookForm.getIsbn());
			resultSet = prepareStatement.executeQuery();
			while (resultSet.next()) {
				bookDataBase = new Book();
				bookDataBase.setIsbn(resultSet.getString(1));
			}
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		} finally {
			close(resultSet);
			close(prepareStatement);

		}
		manager.close(conn);
		return bookDataBase;
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

	public void insertBook(Book BookForm) {
		Connection conn = manager.open(jdbcUrl);
		PreparedStatement preparedStatement = null;
		try {
			preparedStatement = conn.prepareStatement(
					"INSERT INTO BOOK (isbn, editionDate, oldStorehouse, newStorehouse)" + "VALUES (?,?,?,?)");
			preparedStatement.setString(1, BookForm.getIsbn());
			preparedStatement.setDate(2, (Date) BookForm.getEditionDate());
			preparedStatement.setInt(3, BookForm.getOldStorehouse());
			preparedStatement.setInt(3, BookForm.getNewStorehouse());

			preparedStatement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		} finally {
			close(preparedStatement);
		}

		manager.close(conn);
	}

	public void updateOldStoreupdateBook(Book book) {
		Connection conn = manager.open(jdbcUrl);

		PreparedStatement preparedStatement = null;
		try {
			preparedStatement = conn.prepareStatement("UPDATE BOOK SET isbn = ? WHERE isbn = ?");
			preparedStatement.setString(1, book.getIsbn());
			preparedStatement.setString(2, book.getIsbn());

			preparedStatement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		} finally {
			close(preparedStatement);
			manager.close(conn);
		}

	}

	public List<Book> searchAll() {
		List<Book> listBooks = new ArrayList<Book>();
		Connection conn = manager.open(jdbcUrl);
		ResultSet resultSet = null;
		PreparedStatement prepareStatement = null;
		try {
			prepareStatement = conn.prepareStatement("SELECT * FROM OLDSTOREHOUSE");
			resultSet = prepareStatement.executeQuery();
			while (resultSet.next()) {
				Book dto = new Book();
				dto.setIsbn(resultSet.getString(1));
				dto.setEditionDate(resultSet.getDate(2));
				dto.setOldStorehouse(resultSet.getInt(3));
				dto.setNewStorehouse(resultSet.getInt(4));
				listBooks.add(dto);
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
}
