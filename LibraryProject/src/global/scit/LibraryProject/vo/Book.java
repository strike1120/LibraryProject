package global.scit.LibraryProject.vo;

public class Book {
	private int numbers; // 책 일련번호
	private String isbn; // isbn 번호
	private String title; // 도서제목
	private String author; // 저자
	private String bookcom;//출판사
	private char rent; // 책 대출 가능 여부
	private int stock; // 재고

	public Book() {}
	
	

	public Book(String isbn, int stock) {
		super();
		this.isbn = isbn;
		this.stock = stock;
	}



	public Book(String isbn, String title, String author, String bookcom, int stock) {
		this.isbn = isbn;
		this.title = title;
		this.author = author;
		this.bookcom = bookcom;
		this.stock = stock;
		//rentYN(); 책 대출 가능 여부
	}

	public int getNumbers() {
		return numbers;
	}

	public String getIsbn() {
		return isbn;
	}
	
	public String getTitle() {
		return title;
	}

	public String getAuthor() {
		return author;
	}

	public String getBookcom() {
		return author;
	}
	public char getRent() {
		return rent;
	}

	public int getStock() {
		return stock;
	}

	public void setNumbers(int numbers) {
		this.numbers = numbers;
	}

	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}
	
	public void setTitle(String title) {
		this.title = title;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public void setBookcom(String bookcom) {
		this.bookcom = bookcom;
	}
	
	public void setRent(char rent) {
		this.rent = rent;
	}

	public void setStock(int stock) {
		this.stock = stock;
	}

	@Override
	public String toString() {
		return "Book [numbers=" + numbers + ", isbn=" + isbn + ", title=" + title + ", author=" + author + ", bookcom="
				+ bookcom + ", rent=" + rent + ", stock=" + stock + "]";
	}
}