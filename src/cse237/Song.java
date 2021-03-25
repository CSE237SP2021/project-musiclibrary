package cse237;

public class Song {
	private String title;
	private String artist;
	private int length;
	
	public Song(String title, String artist, int length) {
		this.title = title;
		this.artist = artist;
		this.length = length;
	}
	
	public String getFormattedLength() {
		int minutes = length/60;
		int seconds = length%60;
		return minutes + " minutes " + seconds + " seconds";
	}
	
	public String getTitle() {
		return this.title;
	}
	
	public String getArtist() {
		return this.artist;
	}
	
	public int getLength() {
		return this.length;
	}
}
