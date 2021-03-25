package cse237;

import java.util.ArrayList;

public class Playlist {
	private ArrayList<Song> songs;
	
	public Playlist() {
		this.songs = new ArrayList<Song>();
	}
	
	public void addSong(Song songToBeAdded) {
		this.songs.add(songToBeAdded);
	}
	
	public int numberOfSongs() {
		return this.songs.size();
	}
}
