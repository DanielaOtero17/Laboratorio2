package Model;

import java.util.ArrayList;

public class Bookstore<T> {
	
	private ArrayList<Book> list;
	private Queue<employee> employees;
	private ArrayList<ATM> atms;
	private ArrayList<Shelving<String,Integer>> shelves;
	
	public Bookstore() {
		
		list = new ArrayList<>();
		employees = new Queue<>();
		atms = new ArrayList<>();
		shelves = new ArrayList<>();
	}
		
	public ArrayList<Shelving<String,Integer>> getShelves() {
		return shelves;
	}
	public void setShelves(ArrayList<Shelving<String,Integer>> shelves) {
		this.shelves = shelves;
	}

	public void addATM(ATM adding){
		
		atms.add(adding);
	}
	public void createEmployee(employee e){
		
		employees.enqueue(e);
		
	}
		
	public Queue<employee> getEmployees() {
		return employees;
	}

	public void setEmployees(Queue<employee> employees) {
		this.employees = employees;
	}

	public ArrayList<ATM> getAtms() {
		return atms;
	}

	public void setAtms(ArrayList<ATM> atms) {
		this.atms = atms;
	}

	public String search(){
		
		return null;
		}
	
	public void addShelves(String key, int value){
		
		Shelving<String, Integer> s = new Shelving<String, Integer>(key,value);
		shelves.add(s);
		
		
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
