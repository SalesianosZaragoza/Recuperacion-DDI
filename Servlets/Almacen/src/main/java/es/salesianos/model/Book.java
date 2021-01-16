package es.salesianos.model;

import java.time.LocalDate;


public class Book {
	
	private Integer id;
	private String isbn;
	private LocalDate dateEdition ;
	private Integer warehouseOld;
	private Integer warehouseNew;

	

	public LocalDate getDateEdition() {
		return dateEdition;
	}

	public void setDateEdition(LocalDate dateEdition) {
		this.dateEdition = dateEdition;
	}

	public void setDateEdition(String dateEdition) {
		this.dateEdition = LocalDate.parse(dateEdition);
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

	public Integer getWarehouseOld() {
		return warehouseOld;
	}

	public void setWarehouseOld(Integer warehouseOld) {
		this.warehouseOld = warehouseOld;
	}

	public Integer getWarehouseNew() {
		return warehouseNew;
	}

	public void setWarehouseNew(Integer warehouseNew) {
		this.warehouseNew = warehouseNew;
	}

	
	

}
