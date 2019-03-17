package Model;

import java.util.*;
import Interfaces.IStack;

public class Stack<T> implements IStack<T>{

	  private Node<T> end;
	  private int size;
	
	public Stack() {
		
		end = null;
	    size = 0;
		
	}
	
	@Override
	public void push(T elem) {
			
		Node<T> new_node = new Node<T>(elem);
	    if (end == null){
	      end = new_node;
	    size=1;}
	    else {
	      new_node.setNext(end);
	      end = new_node;
	      
	    }
	    size++;
	    
		}


	@Override
	public T pop() {
		
		if (end == null)
		      return null;		    
		   
		    T o = end.getElement();
		    end = end.getNext();
		   
		    size--;
		    return o;
	}

	@Override
	public int size() {
		return size;
	}

	@Override
	public boolean isEmpty() {
	    return (size == 0);
	}
	
	@Override
	public T peek() {
		
		if (end == null)
		      return null;
		    else
		      return end.getElement();
		  }
		
	}

