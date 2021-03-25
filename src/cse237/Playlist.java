package cse237;

import java.util.ArrayList;

public class Playlist {
	String name;
	String description;
	private ArrayList<Song> songs;
	
	public Playlist(String name) {
		this.name = name;
		this.description = "";
		this.songs = new ArrayList<Song>();
	}
	
	public void addSong(Song songToBeAdded) {
		this.songs.add(songToBeAdded);
	}
	
	public int numberOfSongs() {
		return this.songs.size();
	}
	
	public void addDescription(String description) {
		this.description = description;
	}
	
	public String getName() {
		return this.name;
	}
	
	public String getDescription() {
		return this.description;
	}
}
