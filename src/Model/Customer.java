package Model;

public class Customer implements Comparable<Customer> {
	
	private Stack<Book> list;
	private String id;
	private int pay;
	private int time;
	private Bookstore store;
	
	public Customer(String id) {
		
		list = new Stack<>();
		this.id = id;
		pay = 0;
		time = 0;
		store = new Bookstore();
		
	}
	
		
	public Bookstore getStore() {
		return store;
	}


	public void setStore(Bookstore store) {
		this.store = store;
	}


	public Stack<Book> getList() {
		return list;
	}


	public void setList(Stack<Book> list) {
		this.list = list;
	}


	public String getId() {
		return id;
	}


	public void setId(String id) {
		this.id = id;
	}


	public int getPay() {
		return pay;
	}


	public void setPay(int pay) {
		this.pay = pay;
	}


	public int getTime() {
		return time;
	}


	public void setTime(int time) {
		this.time = time;
	}


	public void addBook(Book b){
		
	list.push(b);
	time ++;	
	}
	
	
	//Retorna los códigos de los libros en el orden que han sido pagados.
	public String payBooks(){
		
	String bougths = "";
		for(int i =0; i<list.size();i++){
			
			Book payed = list.pop();
			
			bougths += payed.getCode() + " ";
			pay += payed.getPrice();
		}
		
	return bougths;
	}
	
	public void buyBook(int code){
		
		if(store.existBook(code)){
			
			list.push(store.obtain(code));
			time ++;
		}else{
			System.out.println("El libro se encuentra agotado.");
		}
	}

	public int getTotalBooks(){
		
		return list.size();
	}

	@Override
	public int compareTo(Customer o) {
		if(time < o.time) // Si el tiempo del actual es menor al tiempo del parámetro
			return 1; // retorno 1.
		else if(time > o.time) // si es mayor
			return -1;// retorno -1;
		return 0; // si son iguales, retorno 0;
	}
	
	
}
