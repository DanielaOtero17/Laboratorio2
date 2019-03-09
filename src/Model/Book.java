package Model;

public class Book {
	
	private String code;
	private String name;
	private int quantity;
	
	public Book(String key, int quantity, String shelves) {
		
		code = key;
		name = shelves;
		this.quantity = quantity;
	}
	
	public String getCode() {
		return code;
	}

	public void setCode(String code) {
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
