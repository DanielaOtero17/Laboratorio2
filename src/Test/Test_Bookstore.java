package Test;

import static org.junit.Assert.*;

import org.junit.Test;

import Model.ATM;
import Model.Bookstore;
import Model.Customer;

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
			
			store.createEmployee(new Customer(ids[i], store));
		}
		
	}
	@Test
	public void test() {
		
		StageOne();
		assertEquals(store.getTotalBooks(),0);
	}

}
