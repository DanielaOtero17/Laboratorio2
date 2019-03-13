package Model;

public class Book {
	
	private String name;
	private int code, quantity,price;
	private Book next,back;
	
	public Book(int key, int quantity, String shelves,int price) {
		
		code = key;
		name = shelves;
		this.price = price;
		this.quantity = quantity;
		next = null;
		back = null;
	}
	
	
	public Book getNext() {
		return next;
	}

	public void setNext(Book next) {
		this.next = next;
	}

	public Book getBack() {
		return back;
	}


	public void setBack(Book back) {
		this.back = back;
	}


	public int getCode() {
		return code;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public void setCode(int code) {
		this.code = code;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public boolean exist() {
		
		return(quantity==0);
		
	}
}
