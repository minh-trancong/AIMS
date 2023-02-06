package hust.soict.itep.aims.cart;

import java.util.Comparator;
import hust.soict.itep.aims.media.*;

public class MediaComparatorByTitleCost implements Comparator<Media>{

	@Override
	public int compare(Media o1, Media o2) {
		int com = o1.getTitle().compareToIgnoreCase(o2.getTitle());
		if(com < 0) {
			return -1;
		}
		else if (com > 0) {
			return 1;
		}
		else {
			if (o1.getCost()>o2.getCost()) {
				return 1;
			}
			else if(o1.getCost() < o2.getCost()) {
				return -1;
			}
			else return 0;
		}
	}
	
}
