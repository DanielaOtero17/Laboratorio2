package Model;

import java.util.ArrayList;

public class Bookstore {
	
	private ArrayList<Book> list;
	private Queue<employee> payList;
	private ArrayList<ATM> atms;
	private ArrayList<Shelving<String,Integer>> shelves;
	private ArrayList<employee> employees;
	
	public Bookstore() {
		
		list = new ArrayList<>();
		employees = new ArrayList<>();
		payList = new Queue<>();
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
		
		employees.add(e);
		
	}
		
	public Queue<employee> getPayList() {
		return payList;
	}

	public void setPayList(Queue<employee> payList) {
		this.payList = payList;
	}

	public ArrayList<employee> getEmployees() {
		return employees;
	}

	public void setEmployees(ArrayList<employee> employees) {
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
	
	public void addShelves(Shelving shelve){
		
		shelves.add(shelve);
		
		
	}
	
	public void createNewBook(int code,int examples, String shelve,int price) {
		
		Book new_book = new Book(code,examples,shelve,price);
		
		shelves.get(positionShelve(shelve)).addBook(code, examples,price);
			
		
	}
	
	public int positionShelve(String name){
		
		int i= 0;
		while(i<shelves.size()){
			
			if(shelves.get(i).getKey().equalsIgnoreCase(name)){
				return i;
			}
			i++;
		}
		Integer integer = (Integer) null;
		return integer;
	}
	public boolean existShelve(String name){
		int i= 0;
		while(i<shelves.size()){
			
			if(shelves.get(i).getKey().equalsIgnoreCase(name)){
				return true;
			}
			i++;
		}
		return false;
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
