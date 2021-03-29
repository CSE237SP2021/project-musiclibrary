package cse237;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;



public class MusicPlayer {

	private Playlist nowPlaying;
	private Song currentSong;
	private int songTimeElapsed;
	private int timeRemaining;
	private int currentSongIndex;
	private int playlistSize;
	ArrayList<Song> songs;

	
	public MusicPlayer(Playlist selected) {
		this.nowPlaying = selected;
		playlistSize = selected.numberOfSongs();
		songTimeElapsed = 0;
		songs = selected.getSongs();
		
		//by default, the current song is the first song in the playlist
		currentSong = songs.get(0);
		currentSongIndex = 0;
		timeRemaining = 0;
	}
	
	public void play(){
		
		for (int i = currentSongIndex; i < playlistSize; i++) {
			currentSongIndex = i;
			currentSong = songs.get(i);
			
			playSongs();
		}
		
	}
	
	
	public void playSongs(){	
		
		while (songTimeElapsed < currentSong.getLength()) {
			
			//print a play statement every second for every second in the song
			//then update how much of the song has been listened to, as well as
			//how much time there is remaining in the song.
			printNowPlaying();
			songTimeElapsed++;
			updateTimeRemaining();
			//pause for 1 second
			sleepOneSecond();
		}
	}
	
	public void printNowPlaying() {
		System.out.println("Now playing: " + currentSong.getTitle() + " by " + currentSong.getArtist()+ ". There are " +
				timeRemaining + " seconds remaining. Input 'pause' to pause the current song, , or 'back' to navigate back"
						+ " to the main menu.");
		
	}
	
	public void updateTimeRemaining() {
		timeRemaining = currentSong.getLength() - songTimeElapsed;
	}
	
	private void processPlayerMenu(String selectedOption) {
		
		//TO-DO
		
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
	
}
