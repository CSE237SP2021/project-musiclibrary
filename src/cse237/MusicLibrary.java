package cse237;

import java.util.Scanner;

public class MusicLibrary {
	
	//TODO: write the PlaylistHelper & MusicPlayer class
	private Scanner keyboardIn;
	private PlaylistHelper playlistHelper;
	private MusicPlayer musicPlayer;
	
	public MusicLibrary() {
		this.keyboardIn = new Scanner(System.in);
		this.playlistHelper = new PlaylistHelper();
		this.musicPlayer = new MusicPlayer();
	}

	public static void main(String[] args) {
		
		MusicLibrary musicLibrary = new MusicLibrary(); 
		
		//TODO: call a method on musicLibrary to run the program (display menu & process it)
	}
	

}
