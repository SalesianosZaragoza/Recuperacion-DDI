package es.salesianos.repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import es.salesianos.model.Character;

public class CharacterRepository extends AbstractRepository implements Repository<Character> {

	public void insert(Character character) {
		Connection conn = manager.open(jdbcUrl);
		PreparedStatement preparedStatement = null;
		try {
			preparedStatement = conn
				.prepareStatement("INSERT INTO PERSONAJE (nombre, portador, codRaza)" + "VALUES (?, ?, ?)");
			preparedStatement.setString(1, character.getName());
			preparedStatement.setBoolean(2, character.isHolder());
			preparedStatement.setLong(3, character.getCodRace());
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
			preparedStatement = conn.prepareStatement("SELECT * FROM PERSONAJE");
			ResultSet resultSet = preparedStatement.executeQuery();
			while (resultSet.next()) {
				Character character = new Character();
				character.setId(resultSet.getInt("id"));
				character.setName(resultSet.getString("nombre"));
				character.setHolder(Boolean.parseBoolean(resultSet.getString("portador")));
				character.setCodRace(resultSet.getLong("codRaza"));

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

	public Character findById(Integer id) {
		Connection conn = manager.open(jdbcUrl);
		PreparedStatement preparedStatement = null;
		Character character;
		try {
			preparedStatement = conn.prepareStatement("SELECT * FROM PERSONAJE WHERE id=?");
			preparedStatement.setInt(1, id);
			ResultSet resultSet = preparedStatement.executeQuery();
			resultSet.next();
			character = new Character();
			character.setId(resultSet.getInt("id"));
			character.setName(resultSet.getString("nombre"));
			character.setHolder(resultSet.getBoolean("portador"));
			character.setCodRace(resultSet.getLong("codRaza"));

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
			preparedStatement = conn
				.prepareStatement("UPDATE PERSONAJE  SET nombre=? , portador=?, codRaza=? WHERE id=?");
			preparedStatement.setString(1, character.getName());
			preparedStatement.setBoolean(2, character.isHolder());
			preparedStatement.setLong(3, character.getCodRace());
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
}
