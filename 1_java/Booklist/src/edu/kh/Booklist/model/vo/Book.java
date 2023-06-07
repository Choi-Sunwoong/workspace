package edu.kh.Booklist.model.vo;

import java.util.Objects;

public class Book {
	
	private String bookname;
	private int bookNumber;
	private String author;
	private int price;
	private String publisher;
	
	public Book() {}

	public Book(String bookname, int bookNumber, String author, int price, String publisher) {
		super();
		this.bookname = bookname;
		this.bookNumber = bookNumber;
		this.author = author;
		this.price = price;
		this.publisher = publisher;
	}

	public String getBookname() {
		return bookname;
	}

	public void setBookname(String bookname) {
		this.bookname = bookname;
	}

	public int getBookNumber() {
		return bookNumber;
	}

	public void setBookNumber(int bookNumber) {
		this.bookNumber = bookNumber;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public String getPublisher() {
		return publisher;
	}

	public void setPublisher(String publisher) {
		this.publisher = publisher;
	}
	
	@Override
	public String toString() {
		return  bookname + " " + author + " " + price+"원"
				+ " " + publisher;
	}

	public String favorites() {
		return  bookNumber + " " + bookname + " " + author;
				
	}

	@Override
	public int hashCode() {
		return Objects.hash(author, bookNumber, bookname, price, publisher);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Book other = (Book) obj;
		return Objects.equals(author, other.author) && bookNumber == other.bookNumber
				&& Objects.equals(bookname, other.bookname) && price == other.price
				&& Objects.equals(publisher, other.publisher);
	}

	

}
