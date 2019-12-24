package es.salesianos.model;

import java.text.ParseException;

public class Character {

	private Integer id;
	String name;
	String carrier;
	private Integer codRace;



	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCarrier() {
		return carrier;
	}

	public void setCarrier(String carrier) {
		this.carrier = carrier;
	}

	public Integer getCodRace() {
		return codRace;
	}

	public void setCodRace(String codRace) throws ParseException {
		this.codRace = Integer.parseInt(codRace);
	}

}
