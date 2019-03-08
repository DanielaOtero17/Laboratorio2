package Interfaces;

import Model.Node;

public interface IQueue<T> {
	
	public void insert(Node <T> objet ) ;
	public Node <T> firts();
	public Node <T> lastElement ();
	public Node <T> outElement();

	public int getSize();
	
	public boolean isEmpty();
	
	public String toString();
}
