package hust.soict.itep.aims.media;

import java.util.ArrayList;
import java.util.List;
import hust.soict.itep.aims.exceptions.PlayerException;

public class CompactDisc extends Media implements Playable {
	private String artist;
	private List<Track> tracks;

	public CompactDisc() {
		super();
		this.tracks = new ArrayList<>();
	}

	public CompactDisc(String title, String category, float cost, String artist) {
		super(title, category, cost);
		this.artist = artist;
		this.tracks = new ArrayList<>();
	}

	public CompactDisc(String title, String category, float cost, String artist, List<Track> trackList) {
		super(title, category, cost);
		this.artist = artist;
		this.tracks = new ArrayList<>(trackList);
	}

	public String getArtist() {
		return artist;
	}

	public void setArtist(String artist) {
		this.artist = artist;
	}

	public List<Track> getTracks() {
		return tracks;
	}

	public void setTracks(List<Track> tracks) {
		this.tracks = new ArrayList<>(tracks);
	}

	public void addTrack(Track newTrack) {
		if (tracks.contains(newTrack)) {
			System.out.println("Track already exists.");
		} else {
			tracks.add(newTrack);
			System.out.println("Track added.");
		}
	}

	public void removeTrack(Track rTrack) {
		if (!tracks.contains(rTrack)) {
			System.out.println("Track not found.");
		} else {
			tracks.remove(rTrack);
			System.out.println("Track removed.");
		}
	}

	public int getTotalLength() {
		int totalLength = 0;
		for (Track t : tracks) {
			totalLength += t.getLength();
		}
		return totalLength;
	}

	@Override
	public void play() throws PlayerException {
		System.out.println("Playing CD " + getTitle() + " by " + artist);
		for (Track t : tracks) {
			t.play();
		}
	}

	@Override
	public String toString() {
		return "CD: " + getTitle() + " by " + artist + " in " + getCategory() + " with cost " + getCost();
	}

	public void printTracks() {
		System.out.println("Tracks in CD " + getTitle() + " by " + artist + ":");
		for (Track t : tracks) {
			System.out.println("- " + t.getTitle() + " with length " + t.getLength() + " seconds");
		}
	}
}
