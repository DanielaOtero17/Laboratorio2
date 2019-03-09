package Interfaces;

import Model.Node;

public interface IQueue<T> {
	
	public void enqueue(T objet ) ;
	public T first();
	public T End();
	public T Dequeue();
	public int size();
	public boolean isEmpty();
	public String toString();
}
