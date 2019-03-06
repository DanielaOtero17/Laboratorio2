package Model;

import Interfaces.INodeQueue;

public class NodeQueue <T> implements INodeQueue <T> {
	
	private NodeQueue<T> next;
	private T element;
	
	public NodeQueue() {
		next = null;
		element = null;
	}

	@Override
	public NodeQueue<T> getNext() {
		return next;
	}

	@Override
	public T getElement() {
		return element;
	}

	@Override
	public NodeQueue<T> setNext (NodeQueue<T> object) {
		next = object;
		return object;
		
	}

	@Override
	public NodeQueue<T> firstDisconected() {
		NodeQueue<T> auxNode = next;
		next = null;
		return auxNode;
	}
	
	@Override
	public String toString() {
		return element.toString();
	}

}
