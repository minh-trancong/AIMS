package hust.soict.itep.aims.store;

import hust.soict.itep.aims.media.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Store {
	private String StoreName;
	private List<Media> itemsInStore = new ArrayList<Media>();
	
	
	public String getStoreName() {
		return StoreName;
	}
	
	public ArrayList<Media> getItemsInStore() {
		return (ArrayList<Media>)itemsInStore;
	}

	public Store(String StoreName) {
		this.StoreName = StoreName;
	}

	public String toString(Media m) {
		String printStr = m.getID() + " - " + m.getTitle() + " - " + m.getCategory() + " - " + m.getCost() ;
		return printStr;
	}
	
	public void addMedia(Media ... medias) {
		for(Media media : medias) {
			int check = 0;
			for(Media m : this.itemsInStore) {
				String tempStr = m.getTitle();
				if (tempStr.equals(media.getTitle())) {
					System.out.println("Media already added.");
					check = 1;
					break;
				}
			}
			if(check == 0) {
				this.itemsInStore.add(media);
				System.out.println("Added media.");
			}
		}
	}
	public void removeMedia(Media nMedia) {
		int check = 1;
		for(Media m : this.itemsInStore) {
			String tempStr = m.getTitle();
			if (tempStr.equals(nMedia.getTitle())) {
				check = 0;
				this.itemsInStore.remove(nMedia);
				System.out.println("Removed media.");
				break;
			}
		}
		if(check != 0) {
			System.out.println("Media already removed.");
		}
	}
	
	public void checkStock() {
		System.out.println("***********************SHOP " + this.getStoreName() + " ***********************");
		for(Media m : this.itemsInStore) {
			System.out.println((this.itemsInStore.indexOf(m)+1) + ". " + toString(m));
		}
		System.out.println("***************************************************");
	}
	
	/**
	 * Find the media in store by passed reader
	 * input again until find a Media
	 * @param reader
	 * @return Media
	 */
	public Media searchStoreTitle(Scanner reader) {
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
		for (int i = 0; i<this.itemsInStore.size();i++) {
			if(this.itemsInStore.get(i).getTitle().equals(TitleSearched)) {
				result = i;
				break;
			}
		}
		if(this.itemsInStore.get(result) instanceof Book) {
			returnMedia = (Book) this.itemsInStore.get(result);
		}
		else if(this.itemsInStore.get(result) instanceof DigitalVideoDisc) {
			returnMedia = (DigitalVideoDisc) this.itemsInStore.get(result);
		}
		else {
			returnMedia = (CompactDisc) this.itemsInStore.get(result);
		}
		return returnMedia;
	}
	
	public boolean isMatch(String input) {
		for(Media m: itemsInStore) {
			if(m.getTitle().equalsIgnoreCase(input))return true;
		}
		return false;
	}
}
