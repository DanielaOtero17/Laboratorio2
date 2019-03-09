package Model;

public class ATM {

	public boolean isBusy;
	ATM(){
		
		isBusy = false;
		
	}
	
	public boolean getBusy(){
		return isBusy;
	}
	
	public void setBusy(boolean b){
		
		isBusy = b;
	}
	
	
	
}
