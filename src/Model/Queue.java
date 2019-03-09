package Model;

import java.util.LinkedList;
import Interfaces.IQueue;

public class Queue <T> implements IQueue <T> {
	
	Node<T> first;
	  Node<T> end;
	  int size;

	  public Queue() {
	    end = null;
	    size = 0;
	  }
	  
	  @Override
	public T End(){
		  if(end == null)
			  return null;
		  return end.getElement();
	  }

	  @Override
	  public void enqueue(T o) {
		  
	    Node<T> new_node = new Node<T>(o);
	    if (first == null) {
	      first = new_node;
	      end = new_node;
	    } else {
	      end.setNext(new_node);
	      end = new_node;
	    }
	    size++;
	  }; // inserts an object onto the queue

	  @Override
	  public T Dequeue() {
	    if (first == null)
	      return null;
	    T o = first.getElement();
	    first = first.getNext();
	    size--;
	    return o;
	  } // gets the object from the queue

	  @Override
	  public boolean isEmpty() {
	    return (size == 0);
	  }

	  @Override
	  public int size(){
	    return size;
	  }
	  
	  @Override
	  public T first() {
	    if (first == null)
	      return null;
	    else
	      return first.getElement();
	  }

  @Override
  public String toString() {
	 String answ = "";
	for (Node <T> elementoQueue = first; first !=null ; first.getNext() ) {
		
		answ += elementoQueue.toString() + "->";
	}
	return answ;
	  
  }


	
	

}
