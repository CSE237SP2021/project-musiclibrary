package cse237;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class MusicPlayer {

	private Playlist currentPlaylist;
	private Song currentSong;
	private int timeRemaining;
	private int currentSongIndex;
	private int playlistSize;
	private ArrayList<Song> songs;

	
	public MusicPlayer() {
		

	}
	
	
	/**
	 * Iterates through the Songs in the toPlay Playlist, and plays them
	 * @param toPlay, keyboardIn
	 */
	public void playPlaylist(Playlist toPlay, Scanner keyboardIn){
		
		this.setPlaylist(toPlay);
		
		if(playlistSize == 0) {
			System.out.println("No songs in playlist to play");
			return;
		}
		
		
		for (int i = currentSongIndex; i < playlistSize; i++) {
			currentSongIndex = i;
			currentSong = songs.get(i);
			updateTimeRemaining(0);
			playSongs(keyboardIn);
			String input = songEndMenuHandling(keyboardIn);
			if (input.equals("back")) {
				break;
			}
		}
		
		System.out.println("The playlist has been fully listened to. Now returning to the Now Playing menu.");
		
		currentSongIndex = 0;
		
	}
	
	public String songEndMenuHandling(Scanner keyboardIn) {
		
		System.out.println("The song has finished. Input 'back' to navigate back to the Now Playing menu, or 'next' to continue on to the next song.");
		String input = keyboardIn.nextLine();
		return input;
		
	}
	
	/**
	 * Method for playing the current Song : Emulates playing music by printing while tracking time of songs.
	 */
	public void playSongs(Scanner keyboardIn){	
		
		int songTimeElapsed = (currentSong.getLength() - timeRemaining);
		
		printNowPlaying();

		long start = System.nanoTime();
			
		while (songTimeElapsed < currentSong.getLength()) {
			songTimeElapsed = calcSongTimeElapsed(start);
			updateTimeRemaining(songTimeElapsed);
		}
	}
	
	/**
	 * Method for determining how long it has been since the start of the given song.
	 */
	public int calcSongTimeElapsed(long start) {
		long now = System.nanoTime();
		int timeElapsed = nanoSecToSec(now) - nanoSecToSec(start);
		return timeElapsed;
	}
	
	
	public int nanoSecToSec(long nano) {
		long seconds = nano / (1000000000);
		return (int)seconds;
	}
	
	public void printNowPlaying() {
		System.out.println("Now playing: " + currentSong.getTitle() + " by " + currentSong.getArtist()+ ". There are " +
				timeRemaining + " seconds remaining." );
		
	}
	
	public void updateTimeRemaining(int songTimeElapsed) {
		timeRemaining = currentSong.getLength() - songTimeElapsed;
	}
	
	
	public void setPlaylist(Playlist toPlay) {
		this.currentPlaylist = toPlay;
		this.playlistSize = toPlay.numberOfSongs();
		this.songs = toPlay.getSongs();
		try {
			currentSong = songs.get(0);
		}
		catch(Exception e){ // for case where no songs
			currentSong = null;
		}
		
		currentSongIndex = 0;
		timeRemaining = 0;
	}
	
	
}
