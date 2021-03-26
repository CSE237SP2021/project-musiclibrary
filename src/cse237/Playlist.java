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
	
	public int getPlaytime() {
		int playtime = 0;
		for(int i = 0; i<this.songs.size(); i++) {
			Song currentSong = this.songs.get(i);
			playtime+=currentSong.getLength();
		}
		return playtime;
	}
	
	public String toString() {
		//Name: MyPlaylist   Length: 12 songs  Playtime: 140 seconds
		if (description=="") {
			return ("Name: " + this.name + "  Length: " + this.numberOfSongs()+ "songs  Playtime: " + this.getPlaytime() + " seconds");
		}
		//Name: MyPlaylist  Description: This is a playlist of my favorites songs  Length: 12 songs  Playtime: 140 seconds
		return ("Name: " + this.name + "  Description " + this.description + "  Length: " + this.numberOfSongs()+ " songs  Playtime: " + 
				this.getPlaytime() + " seconds");
	}
	
	public String getName() {
		return this.name;
	}
	
	public String getDescription() {
		return this.description;
	}
}
