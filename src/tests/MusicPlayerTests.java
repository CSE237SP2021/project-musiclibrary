package tests;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import cse237.MusicPlayer;
import cse237.Playlist;
import cse237.PlaylistHelper;
import cse237.Song;

class MusicPlayerTests {

	@Test
	void initalizeMusicPlayer() {
		MusicPlayer player = new MusicPlayer();
	}

	// tests using the default all playlist
	@Test 
	void testPlayAllPlaylistMethod() {
		PlaylistHelper playlistHelper = new PlaylistHelper();
		
		Song testSong1 = new Song("Jailhouse Rock", "Orson Wells", 5);
		playlistHelper.addSongToAllSongsPlaylist(testSong1);
		Song testSong2 = new Song("Bismark Coffee", "Brigham Young", 2);
		playlistHelper.addSongToAllSongsPlaylist(testSong2);
		
		Playlist allSongsPlaylist = playlistHelper.getAllSongsPlaylist();
		assert(allSongsPlaylist.getName()=="all");
		
		MusicPlayer player = new MusicPlayer();
		player.playPlaylist(allSongsPlaylist);
		// requires reading system.out to test, just check console
		// should display Now playing: Jailhouse Rock by Orson Wells. There are 5 seconds remaining.
		// counting down
		// then the same for Now playing: Bismark Coffee by Brigham Young. There are 2 seconds remaining.
	}
	
	// uses methods to create  a new playlist in playlist helper to test from
	@Test 
	void testPlayCustomPlaylistMethod() {
		PlaylistHelper playlistHelper = new PlaylistHelper();
		
		Playlist testPlaylist = new Playlist("testPlaylist");
		// adding directly to the playlist before in the playlistHelper
		Song testSong1 = new Song("Jailhouse Rock", "Orson Wells", 5);
		testPlaylist.addSong(testSong1);
		playlistHelper.addPlaylist(testPlaylist);
		
		Song testSong2 = new Song("Bismark Coffee", "Brigham Young", 2);
		playlistHelper.addSongToPlaylistAtIndex(testSong2,2);
		
		
		Playlist playlist = playlistHelper.getPlaylistAt(2);
		assert(playlist.getName()=="testPlaylist");
		
		MusicPlayer player = new MusicPlayer();
		player.playPlaylist(playlist);
		// requires reading system.out to test, just check console
		// should display Now playing: Jailhouse Rock by Orson Wells. There are 5 seconds remaining.
		// counting down
		// then the same for Now playing: Bismark Coffee by Brigham Young. There are 2 seconds remaining.
	}
}
