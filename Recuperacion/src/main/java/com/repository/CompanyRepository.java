package com.repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.connection.AbstractConnection;
import com.connection.H2Connection;
import com.model.Company;
import com.repository.RepositoryExam2;


@SuppressWarnings("unused")
@Repository
public class CompanyRepository implements RepositoryExam2<Company> {
	private AbstractConnection manager = new H2Connection();
	protected static final String jdbcUrl = "jdbc:h2:file:./src/main/resources/test;INIT=RUNSCRIPT FROM 'classpath:scripts/create.sql'";

	
	public void insert(Company company) {
		Connection conn = manager.open(jdbcUrl);
		PreparedStatement preparedStatement = null;
		try {
			preparedStatement = conn.prepareStatement("INSERT INTO ESTUDIANTE (nombre, edad, fct, empresa)" + "VALUES (?, ?, ?, ?)");
			preparedStatement.setString(1, company.getName());
			preparedStatement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		} finally {
			manager.close(preparedStatement);
			manager.close(conn);
		}
	}
	
	
	public void delete(Integer idCompany) {
		Connection conn = manager.open(jdbcUrl);
		PreparedStatement preparedStatement = null;
		try {
			preparedStatement = conn.prepareStatement("DELETE FROM EMPRESA WHERE id=?");
			preparedStatement.setInt(1, idCompany);
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
	public List<Company> listAll() {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public void update(Company element) {
		// TODO Auto-generated method stub
		
	}
	

	@Override
	public Company findById(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}

	
}