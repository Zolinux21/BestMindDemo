package application;

import java.io.File;
import java.io.IOException;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.FloatControl;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.Mixer;
import javax.sound.sampled.UnsupportedAudioFileException;



public class SoundPlayer {
	
	public static enum sound{
		BACKGROUND,
		LOSE,
		WIN,
		HELP,
		DONE,
		DOOR,
	}
	
	
	public static void play(SoundPlayer.sound selectSound) {
		
		switch(selectSound) {
		case BACKGROUND:
			subPlayer("/home/grabowsky/git/Resources/Sound/BACKGROUND.wav", 100);
			break;
		case LOSE:
			subPlayer("/home/grabowsky/git/Resources/Sound/LOSE.wav", 50);
			break;
		case WIN:
			subPlayer("/home/grabowsky/git/Resources/Sound/WIN.wav", 50);
			break;
		case HELP:
			subPlayer("/home/grabowsky/git/Resources/Sound/HELP.wav", 50);
			break;
		case DONE:
			subPlayer("/home/grabowsky/git/Resources/Sound/DONE.wav", 50);
			break;
		case DOOR:
			subPlayer("/home/grabowsky/git/Resources/Sound/DOOR.wav", 50);
			break;
		default:
			break;			
		}
	}
	
	private static void subPlayer(String filePath, int volume) {
		try {
	    	Mixer.Info[] mixerInfo = AudioSystem.getMixerInfo();
	        Mixer.Info info = mixerInfo[2]; //Edit this number to select output // 0 = Default
	   //     Clip c = GetAudioClip(filePath);
	        GetAudioClip(filePath, volume).start();
	    } catch (Exception e) {
	    	System.out.println(e);
	    }
	}
    
	public static Clip GetAudioClip(String path, int volume)
	{
		File audioFile = new File(path);
		if (!audioFile.exists())
		{
			return null;
		}

		try (AudioInputStream audioStream = AudioSystem.getAudioInputStream(audioFile))
		{
			Clip audioClip = AudioSystem.getClip();
			audioClip.open(audioStream);
			FloatControl gainControl = (FloatControl) audioClip.getControl(FloatControl.Type.MASTER_GAIN);
			float gainValue = (((float) volume) * 40f / 100f) - 35f;
			gainControl.setValue(gainValue);

			return audioClip;
		}
		catch (IOException | LineUnavailableException | UnsupportedAudioFileException e)
		{
			System.out.println("Error opening audiostream from " );//+  audioFile, e);
			return null;
		}
	}
	
	
	///////////////////////////////////////////////////////////////////////
	///////////////////////////////////////////////////////////////////////
	/*
	private static void subPlayer(String filePath, int volume) {
		try {
	    	Mixer.Info[] mixerInfo = AudioSystem.getMixerInfo();
	        Mixer.Info info = mixerInfo[2]; //Edit this number to select output // 0 = Default
	        Clip clip = AudioSystem.getClip(info);
	        clip.open(AudioSystem.getAudioInputStream(new File(filePath)));
	        clip.start();
	        
	    } catch (Exception e) {
	    	System.out.println(e);
	    }
	}
	*/

}
