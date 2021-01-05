package es.salesianos.repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import es.salesianos.connection.ConnectionH2;
import es.salesianos.connection.ConnectionManager;
import es.salesianos.model.Alumno;
import es.salesianos.model.Empresa;



public class Repository {

	private static final String jdbcUrl = "jdbc:h2:file:./src/main/resources/test";
	ConnectionManager manager = new ConnectionH2();

	
	public Alumno search(Integer id) {
		Alumno userInDatabase = null;
		ResultSet resultSet = null;
		PreparedStatement prepareStatement = null;
		Connection conn = manager.open(jdbcUrl);
		try {
			prepareStatement = conn.prepareStatement("SELECT * FROM ALUMNO WHERE id = ?");
			prepareStatement.setInt(1, id);
			resultSet = prepareStatement.executeQuery();
			while (resultSet.next()) {
				userInDatabase = new Alumno();
				userInDatabase.setId(resultSet.getInt(1));
				userInDatabase.setName(resultSet.getString(2));
				userInDatabase.setAsisteFCT(resultSet.getBoolean(3));
				userInDatabase.setEmpresa(resultSet.getInt(4));
				
			}
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		} finally {
			close(resultSet);
			close(prepareStatement);

		}
		manager.close(conn);
		return userInDatabase;
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

	public void insert(Empresa userFormulario) {
		Connection conn = manager.open(jdbcUrl);
		PreparedStatement preparedStatement = null;
		try {
			preparedStatement = conn
					.prepareStatement("INSERT INTO EMPRESA (nombre)" + "VALUES (?)");
			preparedStatement.setString(1, userFormulario.getName());
			
			preparedStatement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		} finally {
			close(preparedStatement);
		}

		manager.close(conn);
	}
	
	public void insert(Alumno userFormulario) {
		Connection conn = manager.open(jdbcUrl);
		PreparedStatement preparedStatement = null;
		try {
			preparedStatement = conn
					.prepareStatement("INSERT INTO ALUMNO (nombre ,edad ,asisteFCT ,empresa )" + "VALUES (?)");
			preparedStatement.setString(1, userFormulario.getName());
			preparedStatement.setInt(2,  userFormulario.getEdad());
			preparedStatement.setBoolean(3, userFormulario.isAsisteFCT());				
			preparedStatement.setInt(4, userFormulario.getEmpresa());
			
			preparedStatement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		} finally {
			close(preparedStatement);
		}

		manager.close(conn);
	}

	public void update(Alumno userFormulario) {
		Connection conn = manager.open(jdbcUrl);
		PreparedStatement preparedStatement = null;
		try {
			preparedStatement = conn
					.prepareStatement("UPDATE ALUMNO SET asisteFCT  = ? WHERE id = ?");
			preparedStatement.setBoolean(1, userFormulario.isAsisteFCT());
			preparedStatement.setInt(2, userFormulario.getId());

			preparedStatement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		} finally {
			close(preparedStatement);
			manager.close(conn);
		}

	}
	
	
	
	
	public List<Empresa> searchAllEmpresa() {
		List<Empresa> listEmpresa = new ArrayList<Empresa>();
		Connection conn = manager.open(jdbcUrl);
		ResultSet resultSet = null;
		PreparedStatement prepareStatement = null;
		try {
			
			prepareStatement = conn.prepareStatement("SELECT * FROM EMPRESA");
			resultSet = prepareStatement.executeQuery();
			while (resultSet.next()) {
				Empresa EmpresaInDatabase = new Empresa();
				
				EmpresaInDatabase.setId(resultSet.getInt(1));
				EmpresaInDatabase.setName(resultSet.getString(2));
				
				listEmpresa.add(EmpresaInDatabase);
			}

			for (Empresa empresa : listEmpresa) {
				
				prepareStatement = conn.prepareStatement(
						"SELECT * FROM ALUMNO where empresa="+empresa.getId());
				resultSet = prepareStatement.executeQuery();
				while (resultSet.next()) {
					Alumno alumno = new Alumno();
					alumno.setName(resultSet.getString(1));
					alumno.setEdad(resultSet.getInt(2));
					alumno.setAsisteFCT(resultSet.getBoolean(3));
					empresa.getAlumno().add(alumno);
				}
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		} finally {
			close(resultSet);
			close(prepareStatement);
			manager.close(conn);
		}

		return listEmpresa;
	}
	
	public void deleteNew(Integer id, String answer) {
		Connection conn = manager.open(jdbcUrl);
		PreparedStatement preparedStatement = null;
		try {
			if(answer.equals("SI")) {
				preparedStatement = deleteAlumno(id, conn);}
			
			preparedStatement = deleteNew(id, conn);

		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		} finally {
			close(preparedStatement);
			manager.close(conn);
		}

	}
	
	
	private PreparedStatement deleteNew (Integer id, Connection conn) throws SQLException {
		PreparedStatement preparedStatement;
		preparedStatement = conn
				.prepareStatement("DELETE FROM EMPRESA WHERE id = ?");
		preparedStatement.setInt(1, id);
		preparedStatement.executeUpdate();
		return preparedStatement;
	}
	

	private PreparedStatement deleteAlumno (Integer id, Connection conn) throws SQLException {
		PreparedStatement preparedStatement;
		preparedStatement = conn
				.prepareStatement("DELETE FROM ALUMNO WHERE empresa = ?");
		preparedStatement.setInt(1, id);
		preparedStatement.executeUpdate();
		return preparedStatement;
	}
	

	

}
