package Model;

import java.util.ArrayList;

import Interfaces.IHashtable;

public class Shelving<K,V> implements IHashtable<String,Integer> {
	
	private String key;
	private int value;
	private ArrayList<Book[]> books;
		
	public Shelving(String k, int v){
		
		key = k;
		value = v;
		books = new ArrayList<Book[]>(value);
	}
	
	public int hashFunction(String k){
		
		int position = Integer.parseInt(k);
		
		
		
		return position;
	}
	public String getKey() {
		return key;
	}

	public void setKey(String key) {
		this.key = key;
	}

	public int getValue() {
		return value;
	}

	public void setValue(int value) {
		this.value = value;
	}

	public ArrayList<Book[]> getBooks() {
		return books;
	}

	public void setBooks(ArrayList<Book[]> books) {
		this.books = books;
	}
	
	public void addBook(int k, int valu,int price){
		
		int position = 0;		
		boolean added = false;
		
		while(added == false && position < books.size()){
			
			if(books.get(position) == null){
				
				added = true;
				Book[] arr = new Book[valu];
				for(int i=0;i<valu;i++){
					arr[i] = new Book(k,valu,this.key,price);
				}
				
				books.add(position,arr);
			}
			position ++;
		}		
	}

	@Override
	public void insert(String key, Integer value) {
		
		this.value = (int) value;
		
		int position = hashFunction(key);
			
	}
	@Override
	public void delete(String key) {
		// TODO Auto-generated method stub
		
	}
	
}
