package es.salesianos.repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import es.salesianos.connection.AbstractConnection;
import es.salesianos.connection.H2Connection;
import es.salesianos.model.EmpresaAlumnoDto;
import es.salesianos.model.Alumno;
import es.salesianos.model.Empresa;


public class Repository {

	private static final String jdbcUrl = "jdbc:h2:file:./src/main/resources/test";
	AbstractConnection manager = new H2Connection();
	
	public void insert(Empresa empresa) {
		Connection conn = manager.open(jdbcUrl);
		PreparedStatement preparedStatement = null;
		try {
			preparedStatement = conn.prepareStatement("INSERT INTO EMPRESA(nombre) VALUES (?)");
			System.out.println("Empresa:" + empresa);
			preparedStatement.setString(1, empresa.getNombre());

			preparedStatement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		} finally {
			manager.close(preparedStatement);
			manager.close(conn);
		}
		
	}
	public Empresa getEmpresa() {
		return null;
	}
	public void insert(Alumno alumno) {
		Connection conn = manager.open(jdbcUrl);
		PreparedStatement preparedStatement = null;
		try {
			preparedStatement = conn.prepareStatement("INSERT INTO ALUMNO(nombre, edad, asisteFCT, empresa) VALUES (?, ?, ?, ?)");
			preparedStatement.setString(1, alumno.getNombre());
			preparedStatement.setInt(2, alumno.getEdad());
			preparedStatement.setBoolean(3, alumno.isAsisteFCT());
			preparedStatement.setInt(4, alumno.getEmpresa());
			System.out.println("jdfwnji " + alumno.getEmpresa());
			preparedStatement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		} finally {
			manager.close(preparedStatement);
			manager.close(conn);
		}
		
	}
	public List<EmpresaAlumnoDto> listAllDto() {
		Connection conn = manager.open(jdbcUrl);
		PreparedStatement preparedStatement = null;
		List<EmpresaAlumnoDto> list = new ArrayList<EmpresaAlumnoDto>();
		try {
			preparedStatement = conn
					.prepareStatement("SELECT EMPRESA.nombre, ALUMNO.nombre, ALUMNO.edad, ALUMNO.asisteFCT FROM EMPRESA INNER JOIN ALUMNO ON EMPRESA.id = ALUMNO.empresa");
			ResultSet resultSet = preparedStatement.executeQuery();
			while (resultSet.next()) {
				EmpresaAlumnoDto dto  = new EmpresaAlumnoDto();
				dto.setEmpresa(resultSet.getString(1));
				dto.setNombre(resultSet.getString(2));
				dto.setEdad(Integer.parseInt(resultSet.getString(3)));
				dto.setAsisteFCT(Boolean.valueOf(resultSet.getString(4)));
				
				list.add(dto);
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
	public void updateAlumno(Alumno a) {
		Connection conn = manager.open(jdbcUrl);
		PreparedStatement preparedStatement = null;
		try {
			preparedStatement = conn
					.prepareStatement("UPDATE ALUMNO SET asisteFCT = true WHERE nombre=?");
			preparedStatement.setString(1, a.getNombre());
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
