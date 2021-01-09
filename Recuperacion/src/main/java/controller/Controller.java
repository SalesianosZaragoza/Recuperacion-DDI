package controller;

import java.sql.Connection;



import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;



import connection.AbstractConnection;
import connection.H2Connection;
import model.Book;
import model.Warehouse;
import repository.Repository;
import service.Service;




public class Controller<ModelAndView> { 


	private Service<Book> bookService;
	

	private Service<Warehouse> WarehouseService;


	public String getIndexPage() {
		return "index";
	}

	
	public String getListBookPage() {
		return "listBooks";
	}

	

	public String getListOldWarehousePage() {
		return "listOldWarehouse";
	}
	

	public String getListNewWarehousePage() {
		return "listNewWarehouse";
	}


	public String insertBook(Book book) {
		bookService.insert(book);
		return "welcomeBook";
	}


	public String insertOldWarehouse(Warehouse oldwarehouse) {
		WarehouseService.insert(oldwarehouse);
		return "welcomeWarehouse";
	}
	

	public String insertNewWarehouse(Warehouse newwarehouse) {
		WarehouseService.insert(newwarehouse);
		return "welcomeWarehouse";
	}


	protected ModelAndView deleteOldWareHouse(Integer id) {
		WarehouseService.delete(id);
		return oldWarehouse();
	}
	
	
	protected ModelAndView deleteNewWareHouse(Integer id) {
		WarehouseService.delete(id);
		return listNewWarehouse();
	}
	

	public void updateBookToOldWarehouse() { 
		AbstractConnection manager = new H2Connection();
		Connection conn = manager.open(Repository.jdbcUrl);
		PreparedStatement preparedStatement = null;
		try {
			preparedStatement = conn.prepareStatement("UPDATE LIBRO SET oldWarehouse='true'");
			preparedStatement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		} finally {
			manager.close(preparedStatement);
			manager.close(conn);
		}
	}
	
	
	public void updateBookToNewWarehouse() { 
		AbstractConnection manager = new H2Connection();
		Connection conn = manager.open(Repository.jdbcUrl);
		PreparedStatement preparedStatement = null;
		try {
			preparedStatement = conn.prepareStatement("UPDATE LIBRO SET newWarehouse='true'");
			preparedStatement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		} finally {
			manager.close(preparedStatement);
			manager.close(conn);
		}
	}
}
