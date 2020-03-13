package forum.business;

import java.io.Serializable;

public class LineItem implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private Book book;
	private int quantity;
	
	public LineItem() {}

	
	public LineItem(Book book, int quantity) {
		this.book = book;
		this.quantity = quantity;
	}


	public Book getBook() {
		return book;
	}
	
	public void setBook(Book book) {
		this.book = book;
	}
	
	public int getQuantity() {
		return quantity;
	}
	
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	
	public double getTotal() {
		double total = this.book.getPrice() * this.quantity;
		return total;
	}
	
	
	
}
