package es.salesianos.repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import es.salesianos.connection.ConnectionH2;
import es.salesianos.connection.ConnectionManager;
import es.salesianos.model.Student;
import es.salesianos.model.Company;



public class Repository {

	private static final String jdbcUrl = "jdbc:h2:file:./src/main/resources/test";
	ConnectionManager manager = new ConnectionH2();

	
	public Student search(Integer id) {
		Student sudentInDatabase = null;
		ResultSet resultSet = null;
		PreparedStatement prepareStatement = null;
		Connection conn = manager.open(jdbcUrl);
		try {
			prepareStatement = conn.prepareStatement("SELECT * FROM ALUMNO WHERE id = ?");
			prepareStatement.setInt(1, id);
			resultSet = prepareStatement.executeQuery();
			while (resultSet.next()) {
				sudentInDatabase = new Student();
				sudentInDatabase.setId(resultSet.getInt(1));
				sudentInDatabase.setName(resultSet.getString(2));
				sudentInDatabase.setAsisteFCT(resultSet.getBoolean(3));
				sudentInDatabase.setCompany(resultSet.getInt(4));
				
			}
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		} finally {
			close(resultSet);
			close(prepareStatement);

		}
		manager.close(conn);
		return sudentInDatabase;
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

	public void insert(Company company) {
		Connection conn = manager.open(jdbcUrl);
		PreparedStatement preparedStatement = null;
		try {
			preparedStatement = conn
					.prepareStatement("INSERT INTO EMPRESA (nombre)" + "VALUES (?)");
			preparedStatement.setString(1, company.getName());
			
			preparedStatement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		} finally {
			close(preparedStatement);
		}

		manager.close(conn);
	}
	
	public void insert(Student student) {
		Connection conn = manager.open(jdbcUrl);
		PreparedStatement preparedStatement = null;
		try {
			preparedStatement = conn
					.prepareStatement("INSERT INTO ALUMNO (nombre ,edad ,asisteFCT ,empresa )" + "VALUES (?,?,?,?)");
			preparedStatement.setString(1, student.getName());
			preparedStatement.setInt(2,  student.getAge());
			preparedStatement.setBoolean(3, student.isAsisteFCT());				
			preparedStatement.setInt(4, student.getCompany());
			
			preparedStatement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		} finally {
			close(preparedStatement);
		}

		manager.close(conn);
	}

	public void update(Student student) {
		Connection conn = manager.open(jdbcUrl);
		PreparedStatement preparedStatement = null;
		try {
			preparedStatement = conn
					.prepareStatement("UPDATE ALUMNO SET asisteFCT  = ? WHERE id = ?");
			preparedStatement.setBoolean(1, student.isAsisteFCT());
			preparedStatement.setInt(2, student.getId());

			preparedStatement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		} finally {
			close(preparedStatement);
			manager.close(conn);
		}

	}
	
	
	
	
	public List<Company> searchAllCompany() {
		List<Company> listCompany = new ArrayList<Company>();
		Connection conn = manager.open(jdbcUrl);
		ResultSet resultSet = null;
		PreparedStatement prepareStatement = null;
		try {
			selectCompany(listCompany,conn,resultSet,prepareStatement);
			selectStudent(listCompany,conn,resultSet,prepareStatement);			
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		} finally {
			close(resultSet);
			close(prepareStatement);
			manager.close(conn);
		}

		return listCompany;
	}
	
	public void selectCompany(List<Company> listCompany,Connection conn,ResultSet resultSet,PreparedStatement prepareStatement) throws SQLException {
		prepareStatement = conn.prepareStatement("SELECT * FROM EMPRESA");
		resultSet = prepareStatement.executeQuery();
		while (resultSet.next()) {
			Company CompanyInDatabase = new Company();
			
			CompanyInDatabase.setId(resultSet.getInt(1));
			CompanyInDatabase.setName(resultSet.getString(2));
			
			listCompany.add(CompanyInDatabase);
		}
	}
	
	public void selectStudent(List<Company> listCompany,Connection conn,ResultSet resultSet,PreparedStatement prepareStatement) throws SQLException {
		for (Company company : listCompany) {
			
			prepareStatement = conn.prepareStatement(
					"SELECT * FROM ALUMNO where empresa="+company.getId());
			resultSet = prepareStatement.executeQuery();
			while (resultSet.next()) {
				Student alumno = new Student();
				alumno.setId(resultSet.getInt(1));
				alumno.setName(resultSet.getString(2));
				alumno.setAge(resultSet.getInt(3));
				alumno.setAsisteFCT(resultSet.getBoolean(4));
				company.getStudents().add(alumno);
			}
		}
	}
	
	public void delete(Integer id, String answer) {
		Connection conn = manager.open(jdbcUrl);
		PreparedStatement preparedStatement = null;
		try {
			if(answer.equals("SI")) {
				preparedStatement = deleteStudent(id, conn);
				preparedStatement = deleteCompany(id, conn);
			}else {
				preparedStatement = newId (id, conn);
				preparedStatement = deleteCompany(id, conn);
			}		

		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		} finally {
			close(preparedStatement);
			manager.close(conn);
		}

	}
	
	
	private PreparedStatement deleteCompany (Integer id, Connection conn) throws SQLException {
		PreparedStatement preparedStatement;
		preparedStatement = conn
				.prepareStatement("DELETE FROM EMPRESA WHERE id = ?");
		preparedStatement.setInt(1, id);
		preparedStatement.executeUpdate();
		return preparedStatement;
	}
	
	private PreparedStatement newId (Integer id, Connection conn) throws SQLException {
		PreparedStatement preparedStatement;
		preparedStatement = conn
				.prepareStatement("UPDATE ALUMNO SET empresa  = ? WHERE empresa = ?");
		preparedStatement.setNull(1, java.sql.Types.NULL);
		preparedStatement.setInt(2, id);
		preparedStatement.executeUpdate();
		return preparedStatement;
	}
	

	private PreparedStatement deleteStudent (Integer id, Connection conn) throws SQLException {
		PreparedStatement preparedStatement;
		preparedStatement = conn
				.prepareStatement("DELETE FROM ALUMNO WHERE empresa = ?");
		preparedStatement.setInt(1, id);
		preparedStatement.executeUpdate();
		return preparedStatement;
	}
	

	

}
