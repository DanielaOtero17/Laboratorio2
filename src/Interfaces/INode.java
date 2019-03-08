package Interfaces;

import Model.Node;

public interface INode <T> {
	
	public Node<T> getNext();
	public T getElement();
	
	public Node<T> setNext(Node<T> object);
	public Node<T> firstDisconected();
	public String toString();

}
