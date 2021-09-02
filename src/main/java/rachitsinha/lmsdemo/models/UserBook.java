package rachitsinha.lmsdemo.models;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class UserBook {
	@Id @GeneratedValue
	private Long id;
	private Long bookId;
	private Long userId;
	private LocalDate borrowDate;
	private LocalDate returnDate;
	
	public UserBook() {
		// TODO Auto-generated constructor stub
	}

	public UserBook(Long bookId, Long userId, LocalDate borrowDate, LocalDate returnDate) {
		this.bookId = bookId;
		this.userId = userId;
		this.borrowDate = borrowDate;
		this.returnDate = returnDate;
	}

	public Long getBookId() {
		return bookId;
	}

	public void setBookId(Long bookId) {
		this.bookId = bookId;
	}

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	public LocalDate getBorrowDate() {
		return borrowDate;
	}

	public void setBorrowDate(LocalDate borrowDate) {
		this.borrowDate = borrowDate;
	}

	public LocalDate getReturnDate() {
		return returnDate;
	}

	public void setReturnDate(LocalDate returnDate) {
		this.returnDate = returnDate;
	}

	public Long getId() {
		return id;
	}
	
	
	
}
