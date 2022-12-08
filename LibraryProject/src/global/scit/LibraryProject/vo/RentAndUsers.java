package global.scit.LibraryProject.vo;

public class RentAndUsers {
	private int USER_NUMBER;
	private String USER_RENTED_BOOK;
	private int USER_RENTED_BOOK_QUANTITY;
	private int BOOK_NUMBER;
	private String RENT_DATE;
	private String RENT_RETURN_DATE;
	
	
	
	
	public RentAndUsers() {
		super();
	}

	

	public RentAndUsers(int uSER_NUMBER, int bOOK_NUMBER) {
		super();
		this.USER_NUMBER = uSER_NUMBER;
		this.BOOK_NUMBER = bOOK_NUMBER;
	}



	public RentAndUsers(String uSER_RENTED_BOOK, int uSER_RENTED_BOOK_QUANTITY) {
		super();
		USER_RENTED_BOOK = uSER_RENTED_BOOK;
		USER_RENTED_BOOK_QUANTITY = uSER_RENTED_BOOK_QUANTITY;
	}



	public RentAndUsers(String uSER_RENTED_BOOK, int uSER_RENTED_BOOK_QUANTITY, int bOOK_NUMBER)
	{
		super();
		USER_RENTED_BOOK = uSER_RENTED_BOOK;
		USER_RENTED_BOOK_QUANTITY = uSER_RENTED_BOOK_QUANTITY;
		BOOK_NUMBER = bOOK_NUMBER;
		
	}


	public int getUSER_NUMBER() {
		return USER_NUMBER;
	}


	public String getUSER_RENTED_BOOK() {
		return USER_RENTED_BOOK;
	}


	public int getUSER_RENTED_BOOK_QUANTITY() {
		return USER_RENTED_BOOK_QUANTITY;
	}


	public int getBOOK_NUMBER() {
		return BOOK_NUMBER;
	}


	public String getRENT_DATE() {
		return RENT_DATE;
	}


	public String getRENT_RETURN_DATE() {
		return RENT_RETURN_DATE;
	}


	public void setUSER_NUMBER(int uSER_NUMBER) {
		USER_NUMBER = uSER_NUMBER;
	}


	public void setUSER_RENTED_BOOK(String uSER_RENTED_BOOK) {
		USER_RENTED_BOOK = uSER_RENTED_BOOK;
	}


	public void setUSER_RENTED_BOOK_QUANTITY(int uSER_RENTED_BOOK_QUANTITY) {
		USER_RENTED_BOOK_QUANTITY = uSER_RENTED_BOOK_QUANTITY;
	}


	public void setBOOK_NUMBER(int bOOK_NUMBER) {
		BOOK_NUMBER = bOOK_NUMBER;
	}


	public void setRENT_DATE(String rENT_DATE) {
		RENT_DATE = rENT_DATE;
	}


	public void setRENT_RETURN_DATE(String rENT_RETURN_DATE) {
		RENT_RETURN_DATE = rENT_RETURN_DATE;
	}


	@Override
	public String toString() {
		return "RentAndUsers [USER_NUMBER=" + USER_NUMBER + ", USER_RENTED_BOOK=" + USER_RENTED_BOOK
				+ ", USER_RENTED_BOOK_QUANTITY=" + USER_RENTED_BOOK_QUANTITY + ", BOOK_NUMBER=" + BOOK_NUMBER
				+ ", RENT_DATE=" + RENT_DATE + ", RENT_RETURN_DATE=" + RENT_RETURN_DATE + "]";
	}
	
	
	
	
}




