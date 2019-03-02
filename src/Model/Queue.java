package Model;

import java.util.LinkedList;

import Interfaces.IQueue;

public class Queue <T> implements IQueue <T> {
	
	private NodeQueue <T> first;
	private NodeQueue <T>  lastElement;
	private int ElementsNumber ;
	
	
	
	public Queue () {
		
		first = null;
		lastElement = null;
		ElementsNumber = 0;
	}


	@Override
	public void insert(NodeQueue <T> object) {

		if (this.getSize() == 0) {

			first = (NodeQueue<T>) object;
			lastElement = (NodeQueue<T>) object;

		} else {
			lastElement = lastElement.setNext(object);

		}
		ElementsNumber++;
	}

	
	@Override
	public NodeQueue <T> firts() {
		return first ;
	}


	@Override
	public NodeQueue <T> lastElement() {
		return lastElement;
	}


	@Override
	public NodeQueue <T> outElement() {
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
	for (NodeQueue <T> elementoQueue = first; first !=null ; first.getNext() ) {
		
		answ += first.getElement().toString() + "->";
	}
	return answ;
	  
  }


	
	

}
