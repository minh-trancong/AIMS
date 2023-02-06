package hust.soict.itep.aims.media;

import java.util.Random;

public abstract class Media {
	private int ID;
	private String title;
	private String category;
	private float cost;
	private static Random random = new Random();

	

	public int getID() {
		return ID;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	public float getCost() {
		return cost;
	}
	public void setCost(float cost) {
		this.cost = cost;
	}
	public static int generateID() {
		return random.nextInt(100);
	}
	public Media() {
		
	}
	
	public Media(String title) {
		this.title = title;
		this.ID = Media.generateID();
	}
	public Media(String title, String category) {
		this.title = title;
		this.category = category;
		this.ID = Media.generateID();
	}
	public Media(String title, String category, float cost) {
		this.title = title;
		this.category = category;
		this.cost = cost;
		this.ID = Media.generateID();
	}

	public void setID(int iD) {
		ID = iD;
	}
	
}
