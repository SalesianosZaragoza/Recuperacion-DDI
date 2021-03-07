package com.controller;

import java.sql.Connection;




import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

import org.springframework.stereotype.Controller;

import com.connection.AbstractConnection;
import com.connection.H2Connection;
import com.model.Book;
import com.model.Warehouse;
import com.repository.RepositoryBookExam1;
import com.service.ServiceExam1;



@Controller
public class ControllerExam1<ModelAndView> { 


	private ServiceExam1<Book> bookService;
	

	private ServiceExam1<Warehouse> WarehouseService;


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
		return deleteOldWareHouse(id);
	}
	
	
	protected ModelAndView deleteNewWareHouse(Integer id) {
		WarehouseService.delete(id);
		return deleteNewWareHouse(id);
	}
	

	public void updateBookToOldWarehouse() { 
		AbstractConnection manager = new H2Connection();
		Connection conn = manager.open(RepositoryBookExam1.jdbcUrl);
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
		Connection conn = manager.open(RepositoryBookExam1.jdbcUrl);
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
