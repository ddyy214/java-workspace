package com.book.model.vo;


public class Vo {
	private String bookid;
	private String bookname;
	private String publisher;
	private String price;
	
	
	@Override
	public String toString() {
		return "Vo [bookname=" + bookname + ", publisher=" + publisher + "]";
	}

	
	public Vo(String bookid, String bookname, String publisher, String price) {
		super();
		this.bookid = bookid;
		this.bookname = bookname;
		this.publisher = publisher;
		this.price = price;
	}


	public String getBookid() {
		return bookid;
	}

	public void setBookid(String bookid) {
		this.bookid = bookid;
	}

	public String getBookname() {
		return bookname;
	}

	public void setBookname(String bookname) {
		this.bookname = bookname;
	}

	public String getPublisher() {
		return publisher;
	}

	public void setPublisher(String publisher) {
		this.publisher = publisher;
	}

	public String getPrice() {
		return price;
	}

	public void setPrice(String price) {
		this.price = price;
	}

}
