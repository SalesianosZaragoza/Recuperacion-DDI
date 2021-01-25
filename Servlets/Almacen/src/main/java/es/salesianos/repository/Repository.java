package es.salesianos.repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import es.salesianos.connection.ConnectionH2;
import es.salesianos.connection.ConnectionManager;
import es.salesianos.model.WarehouseNew;
import es.salesianos.model.WarehouseOld;
import es.salesianos.model.Book;



public class Repository {

	private static final String jdbcUrl = "jdbc:h2:file:./src/main/resources/test";
	ConnectionManager manager = new ConnectionH2();


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

	public void insert(WarehouseOld warehouseOld) {
		Connection conn = manager.open(jdbcUrl);
		PreparedStatement preparedStatement = null;
		try {
			preparedStatement = conn
					.prepareStatement("INSERT INTO ALMACEN_OLD (name)" + "VALUES (?)");
			preparedStatement.setString(1, warehouseOld.getName());
			preparedStatement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		} finally {
			close(preparedStatement);
		}

		manager.close(conn);
	}
	
	public void insert(WarehouseNew warehouseNew) {
		Connection conn = manager.open(jdbcUrl);
		PreparedStatement preparedStatement = null;
		try {
			preparedStatement = conn
					.prepareStatement("INSERT INTO ALMACEN_NEW (name)" + "VALUES (?)");
			preparedStatement.setString(1, warehouseNew.getName());
			
			preparedStatement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		} finally {
			close(preparedStatement);
		}

		manager.close(conn);
	}
	
	public void insert(Book book) {
		Connection conn = manager.open(jdbcUrl);
		PreparedStatement preparedStatement = null;
		try {			
			
			if(book.getWarehouseOld() != null) {			
				preparedStatement = conn
						.prepareStatement("INSERT INTO BOOK (isbn,dateEdition,almacen_old)" + "VALUES (?,?,?)");
				preparedStatement.setString(1, book.getIsbn());
				preparedStatement.setObject(2,  book.getDateEdition());
				preparedStatement.setInt(3, book.getWarehouseOld());
			}else {			
				preparedStatement = conn
						.prepareStatement("INSERT INTO BOOK (isbn,dateEdition,almacen_new)" + "VALUES (?,?,?)");
				preparedStatement.setString(1, book.getIsbn());
				preparedStatement.setObject(2, (book.getDateEdition()));
				preparedStatement.setInt(3, book.getWarehouseNew());
				}
			
			preparedStatement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		} finally {
			close(preparedStatement);
		}

		manager.close(conn);
	}
	
	public List<WarehouseOld> searchAllOld() {
		List<WarehouseOld> listWarehouseOld = new ArrayList<WarehouseOld>();
		Connection conn = manager.open(jdbcUrl);
		ResultSet resultSet = null;
		PreparedStatement prepareStatement = null;
		try {			
			selectAlmacenOld(prepareStatement,conn,resultSet,listWarehouseOld);
			selectBookOld(prepareStatement,conn,resultSet,listWarehouseOld);
			
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		} finally {
			close(resultSet);
			close(prepareStatement);
			manager.close(conn);
		}

		return listWarehouseOld;
	}

	public void selectAlmacenOld(PreparedStatement prepareStatement ,Connection conn,ResultSet resultSet, List<WarehouseOld> listWarehouseOld) throws SQLException{
		prepareStatement = conn.prepareStatement("SELECT * FROM ALMACEN_OLD");
			resultSet = prepareStatement.executeQuery();
			while (resultSet.next()) {
				WarehouseOld WarehouseOldInDatabase = new WarehouseOld();		
				WarehouseOldInDatabase.setId(resultSet.getInt(1));
				WarehouseOldInDatabase.setName(resultSet.getString(2));			
				listWarehouseOld.add(WarehouseOldInDatabase);
			}
	}

	public void selectBookOld(PreparedStatement prepareStatement ,Connection conn,ResultSet resultSet, List<WarehouseOld> listWarehouseOld) throws SQLException{		
			for (WarehouseOld warehouseOld : listWarehouseOld) {				
				prepareStatement = conn.prepareStatement(
						"SELECT * FROM BOOK where almacen_old="+warehouseOld.getId());
				resultSet = prepareStatement.executeQuery();
				while (resultSet.next()) {
					Book book = new Book();
					book.setIsbn(resultSet.getString(2));
					book.setDateEdition(resultSet.getDate(3).toLocalDate());
					warehouseOld.getBooks().add(book);
				}
			}
	}
	
