package hust.soict.itep.aims.media;

import hust.soict.itep.aims.exceptions.PlayerException;

public class Track implements Playable {
	private String title;
	private int length;

	public Track(String title, int length) {
		this.title = title;
		this.length = length;
	}

	public String getTitle() {
		return title;
	}

	public int getLength() {
		return length;
	}

	@Override
	public void play() throws PlayerException {
		if (length <= 0) {
			throw new PlayerException("ERROR: Track Length is non-positive");
		}
		System.out.println("Playing Track: " + title);
		System.out.println("Track length: " + length);
	}

	@Override
	public String toString() {
		return "Track: " + title + " - Length: " + length;
	}

	@Override
	public boolean equals(Object o) {
		if (o == this) return true;
		if (!(o instanceof Track)) return false;
		Track t = (Track)o;

		return t.length == this.length && t.title.equals(this.title);
	}
}
