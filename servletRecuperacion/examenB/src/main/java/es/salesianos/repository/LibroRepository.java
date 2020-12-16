package es.salesianos.repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import es.salesianos.model.Almacen;
import es.salesianos.model.Libro;

public class LibroRepository extends Repository {
	
	public void delete(Libro libro) {
		Connection conn = manager.open(jdbcUrl);
		PreparedStatement prepareStatement = null;
		try {
			prepareStatement = conn.prepareStatement("DELETE FROM LIBRO WHERE id=?");
			prepareStatement.setInt(1, libro.getId());
			prepareStatement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		} finally {
			close(prepareStatement);
			manager.close(conn);
		}
	}
	
	public void insert(Libro libro) {
		Connection conn = manager.open(jdbcUrl);
		PreparedStatement preparedStatement = null;
		try {
			preparedStatement = conn
					.prepareStatement("INSERT INTO LIBRO (isbn, fechaEdicion, almacen_old, almacen_new)" + "VALUES (?, ?, ?, ?)");
			preparedStatement.setString(1, libro.getIsbn());
			preparedStatement.setDate(2, new java.sql.Date(libro.getFechaEdicion().getTime()));
			if (libro.getAlmacen_old().equals(new Integer(-1))) {
				preparedStatement.setNull(3, java.sql.Types.NULL); 
				preparedStatement.setInt(4, libro.getAlmacen_new());
			} else {
				preparedStatement.setInt(3, libro.getAlmacen_old());
				preparedStatement.setNull(4, java.sql.Types.NULL);
			}
			preparedStatement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		} finally {
			close(preparedStatement);
			manager.close(conn);
		}
	}
	
	public void update(Libro libro) {
		Connection conn = manager.open(jdbcUrl);
		PreparedStatement preparedStatement = null;
		try {
			preparedStatement = conn.prepareStatement("UPDATE LIBRO SET isbn=?, fechaEdicion=?, almacen_old=?, almacen_new=? WHERE id=?");
			preparedStatement.setString(1, libro.getIsbn());
			preparedStatement.setDate(2, new java.sql.Date(libro.getFechaEdicion().getTime()));
			if (libro.getAlmacen_old().equals(new Integer(-1))) {
				preparedStatement.setNull(3, java.sql.Types.NULL); 
				preparedStatement.setInt(4, libro.getAlmacen_new());
			} else {
				preparedStatement.setInt(3, libro.getAlmacen_old());
				preparedStatement.setNull(4, java.sql.Types.NULL);
			}
			preparedStatement.setInt(5, libro.getId());
			preparedStatement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		} finally {
			close(preparedStatement);
			manager.close(conn);
		}
	}
	
	public Almacen getAlmacen(Libro libro) {
		Integer id = (libro.getAlmacen_old() > libro.getAlmacen_new()) ? libro.getAlmacen_old() : libro.getAlmacen_new();
		boolean isOld = libro.getAlmacen_old().equals(id);
		AlmacenRepository repository = new AlmacenRepository();
		Almacen almacen = isOld ? repository.findByIdOld(id) : repository.findByIdNew(id);
		return almacen;
	}
	
	public Libro findById(Integer id) {
		Libro libro = null;
		Connection conn = manager.open(jdbcUrl);
		ResultSet resultSet = null;
		PreparedStatement prepareStatement = null;
		try {
			prepareStatement = conn.prepareStatement("SELECT * FROM LIBRO WHERE id=?");
			prepareStatement.setInt(1, id);
			resultSet = prepareStatement.executeQuery();
			while (resultSet.next()) {
				libro = new Libro(
						resultSet.getInt(1),
						resultSet.getString(2),
						resultSet.getString(3),
						resultSet.getInt(4),
						resultSet.getInt(5)
				);
				libro.setAlmacen(getAlmacen(libro));
			}
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		} finally {
			close(resultSet);
			close(prepareStatement);
			manager.close(conn);
		}

		return libro;
	}
	
	public List<Libro> listAll() {
		List<Libro> listaLibros = new ArrayList<Libro>();
		Connection conn = manager.open(jdbcUrl);
		ResultSet resultSet = null;
		PreparedStatement prepareStatement = null;
		try {
			prepareStatement = conn.prepareStatement("SELECT * FROM LIBRO");
			resultSet = prepareStatement.executeQuery();
			while (resultSet.next()) {
				Libro libro = new Libro(
						resultSet.getInt(1),
						resultSet.getString(2),
						resultSet.getString(3),
						resultSet.getInt(4),
						resultSet.getInt(5)
					);
				libro.setAlmacen(getAlmacen(libro));
				listaLibros.add(libro);
			}
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		} finally {
			close(resultSet);
			close(prepareStatement);
			manager.close(conn);
		}

		return listaLibros;
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
