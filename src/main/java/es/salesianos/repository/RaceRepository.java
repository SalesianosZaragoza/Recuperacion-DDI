package es.salesianos.repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import es.salesianos.model.Race;

@Component
public class RaceRepository extends AbstractRepository implements Repository<Race> {



	public void insert(Race raceForm) {
		Connection conn = manager.open(jdbcUrl);
		PreparedStatement preparedStatement = null;
		try {
			preparedStatement = conn
					.prepareStatement("INSERT INTO raza (especie)" + "VALUES (?)");
			preparedStatement.setString(1, raceForm.getSpecie());
			preparedStatement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		} finally {
			manager.close(preparedStatement);
			manager.close(conn);
		}

	}

	public List<Race> listAll() {
		Connection conn = manager.open(jdbcUrl);
		PreparedStatement preparedStatement = null;
		ArrayList<Race> species = new ArrayList<Race>();
		try {
			preparedStatement = conn.prepareStatement("SELECT * FROM raza");
			ResultSet resultSet = preparedStatement.executeQuery();
			while (resultSet.next()) {
				Race specie = new Race();
				specie.setId(resultSet.getInt("id"));
				specie.setSpecie(resultSet.getString("especie"));
				species.add(specie);
			}

		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		} finally {
			manager.close(preparedStatement);
			manager.close(conn);
		}
		return species;

	}

	public Race listByUser(Integer idRace) {
		Connection conn = manager.open(jdbcUrl);
		PreparedStatement preparedStatement = null;
		Race specie;
		try {
			preparedStatement = conn.prepareStatement("SELECT * FROM USER WHERE id=?");
			preparedStatement.setInt(1, idRace);
			ResultSet resultSet = preparedStatement.executeQuery();
			resultSet.next();
			specie = new Race();
			specie.setId(resultSet.getInt("id"));
			specie.setSpecie(resultSet.getString("especie"));

		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		} finally {
			manager.close(preparedStatement);
			manager.close(conn);
		}
		return specie;
	}

	public void update(Race specie) {
		Connection conn = manager.open(jdbcUrl);
		PreparedStatement preparedStatement = null;
		try {
			preparedStatement = conn.prepareStatement("UPDATE raza SET especie=?  WHERE id=?");
			preparedStatement.setString(1, specie.getSpecie());
			preparedStatement.setInt(2, specie.getId());
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
	public Race findBy(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}

}
