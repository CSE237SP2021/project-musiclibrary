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
	
	@Test
	void updatePlaylistTest() {
		PlaylistHelper playlistHelper = new PlaylistHelper();
		Playlist oldPlaylist = new Playlist("Old List");
		playlistHelper.addPlaylist(oldPlaylist);
		Playlist newPlaylist = new Playlist("New List");
		playlistHelper.updatePlaylist(newPlaylist, 2);
	}
	
	@Test
	void getDefaultPlaylistTest() {
		PlaylistHelper playlistHelper = new PlaylistHelper();
		Playlist allSongs  = playlistHelper.getDefaultPlaylist();
		assertEquals(playlistHelper.getAllPlaylists().get(0), allSongs);
	}
}
