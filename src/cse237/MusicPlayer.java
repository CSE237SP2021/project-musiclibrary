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
			
			//if last song in the playlist is complete, ask if user wants to favorite, then return to Now Playing menu.
			if (i == playlistSize - 1) {
		
				int inputEnd = playlistEndMenuHandling(keyboardIn);
				//back to Now Playing menu
				if (inputEnd == 1) {
					System.out.println("Now returning to the Now Playing menu: ");
					break;
				}
				
				//Loop last song
				if (inputEnd == 2){
					System.out.println("Looping the last played song: ");
					i--;
					continue;
				}
				//Start from the top
				if (inputEnd == 3){
					System.out.println("Starting from the top: ");
					i = -1;
					continue;
				}
			}
	
				//else, show user options
				int  input = songEndMenuHandling(keyboardIn);
				//go back to Now Playing Menu
				if (input == 1) {
					System.out.println("Now returning to the Now Playing menu:");
					break;
				}
				
				//loop last song
				if(input == 2) {
					System.out.println("Looping the last played song: ");
					i--;
					continue;
				}
				
				//next song
				if (input == 3) {
					//do nothing, continue to next song
				}
			
			
		}
		
		
		currentSongIndex = 0;
		
	}
	
	public int songEndMenuHandling(Scanner keyboardIn) {
		
		System.out.println("The song has finished. Here are your options: ");
		System.out.println("1. Go back to the Now Playing menu");
		System.out.println("2. Repeat the last played song");
		System.out.println("3. Continue to the next song");
		int inputEnd = keyboardIn.nextInt();
		return inputEnd;
		
	}	
	
	public int playlistEndMenuHandling(Scanner keyboardIn) {
		System.out.println("Looks like you've reached the end of this playlist. Here are your options: ");
		System.out.println("1. Go back to the Now Playing menu");
		System.out.println("2. Repeat the last played song");
		System.out.println("3. Start playing from the first song in this playlist");
		int inputPlaylistEnd = keyboardIn.nextInt();
		return inputPlaylistEnd;
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
		
		System.out.println("\nThe random song has ended. Now returning to the Now Playing menu.");
		
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
