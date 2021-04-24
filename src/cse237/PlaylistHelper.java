package cse237;

import java.util.ArrayList;

public class PlaylistHelper {
	
	ArrayList<Playlist> playlistArray;
	
	public PlaylistHelper() {
		
		playlistArray = new ArrayList<Playlist>();
		addDefaultPlaylists();
	}
	
	// this is solely for the purpose of testing, as normal initialization has a dependency on adding playlists
	public PlaylistHelper(Boolean debug) {
		playlistArray = new ArrayList<Playlist>();
	}
	
	public void addPlaylist(Playlist newPlaylist) {
		playlistArray.add(newPlaylist);
	}
	
	/**
	 * The program has two default playslists: one with all the songs, one with the "favorite" songs
	 */
	public void addDefaultPlaylists() {
		Playlist all = new Playlist("all");
		all.addDescription("Contains all songs from all playlists");
		this.addPlaylist(all);
		
		Playlist favorites = new Playlist("favorites");
		favorites.addDescription("Contains all favorited songs");
		this.addPlaylist(favorites);
	}

	public void deletePlaylistAt(int indexOfPlaylistToDelete) {
		if (indexOfPlaylistToDelete >= 2) {
			this.playlistArray.remove(indexOfPlaylistToDelete);
		} else {
			System.out.println("\nDefault playlists \"all songs\" and \"favorites\" cannot be deleted");			
		}
	}
	
	// no test cases due to it being print style
	public void printAllPlaylists() {
		
		System.out.println("Current Playlists: ");
		
		for (int i = 0; i < playlistArray.size(); i++) {
			
			Playlist playlistAtIndex = playlistArray.get(i);
            System.out.println(i+": "+playlistAtIndex.getName());
            
        }
	}
	
	/**
	 * Gets a random index from the all songs playlist
	 * helper method for creating random playlist
	 * @return random index from all songs playlist
	 */
	public int getRandomIndexFromAllSongs() {
		Playlist allSongs = getAllSongsPlaylist();
		int min = 0;
		int max = allSongs.getNumberOfSongs()- 1;
		int randomInt = (int)Math.floor(Math.random() * (max-min+1) + min);
		return randomInt;
	}
	
	/**
	 * Gets a random song from all songs playlist
	 * @return random Song from all songs
	 */
	public Song getRandomSongFromAllSongs() {
		int randomIndex = getRandomIndexFromAllSongs();
		return getSongFromAllSongsAtIndex(randomIndex);
	}
	
	/**
	 * Add a song to one of the playlists, and update the default "all" playlist
	 * @param songToAdd
	 * @param playlistIndex
	 */
	public void addSongToPlaylistAtIndex(Song songToAdd, int playlistIndex) {
		
		Playlist playlistToEdit = this.getPlaylistAt(playlistIndex);
		playlistToEdit.addSong(songToAdd);
		this.updatePlaylistHelper(playlistToEdit, playlistIndex);
		
		if (playlistIndex > 0) {
			
			addSongToAllSongsPlaylist(songToAdd);
		}
	}

	public void addSongToAllSongsPlaylist(Song songToAdd) {
		
		Playlist newAllPlaylist = this.getAllSongsPlaylist();
		newAllPlaylist.addSong(songToAdd);
		this.updatePlaylistHelper(newAllPlaylist, 0);
		
	}
	
	/**
	 * Get a specified song from all songs playlist
	 * @param index of song to get from playlist
	 * @return song at that index
	 */
	public Song getSongFromAllSongsAtIndex(int index) {
		Playlist allSongs = this.getAllSongsPlaylist();
		Song defaultSong =  new Song("Default", "Default", 5);
		if(index<allSongs.getNumberOfSongs()) {
			return allSongs.getSongAt(index);
		}
		return defaultSong;
	}
	
	/**
	 * Delete a song from one of the playlists, and update the default "all songs" playlist
	 * @param songToDelete
	 * @param playlistIndex
	 */
	public void deleteSongFromPlaylistAtIndex(Song songToDelete, int playlistIndex) {
		
		Playlist playlistToEdit = this.getPlaylistAt(playlistIndex);
		playlistToEdit.removeSong(songToDelete);
		this.updatePlaylistHelper(playlistToEdit, playlistIndex);
		
		if (playlistIndex > 0) {
			
			addSongToAllSongsPlaylist(songToDelete);
		}
	}
	
	public void deleteSongFromAllSongsPlaylist(Song songToDelete) {
		Playlist newAllPlaylist = this.getAllSongsPlaylist();
		newAllPlaylist.removeSong(songToDelete);
		this.updatePlaylistHelper(newAllPlaylist, 0);
	}
	
	/**
	 * Adds the given song to the default "favorites" and "all songs" playlists
	 * @param songToAdd
	 */
	public void addSongToFavoritesHelper(Song songToAdd) {
		Playlist newFavorites = this.getFavoritesPlaylist();
		newFavorites.addSong(songToAdd);
		this.updatePlaylistHelper(newFavorites, 1);
	}
	
	public void updatePlaylistHelper(Playlist editedPlaylist, int index) {
		playlistArray.set(index, editedPlaylist);
	}
	
	public ArrayList<Playlist> getAllPlaylists() {
		return playlistArray;
	}

	public Playlist getAllSongsPlaylist() {
		return playlistArray.get(0);
	}
	
	public Playlist getFavoritesPlaylist() {
		return playlistArray.get(1);
	}
	
	public Playlist getPlaylistAt(int index) {
		return playlistArray.get(index);
	}
	
	public int getNumberOfPlaylists() {
		return playlistArray.size();
	}
	
}
