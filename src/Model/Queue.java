package Model;

import java.util.LinkedList;

import Interfaces.IQueue;

public class Queue <T> implements IQueue <T> {
	
	private T firts;
	private T lastElement;
	
	
	
	public Queue () {
		
		firts = null;
		lastElement = null;
		
	}


	@Override
	public void insert(T object) {

	   if (this.getSize() == 0) {
			
		    firts = object;
			lastElement = object;

		} else if (this.getSize()!= 0) {
            
			  if(this.getNext()==null) {
				  lastElement=object;
			    }
		}else { 
			while(this.getNext()!=null) {
				this.getNext();
			}
			lastElement = object;
		}

	}

	@Override
	public T firts() {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public T lastElement() {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public T outElement() {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public T getNext() {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public int getSize() {
		// TODO Auto-generated method stub
		return 0;
	}


	@Override
	public T setNext(T element) {
		// TODO Auto-generated method stub
		return null;
	}

	
	
	
	

}
