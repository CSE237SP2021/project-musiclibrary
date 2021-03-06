package cse237;

import java.util.Scanner;

public class MusicLibrary {
	
	private Scanner keyboardIn;
	private PlaylistHelper playlistHelper;
	private MusicPlayer musicPlayer;
	
	public MusicLibrary() {
		
		this.keyboardIn = new Scanner(System.in);
		this.playlistHelper = new PlaylistHelper();
		this.musicPlayer = new MusicPlayer();
		
	}

	public static void main(String[] args) {
		
		System.out.println("Welcome to Music Library!");
		
		MusicLibrary musicLibrary = new MusicLibrary(); 
		musicLibrary.runMainMenu();
		
	}
	
	
	private void runMainMenu() {
		displayMainMenu();
		int selectedOption = this.getIntFromUser();
		processMainMenu(selectedOption);
	}
	
	private void displayMainMenu() {
		System.out.println("\n---Main Menu---");
		playlistHelper.printAllPlaylists();
		System.out.println("\nPlease select an option: ");
		System.out.println("1. Play an existing playlist");
		System.out.println("2. View an existing playlist to Play or Edit");
		System.out.println("3. Add a new playlist");
		System.out.println("4. Delete an existing playlist");
		System.out.println("5. Create a random playlist");
		System.out.println("6. Quit Music Library");
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
			mainMenuDeletePlaylist();
			break;
		case 5:
			createRandomPlaylist();
			break;
		case 6:
			System.out.println("\nThank you for using Music Library");
			System.exit(0);
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
		runPlayMenu(listToPlay);
	}
	
	public void runPlayMenu(Playlist listToPlay) {
		displayPlayMenu();
		int selectedOption = this.getIntFromUser();
		processPlayMenu(selectedOption, listToPlay);
	}
	
	public void displayPlayMenu() {
		System.out.println("\n~~~Now Playing~~~");
		System.out.println("Please select an option: ");
		System.out.println("1. Start Listening");
		System.out.println("2. Play a new random song from the playlist");
		System.out.println("3. Go back to the Main Menu");
		System.out.println("4. Quit Music Library");
	}
	
	public void processPlayMenu(int selectedOption, Playlist listToPlay) {
		
		switch(selectedOption) {
		
		//"Start Listening"
		case 1:	 
			musicPlayer.playPlaylist(listToPlay, keyboardIn);
			runPlayMenu(listToPlay);
			break;
		
		//"Play a new random song from the playlist"
		case 2:
			musicPlayer.shuffle(listToPlay);
			runPlayMenu(listToPlay);
			break;
		
		//"Go back to the Main Menu"
		case 3:
			runMainMenu();
			break;
		
		//"Quit Music Library"
		case 4:
			System.out.println("\nThank you for using Music Library");
			System.exit(0);
			
			break;
			
		default:
			int nextInput = getValidUserInput();
			this.processMainMenu(nextInput);
			break;
		}
		
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
		int viewOption = this.getIntFromUser();
		processViewMenu(viewOption, indexToPlayOrEdit);
	}
	
	/**
	 * Displays the chosen playlist and the menu associated.
	 * @param playlistIndex The index of the chosen playlist
	 */
	public void displayViewMenu(int playlistIndex) {

		Playlist playlistToDisplay = this.playlistHelper.getPlaylistAt(playlistIndex);
		playlistToDisplay.displayPlaylistAndSongs();
		
		System.out.println("\nPlease select an option: ");
		System.out.println("1. Play");
		System.out.println("2. Edit");
		System.out.println("3. Back");
	}

