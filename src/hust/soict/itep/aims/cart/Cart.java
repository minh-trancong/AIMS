package hust.soict.itep.aims.cart;

import hust.soict.itep.aims.media.*;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.Comparator;
import java.util.Collections;

public class Cart {
	public static final int MAX_NUMBERS_ORDERED = 20; // unchanged
	private ObservableList<Media> itemsOrdered = FXCollections.observableArrayList();
	public static final Comparator<Media> COMPARE_BY_TITLE_COST = new MediaComparatorByTitleCost();
	public static final Comparator<Media> COMPARE_BY_COST_TITLE = new MediaComparatorByCostTitle();
	
	
	public ObservableList<Media> getItemsOrdered() {
		return this.itemsOrdered;
	}
	
	public void addMedia(Media nMedia) {
		int check = 0;
		for(Media m : this.itemsOrdered) {
			String tempStr = m.getTitle();
			if (tempStr.equals(nMedia.getTitle())) {
				System.out.println("Media already added.");
				check = 1;
				break;
			}
		}
		if(check == 0) {
			this.itemsOrdered.add(nMedia);
			System.out.println("Added media.");
		}
		
	}
	public void addMedia(Media ... medias) {
		for(Media media : medias) {
			int check = 0;
			for(Media m : this.itemsOrdered) {
				String tempStr = m.getTitle();
				if (tempStr.equals(media.getTitle())) {
					System.out.println("Media already added.");
					check = 1;
					break;
				}
			}
			if(check == 0) {
				this.itemsOrdered.add(media);
				System.out.println("Added media.");
			}
		}
	}
	public void removeMedia(Media nMedia) {
		int check = 1;
		for(Media m : this.itemsOrdered) {
			String tempStr = m.getTitle();
			if (tempStr.equals(nMedia.getTitle())) {
				check = 0;
				this.itemsOrdered.remove(nMedia);
				System.out.println("Removed media.");
				break;
			}
		}
		if(check != 0) {
			System.out.println("Media already removed.");
		}
	}
	
	public double totalCost() {
		int TotalCost = 0;
		for(Media t : this.itemsOrdered) {
			TotalCost += t.getCost();  
		}
		return TotalCost;
	}
	public String toString(Media m) {
		String printStr = m.getID() + " - " + m.getTitle() + " - " + m.getCategory() + " - " + m.getCost() ;
		return printStr;
	}
	public void printCart() {
		System.out.println("***********************CART***********************");
		for(Media m : this.itemsOrdered) {
			System.out.println((this.itemsOrdered.indexOf(m)+1) + ". " + toString(m));
		}
		System.out.println("Total cost:" + totalCost());
		System.out.println("***************************************************");
	}
	
	public void filterCartID(int ID) {
		int IDSearched = ID;
		int NumberOfResult = 0;
		for(Media m : this.itemsOrdered) {
			if (IDSearched == m.getID()) {
				NumberOfResult+=1;
				System.out.println("Found: " + toString(m));	
			}
		}
		if (NumberOfResult == 0) System.out.println("ID not found!");
	}
	public void filterCartTitle(String str) {
		String TitleSearched = new String(str);
		int NumberOfResult = 0;
		for(Media m : this.itemsOrdered) {
			if (m.getTitle().indexOf(TitleSearched) != -1) {
				NumberOfResult+=1;
				System.out.println((NumberOfResult) + ". " + toString(m));	
			}
		}
		if (NumberOfResult == 0) System.out.println("Title not found!");
	}
	
	public boolean isMatch(String input) {
		for(Media m: itemsOrdered) {
			if(m.getTitle().equalsIgnoreCase(input))return true;
		}
		return false;
	}
	
	public Media searchCartTitle(Scanner reader) {
		Media returnMedia = null;
		int result = 0;
		System.out.println("Please enter media title: ");
		String TitleSearched = reader.nextLine();
		reader.nextLine();
		while(!this.isMatch(TitleSearched)) {
			System.out.println("Title not found!");
			System.out.println("Please enter media title: ");
			TitleSearched = reader.nextLine();
			reader.nextLine();
		}
		for (int i = 0; i<this.itemsOrdered.size();i++) {
			if(this.itemsOrdered.get(i).getTitle().equals(TitleSearched)) {
				result = i;
				break;
			}
		}
		if(this.itemsOrdered.get(result) instanceof Book) {
			returnMedia = (Book) this.itemsOrdered.get(result);
		}
		else if(this.itemsOrdered.get(result) instanceof DigitalVideoDisc) {
			returnMedia = (DigitalVideoDisc) this.itemsOrdered.get(result);
		}
		else {
			returnMedia = (CompactDisc) this.itemsOrdered.get(result);
		}
		return returnMedia;
	}
	
	public void sortCartTitle() {
		System.out.println("--- Sorting cart by Title then by cost.");
		Collections.sort(this.itemsOrdered, COMPARE_BY_TITLE_COST);
		this.printCart();
	}
	public void sortCartCost() {
		System.out.println("--- Sorting cart by cost then by title.");
		Collections.sort(this.itemsOrdered, COMPARE_BY_COST_TITLE);
		this.printCart();
	}
	
}
