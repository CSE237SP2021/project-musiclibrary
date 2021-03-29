package cse237;

public class Song {
	private String title;
	private String artist;
	private int lengthInSeconds;
	
	public Song(String title, String artist, int lengthInSeconds) {
		this.title = title;
		this.artist = artist;
		this.lengthInSeconds = lengthInSeconds;
	}
	
	public String getFormattedLength() {
		int minutes = lengthInSeconds/60;
		int seconds = lengthInSeconds%60;
		return minutes + " minutes " + seconds + " seconds";
	}
	
	public String getTitle() {
		return this.title;
	}
	
	public String getArtist() {
		return this.artist;
	}
	
	public int getLength() {
		return this.lengthInSeconds;
	}
}
