package model;

import java.util.Date;

public class Book {
	private String isbn;
	private Date editionDate;
	private Integer oldStorehouse;
	private Integer newStorehouse;

	public String getIsbn() {
		return isbn;
	}

	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}

	public Date getEditionDate() {
		return editionDate;
	}

	public void setEditionDate(Date editionDate) {
		this.editionDate = editionDate;
	}

	public Integer getOldStorehouse() {
		return oldStorehouse;
	}

	public void setOldStorehouse(Integer oldStorehouse) {
		this.oldStorehouse = oldStorehouse;
	}

	public Integer getNewStorehouse() {
		return newStorehouse;
	}

	public void setNewStorehouse(Integer newStorehouse) {
		this.newStorehouse = newStorehouse;
	}

}
