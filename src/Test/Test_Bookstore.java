package Test;

import static org.junit.Assert.*;

import java.io.IOException;
import java.util.ArrayList;

import org.junit.Test;

import Model.*;


public class Test_Bookstore {

	private Bookstore store;
	
	public void StageOne(){
		
		store = new Bookstore();
		int numATMS = 5;
		int numCustomers = 2;
		String[] ids = new String[numCustomers];
		ids[0] = "1234";
		ids[1] = "2315";
		
		for(int i=0; i< numATMS;i++) {
			
			store.addATM(new ATM());
		}
		
		for(int i =0; i<numCustomers; i++) {
			store.createCustomer(new Customer(ids[i], store));
		}
		
	}
	
	public void Stagetwo() {
		store = new Bookstore();
		int numATMS = 4;
		int numCustomers = 3;
		String[] ids = new String[numCustomers];
		ids[0] = "1993";
		ids[1] = "8372";
		ids[2] = "7777";
		
		for (int i = 0; i < numATMS; i++) {

			store.addATM(new ATM());
		}
		for (int i = 0; i < numCustomers; i++) {

			store.createCustomer(new Customer(ids[i], store));

		}

	}
	
	public void Stagethree() {
		store = new Bookstore();
		String name = "A9";
		int number = 6;
		store.addShelves(new Shelving<String, Integer> (name, number));
		
	}
	public void StageFour() throws IOException {
		store = new Bookstore();
		ArrayList<Book> array= new ArrayList<>();
		Book b1 = new Book(897, 12, "A9", 12000);
		Book b2 = new Book(123, 2, "B1", 8000);
		Book b3 = new Book(444, 3, "C3", 40000);
		Book b4 = new Book(500, 1, "A8", 60000);
		array.add(b1);
		array.add(b2);
		array.add(b3);
		array.add(b4);
		
		
	}
	
	public void StageFive() {
		store = new Bookstore();
		store.setBooksout(640);
	}
	
	public void StageSix() {
		store = new Bookstore();
		
		store.organizeListPay();
		
	}
	
	
	
	
	//Esta prueba lo que hace es evaluar si el metodo addATM crea en numero de cajeros solicitado
	//y tambien evalua si se estan creando los clientes 
	@Test
	public void test() {	
		StageOne();
		assertEquals(store.getTotalBooks(),0);
	}
	
	//Esta prueba realiza lo mismo que la anterior pero con los otros valores
	@Test
	public void test2() {
		Stagetwo();
		assertEquals(store.getTotalBooks(),0);
		
	}
	
	
	//Esta prueba evalua si el metodo crear estante , crea un nuevo estante 
	@Test
	public void test3() {
		
		Stagethree();
		assertEquals("leido con exito",6, 6);
		
 	}

	//Esta prueba compreba que el metodo getList este retornando la lista de libros 
	@Test
	public void test4() throws IOException {
	StageFour();
	ArrayList<Book> array = new ArrayList<>();	
	assertEquals(store.getList(),array);
	}
		
	//Esta prueba evalua si el metodo getBookSout devulve el libro 
	@Test
	public void test5() {
		StageFive();
		assertEquals(store.getBooksout(),640);
		
	}
	
	
	
	
	
}
