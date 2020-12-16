package es.salesianos.repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.management.RuntimeErrorException;

import es.salesianos.model.Almacen;
import es.salesianos.model.Libro;

public class AlmacenRepository extends Repository {
	
	public void delete(Almacen almacen) {
		Connection conn = manager.open(jdbcUrl);
		PreparedStatement prepareStatement = null;
		try {
			prepareStatement = conn.prepareStatement((almacen.isOld()) ?
							"DELETE FROM ALMACEN_OLD WHERE id=?" :
							"DELETE FROM ALMACEN_NEW WHERE id=?"
						);
			prepareStatement.setInt(1, almacen.getId());
			prepareStatement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		} finally {
			close(prepareStatement);
			manager.close(conn);
		}
	}
	
	public void update(Almacen almacen) {
		Connection conn = manager.open(jdbcUrl);
		PreparedStatement preparedStatement = null;
		try {
			preparedStatement = conn.prepareStatement((almacen.isOld()) ?
					"UPDATE ALMACEN_OLD SET nombre=? WHERE id=?" :
					"UPDATE ALMACEN_NEW SET =? WHERE id=?"	
					);
			preparedStatement.setString(1, almacen.getName());
			preparedStatement.setInt(2, almacen.getId());
			preparedStatement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		} finally {
			close(preparedStatement);
			manager.close(conn);
		}
	}
	
	public Almacen findByIdOld(Integer id) {
		Almacen almacen = null;
		Connection conn = manager.open(jdbcUrl);
		ResultSet resultSet = null;
		PreparedStatement prepareStatement = null;
		try {
			prepareStatement = conn.prepareStatement("SELECT * FROM ALMACEN_OLD WHERE id=?");
			prepareStatement.setInt(1, id);
			resultSet = prepareStatement.executeQuery();
			while (resultSet.next()) {
				almacen = new Almacen(
						resultSet.getInt(1),
						resultSet.getString(2),
						true
				);
				almacen.setLibros(getLibros(almacen));
			}
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		} finally {
			close(resultSet);
			close(prepareStatement);
			manager.close(conn);
		}

		return almacen;
	}
	
	public Almacen findByIdNew(Integer id) {
		Almacen almacen = null;
		Connection conn = manager.open(jdbcUrl);
		ResultSet resultSet = null;
		PreparedStatement prepareStatement = null;
		try {
			prepareStatement = conn.prepareStatement("SELECT * FROM ALMACEN_NEW WHERE id=?");
			prepareStatement.setInt(1, id);
			resultSet = prepareStatement.executeQuery();
			while (resultSet.next()) {
				almacen = new Almacen(
						resultSet.getInt(1),
						resultSet.getString(2),
						false
				);
				almacen.setLibros(getLibros(almacen));
			}
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		} finally {
			close(resultSet);
			close(prepareStatement);
			manager.close(conn);
		}

		return almacen;
	}
	
	public List<Almacen> listOld() {
		List<Almacen> listAlmacen = new ArrayList<Almacen>();
		Connection conn = manager.open(jdbcUrl);
		ResultSet resultSet = null;
		PreparedStatement prepareStatement = null;
		try {
			prepareStatement = conn.prepareStatement("SELECT * FROM ALMACEN_OLD");
			resultSet = prepareStatement.executeQuery();
			while (resultSet.next()) {
				Almacen almacen = new Almacen(
						resultSet.getInt(1),
						resultSet.getString(2),
						true
				);
				almacen.setLibros(getLibros(almacen));
				listAlmacen.add(almacen);
			}
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		} finally {
			close(resultSet);
			close(prepareStatement);
			manager.close(conn);
		}

		return listAlmacen;
	}
	
	public List<Almacen> listNew() {
		List<Almacen> listAlmacen = new ArrayList<Almacen>();
		Connection conn = manager.open(jdbcUrl);
		ResultSet resultSet = null;
		PreparedStatement prepareStatement = null;
		try {
			prepareStatement = conn.prepareStatement("SELECT * FROM ALMACEN_NEW");
			resultSet = prepareStatement.executeQuery();
			while (resultSet.next()) {
				Almacen almacen = new Almacen(
						resultSet.getInt(1),
						resultSet.getString(2),
						false
				);
				almacen.setLibros(getLibros(almacen));
				listAlmacen.add(almacen);
			}
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		} finally {
			close(resultSet);
			close(prepareStatement);
			manager.close(conn);
		}

		return listAlmacen;
	}
	
	public List<Almacen> listAll() {
		List<Almacen> lista = new ArrayList<Almacen>(listOld());
		lista.addAll(listNew());
		return lista;
	}

	public List<Libro> getLibros(Almacen almacen) {
		List<Libro> lista = new ArrayList<Libro>();
		Connection conn = manager.open(jdbcUrl);
		ResultSet resultSet = null;
		PreparedStatement prepareStatement = null;
		try {
			prepareStatement = conn.prepareStatement((almacen.isOld()) ? 
				"SELECT * FROM LIBRO WHERE almacen_old=?" :
				"SELECT * FROM LIBRO WHERE almacen_new=?"
			);
			prepareStatement.setInt(1, almacen.getId());
			resultSet = prepareStatement.executeQuery();
			while (resultSet.next()) {
				Libro libro = new Libro(
						resultSet.getInt(1),
						resultSet.getString(2),
						resultSet.getString(3),
						resultSet.getInt(4),
						resultSet.getInt(5)
				);
				lista.add(libro);
			}
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		} finally {
			close(resultSet);
			close(prepareStatement);
			manager.close(conn);
		}

		return lista;
	}
	
	public void insert(Almacen almacen) {
		Connection conn = manager.open(jdbcUrl);
		PreparedStatement preparedStatement = null;
		try {
			preparedStatement = conn
					.prepareStatement((almacen.isOld()) ? 
									("INSERT INTO ALMACEN_OLD(nombre)" + "VALUES (?)") :
									("INSERT INTO ALMACEN_NEW(nombre)" + "VALUES (?)")
							);
			preparedStatement.setString(1, almacen.getName());
			preparedStatement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		} finally {
			close(preparedStatement);
		}

		manager.close(conn);
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
