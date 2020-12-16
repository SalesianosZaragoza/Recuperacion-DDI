package es.salesianos.model;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Libro {
	private Integer id;
	private String isbn;
	private Date fechaEdicion;
	private SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
	private Integer almacen_old;
	private Integer almacen_new;

	Almacen almacen;

	public Libro() {}
	
	public Libro(String isbn, String fechaEdicion, Integer almacen_old, Integer almacen_new) {
		setIsbn(isbn);
		setFechaEdicion(fechaEdicion);
		if ((getFechaEdicion().getYear()+1900) < 2000) {
			setAlmacen_old(almacen_old);
			setAlmacen_new(new Integer(-1));
		} else {
			setAlmacen_old(new Integer(-1));
			setAlmacen_new(almacen_new);
		}

	}
	
	public Libro(Integer id, String isbn, String fechaEdicion, Integer almacen_old, Integer almacen_new) {
		this(isbn, fechaEdicion, almacen_old, almacen_new);
		setId(id);
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

	public String getShortDate() {
		Date fecha = getFechaEdicion();
		String day = (fecha.getDate() >= 10) ? String.format("%s", fecha.getDate()) : String.format("0%s", fecha.getDate());
		String month = ((fecha.getMonth()+1) < 10) ? String.format("0%s", fecha.getMonth()+1) : String.format("%s", fecha.getMonth()+1);
	
		String format = String.format("%s-%s-%s", fecha.getYear()+1900, month, day);
		return format;
	}
	
	public Date getFechaEdicion() {
		return fechaEdicion;
	}

	public void setFechaEdicion(String fechaEdicion) {
		try {
			this.fechaEdicion = sdf.parse(fechaEdicion);
		} catch (ParseException e) {
			this.fechaEdicion = new Date();
		}
	}

	public Integer getAlmacen_old() {
		return almacen_old;
	}

	public void setAlmacen_old(Integer almacen_old) {
		this.almacen_old = almacen_old;
	}

	public Integer getAlmacen_new() {
		return almacen_new;
	}

	public void setAlmacen_new(Integer almacen_new) {
		this.almacen_new = almacen_new;
	}
	
	public Almacen getAlmacen() {
		return almacen;
	}
	
	public void setAlmacen(Almacen almacen) {
		this.almacen = almacen;
	}
}
