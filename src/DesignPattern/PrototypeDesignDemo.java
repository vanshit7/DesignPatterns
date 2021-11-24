package DesignPattern;

import java.util.ArrayList;

class Book {
	private int bookId;
	private String BookName;
	public int getBookId() {
		return bookId;
	}
	public void setBookId(int bookId) {
		this.bookId = bookId;
	}
	public String getBookName() {
		return BookName;
	}
	public void setBookName(String bookName) {
		BookName = bookName;
	}
	@Override
	public String toString() {
		return "Book [bookId=" + bookId + ", BookName=" + BookName + "]";
	}
	
	
}
class BookShop implements Cloneable {
	private String shopName;
	ArrayList<Book> books = new ArrayList<Book>();
	public String getShopName() {
		return shopName;
	}
	public void setShopName(String shopName) {
		this.shopName = shopName;
	}
	public ArrayList<Book> getBooks() {
		return books;
	}
	public void setBooks(ArrayList<Book> books) {
		this.books = books;
	}
	//for simplicity we are just running a loop.
	//but in real time, it would be probably a database connection from which we will fetch data.
	public void LoadData() {
		for(int i=1;i<=10;i++) {
			Book b = new Book();
			b.setBookId(i);
			b.setBookName("Book" + i);
			this.getBooks().add(b);
		}
	}
	@Override
	public String toString() {
		return "BookShop [shopName=" + shopName + ", books=" + books + "]";
	}
//	@Override
//	protected Object clone() throws CloneNotSupportedException {
//		return super.clone();  //shallow copy , multiple references to the same object
//	}
	
	@Override     //Deep copy, we are implementing the cloning method ourselves.
	protected BookShop clone() throws CloneNotSupportedException {
		BookShop sh = new BookShop();
		sh.setShopName(this.shopName);
		for(Book b : this.getBooks())
		{
			sh.getBooks().add(b);
		}
		return sh;
	}
	
	
}
public class PrototypeDesignDemo  {

	public static void main(String[] args) throws CloneNotSupportedException {
		
		BookShop bs = new BookShop();
		bs.setShopName("Ashoka Book Depot");
		bs.LoadData();
		System.out.println(bs);
		
		BookShop bs1 = bs.clone();
		bs.setShopName("Malik book depot");
		bs.getBooks().remove(2);
		System.out.println(bs);
		System.out.println(bs1);

	}

}
