package Main;

import java.io.*;

public class Principal {

	
	public Principal() {
		
		
	}
	
	public static void main(String [] args) throws NumberFormatException, IOException {
		
		Principal main = new Principal();
		
		File f = new File("data/Input.txt");
		FileReader fr = new FileReader(f);
		BufferedReader br = new BufferedReader(fr);
		
		int totalCases = Integer.parseInt(br.readLine());
		int totalATM = Integer.parseInt(br.readLine());
		int totalShelves = Integer.parseInt(br.readLine());
		
		for(int i = 0; i<totalShelves; i++){
			
			String id = br.readLine();
			int totalBooks = Integer.parseInt(br.readLine().split(" ").toString());
			
			for(int j=0; j<totalBooks; j++){
				
				String[] aux = br.readLine().split(" ");
				
				int  isbn = Integer.parseInt(aux[0]);
				int price = Integer.parseInt(aux[1]);
				int quantity = Integer.parseInt(aux[2]);
			}			
		}
		int c = Integer.parseInt(br.readLine());
		
		for(int i=0; i<c; i++){
			
			String[] totallist = br.readLine().split(" ");
			
		}
		
	}
	
}
