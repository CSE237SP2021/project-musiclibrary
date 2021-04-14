package cse237;

import java.util.ArrayList;
import java.util.Random;
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
			System.out.println("\nNo songs in playlist to play");
			return;
		}
		
		
		for (int i = currentSongIndex; i < playlistSize; i++) {
			currentSongIndex = i;
			currentSong = songs.get(i);
			updateTimeRemaining(0);
			playSongs();
			
			//if last song in the playlist is complete, return to the Now Playing menu.
			if (i == playlistSize - 1) {
				break;
			}
			
			//else, show user options
			String input = songEndMenuHandling(keyboardIn);
			if (input.equals("back")) {
				break;
			}
		}
		
		System.out.println("\nThe playlist has been fully listened to. Now returning to the Now Playing menu.");
		
		currentSongIndex = 0;
		
	}
	
	public String songEndMenuHandling(Scanner keyboardIn) {
		
		System.out.println("The song has finished. Input 'back' to navigate back to the Now Playing menu, or 'next' to continue on to the next song.");
		String input = keyboardIn.nextLine();
		return input;
		
	}
	
	/**
	 * Method for playing the current Song : Emulates playing music by printing the current song's details.
	 */
	
	public void playSongs() {
		printNowPlaying();
		trackTime();
	}
	
	/**
	 * Method to hold the thread equal to the amount of time the song length is.
	 */
	public void trackTime() {
		int songTimeElapsed = (currentSong.getLength() - timeRemaining);
		long start = System.nanoTime();
		
		while (songTimeElapsed < currentSong.getLength()) {
			songTimeElapsed = calcSongTimeElapsed(start);
			updateTimeRemaining(songTimeElapsed);
		}
	}
	
	public void shuffle(Playlist toPlay) {
		
		this.setPlaylist(toPlay);
		
		if(playlistSize == 0) {
			System.out.println("\nNo songs in playlist to play");
			return;
		}
		
		int randomSong = generateRandomSong();
		currentSong = songs.get(randomSong);
		updateTimeRemaining(0);
		playSongs();
		trackTime();
		
		System.out.println("\nThe random song has ended. Now returning to the Now Playing menu");
		
	}
	
	public int generateRandomSong() {
		int min = 0;
		int max = playlistSize - 1;
		
		int randomInt = (int)Math.floor(Math.random() * (max-min+1) + min);
		return randomInt;
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
		this.playlistSize = toPlay.getNumberOfSongs();
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
