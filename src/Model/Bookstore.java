package Model;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
public class Bookstore {
	
	private ArrayList<Book> list;
	private Queue<Customer> payList;
	private ArrayList<ATM> atms;
	private ArrayList<Shelving<String,Integer>> shelves;
	private ArrayList<Customer> employees;
	private int booksout;
	
	public Bookstore() {
		
		list = new ArrayList<>();
		employees = new ArrayList<>();
		payList = new Queue<>();
		atms = new ArrayList<>();
		shelves = new ArrayList<Shelving<String,Integer>>();
		booksout = 0;
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
	
	public void setBooksout(int x) {
		
		booksout = x;
	}
	public int getBooksout() {
		return booksout;
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
		
		String data = "";
		organizeListPay();
		int size = payList.size();
		
		ArrayList<Customer> aux = new ArrayList<>();
		ATM[] array = new ATM[atms.size()];
		boolean[] isAdded = new boolean[payList.size()];
		int counter = 0;
		ATM[] auxArray = new ATM[array.length];
		boolean ok=false;
		
		for(int i=0; i<employees.size();i++){
			booksout += employees.get(i).getTotalBooks();
		}
		for(int i=0; i< size;i++){
			
			aux.add(payList.Dequeue());
		}
		
		
		while(payList.size()>0){
			
			ATM atm = isNotBusy();
			int i = isTheSame(atm);
			
			if (atm == null) {
				
				while(!ok){
				
				for(int m=0; m<atms.size();m++){
					
					if(atms.get(m).getTime()==0){
						
						ok = true;
					}
				}
				}

			} else {
				atms.get(i).addBooksPay(payList.Dequeue());

			}
		}

			for(int m=0; m<atms.size();m++){
				array[m] = atms.get(m);
			}
			
			Arrays.sort(array);
			
			System.out.println(payList.size());
			
				return data;
	}
	
	public boolean exist(boolean[] bool){
		
		for(int i=0; i<bool.length;i++){
			
			if(bool[i]==false){
				
				return true;
			}
		}
		return false;
	}
	
//	public void addCustomerATM() {
//		
//		organizeListPay();
//		
//		for(int i=0; i< atms.size(); i++) {
//			
//			ATM aux = this.isNotBusy();
//			int a = isTheSame(aux);
//			
//			if(aux!=null) {
//				
//				atms.get(a).addBooksPay(payList.Dequeue());				
//			}
//		}
//	}
//	
	public int isTheSame(ATM atm) {
		
		for(int i=0; i<atms.size();i++) {
			
			if(atms.get(i)==atm) {
				
				return i;
			}
		}
		return 0;
	}
	
	public ATM isNotBusy() {
		
		for(int i=0; i<atms.size();i++) {
			
			if(!atms.get(i).isBusy()) {
				
				return atms.get(i);
			}
		}
		return null;
		
	}
	
	public void addATM(ATM adding){
		
		atms.add(adding);
	}
	public void createCustomer(Customer e){
		
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
	
	public void addShelves(Shelving<String, Integer> shelve){
		
		shelves.add(shelve);		
	}
	
	public int getTotalBooks(){
		
		int sum = 0;
		for(int i=0;i<list.size();i++){
			 
			sum += list.get(i).getQuantity();
		}
		return sum;
	}	
	public void createNewBook(int code,int examples, String shelve,int price) throws IOException {
		
		Book new_book = new Book(code,examples,shelve,price);
		list.add(new_book);
	shelves.get(positionShelve(shelve)).addBook(new_book.getCode(), new_book.getQuantity(),new_book.getPrice());		
	}
	
	public int getTamanioListBooks(){
		
		System.out.println("El tamanio de la lista es " + list.size());
		return list.size();
	}
	
	public int positionShelve(String name) throws IOException{
		
		int i= 0;
		while(i<shelves.size()){
			
			if(shelves.get(i).getKey().equalsIgnoreCase(name)){
				return i;
			}
			i++;
		}
		return 0;
		
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
	
	public boolean existBook(int cod){
		
		
		for(int a = 0; a < list.size(); a++){
			
			if(list.get(a).getCode() == cod && list.get(a).getQuantity() > 0)
				return true;
		}
		return false;
	}
	
	public void restQuantity(Book b){
		
		b.setQuantity(b.getQuantity()-1);
		
	}
	
	//permite obtener un libro a partir de su codigo.
	public Book obtain(int code){
		
		for(int i=0; i<list.size();i++){
			
			if(list.get(i).getCode() == code){
				
				restQuantity(list.get(i));
				return list.get(i);
			}
		}
		return null;
		
	}

	public ArrayList<Book> getList() {
		return list;
	}

	public void setList(ArrayList<Book> list) {
		this.list = list;
	}
	

}
