package Main;

import java.io.*;

import Model.ATM;
import Model.Bookstore;
import Model.Shelving;
import Model.employee;

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
			Shelving<String,Integer> shelve = new Shelving<String,Integer>(id,totalBooks);//crea una estantería
			
			System.out.println(id + " "+ totalBooks); //imprime la estanteria y la cantidad total de libros
			
			for(int j=0; j<totalBooks; j++){
				
				String[] aux = br.readLine().split(" ");
				
				int  isbn = Integer.parseInt(aux[0]);
				int price = Integer.parseInt(aux[1]);
				int quantity = Integer.parseInt(aux[2]);
				shelve.addBook(isbn, quantity, price); //agrega una cantidad de libros en una estantería.
				System.out.println(isbn + " "+ price + " " + quantity); // imprime datos de un libro
			}			
			store.addShelves(shelve);//agrega la estantería en la biblioteca.
		}
		
		int c = Integer.parseInt(br.readLine());

		System.out.println(c);
		
		
		for(int i=0; i<c; i++){
			
			employee client = new employee(); // crea un nuevo cliente
			store.createEmployee(client);// agrega el cliente a la tienda de libros.
			
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