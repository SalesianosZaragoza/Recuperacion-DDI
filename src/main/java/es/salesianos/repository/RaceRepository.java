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

@org.springframework.stereotype.Repository("raceRepository")
public class RaceRepository implements Repository<Race> {
	private AbstractConnection manager = new H2Connection();
	protected static final String jdbcUrl = "jdbc:h2:file:./src/main/resources/test;INIT=RUNSCRIPT FROM 'classpath:scripts/create.sql'";

	@Override
	public void insert(Race race) {
		Connection conn = manager.open(jdbcUrl);
		PreparedStatement preparedStatement = null;
		try {
			preparedStatement = conn.prepareStatement("INSERT INTO RAZA (especie)" + "VALUES (?)");
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

	@Override
	public List<Race> listAll() {
		Connection conn = manager.open(jdbcUrl);
		PreparedStatement preparedStatement = null;
		ArrayList<Race> races = new ArrayList<Race>();
		try {
			preparedStatement = conn.prepareStatement("SELECT * FROM RAZA");
			ResultSet resultSet = preparedStatement.executeQuery();
			while (resultSet.next()) {
				Race race = new Race();
				race.setId(resultSet.getInt("id"));
				race.setSpecie(resultSet.getString("especie"));

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

	@Override
	public Race findById(Integer id) {
		Connection conn = manager.open(jdbcUrl);
		PreparedStatement preparedStatement = null;
		Race race;
		try {
			preparedStatement = conn.prepareStatement("SELECT * FROM RAZA WHERE id=?");
			preparedStatement.setInt(1, id);
			ResultSet resultSet = preparedStatement.executeQuery();
			resultSet.next();
			race = new Race();
			race.setId(resultSet.getInt("id"));
			race.setSpecie(resultSet.getString("especie"));

		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		} finally {
			manager.close(preparedStatement);
			manager.close(conn);
		}
		return race;
	}

	@Override
	public void update(Race race) {
		Connection conn = manager.open(jdbcUrl);
		PreparedStatement preparedStatement = null;
		try {
			preparedStatement = conn.prepareStatement("UPDATE RAZA SET especie=? WHERE id=?");
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

	@Override
	public void delete(Integer idRace) {
		Connection conn = manager.open(jdbcUrl);
		PreparedStatement preparedStatement = null;
		try {
			preparedStatement = conn.prepareStatement("DELETE FROM RAZA WHERE id=?");
			preparedStatement.setInt(1, idRace);
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
