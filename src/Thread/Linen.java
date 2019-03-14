package Thread;

import Model.ATM;
import Model.Bookstore;
import Model.Customer;

public class Linen extends Thread{

	private Bookstore store;
	
	public Linen(Bookstore store){
		this.store = store;
	}
	
	public void run(){
		
		while(store.getPayList().size()>0){
			
			for(int i=0; i<store.getAtms().size();i++){
				
				Customer c = store.getPayList().Dequeue();
				store.getAtms().get(i).addBooksPay(c);
				
				try{
				
				ATM aux = store.getAtms().get(i);
				int time = store.getAtms().get(i).getTime();
				
					
				}catch(Exception e){
					
					
					
				}
			}
				
		
			
		}
		
		
	}
}
