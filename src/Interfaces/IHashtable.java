package Interfaces;

public interface IHashtable<K,V> {

	
	public K getKey();
	public void insert(K key,V value);
	public void delete(K key);
}
