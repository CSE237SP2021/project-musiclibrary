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
		int numberOfPlaylists = playlistHelper.getNumberOfPlaylists();
		assertEquals(numberOfPlaylists, 0);
	}

	@Test
	void addPlaylistTest() {
		PlaylistHelper playlistHelper = new PlaylistHelper();
		Playlist newPlaylist = new Playlist("test");
		playlistHelper.addPlaylist(newPlaylist);
		Playlist playListAtIndexTwo = playlistHelper.getPlaylistAt(2);
		assertEquals(playListAtIndexTwo, newPlaylist);
	}
		
	@Test
	void getAllPlaylistsTest() {
		PlaylistHelper playlistHelper = new PlaylistHelper();
		
		Playlist newPlaylist = new Playlist("test");
		playlistHelper.addPlaylist(newPlaylist);
		
		ArrayList<Playlist> playlists = playlistHelper.getAllPlaylists();
		Playlist playlistOne = playlists.get(0);
		Playlist playlistTwo = playlists.get(1);
		Playlist playlistThree = playlists.get(2);
		
		assertEquals(playlistOne.getName(),"all");
		assertEquals(playlistTwo.getName(), "favorites");
		assertEquals(playlistThree.getName(), "test");
	}
	
	// standard initalization with all and favorite playlist
	@Test
	void buildPlaylistHelperStandardTest() {
		
		PlaylistHelper defaultPlaylistHelper = new PlaylistHelper();
		
		PlaylistHelper testPlaylistHelper = new PlaylistHelper(true);
		Playlist all = new Playlist("all");
		Playlist favorites = new Playlist ("favorites");
		testPlaylistHelper.addPlaylist(all);
		testPlaylistHelper.addPlaylist(favorites);
		
		Playlist defaultOne = defaultPlaylistHelper.getPlaylistAt(0);
		Playlist testOne = testPlaylistHelper.getPlaylistAt(0);
		String defaultOneName = defaultOne.getName();
		String testOneName = testOne.getName();
		
		Playlist defaultTwo = defaultPlaylistHelper.getPlaylistAt(1);
		Playlist testTwo = defaultPlaylistHelper.getPlaylistAt(1);
		String defaultTwoName = defaultTwo.getName();
		String testTwoName = testTwo.getName();
		
		assertEquals(defaultOneName, testOneName);
		assertEquals(defaultTwoName, testTwoName);
	}
	
	@Test
	void updatePlaylistTest() {
		PlaylistHelper playlistHelper = new PlaylistHelper();
		Playlist oldPlaylist = new Playlist("Old List");
		playlistHelper.addPlaylist(oldPlaylist);
		Playlist newPlaylist = new Playlist("New List");
		playlistHelper.updatePlaylist(newPlaylist, 2);
		Playlist PlayListAtIndexTwo = playlistHelper.getPlaylistAt(2);
		assertEquals(PlayListAtIndexTwo.getName(), "New List");
	}
	
	@Test
	void getDefaultPlaylistTest() {
		PlaylistHelper playlistHelper = new PlaylistHelper();
		Playlist allSongs  = playlistHelper.getDefaultPlaylist();
		ArrayList<Playlist> playlists = playlistHelper.getAllPlaylists();
		assertEquals(playlists.get(0), allSongs);
	}
	
	@Test
	void getPlaylistAtTest() {
		PlaylistHelper playlistHelper = new PlaylistHelper();
		Playlist playlistAtIndexOne = playlistHelper.getPlaylistAt(1);
		ArrayList<Playlist> playlists = playlistHelper.getAllPlaylists();
		assertEquals(playlists.get(1), playlistAtIndexOne);
	}
	
	@Test
	void getNumberOfPlaylists() {
		PlaylistHelper playlistHelper = new PlaylistHelper();
		int defaultNumberOfPlaylists = playlistHelper.getNumberOfPlaylists();
		assertEquals(defaultNumberOfPlaylists, 2);
	}
}
