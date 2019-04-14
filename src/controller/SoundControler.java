package controller;

import resources.Sound;

import java.util.ArrayList;

public class SoundControler {
	
	public static ArrayList<Sound> sounds = new ArrayList<Sound>();
	
	public static void loadSounds() {
    	System.out.println("Working Directory = " + System.getProperty("user.dir"));
    	String soundDir =  System.getProperty("user.dir") + "/src/resources.sounds/";

    	soundDir = "file:/" + System.getProperty("user.dir") + "/src/resources/sounds/";

    	soundDir = soundDir.replace("\\","/");
    	soundDir = soundDir.replace(" ", "%20");

    	sounds.add(new Sound(soundDir + "footsteps2.wav", "footsteps"));
    	sounds.add(new Sound(soundDir + "ThemeSong_StevevsSteve.wav", "themesong"));
    }
    
    public static Sound getSound(String name) {
    	for(Sound sound : sounds) {
    		if(sound.getName().equals(name)) {
    			return sound;
    		}
    	}
    	return null;
    }
}
