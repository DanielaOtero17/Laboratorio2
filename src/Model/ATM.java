package Model;

public class ATM implements Comparable<ATM>{

	private boolean isBusy;
	private Stack<Customer> toBuy;
	private int time;
	private Customer latest;
	private String data;
	
	public  ATM(){
		
		isBusy = false;
		toBuy = new Stack();
		time = 0;
		latest = null;
		data = "";
	}
	
	// Realiza el proceso de pago de los clientes en el cajero.
	public void addBooksPay(Customer c){			
			
		toBuy.push(c);
		String list = "";
			time = c.getTotalBooks();
			data += c.getId() + " " + c.getPay() + "\n";
			data += c.payBooks() + " ";
			isBusy=true;
			latest = c;	
			waitMinutes();
	}
	
	public Customer getLatest(){
		return latest;
	}
	
	public int getTime(){
		
		return time;
	}
	
	public String getData() {
		return data;
	}
	public void waitMinutes(){
		
		 time=time-1;
		 
		 if(time==0){
			 clean();
		 }
	}
	
	public void clean(){
		
			toBuy.pop();	
			isBusy = false;
			data = "";
	}
	
	public boolean isBusy(){
		return isBusy;
	}
	
	public void setBusy(boolean b){
		
		isBusy = b;
	}

	@Override
	public int compareTo(ATM o) {
		if(time < o.time) // Si el tiempo del actual es menor al tiempo del par�metro
			return -1; // retorno -1.
		else if(time > o.time) // si es mayor
			return 1;// retorno 1;
		return 0; // si son iguales, retorno 0;
	}
	
	
	
	
}
