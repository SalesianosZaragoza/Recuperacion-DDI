package es.salesianos.repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import es.salesianos.model.Character;
import es.salesianos.model.Race;

public class RaceRepository extends AbstractRepository implements Repository<Race> {
	


	public List<Race> listAll() {
		Connection conn = manager.open(jdbcUrl);
		PreparedStatement preparedStatement = null;
		ArrayList<Race> users = new ArrayList<Race>();
		try {
			preparedStatement = conn.prepareStatement("SELECT * FROM raza");
			ResultSet resultSet = preparedStatement.executeQuery();
			while (resultSet.next()) {
				Race user = new Race();
				user.setId(resultSet.getInt("id"));
				user.setSpecie(resultSet.getString("especie"));
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

	public Race findBy(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}

	public void insert(Race race) {
		Connection conn = manager.open(jdbcUrl);
		PreparedStatement preparedStatement = null;
		try {
			preparedStatement = conn.prepareStatement("INSERT INTO raza (especie)" + "VALUES (?)");
			preparedStatement.setString(1, race.getSpecie());
			preparedStatement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		} finally {
			manager.close(preparedStatement);
			manager.close(conn);
		}


	}

	public void update(Race race) {
		Connection conn = manager.open(jdbcUrl);
		PreparedStatement preparedStatement = null;
		try {
			preparedStatement = conn.prepareStatement("UPDATE raza  SET especie=? WHERE id=?");
			preparedStatement.setString(1, race.getSpecie());
			preparedStatement.setInt(2, race.getId());
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
