package rachitsinha.lmsdemo.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Inventory {
	@Id @GeneratedValue
	private Long id;
	private String isbn;
	private Long bookId;
	
	public Inventory() {
		// TODO Auto-generated constructor stub
	}

	public Inventory(String isbn, Long bookId) {
		this.isbn = isbn;
		this.bookId = bookId;
	}

	public String getIsbn() {
		return isbn;
	}

	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}

	public Long getBookId() {
		return bookId;
	}

	public void setBookId(Long bookId) {
		this.bookId = bookId;
	}

	public Long getId() {
		return id;
	}
	
	
	
}
