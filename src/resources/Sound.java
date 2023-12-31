package resources;

import java.applet.Applet;
import java.applet.AudioClip;
import java.net.URL;

@SuppressWarnings("deprecation")
public enum Sound {
	COIN("coin"), COLLISION("collision"), DEATH("collisionpad"), START("Start"),
	NAV("Navigate");
	AudioClip value;
	/**
	 * Constructor
	 * @param str, the path of the song file
	 */
	private Sound(String str) {
		URL url = Sound.class.getResource("/"+str+".wav");
		value = Applet.newAudioClip(url);
	}
	
	/**
	 * Play a song
	 */
	public void play() {
		value.play();
	}
	
}