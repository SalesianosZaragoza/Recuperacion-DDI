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
	/*
	public void update(Book book) {
		Connection conn = manager.open(jdbcUrl);
		PreparedStatement preparedStatement = null;
		try {
			preparedStatement = conn.prepareStatement("UPDATE LIBRO SET isbn=?, fechaEdicion=?, almacen_old=?, almacen_new=? WHERE id=?");
			preparedStatement.setString(1, book.getIsbn());
			preparedStatement.setDate(2, new java.sql.Date(book.getEditionDate().getTime()));
			if (book.isWarehouseOld()) {
				preparedStatement.setInt(3, book.getWarehouseId());
				preparedStatement.setNull(4, java.sql.Types.NULL); 
			} else {
				preparedStatement.setNull(3, java.sql.Types.NULL);
				preparedStatement.setInt(4, book.getWarehouseId());
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
		Integer id = (book.getAlmacen_old() > book.getAlmacen_new()) ? book.getAlmacen_old() : book.getAlmacen_new();
		boolean isOld = book.getAlmacen_old().equals(id);
		WarehouseRepository repository = new WarehouseRepository();
		Warehouse warehouse = isOld ? repository.findByIdOld(id) : repository.findByIdNew(id);
		return warehouse;
	}
	
	public Book findById(Integer id) {
		Book book = null;
		Connection conn = manager.open(jdbcUrl);
		ResultSet resultSet = null;
		PreparedStatement prepareStatement = null;
		try {
			prepareStatement = conn.prepareStatement("SELECT * FROM LIBRO WHERE id=?");
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
		List<Book> bookList = new ArrayList<Book>();
		Connection conn = manager.open(jdbcUrl);
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
				book.setWarehouse(getWarehouse(book));
				bookList.add(book);
			}
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		} finally {
			close(resultSet);
			close(prepareStatement);
			manager.close(conn);
		}

		return bookList;
	} */
	
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
	/*
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
	*/
}
