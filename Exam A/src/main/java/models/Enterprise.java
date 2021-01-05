package models;

import java.util.ArrayList;
import java.util.List;

public class Enterprise {

	private String name;
	private List<Alumn> alumns = new ArrayList<Alumn>();

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<Alumn> getAlumns() {
		return alumns;
	}

	public void setAlumns(List<Alumn> alumns) {
		this.alumns = alumns;
	}

	public void addToListAlumn(Alumn alumn) {
		this.alumns.add(alumn);
	}

}
