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
		
		switch(selectedOption) {
		case 1:
			
			Playlist listToPlay = getPlaylistToPlayFromUser();
			musicPlayer.play(listToPlay);
			
			runMainMenu();
			
			break;
			
		case 2:
			
			runViewMenu();
			
			break;
		case 3:
			
			Playlist newPlaylist = getPlaylistToAddFromUser();
			this.playlistHelper.addPlaylist(newPlaylist);
			
			runMainMenu();
			break;
		case 4:
			System.out.println("Thank you for using Music Library");
			break;
		default:
			int nextInput = getValidUserInput();
			this.processMainMenu(nextInput);
			break;
		}
	}

	public void runViewMenu() {
		
		System.out.println("Please select a playlist to play or edit.");
		int indexToPlayOrEdit = selectPlaylist();
		
		Playlist playlistToPlayOrEdit = playlistHelper.getPlaylistAt(indexToPlayOrEdit);
		
		displayViewMenu(playlistToPlayOrEdit);
		
		int viewOption = this.getUserInput();
		processViewMenu(viewOption, playlistToPlayOrEdit, indexToPlayOrEdit );
		
	}
	
	public void displayViewMenu(Playlist playlistToDisplay) {
		System.out.println("Current playlist: ");
		playlistToDisplay.toString();
		playlistToDisplay.displaySongs();
		System.out.println("Please select an option: ");
		System.out.println("1. Play");
		System.out.println("2. Edit");
		System.out.println("3. Back");
	}

	public void processViewMenu(int viewOption, Playlist playlistToPlayOrEdit, int indexToPlayOrEdit) {
		
		switch(viewOption) {
		
		case 1:
			
			this.musicPlayer.play(playlistToPlayOrEdit);
			this.runMainMenu();
			
			break;
			
		case 2:
			
			runEditMenu(playlistToPlayOrEdit, indexToPlayOrEdit);
			break;
			
		case 3:
			
			this.runMainMenu();
			break;
			
		default:
			int nextInput = this.getValidUserInput();
			processViewMenu(nextInput, playlistToPlayOrEdit, indexToPlayOrEdit);
			break;
		}
		
	}

	public void runEditMenu(Playlist playlistToPlayOrEdit, int indexToPlayOrEdit) {
		
		displayEditMenu();
		
		int editOption = this.getUserInput();

		processEditMenu(editOption, playlistToPlayOrEdit, indexToPlayOrEdit);
	}

	public void displayEditMenu() {
		System.out.println("How would you like to edit?");
		System.out.println("1. Add Song");
		System.out.println("2. Back");
	}
	
	public void processEditMenu(int editOption, Playlist playlistToPlayOrEdit, int indexToPlayOrEdit) {
		
		switch(editOption){
		
		case 1:
			
			Song songToAdd = getSongFromUser();
			playlistToPlayOrEdit.addSong(songToAdd);
			this.playlistHelper.updatePlaylistHelper(playlistToPlayOrEdit, indexToPlayOrEdit);
			
			runMainMenu();
			
			break;
			
		case 2:
			
			runViewMenu();
			
			break;
		
		default:
			
			int nextInput = this.getValidUserInput();
			processEditMenu(nextInput, playlistToPlayOrEdit, indexToPlayOrEdit);
			
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
	
	public int getValidUserInput() {
		System.out.println("Please input a valid option");
		int nextInput = this.getUserInput();
		return nextInput;
	}
	
	public Song getSongFromUser() {
		
		System.out.println("Enter Song Title:");
		String title = this.keyboardIn.nextLine();
		
		System.out.println("Enter Artist:");
		String artist = this.keyboardIn.nextLine();
		
		System.out.println("Enter Song Length in Seconds: ");
		int songLength = this.keyboardIn.nextInt();
		
		Song songToAdd = new Song(title, artist,songLength);
		
		return songToAdd;
	}
	
	public Playlist getPlaylistToAddFromUser() {
		System.out.println("Please enter the name of the new playlist: ");
		String newPlaylistName = this.keyboardIn.nextLine();
		Playlist newPlaylist = new Playlist(newPlaylistName);
		return newPlaylist;
	}

	public Playlist getPlaylistToPlayFromUser() {
		System.out.println("Which playlist would you like to play?");
		int indexToPlay = selectPlaylist();
		Playlist listToPlay = playlistHelper.getPlaylistAt(indexToPlay);
		return listToPlay;
	}

}
