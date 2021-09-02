package rachitsinha.lmsdemo.models;

public class UserBookRequest {
	private String isbn;
	private Long userId;
	private Long bookId;
	
	public UserBookRequest() {}

	public UserBookRequest(String isbn, Long userId) {
		this.isbn = isbn;
		this.userId = userId;
	}
	
	public UserBookRequest(String isbn, Long userId, Long bookId) {
		this.isbn = isbn;
		this.userId = userId;
		this.bookId = bookId;
	}

	public String getIsbn() {
		return isbn;
	}

	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}
	
	public Long getBookId() {
		return bookId;
	}

	public void setBookId(Long bookId) {
		this.bookId = bookId;
	}
}
