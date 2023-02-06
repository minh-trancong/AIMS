package hust.soict.itep.test.disc;

import hust.soict.itep.aims.media.DigitalVideoDisc;

public class TestPassingParameter {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		DigitalVideoDisc jungleDVD = new DigitalVideoDisc("Jungle");
		DigitalVideoDisc cinderellaDVD = new DigitalVideoDisc("Cinderella");
		
		swap(jungleDVD, cinderellaDVD);
		System.out.println("Jungle DVD title: " + jungleDVD.getTitle());
		System.out.println("Cinderella DVD title: " + cinderellaDVD.getTitle());
		
//		swapObjects(jungleDVD, cinderellaDVD);
//		System.out.println("Jungle DVD title: " + jungleDVD.getTitle());
//		System.out.println("Cinderella DVD title: " + cinderellaDVD.getTitle());
		
//		changeTitle(jungleDVD, cinderellaDVD.getTitle());
//		System.out.println("Jungle DVD title: " + jungleDVD.getTitle());
		
		// test wrapper class
		DiskWrapper dw1 = new DiskWrapper(jungleDVD);
		DiskWrapper dw2 = new DiskWrapper(cinderellaDVD);
		
		swapDisk(dw1, dw2);
		System.out.println("Jungle DVD title: " + dw1.d.getTitle());
		System.out.println("Cinderella DVD title: " + dw2.d.getTitle());
		
	}
	
	public static void swap(Object o1, Object o2) {
		Object tmp = o1;
		o1 = o2;
		o2 = tmp;
	}
	
	public static void changeTitle(DigitalVideoDisc dvd, String title) {
		String oldTitle = dvd.getTitle();
		dvd.setTitle(title);
		dvd = new DigitalVideoDisc(oldTitle);
	}
	
	public static void swapObjects(DigitalVideoDisc dvd1, DigitalVideoDisc dvd2){
		String tempTitle = dvd1.getTitle();
		dvd1.setTitle(dvd2.getTitle());
		dvd2.setTitle(tempTitle);
		
		String tempCategory = dvd1.getCategory();
		dvd1.setCategory(dvd2.getCategory());
		dvd2.setCategory(tempCategory);
		
		String tempDirector = dvd1.getDirector();
		dvd1.setDirector(dvd2.getDirector());
		dvd2.setDirector(tempDirector);
		
		int tempLength = dvd1.getLength();
		dvd1.setLength(dvd2.getLength());
		dvd2.setLength(tempLength);
		
		float tempCost = dvd1.getCost();
		dvd1.setCost(dvd2.getCost());
		dvd2.setCost(tempCost);
	}
	
	public static void swapDisk(DiskWrapper dw1, DiskWrapper dw2) {
		DigitalVideoDisc temp = dw1.d;
		dw1.d = dw2.d;
		dw2.d = temp;
	}
}
