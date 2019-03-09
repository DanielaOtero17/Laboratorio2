package Model;

public class employee {
	
	private Stack<Book> list;
	
	public employee() {
		
		list = new Stack<>();
		
	}
	
	public void addBook(Book b){
		
		
	list.push(b);
	
	}

	public int getTotalBooks(){
		
		return list.size();
	}
}
