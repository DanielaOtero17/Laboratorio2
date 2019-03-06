package Interfaces;

import Model.NodeQueue;

public interface INodeQueue <T> {
	
	public NodeQueue<T> getNext();
	public T getElement();
	
	public NodeQueue<T> setNext(NodeQueue<T> object);
	public NodeQueue<T> firstDisconected();
	public String toString();

}
