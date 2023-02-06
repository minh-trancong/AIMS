package hust.soict.itep.aims;

import hust.soict.itep.aims.cart.Cart;
import hust.soict.itep.aims.exceptions.PlayerException;
import hust.soict.itep.aims.media.*;
import hust.soict.itep.aims.store.Store;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Aims {
	//Menu
	public static void showMenu() {
		System.out.println("AIMS: ");
		System.out.println("--------------------------------");
		System.out.println("1. View store");
		System.out.println("2. Update store");
		System.out.println("3. See current cart");
		System.out.println("0. Exit");
		System.out.println("--------------------------------");
		System.out.println("Please choose a number: 0-1-2-3");
	}
	//Menu1
	public static void storeMenu() {
		System.out.println("Options: ");
		System.out.println("--------------------------------");
		System.out.println("1. See a media’s details");
		System.out.println("2. Add a media to cart");
		System.out.println("3. Play a media");
		System.out.println("4. See current cart");
		System.out.println("0. Back");
		System.out.println("--------------------------------");
		System.out.println("Please choose a number: 0-1-2-3-4");
	}
	
	//Menu1.1
	public static void mediaDetailsMenu() {
		System.out.println("Options: ");
		System.out.println("--------------------------------");
		System.out.println("1. Add to cart");
		System.out.println("2. Play");
		System.out.println("0. Back");
		System.out.println("--------------------------------");
		System.out.println("Please choose a number: 0-1-2");
	}
	//Menu3 & Menu1.4
	public static void cartMenu() {
		System.out.println("Options: ");
		System.out.println("--------------------------------");
		System.out.println("1. Filter medias in cart");
		System.out.println("2. Sort medias in cart");
		System.out.println("3. Remove media from cart");
		System.out.println("4. Play a media");
		System.out.println("5. Place order");
		System.out.println("0. Back");
		System.out.println("--------------------------------");
		System.out.println("Please choose a number: 0-1-2-3-4-5");
	}
	//Menu2
	public static void addMenu() {
		System.out.println("Options: ");
		System.out.println("--------------------------------");
		System.out.println("1. Add Book");
		System.out.println("2. Add CD");
		System.out.println("3. Add DVD");
		System.out.println("0. Back");
		System.out.println("--------------------------------");
		System.out.println("Please choose a number: 0-1-2-3");
	}
	public static void playMedia(Media m) throws PlayerException {
		if(m instanceof Book) {
			System.out.println("Media can't be played since it's a book.");
		}
		else if(m instanceof DigitalVideoDisc) {
			DigitalVideoDisc temp = (DigitalVideoDisc) m;
			temp.play();
		}
		else {
			CompactDisc temp = (CompactDisc) m;
			temp.play();
		}
	}
	
	public static void viewCart(Cart c, Scanner reader) throws PlayerException {
		int choice;
		do {
			cartMenu();
			choice = reader.nextInt();
			switch(choice) {
			case 1:// filter medias in cart by title
				String temp;
				System.out.println("Filter by title:");
				temp = reader.nextLine();
				reader.nextLine();
				c.filterCartTitle(temp);
				reader.nextLine();
				break;
			case 2://Sort media in cart
				System.out.println("1 - sort by title");
				System.out.println("2 - sort by cost");
				System.out.println("Choose 1 - 2:");
				if(reader.nextInt() == 1) {
					c.sortCartTitle();
				}
				else if(reader.nextInt() == 2) {
					c.sortCartCost();
				}
				else System.out.println("Invalid choice.");
				break;
			case 3://remove media from cart
				Media m = null;
				m = c.searchCartTitle(reader);
				c.removeMedia(m);
				break;
			case 4:// play a media
				Media tempMedia = null;
				tempMedia = c.searchCartTitle(reader);
				playMedia(tempMedia);
				break;
			case 5:// place order
				c.printCart();
				System.out.println("Total cost: " + c.totalCost());
				break; 
			case 0:
				break;
			default:
				System.out.println("Invalid choice. Please choose again.");
			}
		}while(choice != 0);
	}
	
	public static Media addBook(Scanner reader) {
		String name, category;
		float cost;
		int numAuth;
		System.out.println("Input name");
		name = reader.nextLine();
		reader.nextLine();
		System.out.println("Input Category");
		category = reader.nextLine();
		reader.nextLine();
		System.out.println("Input Cost");
		cost = reader.nextFloat();
		reader.nextLine();
		List<String> authorList = new ArrayList<String>();
		System.out.println("The number of author:");
		numAuth = reader.nextInt();
		reader.nextLine();
		for(int i = 0; i < numAuth; i++) {
			System.out.println("Author " + (i+1) + " :");
			authorList.add(reader.nextLine());
			reader.nextLine();
		}
		return new Book(name, category, cost, authorList);
	}
	
	public static Media addCD(Scanner reader) {
		String name, category, artist;
		float cost;
		int numTrack;
		List<Track> TrackInput = new ArrayList<Track>();
		System.out.println("Input name");
		name = reader.nextLine();
		reader.nextLine();
		System.out.println("Input Category");
		category = reader.nextLine();
		reader.nextLine();
		System.out.println("Input Cost");
		cost = reader.nextFloat();
		reader.nextLine();
		System.out.println("Input Length");
		cost = reader.nextFloat();
		reader.nextLine();
		System.out.println("Input Artist");
		artist = reader.nextLine();
		reader.nextLine();
		System.out.println("How many Tracks are there in this CD:");
		numTrack = reader.nextInt();
		reader.nextLine();
		for(int i = 0; i < numTrack; i++) {
			String Tname;
			int Tlength;
			System.out.println("Track " + (i+1) + " name: ");
			Tname = reader.nextLine();
			reader.nextLine();
			System.out.println("Track " + (i+1) + " length: ");
			Tlength = reader.nextInt();
			Track temp = new Track(Tname, Tlength);
			TrackInput.add(temp);
		}
		return new CompactDisc(name, category, cost, artist, TrackInput);
	}
	
	public static Media addDVD(Scanner reader) {
		String name, category, director;
		float cost;
		int length;
		System.out.println("Input Name");
		name = reader.nextLine();
		reader.nextLine();
		System.out.println("Input Category");
		category = reader.nextLine();
		reader.nextLine();
		System.out.println("Input Director");
		director = reader.nextLine();
		reader.nextLine();
		System.out.println("Input Cost");
		cost = reader.nextFloat();
		reader.nextLine();
		System.out.println("Input Length");
		length = reader.nextInt();
		reader.nextLine();
		return new DigitalVideoDisc(name, category, director, length, cost);
	}
	
	/**
	 * Ham tra lai dang cua Media
	 * @param
	 * @return 1 if m is Book, -1 if m is DVD, 0 if m is CD
	 */

	public static void main(String[] args) throws PlayerException {
		Scanner reader = new Scanner(System.in);
		Store shop1 = new Store("Cua hang bang dia");
		Cart myCart = new Cart();
		int choiceMenu;
		int choiceStoreMenu;
		int choiceMediaOption;
		int choiceAdd;
		do {
			showMenu();
			choiceMenu = reader.nextInt();
			reader.nextLine();
			switch(choiceMenu) {
			case 1:// view store
				do {
				storeMenu();
				choiceStoreMenu = reader.nextInt();
				reader.nextLine();
				switch(choiceStoreMenu) {
				case 1://see Media detail
					Media temp = shop1.searchStoreTitle(reader);
					do {
						mediaDetailsMenu();
						choiceMediaOption = reader.nextInt();
						reader.nextLine();
						switch(choiceMediaOption) {
						case 1: // add to cart
							myCart.addMedia(temp);
							break;
						case 2: //play media
							playMedia(temp);
							break;
						case 0:// exit media detail
							break;
						}
					}while(choiceMediaOption != 0);
					break;
				case 2://add media to cart
					shop1.checkStock();
					Media temp2 = null;
					temp2 = shop1.searchStoreTitle(reader);
					myCart.addMedia(temp2);
					break;
				case 3://play a media
					Media temp3 = null;
					temp3 = shop1.searchStoreTitle(reader);
					playMedia(temp3);
					break;
				case 4://view cart
					viewCart(myCart, reader);
					break;
				default:
					System.out.println("Invalid choice. Please choose again.");
				}
				}while(choiceStoreMenu != 0);
				
			case 2: // update store
				do {
					addMenu();
					choiceAdd = reader.nextInt();
					reader.nextLine();
					switch(choiceAdd) {
					case 1:
						Media newBook = addBook(reader);
						shop1.addMedia(newBook);
						break;
					case 2:
						Media newCD = addCD(reader);
						shop1.addMedia(newCD);
						break;
					case 3:
						Media newDVD = addDVD(reader);
						shop1.addMedia(newDVD);
						break;
					case 0:
						break;
					default:
						System.out.println("Invalid choice. Please choose again.");
					}
				}while (choiceAdd != 0);
				break;
			case 3: //view cart
				viewCart(myCart, reader);
				break;
			case 0:// exit
				System.out.println("Exiting AIMS");
				break;
			default :
				System.out.println("Invalid choice. Please choose again.");
			}
		} while(choiceMenu != 0);
		reader.close();
	}
}