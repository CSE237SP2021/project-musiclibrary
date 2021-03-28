package cse237;
import java.util.Collections;


public class MusicPlayer {

	private Playlist nowPlaying;
	private int songTimeElapsed;
	private boolean paused;
	
	public MusicPlayer(Playlist selected) {
		this.nowPlaying = selected;
	}
}
