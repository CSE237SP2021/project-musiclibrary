package cse237;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class MusicPlayer {

	private Playlist nowPlaying;
	private Song currentSong;
	private int timeRemaining;
	private int currentSongIndex;
	private int playlistSize;
	ArrayList<Song> songs;

	
	public MusicPlayer(Playlist selected) {
		this.nowPlaying = selected;
		playlistSize = selected.numberOfSongs();
		songs = selected.getSongs();
		
		//by default, the current song is the first song in the playlist
		currentSong = songs.get(0);
		currentSongIndex = 0;
		timeRemaining = 0;
	}
	
	
	/**
	 * Iterates through the Songs in the toPlay Playlist, and plays them
	 * @param toPlay
	 */
	public void play(Playlist toPlay){
		
		this.setPlaylist(toPlay);
		
		for (int i = currentSongIndex; i < playlistSize; i++) {
			currentSongIndex = i;
			currentSong = songs.get(i);
			
			playSongs();
		}
		currentSongIndex = 0;
	}
	
	/**
	 * Method for playing the current Song : Emulates playing music by printing while tracking time of songs.
	 */
	public void playSongs(){	
		
		int songTimeElapsed = 0;
		
		timeRemaining = currentSong.getLength() - songTimeElapsed;

		while (songTimeElapsed < currentSong.getLength()) {
			
			//print a play statement every second for every second in the song
			//then update how much of the song has been listened to, as well as
			//how much time there is remaining in the song
			printNowPlaying();
			songTimeElapsed++;
			updateTimeRemaining(songTimeElapsed);
			//pause for 1 second
			sleepOneSecond();
		}
	}
	
	
	public void printNowPlaying() {
		System.out.println("Now playing: " + currentSong.getTitle() + " by " + currentSong.getArtist()+ ". There are " +
				timeRemaining + " seconds remaining." );
		
	}
	
	public void updateTimeRemaining(int songTimeElapsed) {
		timeRemaining = currentSong.getLength() - songTimeElapsed;
	}
	
	//Not Finished - will try to implement if Iteration2
	private void processPlayerMenu(String selectedOption) {
		
		//TODO: add functionality to music player
		
		switch(selectedOption) {
		
		case "shuffle":
			break;
			
		case "pause":
			break;
			
		case "play":
			break;
			
		case "back":
			break;
		}
	}

	public void sleepOneSecond(){
	    try {
	        Thread.sleep(1000);
	    } catch (InterruptedException e) {}
	}
	
	public void setPlaylist(Playlist toPlay) {
		this.nowPlaying = toPlay;
		this.playlistSize = toPlay.numberOfSongs();
		this.songs = toPlay.getSongs();
		currentSong = songs.get(0);
		currentSongIndex = 0;
		timeRemaining = 0;
	}
	
	
}
