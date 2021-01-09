package model;

import java.util.Date;

public class Book {
	private Integer id;
	private String name;
	private Date dateEdition;
	private boolean oldWarehouse;
	private boolean newWarehouse;
	
	
	public boolean getOldWarehouse() {
		return oldWarehouse;
	}

	public void setOldWarehouse(boolean oldWarehouse) {
		this.oldWarehouse = oldWarehouse;
	}

	public boolean getNewWarehouse() {
		return newWarehouse;
	}

	public void setNewWarehouse(boolean newWarehouse) {
		this.newWarehouse = newWarehouse;
	}

	public Date getDateEdition() {
		return dateEdition;
	}

	public void setDateEdition(Date dateEdition) {
		this.dateEdition = dateEdition;
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

	public void setName(String name) {
		this.name = name;
	}

}
