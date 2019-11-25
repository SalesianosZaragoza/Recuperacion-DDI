package es.salesianos.repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import es.salesianos.model.User;

@Component
public class UserRepository extends AbstractRepository implements Repository<User> {



	public void insert(User userFormulario) {
		Connection conn = manager.open(jdbcUrl);
		PreparedStatement preparedStatement = null;
		try {
			preparedStatement = conn
					.prepareStatement("INSERT INTO USER (nombre,apellido)" + "VALUES (?, ?)");
			preparedStatement.setString(1, userFormulario.getNombre());
			preparedStatement.setString(2, userFormulario.getApellido());
			preparedStatement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		} finally {
			manager.close(preparedStatement);
			manager.close(conn);
		}

	}

	public List<User> listAll() {
		Connection conn = manager.open(jdbcUrl);
		PreparedStatement preparedStatement = null;
		ArrayList<User> users = new ArrayList<User>();
		try {
			preparedStatement = conn.prepareStatement("SELECT * FROM USER");
			ResultSet resultSet = preparedStatement.executeQuery();
			while (resultSet.next()) {
				User user = new User();
				user.setId(resultSet.getInt("id"));
				user.setNombre(resultSet.getString("nombre"));
				user.setApellido(resultSet.getString("apellido"));
				users.add(user);
			}

		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		} finally {
			manager.close(preparedStatement);
			manager.close(conn);
		}
		return users;

	}

	public User listByUser(Integer idUser) {
		Connection conn = manager.open(jdbcUrl);
		PreparedStatement preparedStatement = null;
		User user;
		try {
			preparedStatement = conn.prepareStatement("SELECT * FROM USER WHERE id=?");
			preparedStatement.setInt(1, idUser);
			ResultSet resultSet = preparedStatement.executeQuery();
			resultSet.next();
			user = new User();
			user.setId(resultSet.getInt("id"));
			user.setNombre(resultSet.getString("nombre"));
			user.setApellido(resultSet.getString("apellido"));

		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		} finally {
			manager.close(preparedStatement);
			manager.close(conn);
		}
		return user;
	}

	public void update(User user) {
		Connection conn = manager.open(jdbcUrl);
		PreparedStatement preparedStatement = null;
		try {
			preparedStatement = conn.prepareStatement("UPDATE USER SET nombre=? , apellido=? WHERE id=?");
			preparedStatement.setString(1, user.getNombre());
			preparedStatement.setString(2, user.getApellido());
			preparedStatement.setInt(3, user.getId());
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
	public User findBy(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}

}
