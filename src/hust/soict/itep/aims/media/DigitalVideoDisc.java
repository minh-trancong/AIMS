package hust.soict.itep.aims.media;

import java.lang.Thread;

public class DigitalVideoDisc extends Disc implements Playable{
	public DigitalVideoDisc() {
		super();
	}
	public DigitalVideoDisc(String name){
		super(name);
	}
	public DigitalVideoDisc(String name, String kind, float price){
		super(name, kind, price);
	}
	public DigitalVideoDisc(String name, String kind, String author, float price){
		super(name, kind, author, price);
	}
	public DigitalVideoDisc(String name,String kind, String author, int min, float price){
		super(name, kind, author, min, price);
	}
	public void play() {
		System.out.println("Playing DVD::" + this.getTitle());
		System.out.println("DVD length:" + this.getLength());
		System.out.println();
		for(int i = 0; i< this.getLength();i+=10) {
			System.out.print("-");
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		System.out.println();
		System.out.println("DVD end");
	}
	public String toString() {
		return "DVD: " + this.getTitle() + " - " + this.getDirector()+ " - " + this.getCategory()+ " - " + this.getCost();
	}
}
