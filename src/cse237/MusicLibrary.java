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
		musicLibrary.runMenu();
		
	}
	
	
	private void runMenu() {
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
			Playlist listToPlay = playlistHelper.getPlaylistAt(indexToPlay);
			musicPlayer.setPlaylist(listToPlay);
			musicPlayer.play();
			runMenu();
			break;
			
		case 2:
			System.out.println("Please select a playlist to view or edit.");
			int indexToEdit = selectPlaylist();
			Playlist playlistToEdit = playlistHelper.getPlaylistAt(indexToEdit);
			
			// Add song or whatever (Edit playlist menu)
			// call a method from playlistHelper to put the edited 
			// playlist in same index
			//playlistHelper.updatePlaylist(playListToEdit,indexToEdit)
			// add song to all songs playlists
			
			playlistHelper.edit(indexToEdit); //assumes the editing menu & functionality is in edit();
			//runEditPlaylistMenu(playlistToEdit); //TODO: implement this
			
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
		playlistHelper.printAllPlaylists();
		int playlistIndex = keyboardIn.nextInt();	
		return playlistIndex;
	}
	
	private int getUserInput() {
		return this.keyboardIn.nextInt();
	}

}
