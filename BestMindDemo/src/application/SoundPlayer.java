package application;

import java.io.File;

import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.Mixer;



public class SoundPlayer {
	
	

   // System.out.println(String.format("Name [%s]\n", info.getName()));
   // System.out.println(info.getDescription());
	public static void play() {
		try {
	    	Mixer.Info[] mixerInfo = AudioSystem.getMixerInfo();
	        Mixer.Info info = mixerInfo[2]; //Edit this number to select output // 0 = Default
	        Clip clip = AudioSystem.getClip(info);
	        clip.open(AudioSystem.getAudioInputStream(new File("/home/grabowsky/git/BestMindDemo/Resources/Sound/bgMusic.wav")));
	        clip.start();
	    } catch (Exception e) {
	    	System.out.println(e);
	    }
	}
    


}
