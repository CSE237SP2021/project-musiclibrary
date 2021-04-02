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
		this.addPlaylist(all);
		
		Playlist favorites = new Playlist("favorites");
		this.addPlaylist(favorites);
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
	
	public void updatePlaylistHelper(Playlist editedPlaylist, int index) {
		playlistArray.set(index, editedPlaylist);
	}
	
	public ArrayList<Playlist> getAllPlaylists() {
		return playlistArray;
	}

	public Playlist getAllSongsPlaylist() {
		return playlistArray.get(0);
	}
	
	public Playlist getPlaylistAt(int index) {
		return playlistArray.get(index);
	}
	
	public int getNumberOfPlaylists() {
		return playlistArray.size();
	}
	
}
