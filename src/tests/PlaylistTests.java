package tests;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import cse237.Playlist;
import cse237.Song;

class PlaylistTests {

	@Test
	void testAddSong() {
		Playlist testPlaylist = new Playlist("My Playlist");
		Song songToAdd = new Song("Test Title", "Test Arist", 120);
		int numberOfSongsOnPlaylist = testPlaylist.numberOfSongs();
		assertEquals(numberOfSongsOnPlaylist, 0);
		testPlaylist.addSong(songToAdd);
		numberOfSongsOnPlaylist = testPlaylist.numberOfSongs();
		assertEquals(numberOfSongsOnPlaylist, 1);
	}
	
	@Test
	void testGetPlaylistName() {
		Playlist testPlaylist = new Playlist("My Playlist");
		String playlistName = testPlaylist.getName();
		assertEquals(playlistName, "My Playlist");
	}
	
	@Test
	void testGetPlaylistDescription() {
		Playlist testPlaylist = new Playlist("My Playlist");
		String playlistDesc = testPlaylist.getDescription();
		assertEquals(playlistDesc, "");
	}
	
	@Test
	void testAddDescription() {
		Playlist testPlaylist = new Playlist("My Playlist");
		String playlistDescription = "This is my first playlist with my favorite songs";
		testPlaylist.addDescription(playlistDescription);
		String newDescription = testPlaylist.getDescription();
		assertEquals(newDescription, playlistDescription);
	}
	
	@Test
	void testGetPlaytime() {
		Playlist testPlaylist = new Playlist("My Playlist");
		Song firstSong = new Song("First Title", "First Arist", 120);
		Song secondSong = new Song("Second Title", "Second Artist", 312);
		Song thirdSong = new Song("Third Title", "Third Artist", 245);
		testPlaylist.addSong(firstSong);
		testPlaylist.addSong(secondSong);
		testPlaylist.addSong(thirdSong);
		int playtime = testPlaylist.getPlaytime();
		assertEquals(playtime, 677);
		
	}
	
	

}
