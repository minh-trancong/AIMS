package hust.soict.itep.aims.media;

public class Disc extends Media{
	private String director;
	private int length;
	
	public Disc() {
		super();
	}
	public String getDirector() {
		return director;
	}
	public void setDirector(String director) {
		this.director = director;
	}
	public int getLength() {
		return length;
	}
	public void setLength(int length) {
		this.length = length;
	}
	public Disc(String name){
		super(name);
	}
	public Disc(String name, String kind, float price){
		super(name, kind, price);
	}
	public Disc(String name, String kind, String author, float price){
		super(name, kind, price);
		this.director = author;
	}
	public Disc(String name,String kind, String author, int min, float price){
		super(name, kind, price);
		this.director = author;
		this.length = min;
	}
}
