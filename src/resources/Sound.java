package resources;

import javafx.scene.media.AudioClip;

public class Sound {

	private String name;
	private AudioClip clip;
	private double volume = 1;
	
	public Sound(String path, String name) {
		this.name = name;
		this.clip = new AudioClip(path);
	}
	
	public boolean isActive() {
		return clip.isPlaying();
	}
	
	public void play() {
		if(!clip.isPlaying()) {
			clip.play(volume);
		}
	}
	
	public void stop() {
		if(clip.isPlaying()) {
			clip.stop();
		}
	}
	public void startLoop() {
		clip.setCycleCount(999999);
		clip.play(volume);
	}
	
	public void stopLoop() {
		clip.setCycleCount(1);
		clip.stop();
	}
	
	public String getName() {
		return name;
	}
	
	public void changeVolume(int volume) {
		this.volume = volume;
	}
}
