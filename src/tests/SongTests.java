package tests;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import cse237.Song;

class SongTests {

	@Test
	void testGetSongTitle() {
		Song testSong = new Song("Test Title", "Test Artist", 3.45);
		String songTitle = testSong.getTitle();
		assertEquals(songTitle, "Test Title");
	}
	
	@Test
	void testGetSongArtist() {
		Song testSong = new Song("Test Title", "Test Artist", 3.45);
		String songArtist = testSong.getArtist();
		assertEquals(songArtist, "Test Artist");
	}
	
	@Test
	void testGetSongLength() {
		Song testSong = new Song("Test Title", "Test Artist", 3.45);
		double songLength = testSong.getLength();
		assertEquals(songLength, 3.45);	
	}

}
