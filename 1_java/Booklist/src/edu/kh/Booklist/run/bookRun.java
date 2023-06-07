package edu.kh.Booklist.run;

import edu.kh.Booklist.model.service.BookService;

public class bookRun {

	public static void main(String[] args) {
		BookService es = new BookService();
		
		es.displayMenu();

	}
}