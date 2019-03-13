package Main;

import java.io.*;

import Model.ATM;
import Model.Book;
import Model.Bookstore;
import Model.Shelving;
import Model.Customer;

public class Principal {

	
	public Principal() {
		
		
	}
	
	
	public void readBuffer(File f) throws NumberFormatException, IOException{
		
		f = new File("data/Input.txt");
		FileReader fr = new FileReader(f);
		BufferedReader br = new BufferedReader(fr);
		
		int totalCases = Integer.parseInt(br.readLine());// numero de casos totales
		System.out.println(totalCases);
		
		for(int a = 0; a<totalCases; a++){
			
		Bookstore store = new Bookstore();
			
		int totalATM = Integer.parseInt(br.readLine());
		
		for(int o=0; o<totalATM;o++){
						
			store.addATM(new ATM());// agrega la cantidad de cajeros a la tienda.
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
				Book new_book = new Book(isbn,quantity,id,price);
				store.addBook(new_book);
				System.out.println(isbn + " "+ price + " " + quantity); // imprime datos de un libro
			}			
			store.addShelves(shelve);//agrega la estantería en la biblioteca.
		}
		
		int c = Integer.parseInt(br.readLine());

		System.out.println(c);
	
		for(int i=0; i<c; i++){
			
			String st = "";
			String[] totallist = br.readLine().split(" ");
			String id = totallist[0];
			
			Customer customer = new Customer(id); // crea un nuevo cliente
			store.createEmployee(customer);// agrega el cliente a la tienda de libros.
			
			
			for(int j=1; j<totallist.length; j++){
				
				
				st+= totallist[j] + " ";
			}
			System.out.println(st);
		}
		
		
	}
	
}
	
	public static void main(String [] args) throws NumberFormatException, IOException {
		
		Principal main = new Principal();
		main.readBuffer(new File("data/Input.txt"));
		
	}
}