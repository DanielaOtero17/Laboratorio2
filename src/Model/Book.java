package Model;

public class Book<T> {
	
	private T code;
	private T name;
	private int quantity;
	
	public Book(T key, T value,int quantity) {
		
		code = key;
		name = value;
		this.quantity = quantity;
	}

	public T getCode() {
		return code;
	}

	public void setCode(T code) {
		this.code = code;
	}

	public T getName() {
		return name;
	}

	public void setName(T name) {
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
