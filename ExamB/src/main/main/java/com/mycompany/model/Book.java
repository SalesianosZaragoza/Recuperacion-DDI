package com.mycompany.model;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Book {
	private Integer id;
	private String ISBN;
	private Date dateEdition;
	private SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
	private Integer newWarehouse;
	private Integer oldWarehouse;
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getISBN() {
		return ISBN;
	}
	public void setISBN(String ISBN) {
		this.ISBN = ISBN;
	}
	public Date DateEdition() {
		if ((getDateEdition().getYear()+1900) < 2000) {
			setOldWarehouse(oldWarehouse);
			setNewWarehouse(new Integer(-1));
			} else {
			setOldWarehouse(new Integer(-1));
			setNewWarehouse(newWarehouse);
		}

	public String getShortDate() {
		Date date = getDateEdition();
		String day = (fecha.getDate() >= 10) ? String.format("%s", fecha.getDate()) : String.format("0%s", fecha.getDate());
		String month = ((fecha.getMonth()+1) < 10) ? String.format("0%s", fecha.getMonth()+1) : String.format("%s", date.getMonth()+1);

		String format = String.format("%s-%s-%s", date.getYear()+1900, month, day);
		return format;
	}

	public Date getDateEdition() {
		return dateEdition;
	}

	public void setFechaEdicion(String fechaEdicion) {
		try {
			this.dateEdition = sdf.parse(dateEdition);
		} catch (ParseException e) {
			this.dateEdition = new Date();
		}
	}
	
	public void setNewWarehouse(Integer newWarehouse) {
		this.newWarehouse = newWarehouse;
	}
	public Integer newWarehouse(){
		return newWarehouse;
	}
	public void setOldWarehouse(Integer oldWarehouse) {
		this.oldWarehouse = oldWarehouse;
	}
	public Integer oldWarehouse(){
		return oldWarehouse;
	}
		
	public Book(Integer id, String ISBN, Date dateEdition, Integer newWarehouse, Integer oldWarehouse) {
		this.id = id;
		this.ISBN = ISBN;
		this.dateEdition = dateEdition;
		this.newWarehouse = newWarehouse;
		this.oldWarehouse = oldWarehouse;
	}
	

}
