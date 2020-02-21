package es.salesianos.repository;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import es.salesianos.connection.AbstractConnection;
import es.salesianos.connection.H2Connection;
import es.salesianos.model.Character;

public class CharacterRepository extends AbstractRepository implements Repository<Character>{

	protected static final String jdbcUrl = "jdbc:h2:file:./src/main/resources/test;INIT=RUNSCRIPT FROM 'classpath:scripts/create.sql'";
	protected AbstractConnection manager = new H2Connection();

	public void insert(Character character) {
		Connection conn = manager.open(jdbcUrl);
		PreparedStatement preparedStatement = null;
		try {
			preparedStatement = conn
					.prepareStatement("INSERT INTO character (name,ringBearer,codRace)" + "VALUES (?, ?, ?)");
			preparedStatement.setString(1, character.getName());
			preparedStatement.setString(2, character.getRingBearer());
			preparedStatement.setInt(3, character.getCodRace());
			preparedStatement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		} finally {
			manager.close(preparedStatement);
			manager.close(conn);
		}

	}

	public List<Character> listAll() {
		Connection conn = manager.open(jdbcUrl);
		PreparedStatement preparedStatement = null;
		ArrayList<Character> characters = new ArrayList<Character>();
		try {
			preparedStatement = conn.prepareStatement("SELECT c.id as id, c.name as name, c.ringBearer as ringBearer, c.codRace as codRace, r.specie as specie " 
													  + "FROM character c JOIN race r ON c.codRace = r.id");
			ResultSet resultSet = preparedStatement.executeQuery();
			while (resultSet.next()) {
				Character character = new Character();
				character.setId(resultSet.getInt("id"));
				character.setName(resultSet.getString("name"));
				character.setRingBearer(resultSet.getString("ringBearer"));
				character.setCodRace(resultSet.getInt("codRace"));
				characters.add(character);
			}

		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		} finally {
			manager.close(preparedStatement);
			manager.close(conn);
		}
		return characters;

	}

	public Character findBy(Integer id) {
		Connection conn = manager.open(jdbcUrl);
		PreparedStatement preparedStatement = null;
		Character character;
		try {
			preparedStatement = conn.prepareStatement("SELECT * FROM character WHERE id=?");
			preparedStatement.setInt(1, id);
			ResultSet resultSet = preparedStatement.executeQuery();
			resultSet.next();
			character = new Character();
			character.setId(resultSet.getInt("id"));
			character.setName(resultSet.getString("name"));
			character.setRingBearer(resultSet.getString("ringBearer"));
			character.setCodRace(resultSet.getInt("codRace"));
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		} finally {
			manager.close(preparedStatement);
			manager.close(conn);
		}
		return character;
		}

		public void update(Character character) {
			Connection conn = manager.open(jdbcUrl);
			PreparedStatement preparedStatement = null;
			try {
				preparedStatement = conn.prepareStatement("UPDATE character  SET name=? , ringBearer=?,codRace=? WHERE id=?");
				preparedStatement.setString(1, character.getName());
				preparedStatement.setString(2, character.getRingBearer());
				preparedStatement.setInt(3, character.getCodRace());
				preparedStatement.setInt(4, character.getId());
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
		public void delete(HttpServletRequest req){
			String parameter = req.getParameter("id");
			Integer idCharacter = Integer.parseInt(parameter);
			System.out.println(idCharacter);
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
				preparedStatement = conn.prepareStatement("DELETE FROM character WHERE id=?");
				preparedStatement.setInt(1, idCharacter);
				preparedStatement.executeUpdate();
			} catch (SQLException e) {
				e.printStackTrace();
				throw new RuntimeException(e);
			} finally {
				manager.close(preparedStatement);
				manager.close(conn);
			}
		}
		
		public void updateRingBearer() {
			Connection conn = manager.open(jdbcUrl);
			PreparedStatement preparedStatement = null;
			try {
				preparedStatement = conn.prepareStatement("UPDATE character SET ringBearer='NO'");
				preparedStatement.executeUpdate();
			} catch (SQLException e) {
				e.printStackTrace();
				throw new RuntimeException(e);
			}
		}

		
	}