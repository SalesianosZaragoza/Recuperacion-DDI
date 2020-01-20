package es.salesianos.repository;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


import es.salesianos.model.Race;
import es.salesianos.repository.Repository;

public class RaceRepository extends AbstractRepository implements Repository<Race> {
	

	public void insert (Race raceFormulario) {
		Connection conn = manager.open(jdbcUrl);
		PreparedStatement preparedStatement = null;
		try {
			preparedStatement = conn.prepareStatement("INSERT INTO RACE (species)" + "VALUES (?)");
			preparedStatement.setString(1, raceFormulario.getSpecies());
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
		ArrayList<Race> races = new ArrayList<Race>();
		try {
			preparedStatement = conn.prepareStatement("SELECT c.name as nb,  r.species as ne* "
							+ "FROM Character p JOIN Race r ON p.codRace = r.id");
			ResultSet resultSet = preparedStatement.executeQuery();
			while (resultSet.next()) {
				Race race = new Race();
				race.setSpecies(resultSet.getString("ne"));
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
	public Race findBy(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public void update(Race user) {
		// TODO Auto-generated method stub

	}

	/*public String showSpecies(Integer codRace) {
		
		Race race = new Race();
		race.setSpecies(req.getParameter("race"));
		Connection conn;
		try {
			Class.forName("org.h2.Driver");
			conn = DriverManager.getConnection(jdbcUrl, "sa", "");
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}
		PreparedStatement preparedStatement = null;
		try {
			preparedStatement = conn.prepareStatement("INSERT INTO RACE (species)" + "VALUES (?)");
			preparedStatement.setString(1, race.getSpecies());
			
			preparedStatement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		} finally {
			if (null != conn) {
				try {
					conn.close();
				} catch (SQLException e) {
					e.printStackTrace();
					throw new RuntimeException(e);
				}
			}
			if (preparedStatement != null) {
				try {
					preparedStatement.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
		
		redirect(req, resp);
		
		
		/*Connection conn = manager.open(jdbcUrl);
		PreparedStatement preparedStatement = null;
		String race;
		try {
			preparedStatement = conn.prepareStatement("SELECT * FROM RACE  WHERE id=?");
			preparedStatement.setInt(1, codRace);
			ResultSet resultSet = preparedStatement.executeQuery();
			resultSet.next();
			race = resultSet.getString("species");

		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		} finally {
			manager.close(preparedStatement);
			manager.close(conn);
		}*/
		
		//return race;
	//}
}