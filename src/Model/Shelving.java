package Model;

import Interfaces.IHashtable;

public class Shelving<K,V> implements IHashtable<K,V> {
	
	private K key;
	private V value;
	
	
	public Shelving(K k, V v){
		
		key = k;
		value = v;
	}

	@Override
	public K getKey() {
		// TODO Auto-generated method stub
		return key;
	}
	
	public V getValue(){
		return value;
	}

	@Override
	public void insert(K key, V value) {
		
		
		
	}

	@Override
	public void delete(K key) {
		// TODO Auto-generated method stub
		
	}

	
}
