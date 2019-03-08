package Model;

import java.util.ArrayList;

public class Bookstore<T> {
	
	private ArrayList<Book> list;
	
	public Bookstore() {
		
		list = new ArrayList<>();
		
	}
	
	public void createNewBook(T key,T value, int quantity) {
		
		Book new_book = new Book(key,value,quantity);
	}
	
	public void addBook(Book book) {
		
		list.add(book);
	}

	public ArrayList<Book> getList() {
		return list;
	}

	public void setList(ArrayList<Book> list) {
		this.list = list;
	}
	

}
