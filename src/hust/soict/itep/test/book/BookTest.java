package hust.soict.itep.test.book;

import hust.soict.itep.aims.media.Book;

public class BookTest {

	public static void main(String[] args) {
		Book b1 = new Book("Muoi nguoi da den nho");
		Book b2 = new Book("Nang tien ca", "fiction", 10);
		b2.addAuthor("Jamie");
		Book b3 =  new Book("Sherlock Holmes", "detective");
		Book[] bookList = {b1, b2, b3};
		for (Book b : bookList) {
			System.out.println(b.toString());
		}
	}

}
