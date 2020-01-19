package es.salesianos.model;

public class Character {

	private Integer id;
	private String name;
	private String carrier;
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

	public void setCodRace(String codRace) {
		try {
			this.codRace = Integer.parseInt(codRace);
		}catch (NumberFormatException e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}
	}
}
