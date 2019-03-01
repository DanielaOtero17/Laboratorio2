package Interfaces;

public interface IQueue<T> {

	
	public void enqueue(T elem);
	public T dequeue(T elem);
	public int size();
	
}
