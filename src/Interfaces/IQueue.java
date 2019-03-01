package Interfaces;

public interface IQueue<T> {
	
	public void insert(T objet ) ;
	public T firts();
	public T lastElement ();
	public T outElement();
	public T getNext();
	public int getSize();
	public T setNext(T element);
}
