package Model;

public class ATM {

	private boolean isBusy;
	private Stack<Customer> toBuy;
	
	public  ATM(){
		
		isBusy = false;
		toBuy = new Stack();
		
	}
	
	// Realiza el proceso de pago de los clientes en el cajero.
	public String addBooksPay(Customer c){			
			toBuy.push(c);
			String list = c.payBooks();
			isBusy=true;
			return list;
	}
	
	public void clean(){
		
			toBuy.pop();		
	}
	
	public boolean isBusy(){
		return isBusy;
	}
	
	public void setBusy(boolean b){
		
		isBusy = b;
	}
	
	
	
	
}
