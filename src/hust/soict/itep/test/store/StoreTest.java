package hust.soict.itep.test.store;

import hust.soict.itep.aims.media.DigitalVideoDisc;
import hust.soict.itep.aims.screen.*;
import hust.soict.itep.aims.store.Store;

public class StoreTest {
	public static void main(String[] args) {
		Store st1 = new Store("Cua hang bang dia An Hung");
		DigitalVideoDisc dvd1 = new DigitalVideoDisc("The Lion King", "Animation", "Roger Allers", 87, 19.95f);
		DigitalVideoDisc dvd2 = new DigitalVideoDisc("Star Wars", "Science Fiction", "George Lucas", 87, 24.95f);
		DigitalVideoDisc dvd3 = new DigitalVideoDisc("Aladin", "Animation", 18.99f);
		
		st1.addMedia(dvd1, dvd2, dvd3, dvd1);
		
		new StoreScreen(st1);
	}
	

}
