package Model;

import java.util.ArrayList;
import java.util.Arrays;

public class Bookstore {
	
	private ArrayList<Book> list;
	private Queue<Customer> payList;
	private ArrayList<ATM> atms;
	private ArrayList<Shelving<String,Integer>> shelves;
	private ArrayList<Customer> employees;
	private int time;
	
	public Bookstore() {
		
		list = new ArrayList<>();
		employees = new ArrayList<>();
		payList = new Queue<>();
		atms = new ArrayList<>();
		shelves = new ArrayList<>();
		time = 0;
	}
		
	public ArrayList<Shelving<String,Integer>> getShelves() {
		return shelves;
	}
	public void setShelves(ArrayList<Shelving<String,Integer>> shelves) {
		this.shelves = shelves;
	}
	
	public void addClientPay(Customer c){
		payList.enqueue(c);
	}
	
	public String deleteClient(){
		
		Customer custom = payList.Dequeue();
		String deleted = custom.getId() +  " " + custom.getPay() + "\n";
		deleted += custom.payBooks();
				return deleted;
	}
	
	public void organizeListPay(){
		
		Customer[] aux = new Customer[employees.size()];
		
		for(int i=0;i<employees.size();i++){
			
			aux[i]=employees.get(i);
		}
		
		Arrays.sort(aux);
		
		for(int i=0; i<aux.length;i++){
			
			payList.enqueue(aux[i]);
		}		
	}

	public String processPaying(){
		
		String paying = "";
		
		while(payList.size>0){
		for(int i=0;i<atms.size();i++){
			
			if(!atms.get(i).isBusy()){
				
				atms.get(i).addBooksPay(payList.Dequeue());				
			}
			
			
			//completar m�todo de pago.
			
		}
		
		}
		
		return paying;
		
	}
	public void addATM(ATM adding){
		
		atms.add(adding);
	}
	public void createEmployee(Customer e){
		
		e.setTime(employees.size()+1);//incrementa el tiempo del cliente.
		employees.add(e);
		
		}
		
	public Queue<Customer> getPayList() {
		return payList;
	}

	public void setPayList(Queue<Customer> payList) {
		this.payList = payList;
	}

	public ArrayList<Customer> getEmployees() {
		return employees;
	}

	public void setEmployees(ArrayList<Customer> employees) {
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
	
	//permite saber si a�n hay ejemplares de un libro en la biblioteca.
	public boolean existBook(int code){
		
		for(int i=0; i<list.size();i++){
			
			if(list.get(i).getCode() == code && list.get(i).getQuantity()>0){
				
				return true;
			}
		}
		
		return false;
	}
	
	public void restQuantity(Book b){
		
		b.setQuantity(b.getQuantity()-1);
		
	}
	
	//permite obtener un libro a partir de su c�digo.
	public Book obtain(int code){
		
		for(int i=0; i<list.size();i++){
			
			if(list.get(i).getCode() == code){
				
				restQuantity(list.get(i));
				return list.get(i);
			}
		}
		return null;
		
	}
	
	public void addBook(Book book) {
		
		list.add(book);
		
		boolean added = false;
		int i=0;
		while(i<shelves.size() && !added ){
			
			if(shelves.get(i).getKey().equalsIgnoreCase(book.getName())){
				
				shelves.get(i).addBook(book.getCode(), book.getQuantity(), book.getPrice());
				added = true;
			}
			
			i++;
		}
		
	}

	public ArrayList<Book> getList() {
		return list;
	}

	public void setList(ArrayList<Book> list) {
		this.list = list;
	}
	

}
