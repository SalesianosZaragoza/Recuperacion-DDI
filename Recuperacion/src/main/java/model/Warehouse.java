package model;

import java.util.ArrayList;

public class Warehouse {
	private Integer id;
	private String name;
	private boolean oldWarehouse;
	private boolean newWarehouse;

	
	public boolean isOldWarehouse() {
		return oldWarehouse;
	}

	public void setOldWarehouse(boolean oldWarehouse) {
		this.oldWarehouse = oldWarehouse;
	}

	public boolean isNewWarehouse() {
		return newWarehouse;
	}

	public void setNewWarehouse(boolean newWarehouse) {
		this.newWarehouse = newWarehouse;
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

	public void add(ArrayList<Warehouse> oldWarehouse) {
		
		
	}

	
}
