package Interfaces;

import Model.NodeQueue;

public interface IQueue<T> {
	
	public void insert(NodeQueue <T> objet ) ;
	public NodeQueue <T> firts();
	public NodeQueue <T> lastElement ();
	public NodeQueue <T> outElement();

	public int getSize();
	
	public boolean isEmpty();
	
	public String toString();
}
