package Model;

public class Customer implements Comparable<Customer> {
	
	private Stack<Book> list;
	private String id;
	private int pay;
	private int time;
	private Bookstore store;
	
	public Customer(String id, Bookstore bookStore) {
		
		list = new Stack<>();
		this.id = id;
		pay = 0;
		time = 0;
		store = bookStore;
		
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

	public String payBooks(){
		
		String bougths = "";
		
		int i=0;
		
		while(i<list.size()){
				
				Book payed = list.pop();
				bougths += payed.getCode() + " ";
				pay += payed.getPrice();
				i++;
			}
			
		return bougths;
		}
	
	public void buyBook(int code){
		
		if(store.existBook(code)){
			
			Book b = store.obtain(code);
			list.push(b);
			pay += b.getPrice();
			time ++;
			store.setBooksout(store.getBooksout()+1);
		}else{
			System.out.println("El libro " + code + " se encuentra agotado.");
		}
	}

	public int getTotalBooks(){
		
		return list.size();
	}

	@Override
	public int compareTo(Customer o) {
		if(time < o.time) // Si el tiempo del actual es menor al tiempo del par�metro
			return -1; // retorno 1.
		else if(time > o.time) // si es mayor
			return 1;// retorno -1;
		return 0; // si son iguales, retorno 0;
	}
	
	
}
