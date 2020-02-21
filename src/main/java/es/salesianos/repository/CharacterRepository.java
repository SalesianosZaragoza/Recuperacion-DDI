package es.salesianos.repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import es.salesianos.connection.AbstractConnection;
import es.salesianos.connection.H2Connection;
import es.salesianos.model.Character;
import es.salesianos.sql.DbSqlQuery;

@org.springframework.stereotype.Repository("characterRepository")
public class CharacterRepository implements Repository<Character> {
	private AbstractConnection manager = new H2Connection();

	@Override
	public void insert(Character character) {
		Connection conn = manager.open(Repository.jdbcUrl);
		PreparedStatement preparedStatement = null;
		try {
			preparedStatement = conn.prepareStatement(DbSqlQuery.INSERT_CHARACTER);
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

	@Override
	public List<Character> listAll() {
		Connection conn = manager.open(Repository.jdbcUrl);
		PreparedStatement preparedStatement = null;
		ArrayList<Character> characters = new ArrayList<Character>();
		try {
			preparedStatement = conn.prepareStatement(DbSqlQuery.SELECT_CHARACTERS);
			ResultSet resultSet = preparedStatement.executeQuery();
			while (resultSet.next()) {
				Character character = new Character();
				character.setId(resultSet.getInt("id"));
				character.setName(resultSet.getString("nombre"));
				character.setHolder(Boolean.parseBoolean(resultSet.getString("portador")));
				character.setCodRace(resultSet.getLong("codRaza"));
				character.setRaceName(resultSet.getString("especie"));

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

	@Override
	public Character findById(Integer id) {
		Connection conn = manager.open(Repository.jdbcUrl);
		PreparedStatement preparedStatement = null;
		Character character;
		try {
			preparedStatement = conn.prepareStatement(DbSqlQuery.SELECT_CHARACTER_BY_ID);
			preparedStatement.setInt(1, id);
			ResultSet resultSet = preparedStatement.executeQuery();
			resultSet.next();
			character = new Character();
			character.setId(resultSet.getInt("id"));
			character.setName(resultSet.getString("nombre"));
			character.setHolder(resultSet.getBoolean("portador"));
			character.setCodRace(resultSet.getLong("codRaza"));
			character.setRaceName(resultSet.getString("especie"));

		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		} finally {
			manager.close(preparedStatement);
			manager.close(conn);
		}
		return character;
	}

	@Override
	public void update(Character character) {
		Connection conn = manager.open(Repository.jdbcUrl);
		PreparedStatement preparedStatement = null;
		try {
			preparedStatement = conn.prepareStatement(DbSqlQuery.UPDATE_CHARACTER);
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

	@Override
	public void delete(Integer idCharacter) {
		Connection conn = manager.open(jdbcUrl);
		PreparedStatement preparedStatement = null;
		try {
			preparedStatement = conn.prepareStatement(DbSqlQuery.DELETE_CHARACTER_BY_ID);
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
}
