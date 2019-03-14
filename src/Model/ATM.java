package Model;

public class ATM {

	private boolean isBusy;
	private Stack<Customer> toBuy;
	private int time;
	
	public  ATM(){
		
		isBusy = false;
		toBuy = new Stack();
		time = 0;
		
	}
	
	// Realiza el proceso de pago de los clientes en el cajero.
	public String addBooksPay(Customer c){			
			toBuy.push(c);
			String list = "";
			list += c.getId() + " " + c.getPay() + "\n";
			list += c.payBooks() + " ";
			time = c.getTotalBooks();
			isBusy=true;
			return list;
	}
	
	public int getTime(){
		
		return time;
	}
	
	public void waitMinutes(){
		try{
			
			Thread.sleep(time);
			clean();
			
		}catch(Exception e){
			
		}
	}
	
	public void clean(){
		
			toBuy.pop();	
			isBusy = false;
	}
	
	public boolean isBusy(){
		return isBusy;
	}
	
	public void setBusy(boolean b){
		
		isBusy = b;
	}
	
	
	
	
}
