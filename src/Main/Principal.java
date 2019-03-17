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
	
	
	public void readBuffer() throws NumberFormatException, IOException{
		
		File f = new File("data/Input.txt");
		FileReader fr = new FileReader(f);
		BufferedReader br = new BufferedReader(fr);

		int totalCases = Integer.parseInt(br.readLine());// numero de casos
															// totales

		for (int a = 0; a < totalCases; a++) {

			Bookstore store = new Bookstore();

			int totalATM = Integer.parseInt(br.readLine());

			for (int o = 0; o < totalATM; o++) {

				store.addATM(new ATM());// agrega la cantidad de cajeros a la
										// tienda.
			}

			int totalShelves = Integer.parseInt(br.readLine());

			for (int i = 0; i < totalShelves; i++) {

				String[] auxi = br.readLine().split(" ");
				String id = auxi[0];
				int totalBooks = Integer.parseInt(auxi[1]);
				Shelving<String, Integer> shelve = new Shelving<String, Integer>(id, totalBooks);// crea una estanteria
				// System.out.println("existe la estantería " + shelve.getKey());
				store.addShelves(shelve);

				for (int j = 0; j < totalBooks; j++) {

					String[] aux = br.readLine().split(" ");

					int isbn = Integer.parseInt(aux[0]);
					int price = Integer.parseInt(aux[1]);
					int quantity = Integer.parseInt(aux[2]);
					Book new_book = new Book(isbn, quantity, id, price);
					store.createNewBook(isbn, quantity, id, price);
				}
			}
		/*	System.out.println("Cantidad de estanterias: " + store.getShelves().size());
			System.out.println("Cantidad de isbn : " + store.getList().size());
			System.out.println("Cantidad de libros totales: " + store.getTotalBooks());
			System.out.println("La Cantidad de cajeros es: "+ store.getAtms().size());*/

			int c = Integer.parseInt(br.readLine());

			for (int i = 0; i < c; i++) {

				String st = "";
				String[] totallist = br.readLine().split(" "); // lista que contiene la
																// id del
																// cliente y los
																// libros que el
																// cliente
																// compra.
				String id = totallist[0];

				Customer customer = new Customer(id,store); // crea un nuevo cliente
				store.createCustomer(customer);// agrega el cliente a la tienda
												// de libros.
				for (int j = 1; j < totallist.length; j++) {

					int aux = Integer.parseInt(totallist[j]);
					customer.buyBook(aux);
					st += totallist[j] + " ";
				}
			}
			store.processPaying();
		}
	}
	
	public static void main(String [] args) throws NumberFormatException, IOException {
		
		Principal main = new Principal();
		main.readBuffer();
		
	}
}