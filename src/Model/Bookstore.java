package Model;

import java.util.ArrayList;

public class Bookstore<T> {
	
	private ArrayList<Book> list;
	private Queue<employee> employees;
	
	public Bookstore() {
		
		list = new ArrayList<>();
		employees = new Queue<>();
		
	}
	
	public void createEmployee(employee e){
		
		employees.enqueue(e);
		
	}
	public String search(){
		
		return null;
		}
	
	public void createNewBook(String key,int value, String shelves) {
		
		Book new_book = new Book(key,value,shelves);
		
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
