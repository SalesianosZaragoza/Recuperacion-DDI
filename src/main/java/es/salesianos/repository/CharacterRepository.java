package es.salesianos.repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import es.salesianos.model.LordOfTheRingsCharacter;

public class CharacterRepository extends AbstractRepository implements Repository<LordOfTheRingsCharacter> {



	public void insert(LordOfTheRingsCharacter characterForm) {
		Connection conn = manager.open(jdbcUrl);
		PreparedStatement preparedStatement = null;
		try {
			preparedStatement = conn
					.prepareStatement("INSERT INTO personaje (nombre,portador,codRaza)" + "VALUES (?, ?, ?)");
			preparedStatement.setString(1, characterForm.getCharacterName());
			preparedStatement.setString(2, characterForm.getRingBearer());
			preparedStatement.setInt(3, characterForm.getCodRace());
			preparedStatement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		} finally {
			manager.close(preparedStatement);
			manager.close(conn);
		}

	}

	public List<LordOfTheRingsCharacter> listAll() {
		Connection conn = manager.open(jdbcUrl);
		PreparedStatement preparedStatement = null;
		ArrayList<LordOfTheRingsCharacter> characters = new ArrayList<LordOfTheRingsCharacter>();
		try {
			preparedStatement = conn.prepareStatement("SELECT * FROM personaje");
			ResultSet resultSet = preparedStatement.executeQuery();
			while (resultSet.next()) {
				LordOfTheRingsCharacter character = new LordOfTheRingsCharacter();
				character.setId(resultSet.getInt("id"));
				character.setCharacterName(resultSet.getString("nombre"));
				character.setRingBearer(resultSet.getString("portador"));
				character.setCodRace(resultSet.getInt("codRaza"));
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

	public LordOfTheRingsCharacter listByUser(Integer idCharacter) {
		Connection conn = manager.open(jdbcUrl);
		PreparedStatement preparedStatement = null;
		LordOfTheRingsCharacter character;
		try {
			preparedStatement = conn.prepareStatement("SELECT * FROM personaje WHERE id=?");
			preparedStatement.setInt(1, idCharacter);
			ResultSet resultSet = preparedStatement.executeQuery();
			resultSet.next();
			character = new LordOfTheRingsCharacter();
			character.setId(resultSet.getInt("id"));
			character.setCharacterName(resultSet.getString("nombre"));
			character.setRingBearer(resultSet.getString("portador"));
			character.setCodRace(resultSet.getInt("codRaza"));

		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		} finally {
			manager.close(preparedStatement);
			manager.close(conn);
		}
		return character;
	}

	public void update(LordOfTheRingsCharacter character) {
		Connection conn = manager.open(jdbcUrl);
		PreparedStatement preparedStatement = null;
		try {
			preparedStatement = conn.prepareStatement("UPDATE USER SET nombre=? , portador=?, codRaza=?  WHERE id=?");
			preparedStatement.setString(1, character.getCharacterName());
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
	public LordOfTheRingsCharacter findBy(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}
}
