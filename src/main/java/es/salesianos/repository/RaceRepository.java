package es.salesianos.repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import es.salesianos.connection.AbstractConnection;
import es.salesianos.connection.H2Connection;
import es.salesianos.model.Race;

public class RaceRepository extends AbstractRepository implements Repository<Race> {

	protected static final String jdbcUrl = "jdbc:h2:file:./src/main/resources/test;INIT=RUNSCRIPT FROM 'classpath:scripts/create.sql'";
	protected AbstractConnection manager = new H2Connection();

	public List<Race> listAll() {
		Connection conn = manager.open(jdbcUrl);
		PreparedStatement preparedStatement = null;
		ArrayList<Race> races = new ArrayList<Race>();
		try {
			preparedStatement = conn.prepareStatement("SELECT * FROM race");
			ResultSet resultSet = preparedStatement.executeQuery();
			while (resultSet.next()) {
				Race race = new Race();
				race.setId(resultSet.getInt("id"));
				race.setSpecie(resultSet.getString("specie"));
				races.add(race);
			}

		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		} finally {
			manager.close(preparedStatement);
			manager.close(conn);
		}
		return races;
	}

	public void insert(Race race) {
		Connection conn = manager.open(jdbcUrl);
		PreparedStatement preparedStatement = null;
		try {
			preparedStatement = conn.prepareStatement("INSERT INTO race (specie)" + "VALUES (?)");
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
			preparedStatement = conn.prepareStatement("UPDATE race  SET specie=? WHERE id=?");
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

	public Race findBy(Integer id) {
		Connection conn = manager.open(jdbcUrl);
		PreparedStatement preparedStatement = null;
		Race race;
		try {
			preparedStatement = conn.prepareStatement("SELECT * FROM race WHERE id=?");
			preparedStatement.setInt(1, id);
			ResultSet resultSet = preparedStatement.executeQuery();
			resultSet.next();
			race = new Race();
			race.setId(resultSet.getInt("id"));
			race.setSpecie(resultSet.getString("specie"));

		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		} finally {
			manager.close(preparedStatement);
			manager.close(conn);
		}
		return race;
	}
}