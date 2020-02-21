package es.salesianos.sql;

public abstract class DbSqlQuery {

	public static final String SELECT_CHARACTERS = "SELECT * FROM PERSONAJE p JOIN RAZA r ON p.codRaza =  r.id";
	public static final String SELECT_RACES = "SELECT * FROM RAZA";
	public static final String SELECT_CHARACTER_BY_ID = "SELECT * FROM PERSONAJE WHERE id=?";
	public static final String SELECT_RACE_BY_ID = "SELECT * FROM RAZA WHERE id=?";

	public static final String INSERT_CHARACTER = "INSERT INTO PERSONAJE (nombre,portador,codRaza) VALUES (?, ?, ?)";
	public static final String INSERT_RACE = "INSERT INTO RAZA (especie) VALUES (?)";

	public static final String UPDATE_CHARACTER = "UPDATE PERSONAJE SET nombre=? , portador=?, codRaza=? WHERE id=?";
	public static final String UPDATE_RACE = "UPDATE RAZA SET especie=? WHERE id=?";
	public static final String UPDATE_CARRIER = "UPDATE PERSONAJE SET portador='false'";

	public static final String DELETE_CHARACTER_BY_ID = "DELETE FROM PERSONAJE WHERE id=?";
	public static final String DELETE_CHARACTER_BY_RACE = "DELETE FROM PERSONAJE WHERE codRaza=?";
	public static final String DELETE_RACE = "DELETE FROM RAZA WHERE id=?";
}