	public void processViewMenu(int viewOption, int indexToPlayOrEdit) {
		
		switch(viewOption) {
		
		case 1:
			Playlist listToPlay = this.playlistHelper.getPlaylistAt(indexToPlayOrEdit);
			runPlayMenu(listToPlay);
			break;
			
		case 2:
			
			runEditMenu(indexToPlayOrEdit);
			break;
			
		case 3:
			
			runMainMenu();
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
		int editOption = this.getIntFromUser();
		processEditMenu(editOption, indexToPlayOrEdit);
	}

	public void displayEditMenu() {
		System.out.println("\nHow would you like to edit?");
		System.out.println("1. Add Songs");
		System.out.println("2. Delete Song");
		System.out.println("3. Add Song to Favorites");
		System.out.println("4. Back");
	}
	
	public void processEditMenu(int editOption, int indexToPlayOrEdit) {
		
		switch(editOption){
		
		case 1:
			
			editPlaylistAddSong(indexToPlayOrEdit);
			break;
			
		case 2:
			
			editPlaylistDeleteSong(indexToPlayOrEdit);
			break;
			
		case 3:
			
			addSongToFavoritesPlaylist(indexToPlayOrEdit);
			runViewMenu(indexToPlayOrEdit);
			break;
		
		case 4:
			mainMenuView();
			break;
		
		default:
			
			int nextInput = this.getValidUserInput();
			processEditMenu(nextInput, indexToPlayOrEdit);
			
			break;
		}
		
	}

	/**
	 * Let user select a song from the given playlist to delete
	 * @param playlistIndex
	 */
	public void editPlaylistDeleteSong(int playlistIndex) {
		
		Playlist playlistToDeleteFrom = this.playlistHelper.getPlaylistAt(playlistIndex);
		
		if (playlistToDeleteFrom.getNumberOfSongs() < 1) {
			System.out.println("\nPlaylist empty; no songs to delete!");
		} else {
			Song songToDelete = getUserChoiceSongFromPlaylist(playlistToDeleteFrom);
			this.playlistHelper.deleteSongFromPlaylistAtIndex(songToDelete, playlistIndex);
			runDeleteAnotherSongMenu(playlistIndex);
		}
		
	}

	public void runDeleteAnotherSongMenu(int playlistIndex) {
		displayDeleteAnotherSongMenu();
		int input = this.getIntFromUser();
		processDeleteAnotherSongMenu(playlistIndex, input);
	}

	public void displayDeleteAnotherSongMenu() {
		System.out.println("\nWould you like to delete another song?");
		System.out.println("1. Yes");
		System.out.println("2. No");
	}

	public void processDeleteAnotherSongMenu(int playlistIndex, int input) {
		switch(input) {
		case 1:
			editPlaylistDeleteSong(playlistIndex);
			break;
		case 2:
			runViewMenu(playlistIndex);
			break;
		default:
			int newInput = this.getValidUserInput();
			processDeleteAnotherSongMenu(playlistIndex, newInput);
			break;
		}
	}


	/**
	 * Get a song from a user, then add it to the program
	 * @param indexOfPlaylistToAddSong
	 */
	public void editPlaylistAddSong(int indexOfPlaylistToAddSong) {
		this.keyboardIn.nextLine();
		Song songToAdd = getSongFromUser();
		this.playlistHelper.addSongToPlaylistAtIndex(songToAdd, indexOfPlaylistToAddSong);
		runAddAnotherSongMenu(indexOfPlaylistToAddSong);
		
	}

	public void runAddAnotherSongMenu(int indexOfPlaylistToAddSong) {
		displayAddAnotherSongMenu();
		int input = this.getIntFromUser();
		processAddAnotherSongMenu(indexOfPlaylistToAddSong, input);
	}

	public void displayAddAnotherSongMenu() {
		System.out.println("\nWould you like to add another song?");
		System.out.println("1. Yes");
		System.out.println("2. No");
	}

	public void processAddAnotherSongMenu(int indexOfPlaylistToAddSong, int input) {
		switch(input) {
		case 1:
			editPlaylistAddSong(indexOfPlaylistToAddSong);
			break;
		case 2:
			runViewMenu(indexOfPlaylistToAddSong);
			break;
		default:
			int newInput = this.getValidUserInput();
			processAddAnotherSongMenu(indexOfPlaylistToAddSong, newInput);
			break;
		}
	}
	
	/**
	 * Get a song from a user, selected from the current playlist, then add it to the favorites
	 * @param indexToAddToPlaylist
	 */
	public void addSongToFavoritesPlaylist(int playlistIndex) {
		
		Playlist playlistToEdit = this.playlistHelper.getPlaylistAt(playlistIndex);
		
		if (playlistToEdit.getNumberOfSongs()<1 ) {
			System.out.println("\nPlaylist empty; no songs to favorite");
		} else {
			Song songToFavorite = this.getUserChoiceSongFromPlaylist(playlistToEdit);
			this.playlistHelper.addSongToFavoritesHelper(songToFavorite);
		}
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
		runConfigureNewPlaylistMenu(newPlaylist);
		return newPlaylist;
	}

	public void runConfigureNewPlaylistMenu(Playlist newPlaylist) {
		displayConfigureNewPlaylistMenu();
		int input = this.getIntFromUser();
		processConfigureNewPlaylistMenu(newPlaylist, input);
	}
	
	public void displayConfigureNewPlaylistMenu() {
		System.out.println("\nWould you like to add songs to your playlsit?");
		System.out.println("1. Yes");
		System.out.println("2. No");
	}
	
	public void processConfigureNewPlaylistMenu(Playlist newPlaylist, int input) {
		switch(input) {
		case 1:
			addInitialSongs(newPlaylist);
			break;
		case 2:
			System.out.println("\nThe new playlist contains 0 songs!");
			break;
		default:
			int newInput = this.getValidUserInput();
			this.processConfigureNewPlaylistMenu(newPlaylist, newInput);
			break;
		}
	}

	

	public void addInitialSongs(Playlist initialPlaylist) {
		
		Song songToAdd = this.getSongFromUser();
		initialPlaylist.addSong(songToAdd);
		this.playlistHelper.addSongToAllSongsPlaylist(songToAdd); //update 'all songs' playlist
		
		addAnotherSongToInitialPlaylist(initialPlaylist);
		
	}

	public void addAnotherSongToInitialPlaylist(Playlist initialPlaylist) {
		this.displayAddAnotherSongMenu();
		int input = this.getIntFromUser();
		processAddSongsToInitalPlaylistMenu(initialPlaylist, input);
	}

	public void processAddSongsToInitalPlaylistMenu(Playlist initialPlaylist, int input) {
		switch(input) {
		case 1: 
			this.addInitialSongs(initialPlaylist);
			break;
		case 2:
			break;
		default:
			int newInput = this.getValidUserInput();
			this.processAddSongsToInitalPlaylistMenu(initialPlaylist, newInput);
			break;
		}
	}
	
	/**
	 * Main menu option 4: delete an existing user-made playlist
	 */
	public void mainMenuDeletePlaylist() {
		if (this.playlistHelper.getNumberOfPlaylists()<=2) {
			System.out.println("\nDefault playlists \"all songs\" and \"favorites\" cannot be deleted");			
		} else {
			System.out.println("\nPlease select a playlist to delete: ");
			int indexOfPlaylistToDelete = this.selectPlaylist();
			this.playlistHelper.deletePlaylistAt(indexOfPlaylistToDelete);
		}
		runMainMenu();
	}
	
	/**
	 * Main menu option 5: create a random playlist based on user input
	 */
	public void createRandomPlaylist() {
		int length = getLengthFromUser();
		Playlist random =  getUserInputForRandomPlaylist(length);
		this.playlistHelper.addPlaylist(random);
		int indexOfPlaylist = playlistHelper.getNumberOfPlaylists()-1;
		generateRandomPlaylist(length, indexOfPlaylist);
		runMainMenu();
	}
	
	/**
	 * 
	 * @param length of the random playlist
	 * @return random playlist with user specified length and title
	 */
	public Playlist getUserInputForRandomPlaylist(int length) {
		String title = getTitleFromUser();
		Playlist random = new Playlist(title);
		return random;
	}
	
	/**
	 * Forms random playlist
	 * @param length of playlist to construct
	 * @param indexOfPlaylist in list of playlists
	 */
	public void generateRandomPlaylist(int length, int indexOfPlaylist) {
		for(int i = 0; i<length; ++i) {
			Song songToAdd = playlistHelper.getRandomSongFromAllSongs();
			playlistHelper.addSongToPlaylistAtIndex(songToAdd, indexOfPlaylist);
		}
	}
	
	/**
	 * Asks user for length of their random playlist
	 * @return the length of the  playlist
	 */
	public int getLengthFromUser() {
		System.out.println("How long would you like your random playlist to be?");
		int length = this.getIntFromUser();
		return length;
	}
	
	/**
	 * Asks the user for title to name their playlist
	 * @return title of playlist
	 */
	public String getTitleFromUser() {
		System.out.println("What would you like your random playlist to be called?");
		keyboardIn.nextLine();
		String title = keyboardIn.nextLine();
		return title;
	}
	
	/**
	 * Prints all the current playlists, and gets user input as playlist index
	 * @return the index of playlist selected
	 */
	private int selectPlaylist() {
		playlistHelper.printAllPlaylists();
		int numOfPlaylist = playlistHelper.getNumberOfPlaylists();
		int playlistIndex = this.getIntFromUser();
		while(playlistIndex>=numOfPlaylist) {
			System.out.println("This isn't a valid playlist, please enter again:");
			playlistIndex = this.getIntFromUser();
		}
		return playlistIndex;
	}
	
	// might warrant a rename if we want non integers as a user input
	private int getIntFromUser() {
		while (!this.keyboardIn.hasNextInt()) {
	        System.out.println("That's not a number, please enter a number again:");
	        this.keyboardIn.next(); // this is important!
	    }
		
		int input = this.keyboardIn.nextInt();
		return input;

	}
	
	public int getValidUserInput() {
		System.out.println("\nPlease input a valid option");
		int nextInput = this.getIntFromUser();
		return nextInput;
	}
	
	public Song getSongFromUser() {
		String title = getSongTitleFromUser();
		String artist = getSongArtistFromUser();
		int songLength = getSongLengthInSecondsFromUser();
		
		Song songToAdd = new Song(title, artist,songLength);
		
		return songToAdd;
	}
	
	public String getSongTitleFromUser() {
		System.out.println("\nEnter Song Title:");
		String title = this.keyboardIn.next();
		title = title + this.keyboardIn.nextLine();
		return title;
	}
	
	public String getSongArtistFromUser() {
		System.out.println("\nEnter Artist:");
		String artist = this.keyboardIn.next();
		artist = artist + this.keyboardIn.nextLine();
		return artist;
	}
	public int getSongLengthInSecondsFromUser() {
		System.out.println("\nEnter Song Length in Seconds: ");
		int songLength = this.getIntFromUser();
		return songLength;
	}

	


	
	public Playlist getPlaylistToAddFromUser() {
		System.out.println("\nPlease enter the name of the new playlist: ");
		// weird bug, unsure where it is triggered from but fixed by this (refrence issue 108)
		this.keyboardIn.nextLine();
		String newPlaylistName = this.keyboardIn.nextLine();
		Playlist newPlaylist = new Playlist(newPlaylistName);
		return newPlaylist;
	}

	public Playlist getPlaylistToPlayFromUser() {
		System.out.println("\nWhich playlist would you like to play?");
		int indexToPlay = selectPlaylist();
		Playlist listToPlay = playlistHelper.getPlaylistAt(indexToPlay);
		return listToPlay;
	}
	
	public int getUserChoicePlaylistIndex() {
		System.out.println("\nPlease select a playlist to play or edit.");
		int indexToPlayOrEdit = selectPlaylist();
		return indexToPlayOrEdit;
	}
	
	public Song getUserChoiceSongFromPlaylist(Playlist playlistToGetSongFrom) {
		
		System.out.println("\nPlease select a song: ");
		playlistToGetSongFrom.displayPlaylistAndSongs();
		
		int indexOfSong = this.getIntFromUser();
		
		while(indexOfSong >= playlistToGetSongFrom.getNumberOfSongs()) {
			System.out.println("\nPlease input a valid index:");
			indexOfSong = this.getIntFromUser();
		}
		
		Song songToDelete = playlistToGetSongFrom.getSongAt(indexOfSong);
		return songToDelete;
	}

}
