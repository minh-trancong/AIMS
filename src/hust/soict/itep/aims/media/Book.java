package hust.soict.itep.aims.media;

import java.util.ArrayList;
import java.util.List;

public class Book extends Media{
	private List<String> authors = new ArrayList<String>();

	public List<String> getAuthors() {
		return authors;
	}

	// constructors
	public Book() {
		super();
	}
	public Book(String title) {
		super(title);
	}
	public Book(String title, String category) {
		super(title, category);
	}
	public Book(String title, String category, float cost) {
		super(title, category, cost);
	}
	public Book(String title, String category, float cost, List<String> authorList) {
		super(title, category, cost);
		for (int i = 0; i < authorList.size(); i++) {
			this.authors.add(authorList.get(i));
		}
	}
	
	public void addAuthor(String authorName) {
		if(this.authors.contains(authorName)) {
			System.out.println("Author has already been added.");
		}
		else {
			this.authors.add(authorName);
		}
	}
	public void removeAuthor(String authorName) {
		if(!this.authors.contains(authorName)) {
			System.out.println("Author has been removed.");
		}
		else {
			this.authors.remove(authorName);
		}
	}
	@Override
	public String toString() {
		return "Book: " + this.getTitle() + " - " + this.getAuthors()+ " - " + this.getCategory()+ " - " + this.getCost();
	}
	
}
