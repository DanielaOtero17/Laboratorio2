package Main;

import java.io.*;

import Model.ATM;
import Model.Bookstore;

public class Principal {

	
	public Principal() {
		
		
	}
	
	public static void main(String [] args) throws NumberFormatException, IOException {
		
		Principal main = new Principal();
		
		File f = new File("data/Input.txt");
		FileReader fr = new FileReader(f);
		BufferedReader br = new BufferedReader(fr);
		
		int totalCases = Integer.parseInt(br.readLine());
		System.out.println(totalCases);
		
		for(int a = 0; a<totalCases; a++){
			
		Bookstore store = new Bookstore();
			
		int totalATM = Integer.parseInt(br.readLine());
		
		for(int o=0; o<totalATM;o++){
						
			store.addATM(new ATM());
		}
				
		System.out.println(totalATM);
		
		int totalShelves = Integer.parseInt(br.readLine());
		System.out.println(totalShelves);
		
		for(int i = 0; i<totalShelves; i++){
			
			
			String[] auxi = br.readLine().split(" ");
			String id = auxi[0];
			int totalBooks = Integer.parseInt(auxi[1]);
			System.out.println(id + " "+ totalBooks);
			
			for(int j=0; j<totalBooks; j++){
				
				String[] aux = br.readLine().split(" ");
				
				int  isbn = Integer.parseInt(aux[0]);
				int price = Integer.parseInt(aux[1]);
				int quantity = Integer.parseInt(aux[2]);
				
				System.out.println(isbn + " "+ price + " " + quantity);
			}			
		}
		int c = Integer.parseInt(br.readLine());
		
		System.out.println(c);
		
		
		for(int i=0; i<c; i++){
			
			String st = "";
			String[] totallist = br.readLine().split(" ");
			
			for(int j=0; j<totallist.length; j++){
				st+= totallist[j] + " ";
			}
			System.out.println(st);
		}
		
		
		
		
	}
	
}
}