package com.mycompany.repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

mport com.mycompany.connection.AbstractConnection;
import com.mycompany.connection.H2Connection;
import com.mycomapny.model.EmpresaAlumnoDto;
import es.salesianos.model.Alumno;
import es.salesianos.model.FCTCompany;


public class Repository {

	private static final String jdbcUrl = "jdbc:h2:file:./src/main/resources/test";
	AbstractConnection manager = new H2Connection();

	public void insert(Company company) {
		Connection conn = manager.open(jdbcUrl);
		PreparedStatement preparedStatement = null;
		try {
			preparedStatement = conn.prepareStatement("INSERT INTO COMPANY(name) VALUES (?)");
			System.out.println("Comapny:" + empresa);
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
	public Company getCompany() {
		return null;
	}
	public void insert(Student student) {
		Connection conn = manager.open(jdbcUrl);
		PreparedStatement preparedStatement = null;
		try {
			preparedStatement = conn.prepareStatement("INSERT INTO STUDENT(name_student, age, FCTasists, company) VALUES (?, ?, ?, ?)");
			preparedStatement.setString(1, student.getName_student());
			preparedStatement.setInt(2, student.getAge());
			preparedStatement.setBoolean(3, student.FCTasists());
			preparedStatement.setInt(4, student.getCompany());
			System.out.println("Hello" + student.getComapny());
			preparedStatement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		} finally {
			manager.close(preparedStatement);
			manager.close(conn);
		}

	}
	public List<FCTCompany> listAllDto() {
		Connection conn = manager.open(jdbcUrl);
		PreparedStatement preparedStatement = null;
		List<FCTCompany> list = new ArrayList<FCTCompany>();
		try {
			preparedStatement = conn
					.prepareStatement("SELECT COMPANY.name, STUDENT.name_student, STUDENT.age, STUDENT.FCTasists FROM COMPANY INNER JOIN STUDENT ON COMPANY.id = STUDENT.company");
			ResultSet resultSet = preparedStatement.executeQuery();
			while (resultSet.next()) {
				FCTCompany fct  = new FCTCompany();
				fct.setCompany(resultSet.getString(1));
				fct.setName_student(resultSet.getString(2));
				fct.setAge(Integer.parseInt(resultSet.getString(3)));
				fct.setFCTasists(Boolean.valueOf(resultSet.getString(4)));

				list.add(fct);
			}

		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		} finally {
			manager.close(preparedStatement);
			manager.close(conn);
		}
		return list;

	}
	public void updateStudent(Student) {
		Connection conn = manager.open(jdbcUrl);
		PreparedStatement preparedStatement = null;
		try {
			preparedStatement = conn
					.prepareStatement("UPDATE STUDENT SET FCTasists = true WHERE name_student=?");
			preparedStatement.setString(1, a.getName_student());
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
