package tests;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import cse237.Playlist;
import cse237.Song;

class PlaylistTests {

	@Test
	void testAddSong() {
		Playlist testPlaylist = new Playlist();
		Song songToAdd = new Song("Test Title", "Test Arist", 3.45);
		int numberOfSongsOnPlaylist = testPlaylist.numberOfSongs();
		assertEquals(numberOfSongsOnPlaylist, 0);
		testPlaylist.addSong(songToAdd);
		numberOfSongsOnPlaylist = testPlaylist.numberOfSongs();
		assertEquals(numberOfSongsOnPlaylist, 1);
	}

}
