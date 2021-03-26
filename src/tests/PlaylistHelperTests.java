package tests;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import cse237.Playlist;
import cse237.PlaylistHelper;

class PlaylistHelperTests {

	@Test
	// tests for basic initalization, no inital all and favorites playlists
	void buildPlaylistHelperTest() {
		PlaylistHelper playlistHelper = new PlaylistHelper(true);
	}

	@Test
	void addPlaylistTest() {
		PlaylistHelper playlistHelper = new PlaylistHelper(true);
		Playlist newPlaylist = new Playlist("test");
		playlistHelper.addPlaylist(newPlaylist);
		
	}
		
	@Test
	void getPlaylistsTest() {
		PlaylistHelper playlistHelper = new PlaylistHelper();
		Playlist newPlaylist = new Playlist("test");
		playlistHelper.addPlaylist(newPlaylist);
		ArrayList<Playlist> playlists = playlistHelper.getAllPlaylists();
		assertEquals(playlists.get(0).getName(),"all");
	}
	
	// standard initalization with all and favorite playlist
	@Test
	void buildPlaylistHelperStandardTest() {
		PlaylistHelper playlistHelper = new PlaylistHelper();
		ArrayList<Playlist> playlists = playlistHelper.getAllPlaylists();
		assertEquals(playlists.get(0).getName(),"all");
		assertEquals(playlists.get(1).getName(),"favorites");
	}
}
