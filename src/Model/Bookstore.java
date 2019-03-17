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
		
	// Arreglo que almacena los cajeros existentes.
	public ArrayList<Shelving<String,Integer>> getShelves() {
		return shelves;
	}
	
	// metodo set de los cajeros.
	public void setShelves(ArrayList<Shelving<String,Integer>> shelves) {
		this.shelves = shelves;
	}
	
	// set de cantidad de libros que ser�n vendidos.
	public void setBooksout(int x) {
		
		booksout = x;
	}
	
	// retorna la cantidad de libros que ser�n vendidos.
	public int getBooksout() {
		return booksout;
	}

	// Organiza la lista de clientes teniendo en cuenta su tiempo en la librer�a
	// agregando a los clientes en la cola de pago ( PayList)
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
	
	// Este m�todo es el encargado de retornar el listado de datos
	// de los clientes al momento de salir de la librer�a, teniendo en cuenta su orden en la cola
	// de pago y la cantidad de libros que van a comprar.
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
	
	// este m�todo es auxiliar, para verificar si hay algun elemento de un arreglo booleano 
	// con valor false.
	public boolean exist(boolean[] bool){
		
		for(int i=0; i<bool.length;i++){
			
			if(bool[i]==false){
				
				return true;
			}
		}
		return false;
	}
	
	// Este m�todo verifica si un cajero que ingresa por par�metro, es
	// igual a uno de los cajeros pertenecientes a la librer�a.
	public int isTheSame(ATM atm) {
		
		for(int i=0; i<atms.size();i++) {
			
			if(atms.get(i)==atm) {
				
				return i;
			}
		}
		return 0;
	}
	
	// Este m�todo verifica si un cajero de la librer�a se encuentra desocupado, y lo retorna.
	// en caso de no encontrar ning�n cajero que est� disponible, retorna null.
	public ATM isNotBusy() {
		
		for(int i=0; i<atms.size();i++) {
			
			if(!atms.get(i).isBusy()) {
				
				return atms.get(i);
			}
		}
		return null;
		
	}
	
	// Este m�todo agrega un cajero al arreglo de cajeros de la librer�a.
	public void addATM(ATM adding){
		
		atms.add(adding);
	}
	
	// Este m�todo crea un nuevo cliente. Le asigna el tiempo de entrada al cliente dependiendo
	// de el orden en el que haya llegado a la librer�a.
	// Tambi�n agrega el cliente a la lista de clientes de la librer�a.
	public void createCustomer(Customer e){
		
		e.setTime(employees.size()+1);//incrementa el tiempo del cliente.
		employees.add(e);
		
		}
		
	// retorna la cola de pago.
	public Queue<Customer> getPayList() {
		return payList;
	}
	
	// cambia la cola de pago.
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
	
	// Este m�todo agrega una Estanter�a gen�rica a la lista de estanter�as de la librer�a.
	public void addShelves(Shelving<String, Integer> shelve){
		
		shelves.add(shelve);		
	}
	
	// Este m�todo retorna la cantidad total de libros que existen en la librer�a.
	public int getTotalBooks(){
		
		int sum = 0;
		for(int i=0;i<list.size();i++){
			 
			sum += list.get(i).getQuantity();
		}
		return sum;
	}	
	
	// Este M�todo crea un nuevo libro. y lo agraga a la lista de libros de la librer�a
	// Lo ubica en su respectiva estanter�a y pelda�o.
	public void createNewBook(int code,int examples, String shelve,int price) throws IOException {
		
		Book new_book = new Book(code,examples,shelve,price);
		list.add(new_book);
	shelves.get(positionShelve(shelve)).addBook(new_book.getCode(), new_book.getQuantity(),new_book.getPrice());		
	}
	
	
	// Este m�todo retorna el tama�o de la lista de libros. Es un auxiliar de verificaci�n
	// Para saber si el tama�o de la lista de libros es la misma cantidad de libros totales.
	public int getTamanioListBooks(){
		
		System.out.println("El tamanio de la lista es " + list.size());
		return list.size();
	}
	
	// Este m�todo retorna la posici�n de una estanter�a, basado en su c�digo.
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
	
	// este m�todo verifica si existe una estanter�a con cierto c�digo ingresado.
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
	
	// Este m�todo verifica si existe un libro dado su codigo isbn.
	public boolean existBook(int cod){
		
		
		for(int a = 0; a < list.size(); a++){
			
			if(list.get(a).getCode() == cod && list.get(a).getQuantity() > 0)
				return true;
		}
		return false;
	}
	
	// Este m�todo resta la cantidad de libros.
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
