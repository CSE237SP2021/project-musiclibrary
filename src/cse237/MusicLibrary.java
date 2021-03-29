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
			mainMenuPlay();
			break;
			
		case 2:
			mainMenuView();
			break;
			
		case 3:
			mainMenuAddPlaylist();
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
	
	/**
	 *Main Menu option 1: Prompts the user to select a playlist then play it.
	 */
	public void mainMenuPlay() {
		Playlist listToPlay = getPlaylistToPlayFromUser();
		musicPlayer.play(listToPlay);
		runMainMenu();
	}

	/**
	 * Main Menu option 2: Allows user to choose a playlist and runs menu associated.
	 */
	public void mainMenuView() {
		
		int indexToPlayOrEdit = getUserChoicePlaylistIndex();
		runViewMenu(indexToPlayOrEdit);
		
	}
	
	/**
	 * Runs the view Menu according to selected playlist
	 * @param indexToPlayOrEdit index of selected playlist
	 */
	public void runViewMenu(int indexToPlayOrEdit) {
		displayViewMenu(indexToPlayOrEdit);	
		int viewOption = this.getUserInput();
		processViewMenu(viewOption, indexToPlayOrEdit);
	}
	
	/**
	 * Displays the chosen playlist and the menu associated.
	 * @param playlistIndex The index of the chosen playlist
	 */
	public void displayViewMenu(int playlistIndex) {

		Playlist playlistToDisplay = this.playlistHelper.getPlaylistAt(playlistIndex);
		playlistToDisplay.displayPlaylistAndSongs();
		
		System.out.println("Please select an option: ");
		System.out.println("1. Play");
		System.out.println("2. Edit");
		System.out.println("3. Back");
	}

	public void processViewMenu(int viewOption, int indexToPlayOrEdit) {
		
		switch(viewOption) {
		
		case 1:
			Playlist listToPlay = this.playlistHelper.getPlaylistAt(indexToPlayOrEdit);
			this.musicPlayer.play(listToPlay);
			this.runMainMenu();
			
			break;
			
		case 2:
			
			runEditMenu(indexToPlayOrEdit);
			break;
			
		case 3:
			
			this.runMainMenu();
			break;
			
		default:
			int nextInput = this.getValidUserInput();
			processViewMenu(nextInput, indexToPlayOrEdit);
			break;
		}
		
	}

	/**
	 * If the edit option is selected in the view menu, run the menu for editing
	 * @param indexToPlayOrEdit the index of playlist selected for edit
	 */
	public void runEditMenu(int indexToPlayOrEdit) {
		
		displayEditMenu();
		int editOption = this.getUserInput();
		processEditMenu(editOption, indexToPlayOrEdit);
	}

	public void displayEditMenu() {
		System.out.println("How would you like to edit?");
		System.out.println("1. Add Song");
		System.out.println("2. Back");
	}
	
	public void processEditMenu(int editOption, int indexToPlayOrEdit) {
		
		switch(editOption){
		
		case 1:
			
			editPlaylistAddSong(indexToPlayOrEdit);
			runMainMenu();
			
			break;
			
		case 2:
			
			mainMenuView();
			
			break;
		
		default:
			
			int nextInput = this.getValidUserInput();
			processEditMenu(nextInput, indexToPlayOrEdit);
			
			break;
		}
		
	}

	/**
	 * Get a song from a user, then add it to the program
	 * @param indexOfPlaylistToAddSong
	 */
	public void editPlaylistAddSong(int indexOfPlaylistToAddSong) {
		
		Song songToAdd = getSongFromUser();
		this.playlistHelper.addSongToPlaylistAtIndex(songToAdd, indexOfPlaylistToAddSong);

	}

	/**
	 * Main Menu option 3: Adds a new user-made playlist to the program.
	 */
	public void mainMenuAddPlaylist() {
		Playlist newPlaylist = configureNewPlaylistToAdd();
		this.playlistHelper.addPlaylist(newPlaylist);
		runMainMenu();
	}

	
	/**
	 * Prompt the user for the name of a new playlist and the first song in it
	 * @return A new playlist with the first song added
	 */
	public Playlist configureNewPlaylistToAdd() {
		
		Playlist newPlaylist = getPlaylistToAddFromUser();
		
		System.out.println("What is your first song in the new playlist?");
		Song firstSong = this.getSongFromUser();
		
		newPlaylist.addSong(firstSong);
		
		//update the "all" playlist to contain the new song
		this.playlistHelper.addSongToDefaultPlaylist(firstSong);
		
		return newPlaylist;
	}
	
	/**
	 * Prints all the current playlists, and gets user input as playlist index
	 * @return the index of playlist selected
	 */
	private int selectPlaylist() {
		playlistHelper.printAllPlaylists();
		int playlistIndex = keyboardIn.nextInt();
		this.keyboardIn.nextLine();
		return playlistIndex;
	}
	
	private int getUserInput() {

		int input = this.keyboardIn.nextInt();
		this.keyboardIn.nextLine();
		return input;

	}
	
	public int getValidUserInput() {
		System.out.println("Please input a valid option");
		int nextInput = this.getUserInput();
		return nextInput;
	}
	
	public Song getSongFromUser() {
		
		String title = getSongTitleFromUser();
		String artist = getSongArtistFromUser();
		int songLength = getSongLengthInSecondsFromUser();
		
		Song songToAdd = new Song(title, artist,songLength);
		
		return songToAdd;
	}

	public int getSongLengthInSecondsFromUser() {
		System.out.println("Enter Song Length in Seconds: ");
		int songLength = this.keyboardIn.nextInt();
		this.keyboardIn.nextLine();
		return songLength;
	}

	public String getSongArtistFromUser() {
		System.out.println("Enter Artist:");
		String artist = this.keyboardIn.nextLine();
		return artist;
	}

	public String getSongTitleFromUser() {
		System.out.println("Enter Song Title:");
		String title = this.keyboardIn.nextLine();
		return title;
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
	
	public int getUserChoicePlaylistIndex() {
		System.out.println("Please select a playlist to play or edit.");
		int indexToPlayOrEdit = selectPlaylist();
		return indexToPlayOrEdit;
	}

}
