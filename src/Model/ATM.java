package Model;

public class ATM {

	public boolean isBusy;
	public Stack<Book> toBuy;
	
	public  ATM(){
		
		isBusy = false;
		
	}
	
	public void addBooks(Book b){
		
		toBuy.push(b);
	}
	
	public void clean(){
		
		for(int i=0; i<toBuy.size();i++){
			
			toBuy.pop();
		}
	}
	
	public boolean getBusy(){
		return isBusy;
	}
	
	public void setBusy(boolean b){
		
		isBusy = b;
	}
	
	
	
}
