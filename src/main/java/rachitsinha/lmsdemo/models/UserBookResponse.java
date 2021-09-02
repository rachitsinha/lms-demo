package rachitsinha.lmsdemo.models;

public class UserBookResponse {
	private UserBook userBook;
	private String message;
	
	public UserBookResponse() {
		// TODO Auto-generated constructor stub
	}

	public UserBookResponse(UserBook userBook, String message) {
		super();
		this.userBook = userBook;
		this.message = message;
	}

	public UserBook getUserBook() {
		return userBook;
	}

	public void setUserBook(UserBook userBook) {
		this.userBook = userBook;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
	
	
}
