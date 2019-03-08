package Model;

import Interfaces.INode;

public class Node <T> implements INode <T> {
	
	private Node<T> next;
	private T element;
	
	public Node(T elem) {
		next = null;
		element = elem;
	}

	@Override
	public Node<T> getNext() {
		return next;
	}

	@Override
	public T getElement() {
		return element;
	}

	@Override
	public Node<T> setNext (Node<T> object) {
		next = object;
		return object;
		
	}

	@Override
	public Node<T> firstDisconected() {
		Node<T> auxNode = next;
		next = null;
		return auxNode;
	}
	
	@Override
	public String toString() {
		return element.toString();
	}

}
