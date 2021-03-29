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
	
	public void addDefaultPlaylists() {
		Playlist all = new Playlist("all");
		Song welcome = new Song("Welcome!", "Librarians", 3);
		all.addSong(welcome);
		this.addPlaylist(all);
		
		Playlist favorites = new Playlist("favorites");
		Song myFav = new Song("myFavSong", "Me", 3);
		favorites.addSong(myFav);
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
	
	public void updatePlaylistHelper(Playlist editedPlaylist, int index) {
		playlistArray.set(index, editedPlaylist);
	}
	
	public ArrayList<Playlist> getAllPlaylists() {
		return playlistArray;
	}

	public Playlist getDefaultPlaylist() {
		return playlistArray.get(0);
	}
	
	public Playlist getPlaylistAt(int index) {
		return playlistArray.get(index);
	}
	
	public int getNumberOfPlaylists() {
		return playlistArray.size();
	}
	
}
