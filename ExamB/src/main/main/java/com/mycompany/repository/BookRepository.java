package com.mycompany.repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;



import com.mycompany.model.Book;
import com.mycompany.model.Warehouse;

@Component
public class BookRepository extends AbstractRepository implements Repository {


	public void delete(Book book) {
		Connection conn = manager.open(jdbcUrl);
		PreparedStatement prepareStatement = null;
		try {
			prepareStatement = conn.prepareStatement("DELETE FROM BOOK WHERE id=?");
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
			preparedStatement = conn
					.prepareStatement("INSERT INTO BOOK (ISBN, fechaEdicion, almacen_old, almacen_new)" + "VALUES (?, ?, ?, ?)");
			preparedStatement.setString(1, book.getISBN());
			preparedStatement.setDate(2, new java.sql.Date(book.getDateEdicion().getTime()));
			if (book.getWarehouse_old().equals(new Integer(-1))) {
				preparedStatement.setNull(3, java.sql.Types.NULL); 
				preparedStatement.setInt(4, book.getWarehouse_new());
			} else {
				preparedStatement.setInt(3, book.getWarehouse_old());
				preparedStatement.setNull(4, java.sql.Types.NULL);
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

	public void update(Book book) {
		Connection conn = manager.open(jdbcUrl);
		PreparedStatement preparedStatement = null;
		try {
			preparedStatement = conn.prepareStatement("UPDATE BOOK SET ISBN=?, dateEdicion=?, warehouse_old=?, warehouse_new=? WHERE id=?");
			preparedStatement.setString(1, book.getISBN());
			preparedStatement.setDate(2, new java.sql.Date(book.getDateEdicion().getTime()));
			if (book.getWarehouse_old().equals(new Integer(-1))) {
				preparedStatement.setNull(3, java.sql.Types.NULL); 
				preparedStatement.setInt(4, libro.getWarehouse_new());
			} else {
				preparedStatement.setInt(3, book.getWarehouse_old());
				preparedStatement.setNull(4, java.sql.Types.NULL);
			}
			preparedStatement.setInt(5, book.getId());
			preparedStatement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		} finally {
			close(preparedStatement);
			manager.close(conn);
		}
	}

	public Warehouse getWarehouse(Book book) {
		Integer id = (book.getWarehouse_old() > book.getWarehouse_new()) ? book.getWarehouse_old() : book.getWarehouse_new();
		boolean isOld = book.getWarehouse_old().equals(id);
		WarehouseRepository repository = new WarehouseRepository();
		Warehouse warehouse = isWarehouseOldOrNew ? repository.findByIdOld(id) : repository.findByIdNew(id);
		return warehouse;
	}

	public Book findById(Integer id) {
		Book book = null;
		Connection conn = manager.open(jdbcUrl);
		ResultSet resultSet = null;
		PreparedStatement prepareStatement = null;
		try {
			prepareStatement = conn.prepareStatement("SELECT * FROM BOOK WHERE id=?");
			prepareStatement.setInt(1, id);
			resultSet = prepareStatement.executeQuery();
			while (resultSet.next()) {
				book = new Book(
						resultSet.getInt(1),
						resultSet.getString(2),
						resultSet.getString(3),
						resultSet.getInt(4),
						resultSet.getInt(5)
				);
				book.setWarehouse(getWarehouse(book));
			}
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		} finally {
			close(resultSet);
			close(prepareStatement);
			manager.close(conn);
		}

		return book;
	}

	public List<Book> listAll() {
		List<Book> listBooks = new ArrayList<Book>();
		Connection conn = manager.open(jdbcUrl);
		ResultSet resultSet = null;
		PreparedStatement prepareStatement = null;
		try {
			prepareStatement = conn.prepareStatement("SELECT * FROM BOOK");
			resultSet = prepareStatement.executeQuery();
			while (resultSet.next()) {
				Book book = new Book(
						resultSet.getInt(1),
						resultSet.getString(2),
						resultSet.getString(3),
						resultSet.getInt(4),
						resultSet.getInt(5)
					);
				book.setWarehouse(getWarehouse(book));
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