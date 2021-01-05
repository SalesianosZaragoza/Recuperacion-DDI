package es.salesianos.model;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Libro {
	
	private Integer id;
	private String isbn;
	private Date fechaEdicion ;
	private Integer almacenOld;
	private Integer almacenNew;
	private SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

	

	public Date getFechaEdicion() {
		return fechaEdicion;
	}

	public void setFechaEdicion(Date dateOfBirth) {
		this.fechaEdicion = dateOfBirth;
	}

	public void setFechaEdicion(String dateOfBirth) {

		try {
			this.fechaEdicion = sdf.parse(dateOfBirth);
		} catch (ParseException e) {
			this.fechaEdicion = new Date();
		}
	}

	@Override
	public String toString() {
		return "User [name=" + isbn + ", dateOfBirth=" + fechaEdicion + ", sdf=" + sdf + "]";
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getIsbn() {
		return isbn;
	}

	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}

	public Integer getAlmacenOld() {
		return almacenOld;
	}

	public void setAlmacenOld(Integer almacenOld) {
		this.almacenOld = almacenOld;
	}

	public Integer getAlmacenNew() {
		return almacenNew;
	}

	public void setAlmacenNew(Integer almacenNew) {
		this.almacenNew = almacenNew;
	}

	
	

}