	public List<WarehouseNew> searchAllNew() {
		List<WarehouseNew> listWarehouseNew = new ArrayList<WarehouseNew>();
		Connection conn = manager.open(jdbcUrl);
		ResultSet resultSet = null;
		PreparedStatement prepareStatement = null;
		try {			
			selectWarehouseNew(prepareStatement,conn,resultSet,listWarehouseNew);
			selectBookNew(prepareStatement,conn,resultSet,listWarehouseNew);			
			
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		} finally {
			close(resultSet);
			close(prepareStatement);
			manager.close(conn);
		}

		return listWarehouseNew;
	}
	
	public void selectWarehouseNew(PreparedStatement prepareStatement ,Connection conn,ResultSet resultSet, List<WarehouseNew> listWarehouseNew) throws SQLException {
		prepareStatement = conn.prepareStatement("SELECT * FROM ALMACEN_NEW");
		resultSet = prepareStatement.executeQuery();
		while (resultSet.next()) {
			WarehouseNew WarehouseNewInDatabase = new WarehouseNew();		
			WarehouseNewInDatabase.setId(resultSet.getInt(1));
			WarehouseNewInDatabase.setName(resultSet.getString(2));			
			listWarehouseNew.add(WarehouseNewInDatabase);
		}
	}
	
	public void selectBookNew(PreparedStatement prepareStatement ,Connection conn,ResultSet resultSet, List<WarehouseNew> listWarehouseNew) throws SQLException {
		for (WarehouseNew warehouseNew : listWarehouseNew) {
			
			prepareStatement = conn.prepareStatement(
					"SELECT * FROM BOOK where almacen_new="+warehouseNew.getId());
			resultSet = prepareStatement.executeQuery();
			while (resultSet.next()) {
				Book book = new Book();
				book.setIsbn(resultSet.getString(2));
				book.setDateEdition(resultSet.getDate(3).toLocalDate());
				warehouseNew.getBooks().add(book);
			}
		}
	}
	
	public void deleteNew(Integer id) {
		Connection conn = manager.open(jdbcUrl);
		PreparedStatement preparedStatement = null;
		try {		
			preparedStatement = deleteBooksNew(id, conn);		
			preparedStatement = deleteWarehouseNew(id, conn);
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		} finally {
			close(preparedStatement);
			manager.close(conn);
		}

	}
	
	public void deleteOld(Integer id) {
		Connection conn = manager.open(jdbcUrl);
		PreparedStatement preparedStatement = null;
		try {		
			preparedStatement = deleteBooksOld(id, conn);		
			preparedStatement = deleteWarehouseOld(id, conn);
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		} finally {
			close(preparedStatement);
			manager.close(conn);
		}

	}
	
	private PreparedStatement deleteWarehouseNew (Integer id, Connection conn) throws SQLException {
		PreparedStatement preparedStatement;
		preparedStatement = conn
				.prepareStatement("DELETE FROM ALMACEN_NEW WHERE id = ?");
		preparedStatement.setInt(1, id);
		preparedStatement.executeUpdate();
		return preparedStatement;
	}
	
	private PreparedStatement deleteWarehouseOld (Integer id, Connection conn) throws SQLException {
		PreparedStatement preparedStatement;
		preparedStatement = conn
				.prepareStatement("DELETE FROM ALMACEN_OLD WHERE id = ?");
		preparedStatement.setInt(1, id);
		preparedStatement.executeUpdate();
		return preparedStatement;
	}

	private PreparedStatement deleteBooksOld (Integer id, Connection conn) throws SQLException {
		PreparedStatement preparedStatement;
		preparedStatement = conn
				.prepareStatement("DELETE FROM BOOK WHERE almacen_old = ?");
		preparedStatement.setInt(1, id);
		preparedStatement.executeUpdate();
		return preparedStatement;
	}

	private PreparedStatement deleteBooksNew (Integer id, Connection conn) throws SQLException {
		PreparedStatement preparedStatement;
		preparedStatement = conn
				.prepareStatement("DELETE FROM BOOK WHERE almacen_new = ?");
		preparedStatement.setInt(1, id);
		preparedStatement.executeUpdate();
		return preparedStatement;
	}
	

	

}
