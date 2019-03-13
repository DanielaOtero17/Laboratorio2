package Model;

public class Book {
	
	private String name; // nombre de la estantería en la que se ubican
	private int code, quantity,price; // codigo identificador, cantidad de ejemplares, precio del libro
	
	public Book(int key, int quantity, String shelves,int price) {
		
		code = key;
		name = shelves;
		this.price = price;
		this.quantity = quantity;
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
