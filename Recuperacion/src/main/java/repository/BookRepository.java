package repository;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import connection.AbstractConnection;
import connection.H2Connection;
import model.Book;



public class BookRepository implements Repository<Book> {
	private AbstractConnection manager = new H2Connection();
	protected static final String jdbcUrl = "jdbc:h2:file:./src/main/resources/test;INIT=RUNSCRIPT FROM 'classpath:scripts/create.sql'";

	public void insert(Book book) {
		Connection conn = manager.open(jdbcUrl);
		PreparedStatement preparedStatement = null;
		try {
			preparedStatement = conn.prepareStatement("INSERT INTO LIBRO (nombre, fechaEdicion, almacen_old, almacen_new)" + "VALUES (?, ?, ?, ?)");
			preparedStatement.setString(1, book.getName());
			preparedStatement.setDate(2, (Date) book.getDateEdition());
			preparedStatement.setBoolean(3, book.getOldWarehouse());
			preparedStatement.setBoolean(4, book.getNewWarehouse());
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
	public List<Book> listAll() {
		Connection conn = manager.open(jdbcUrl);
		PreparedStatement preparedStatement = null;
		ArrayList<Book> books = new ArrayList<Book>();
		try {
			preparedStatement = conn.prepareStatement("SELECT * FROM ALMACEN_OLD a JOIN LIBRO l ON a.id =  l.oldWarehouse");
			ResultSet resultSet = preparedStatement.executeQuery();
			while (resultSet.next()) {
				Book book = new Book();
				book.setId(resultSet.getInt("id"));
				book.setName(resultSet.getString("nombre"));
				book.setDateEdition(resultSet.getDate(0));
				book.setOldWarehouse(resultSet.getBoolean("oldWarehouse"));
				book.setNewWarehouse(resultSet.getBoolean("newWarehouse"));
				books.add(book);
			}

		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		} finally {
			manager.close(preparedStatement);
			manager.close(conn);
		}
		return books;
	}

	@Override
	public void insertOldWarehouse(Book element) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void insertNewWarehouse(Book element) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Book findByIdOldWarehouse(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Book findByIdNewWarehouse(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void delete(Integer id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void update(Book element) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteOldWarehouse(Integer id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteNewWarehouse(Integer id) {
		// TODO Auto-generated method stub
		
	}

	
}
