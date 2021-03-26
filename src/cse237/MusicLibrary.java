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
		musicLibrary.runMenu();
	}
	
	
	private void runMenu() {
		displayMainMenu();
		int selectedOption = this.getUserInput();
		processMainMenu(selectedOption);
	}
	
	private void displayMainMenu() {
		System.out.println("Welcome to Music Library!");
		playlistHelper.showPlaylists();
			/*
			 * Current Playlists:
			 * 0. All Songs 
			 * 1. Favorites
			 * 2. <custom playlist name here>
			 * ...
			 */
		System.out.println("Please select an option: ");
		System.out.println("1. Play an existing playlist");
		System.out.println("2. Edit an existing playlist");
		System.out.println("3. Delete an existing playlist");
		System.out.println("4. Add a new playlist");
		System.out.println("5. Quit Music Library");
		
	}
	
	private void processMainMenu(int selectedOption) {
		//TODO: Reorganize for better modularity
		switch(selectedOption) {
		case 1:
			
			System.out.println("Which playlist would you like to play?");
			int indexToPlay = selectPlaylist();
			Playlist listToPlay = playlistHelper.getPlaylist(indexToPlay);
			musicPlayer.setPlaylist(listToPlay);
			//musicPlayer.play(); //assumes shuffle/loop/normal option is asked in play();
			
			runPlayMenu(); //TODO: display menu (show modes), process option, run following:
						   //musicPlayer.setMode(shuffle); musicPlayer.play();
			runMenu();
			break;
		case 2:
			System.out.println("Which playlist would you like to edit?");
			int indexToEdit = selectPlaylist();
			Playlist playlistToEdit = playlistHelper.getPlaylist(indexToEdit);
			//playlistHelper.edit(indexToEdit); //assumes the editing menu & functionality is in edit();
			runEditPlaylistMenu(playlistToEdit); //TODO: implement this
			
			runMenu();
			break;
		case 3:
			System.out.println("Which playlist would you like to delete?");
			int indexToDelete = selectPlaylist();
			playlistHelper.delete(indexToDelete); // delete() shouldn't delete All Songs or Favorites
			runMenu();
			break;
		case 4:
			playlistHelper.addNewPlaylist();
			runMenu();
			break;
		case 5:
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
		playlistHelper.showPlaylists();
		int playlistIndex = keyboardIn.nextInt();	
		return playlistIndex;
	}
	
	private int getUserInput() {
		return this.keyboardIn.nextInt();
	}

}
