package cse237;

public class Song {
	private String title;
	private String artist;
	private double length;
	
	public Song(String title, String artist, double length) {
		this.title = title;
		this.artist = artist;
		this.length = length;
	}
	
	public String getTitle() {
		return this.title;
	}
	
	public String getArtist() {
		return this.artist;
	}
	
	public double getLength() {
		return this.length;
	}
}
