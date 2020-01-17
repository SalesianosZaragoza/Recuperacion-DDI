package es.salesianos.model;

public class LordOfTheRingsCharacter {

	private Integer id;
	String characterName;
	String ringBearer;
	private Integer codRace;

	public String getCharacterName() {
		return characterName;
	}

	public void setCharacterName(String nombre) {
		this.characterName = nombre;
	}

	public String getRingBearer() {
		return ringBearer;
	}

	public void setRingBearer(String bearer) {
		this.ringBearer = bearer;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getCodRace() {
		return codRace;
	}

	public void setCodRace(Integer codRace) {
		this.codRace = codRace;
	}


}
