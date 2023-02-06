package hust.soict.itep.test.cart;
import java.util.Scanner;

import hust.soict.itep.aims.cart.*;
import hust.soict.itep.aims.media.*;
import hust.soict.itep.aims.screen.*;
/**
 * @author becac
 *
 */
public class CartTest {

	public static void main(String[] args) {
		// Create a new cart
		Cart cart = new Cart();
		
		// Create new dvd obj and add them to the cart
		DigitalVideoDisc dvd1 = new DigitalVideoDisc("The Lion King", "Animation", "Roger Allers", 87, 19.95f);
		DigitalVideoDisc dvd2 = new DigitalVideoDisc("Star Wars", "Science Fiction", "George Lucas", 87, 24.95f);
		DigitalVideoDisc dvd3 = new DigitalVideoDisc("Aladin", "Animation", 18.99f);
		DigitalVideoDisc[] DiscList = {dvd1, dvd2, dvd3};
		cart.addMedia(DiscList);
//		
//		cart.printCart();
//		Scanner reader = new Scanner(System.in);
//		System.out.println("Search by ID: ");
//		int searchID = reader.nextInt();
//		cart.filterCartID(searchID);
//		reader.nextLine();
//		System.out.println("Search by Title:");
//		String searchTitle = reader.nextLine();
//		cart.filterCartTitle(searchTitle);
//		Media m = cart.searchCartTitle(reader);
//		cart.addMedia(m);
//		reader.close();
//		cart.sortCartCost();
//		cart.sortCartTitle();
//		
		new CartScreen(cart);
	}

}
