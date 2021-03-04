package es.salesianos.repository;

import java.sql.Connection;



import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import es.salesianos.model.Business;
import es.salesianos.model.Student;

@org.springframework.stereotype.Repository("BusinessRepository")

public class BusinessRepository extends Repository {
	
	public void delete(Integer id) {
		Connection conn = createConnection();
		PreparedStatement prepareStatement = null;
		
		try {
			prepareStatement = conn.prepareStatement("DELETE FROM EMPRESA WHERE id=?");
			prepareStatement.setInt(1, id);
			prepareStatement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
			
		} finally {
			close(prepareStatement);
		}

		closeConnection(conn);
	}

	public void update(Business businessForm) {
		Connection conn = createConnection();
		PreparedStatement preparedStatement = null;
		try {
			preparedStatement = conn.prepareStatement("UPDATE EMPRESA SET nombre=? WHERE id=?");
			preparedStatement.setString(1, businessForm.getName());
			preparedStatement.setInt(2, businessForm.getId());
			preparedStatement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
			
		} finally {
			close(preparedStatement);
		}
		closeConnection(conn);
	}
	public void insert(Business business) {
		Connection conn = createConnection();
		PreparedStatement preparedStatement = null;
		try {
			preparedStatement = conn
					.prepareStatement("INSERT INTO EMPRESA (nombre)" + "VALUES (?)");
			preparedStatement.setString(1, business.getName());
			preparedStatement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
			
		} finally {
			close(preparedStatement);
		}
		closeConnection(conn);
	}
	
	public Business findById(Integer id) {
		Business business = null;
		Connection conn = createConnection();
		ResultSet resultSet = null;
		PreparedStatement prepareStatement = null;
		try {
			prepareStatement = conn.prepareStatement("SELECT * FROM EMPRESA WHERE id=?");
			prepareStatement.setInt(1, id);
			resultSet = prepareStatement.executeQuery();
			while (resultSet.next()) {
				 business = new Business(
						resultSet.getInt(1),
						resultSet.getString(2)
				);
			}
		} catch (SQLException e) {
			e.printStackTrace();
			
		} finally {
			close(resultSet);
			close(prepareStatement);
		}
		closeConnection(conn);
		return business;
	}
	public List<Student> getStudents(Business business) {
		List<Student> studentList = new ArrayList<Student>();
		Connection conn = createConnection();
		ResultSet resultSet = null;
		PreparedStatement prepareStatement = null;
		try {
			prepareStatement = conn.prepareStatement("SELECT * FROM ALUMNO WHERE empresa=?");
			prepareStatement.setInt(1, business.getId());
			resultSet = prepareStatement.executeQuery();
			while (resultSet.next()) {
				Student student = new Student(
						resultSet.getInt(1),
						resultSet.getString(2),
						resultSet.getInt(3),
						resultSet.getBoolean(4)
				);
				studentList.add(student);
			}
		} catch (SQLException e) {
			e.printStackTrace();
			
		} finally {
			close(resultSet);
			close(prepareStatement);
		}
		closeConnection(conn);
		return studentList;
	}
	public List<Business> listAll() {
		List<Business> businessList = new ArrayList<Business>();
		Connection conn = createConnection();
		ResultSet resultSet = null;
		PreparedStatement prepareStatement = null;
		try {
			prepareStatement = conn.prepareStatement("SELECT * FROM EMPRESA");
			resultSet = prepareStatement.executeQuery();
			while (resultSet.next()) {
				Business business = new Business(
						resultSet.getInt(1),
						resultSet.getString(2)
				);
				businessList.add(business);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(resultSet);
			close(prepareStatement);
			
		}
		closeConnection(conn);
		return businessList;
	}
}
