package cse237;

import java.util.Scanner;

public class MusicLibrary {
	
	private Scanner keyboardIn;
	private PlaylistHelper playlistHelper;
	private MusicPlayer musicPlayer;
	
	public MusicLibrary() {
		
		this.keyboardIn = new Scanner(System.in);
		this.playlistHelper = new PlaylistHelper();
		Playlist allSongsPlaylist = playlistHelper.getDefaultPlaylist();
		this.musicPlayer = new MusicPlayer(allSongsPlaylist);
		
	}

	public static void main(String[] args) {
		
		System.out.println("Welcome to Music Library!");
		
		MusicLibrary musicLibrary = new MusicLibrary(); 
		musicLibrary.runMainMenu();
		
	}
	
	
	private void runMainMenu() {
		displayMainMenu();
		int selectedOption = this.getUserInput();
		processMainMenu(selectedOption);
	}
	
	private void displayMainMenu() {
		System.out.println("---Main Menu---");
		playlistHelper.printAllPlaylists();
		System.out.println("Please select an option: ");
		System.out.println("1. Play an existing playlist");
		System.out.println("2. View an existing playlist to Play or Edit");
		System.out.println("3. Add a new playlist");
		System.out.println("4. Quit Music Library");
	}
	
	private void processMainMenu(int selectedOption) {
		//TODO: Reorganize for better modularity
		switch(selectedOption) {
		case 1:
			
			System.out.println("Which playlist would you like to play?");
			int indexToPlay = selectPlaylist();
			Playlist listToPlay = playlistHelper.getPlaylistAt(indexToPlay);
			
			musicPlayer.setPlaylist(listToPlay);
			musicPlayer.play();
			
			runMainMenu();
			break;
			
		case 2:
			System.out.println("Please select a playlist to play or edit.");
			int indexToPlayOrEdit = selectPlaylist();
			Playlist playlistToPlayOrEdit = playlistHelper.getPlaylistAt(indexToPlayOrEdit);
			playlistToPlayOrEdit.toString();
			playlistToPlayOrEdit.displaySongs();
			
			System.out.println("Please select an option: ");
			System.out.println("1. Play");
			System.out.println("2. Edit");
			System.out.println("3. Back");
			
			int viewOption = this.getUserInput();
			
			switch(viewOption) {
			case 1:
				this.musicPlayer.setPlaylist(playlistToPlayOrEdit);
				this.musicPlayer.play();
				this.runMainMenu();
				break;
			case 2:
				break;
			case 3:
				break;
			default:
				break;
			}
			
			break;
		case 3:
			runMainMenu();
			break;
		case 4:
			System.out.println("Thank you for using Music Library");
			break;
		default:
			System.out.println("Please input a valid option");
			int nextInput = this.getUserInput();
			this.processMainMenu(nextInput);
			break;
		}
	}
	
	private int selectPlaylist() {
		playlistHelper.printAllPlaylists();
		int playlistIndex = keyboardIn.nextInt();	
		return playlistIndex;
	}
	
	private int getUserInput() {
		return this.keyboardIn.nextInt();
	}

}
