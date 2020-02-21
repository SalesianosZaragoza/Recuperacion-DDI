package es.salesianos.model;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
@Qualifier("Character")
public class Character {

	private Integer id;
	private String name;
	private String ringBearer;
	private Integer codRace;
	private String raceName;
	

	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	public Integer getId() {
		return id;
	}
	
	public void setId(Integer id) {
		this.id = id;
	}
	
	public String getRingBearer() {
		return ringBearer;
	}
	
	public void setRingBearer(String ringBearer) {
		this.ringBearer = ringBearer;
	}
	
	public Integer getCodRace() {
		return codRace;
	}
	
	public void setCodRace(Integer codRace) {
		this.codRace = codRace;
	}
	public String getRaceName() {
		return raceName;
	}
	public void setRaceName(String raceName) {
		this.raceName = raceName;
	}
	
	
	
	
}
