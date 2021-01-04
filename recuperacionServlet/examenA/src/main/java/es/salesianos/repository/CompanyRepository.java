package es.salesianos.repository;

import java.sql.Connection;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import es.salesianos.model.Student;
import es.salesianos.model.Company;

public class CompanyRepository extends Repository {

	public Company findById(Integer id) {
		Company company = null;
		Connection conn = manager.open(jdbcUrl);
		ResultSet resultSet = null;
		PreparedStatement prepareStatement = null;
		try {
			prepareStatement = conn.prepareStatement("SELECT * FROM EMPRESA WHERE id=?");
			prepareStatement.setInt(1, id);
			resultSet = prepareStatement.executeQuery();
			while (resultSet.next()) {
				 company = new Company(
						resultSet.getInt(1),
						resultSet.getString(2)
				);
			}
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		} finally {
			close(resultSet);
			close(prepareStatement);
			manager.close(conn);
		}

		return company;
	}
	
	public List<Student> getStudents(Company company) {
		List<Student> listaStudents = new ArrayList<Student>();
		Connection conn = manager.open(jdbcUrl);
		ResultSet resultSet = null;
		PreparedStatement prepareStatement = null;
		try {
			prepareStatement = conn.prepareStatement("SELECT * FROM ALUMNO WHERE empresa=?");
			prepareStatement.setInt(1, company.getId());
			resultSet = prepareStatement.executeQuery();
			while (resultSet.next()) {
				Student student = new Student(
						resultSet.getInt(1),
						resultSet.getString(2),
						resultSet.getInt(3),
						resultSet.getBoolean(4),
						resultSet.getInt(5)
				);
				student.setObjCompany(company);
				listaStudents.add(student);
			}
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		} finally {
			close(resultSet);
			close(prepareStatement);
			manager.close(conn);
		}

		return listaStudents;
	}
	
	public void delete(Company company) {
		Connection conn = manager.open(jdbcUrl);
		PreparedStatement prepareStatement = null;
		try {
			prepareStatement = conn.prepareStatement("DELETE FROM EMPRESA WHERE id=?");
			prepareStatement.setInt(1, company.getId());
			prepareStatement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		} finally {
			close(prepareStatement);
			manager.close(conn);
		}
	}
	
	public void insert(Company empresa) {
		Connection conn = manager.open(jdbcUrl);
		PreparedStatement preparedStatement = null;
		try {
			preparedStatement = conn
					.prepareStatement("INSERT INTO EMPRESA (nombre)" + "VALUES (?)");
			preparedStatement.setString(1, empresa.getName());
			preparedStatement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		} finally {
			close(preparedStatement);
			manager.close(conn);
		}
	}
	
	public List<Company> listAll() {
		List<Company> listaCompanies = new ArrayList<Company>();
		Connection conn = manager.open(jdbcUrl);
		ResultSet resultSet = null;
		PreparedStatement prepareStatement = null;
		try {
			prepareStatement = conn.prepareStatement("SELECT * FROM EMPRESA");
			resultSet = prepareStatement.executeQuery();
			while (resultSet.next()) {
				Company company = new Company(
						resultSet.getInt(1),
						resultSet.getString(2)
				);
				listaCompanies.add(company);
			}
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		} finally {
			close(resultSet);
			close(prepareStatement);
			manager.close(conn);
		}
		
		return listaCompanies;
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
