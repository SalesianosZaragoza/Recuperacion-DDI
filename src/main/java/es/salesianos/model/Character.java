package es.salesianos.model;

import java.text.ParseException;

public class Character {

	private Integer id;
	private String name;
	private String ringPerson;
	private Integer codRace;
	private String raceName;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}
	
	public String getRingPerson() {
		return ringPerson;
	}

	public void setRingPerson(String ringPerson) {
		this.ringPerson = ringPerson;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}


	public Integer getCodRace() {
		return codRace;
	}

	public void setCodRace(String codRace) throws ParseException {
		this.codRace = Integer.parseInt(codRace);
	}

	public String getRaceName() {
		return raceName;
	}

	public void setRaceName(String raceName) {
		this.raceName = raceName;
	}

}