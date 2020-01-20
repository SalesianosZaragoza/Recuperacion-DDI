package es.salesianos.model;

import es.salesianos.repository.RaceRepository;

public class Character {

	private Integer id;
	private String name;
	private String bearer;
	private Integer codRace;
	private String species;	
	

	public String getBearer() {
		return bearer;
	}

	public void setBearer(String bearer) {
		this.bearer = bearer;
	}

	public String getSpecies() {
		return species;
	}
//	public String getSpecies() {
//		RaceRepository er = new RaceRepository();
//		species = er.showSpecies(this.getCodRace());
//		return species;
//	}

	public void setEspecie(String species) {
		this.species = species;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String nombre) {//NO CAMBIO NADA
		this.name = nombre;
	}

	public Integer getCodRace() {
		return codRace;
	}

	public void setCodRace(Integer codRace) {
		this.codRace = codRace;
	}
}