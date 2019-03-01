package Model;

import java.util.*;

import Interfaces.IStack;

public class Stack<T> implements IStack<T>{

	private int size;
	private T pop;
	private T next;
	private ArrayList<T> array;
	
	public Stack() {
		
		size = 0;
		pop = null;
		array = new ArrayList<>();
		
	}
	
	@Override
	public void push(T elem) {
			
			pop = elem;
			array.add(pop);
			size++;	
		}


	@Override
	public T pop() {
		
		T deleted = array.remove(array.size()-1);
		pop = array.get(array.size()-1);
		size--;
		
		return deleted;
	}

	@Override
	public int size() {
		// TODO Auto-generated method stub
		return 0;
	}
}
