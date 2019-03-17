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
	
	// set de cantidad de libros que serán vendidos.
	public void setBooksout(int x) {
		
		booksout = x;
	}
	
	// retorna la cantidad de libros que serán vendidos.
	public int getBooksout() {
		return booksout;
	}

	// Organiza la lista de clientes teniendo en cuenta su tiempo en la librería
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
	
	// Este método es el encargado de retornar el listado de datos
	// de los clientes al momento de salir de la librería, teniendo en cuenta su orden en la cola
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
	
	// este método es auxiliar, para verificar si hay algun elemento de un arreglo booleano 
	// con valor false.
	public boolean exist(boolean[] bool){
		
		for(int i=0; i<bool.length;i++){
			
			if(bool[i]==false){
				
				return true;
			}
		}
		return false;
	}
	
	// Este método verifica si un cajero que ingresa por parámetro, es
	// igual a uno de los cajeros pertenecientes a la librería.
	public int isTheSame(ATM atm) {
		
		for(int i=0; i<atms.size();i++) {
			
			if(atms.get(i)==atm) {
				
				return i;
			}
		}
		return 0;
	}
	
	// Este método verifica si un cajero de la librería se encuentra desocupado, y lo retorna.
	// en caso de no encontrar ningún cajero que esté disponible, retorna null.
	public ATM isNotBusy() {
		
		for(int i=0; i<atms.size();i++) {
			
			if(!atms.get(i).isBusy()) {
				
				return atms.get(i);
			}
		}
		return null;
		
	}
	
	// Este método agrega un cajero al arreglo de cajeros de la librería.
	public void addATM(ATM adding){
		
		atms.add(adding);
	}
	
	// Este método crea un nuevo cliente. Le asigna el tiempo de entrada al cliente dependiendo
	// de el orden en el que haya llegado a la librería.
	// También agrega el cliente a la lista de clientes de la librería.
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
	
	// Este método agrega una Estantería genérica a la lista de estanterías de la librería.
	public void addShelves(Shelving<String, Integer> shelve){
		
		shelves.add(shelve);		
	}
	
	// Este método retorna la cantidad total de libros que existen en la librería.
	public int getTotalBooks(){
		
		int sum = 0;
		for(int i=0;i<list.size();i++){
			 
			sum += list.get(i).getQuantity();
		}
		return sum;
	}	
	
	// Este Método crea un nuevo libro. y lo agraga a la lista de libros de la librería
	// Lo ubica en su respectiva estantería y peldaño.
	public void createNewBook(int code,int examples, String shelve,int price) throws IOException {
		
		Book new_book = new Book(code,examples,shelve,price);
		list.add(new_book);
	shelves.get(positionShelve(shelve)).addBook(new_book.getCode(), new_book.getQuantity(),new_book.getPrice());		
	}
	
	
	// Este método retorna el tamaño de la lista de libros. Es un auxiliar de verificación
	// Para saber si el tamaño de la lista de libros es la misma cantidad de libros totales.
	public int getTamanioListBooks(){
		
		System.out.println("El tamanio de la lista es " + list.size());
		return list.size();
	}
	
	// Este método retorna la posición de una estantería, basado en su código.
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
	
	// este método verifica si existe una estantería con cierto código ingresado.
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
	
	// Este método verifica si existe un libro dado su codigo isbn.
	public boolean existBook(int cod){
		
		
		for(int a = 0; a < list.size(); a++){
			
			if(list.get(a).getCode() == cod && list.get(a).getQuantity() > 0)
				return true;
		}
		return false;
	}
	
	// Este método resta la cantidad de libros.
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
