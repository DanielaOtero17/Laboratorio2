package Interfaces;

public interface IStack <T>{

	
	public void push(T elem);
	public T pop();
	public int size();
	public boolean isEmpty();
	public T peek();
	
}
