package tests;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import cse237.Song;

class SongTests {

	@Test
	void testGetSongTitle() {
		Song testSong = new Song("Test Title", "Test Artist", 120);
		String songTitle = testSong.getTitle();
		assertEquals(songTitle, "Test Title");
	}
	
	@Test
	void testGetSongArtist() {
		Song testSong = new Song("Test Title", "Test Artist", 120);
		String songArtist = testSong.getArtist();
		assertEquals(songArtist, "Test Artist");
	}
	
	@Test
	void testGetSongLength() {
		Song testSong = new Song("Test Title", "Test Artist", 120);
		double songLength = testSong.getLength();
		assertEquals(songLength, 120);	
	}
	
	@Test
	void testGeFormattedLength() {
		Song testSong = new Song("Test Title", "Test Artist", 137);
		String formattedLength = testSong.getFormattedLength();
		assertEquals(formattedLength, "2 minutes 17 seconds");	
	}

}
