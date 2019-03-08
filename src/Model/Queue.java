package Model;

import java.util.LinkedList;

import Interfaces.IQueue;

public class Queue <T> implements IQueue <T> {
	
	private Node <T> first;
	private Node <T>  lastElement;
	private int ElementsNumber ;
	
	
	
	public Queue () {
		
		first = null;
		lastElement = null;
		ElementsNumber = 0;
	}


	@Override
	public void insert(Node <T> object) {

		if (this.getSize() == 0) {

			first = (Node<T>) object;
			lastElement = (Node<T>) object;

		} else {
			lastElement = lastElement.setNext(object);

		}
		ElementsNumber++;
	}

	
	@Override
	public Node <T> firts() {
		return first ;
	}


	@Override
	public Node <T> lastElement() {
		return lastElement;
	}


	@Override
	public Node <T> outElement() {
		// TODO Auto-generated method stub
		return null;
	}



	@Override
	public int getSize() {
		return ElementsNumber;
	}




	@Override
	public boolean isEmpty() {
	 boolean answ;
		if(first!=null) {
			answ = false;
		}else {
			answ = true;
		}
		return answ ;
	}


  @Override
  public String toString() {
	 String answ = "";
	for (Node <T> elementoQueue = first; first !=null ; first.getNext() ) {
		
		answ += first.getElement().toString() + "->";
	}
	return answ;
	  
  }


	
	

}
