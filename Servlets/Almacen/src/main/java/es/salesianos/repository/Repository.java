package es.salesianos.repository;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import es.salesianos.connection.ConnectionH2;
import es.salesianos.connection.ConnectionManager;
import es.salesianos.model.AlmacenNew;
import es.salesianos.model.AlmacenOld;
import es.salesianos.model.Libro;



public class Repository {

	private static final String jdbcUrl = "jdbc:h2:file:./src/main/resources/test";
	ConnectionManager manager = new ConnectionH2();

	public AlmacenOld search(AlmacenOld userFormulario) {
		AlmacenOld userInDatabase = null;
		ResultSet resultSet = null;
		PreparedStatement prepareStatement = null;
		Connection conn = manager.open(jdbcUrl);
		try {
			prepareStatement = conn.prepareStatement("SELECT * FROM ALMACEN_OLD WHERE name = ?");
			prepareStatement.setString(1, userFormulario.getName());
			resultSet = prepareStatement.executeQuery();
			while (resultSet.next()) {
				userInDatabase = new AlmacenOld();
				userInDatabase.setName(resultSet.getString(1));
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
	
	public AlmacenNew search(AlmacenNew userFormulario) {
		AlmacenNew userInDatabase = null;
		ResultSet resultSet = null;
		PreparedStatement prepareStatement = null;
		Connection conn = manager.open(jdbcUrl);
		try {
			prepareStatement = conn.prepareStatement("SELECT * FROM ALMACEN_NEW WHERE name = ?");
			prepareStatement.setString(1, userFormulario.getName());
			resultSet = prepareStatement.executeQuery();
			while (resultSet.next()) {
				userInDatabase = new AlmacenNew();
				userInDatabase.setName(resultSet.getString(1));
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

	public void insert(AlmacenOld userFormulario) {
		Connection conn = manager.open(jdbcUrl);
		PreparedStatement preparedStatement = null;
		try {
			preparedStatement = conn
					.prepareStatement("INSERT INTO ALMACEN_OLD (nombre)" + "VALUES (?)");
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
	
	public void insert(AlmacenNew userFormulario) {
		Connection conn = manager.open(jdbcUrl);
		PreparedStatement preparedStatement = null;
		try {
			preparedStatement = conn
					.prepareStatement("INSERT INTO ALMACEN_NEW (nombre)" + "VALUES (?)");
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
	
	public void insert(Libro userFormulario) {
		Connection conn = manager.open(jdbcUrl);
		PreparedStatement preparedStatement = null;
		try {
			preparedStatement = conn
					.prepareStatement("INSERT INTO LIBRO (isbn,fechaEdicion,almacen_old,almacen_new)" + "VALUES (?)");
			preparedStatement.setString(1, userFormulario.getIsbn());
			preparedStatement.setDate(2, (Date) userFormulario.getFechaEdicion());
			if(userFormulario.getAlmacenOld() != null)
				preparedStatement.setInt(3, userFormulario.getAlmacenOld());
			else				
				preparedStatement.setInt(4, userFormulario.getAlmacenNew());
			
			preparedStatement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		} finally {
			close(preparedStatement);
		}

		manager.close(conn);
	}

	public void update(AlmacenOld userFormulario) {
		Connection conn = manager.open(jdbcUrl);

		PreparedStatement preparedStatement = null;
		try {
			preparedStatement = conn
					.prepareStatement("UPDATE ALMACEN_OLD SET nombre = ? WHERE nombre = ?");
			preparedStatement.setString(1, userFormulario.getName());
			preparedStatement.setString(2, userFormulario.getName());

			preparedStatement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		} finally {
			close(preparedStatement);
			manager.close(conn);
		}

	}
	
	public void update(AlmacenNew userFormulario) {
		Connection conn = manager.open(jdbcUrl);

		PreparedStatement preparedStatement = null;
		try {
			preparedStatement = conn
					.prepareStatement("UPDATE ALMACEN_NEW SET nombre = ? WHERE nombre = ?");
			preparedStatement.setString(1, userFormulario.getName());
			preparedStatement.setString(2, userFormulario.getName());

			preparedStatement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		} finally {
			close(preparedStatement);
			manager.close(conn);
		}

	}
	
	public List<AlmacenOld> searchAllOld() {
		List<AlmacenOld> listAlmacenOld = new ArrayList<AlmacenOld>();
		Connection conn = manager.open(jdbcUrl);
		ResultSet resultSet = null;
		PreparedStatement prepareStatement = null;
		try {
			
			prepareStatement = conn.prepareStatement("SELECT * FROM ALMACEN_OLD");
			resultSet = prepareStatement.executeQuery();
			while (resultSet.next()) {
				AlmacenOld AlmacenOldInDatabase = new AlmacenOld();
				
				AlmacenOldInDatabase.setId(resultSet.getInt(1));
				AlmacenOldInDatabase.setName(resultSet.getString(2));
				
				listAlmacenOld.add(AlmacenOldInDatabase);
			}

			for (AlmacenOld almacenOld : listAlmacenOld) {
				
				prepareStatement = conn.prepareStatement(
						"SELECT * FROM LIBRO where almacen_old="+almacenOld.getId());
				resultSet = prepareStatement.executeQuery();
				while (resultSet.next()) {
					Libro libro = new Libro();
					libro.setIsbn(resultSet.getString(1));
					libro.setFechaEdicion(resultSet.getDate(2));
					almacenOld.getLibros().add(libro);
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

		return listAlmacenOld;
	}
	
	public List<AlmacenNew> searchAllNew() {
		List<AlmacenNew> listAlmacenNew = new ArrayList<AlmacenNew>();
		Connection conn = manager.open(jdbcUrl);
		ResultSet resultSet = null;
		PreparedStatement prepareStatement = null;
		try {
			
			prepareStatement = conn.prepareStatement("SELECT * FROM ALMACEN_NEW");
			resultSet = prepareStatement.executeQuery();
			while (resultSet.next()) {
				AlmacenNew AlmacenNewInDatabase = new AlmacenNew();
				
				AlmacenNewInDatabase.setId(resultSet.getInt(1));
				AlmacenNewInDatabase.setName(resultSet.getString(2));
				
				listAlmacenNew.add(AlmacenNewInDatabase);
			}

			for (AlmacenNew almacenNew : listAlmacenNew) {
				
				prepareStatement = conn.prepareStatement(
						"SELECT * FROM LIBRO where almacen_new="+almacenNew.getId());
				resultSet = prepareStatement.executeQuery();
				while (resultSet.next()) {
					Libro libro = new Libro();
					libro.setIsbn(resultSet.getString(1));
					libro.setFechaEdicion(resultSet.getDate(2));
					almacenNew.getLibros().add(libro);
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

		return listAlmacenNew;
	}
	
	public void deleteNew(Integer id) {
		Connection conn = manager.open(jdbcUrl);
		PreparedStatement preparedStatement = null;
		try {
			
			preparedStatement = deleteLibrosNew(id, conn);
			
			preparedStatement = deleteNew(id, conn);

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
			
			preparedStatement = deleteLibrosOld(id, conn);
			
			preparedStatement = deleteOld(id, conn);

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
				.prepareStatement("DELETE FROM ALMACEN_NEW WHERE id = ?");
		preparedStatement.setInt(1, id);
		preparedStatement.executeUpdate();
		return preparedStatement;
	}
	
	private PreparedStatement deleteOld (Integer id, Connection conn) throws SQLException {
		PreparedStatement preparedStatement;
		preparedStatement = conn
				.prepareStatement("DELETE FROM ALMACEN_OLD WHERE id = ?");
		preparedStatement.setInt(1, id);
		preparedStatement.executeUpdate();
		return preparedStatement;
	}

	private PreparedStatement deleteLibrosOld (Integer id, Connection conn) throws SQLException {
		PreparedStatement preparedStatement;
		preparedStatement = conn
				.prepareStatement("DELETE FROM LIBRO WHERE almacen_old = ?");
		preparedStatement.setInt(1, id);
		preparedStatement.executeUpdate();
		return preparedStatement;
	}

	private PreparedStatement deleteLibrosNew (Integer id, Connection conn) throws SQLException {
		PreparedStatement preparedStatement;
		preparedStatement = conn
				.prepareStatement("DELETE FROM LIBRO WHERE almacen_new = ?");
		preparedStatement.setInt(1, id);
		preparedStatement.executeUpdate();
		return preparedStatement;
	}
	

	

}
