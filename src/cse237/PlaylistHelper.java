package cse237;

import java.util.ArrayList;

public class PlaylistHelper {
	ArrayList<Playlist> playlistArray;
	
	
	public PlaylistHelper() {
		playlistArray = new ArrayList<Playlist>();
		
		Playlist all = new Playlist("all");
		this.addPlaylist(all);
		
		Playlist favorites = new Playlist("favorites");
		this.addPlaylist(favorites);
	}
	
	// this is solely for the purpose of testing, as normal initalization has a dependency on adding playlists
	public PlaylistHelper(Boolean debug) {
		playlistArray = new ArrayList<Playlist>();
	}
	
	public void addPlaylist(Playlist newPlaylist) {
		playlistArray.add(newPlaylist);
		
	}
	
	public ArrayList<Playlist> getAllPlaylists() {
		return playlistArray;
	}

	private void updatePlaylist(Playlist editedPlaylist, int index) {
		playlistArray[index] = editedPlaylist; //TODO: fix
	}
	

}
