package audio_players;

import java.io.File;

import javax.sound.sampled.AudioFileFormat;
import javax.sound.sampled.AudioFormat;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.DataLine;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.TargetDataLine;

import javafx.scene.control.TextArea;

public class Sound {
	
	
	
	private TargetDataLine targetLine;
	public String filename;
	
	
	public Sound() {
		
		this.targetLine = null;
		
		
	}
	

	public void soundFormat(TextArea area) throws LineUnavailableException {
		
		
		try {
		
		AudioFormat format = new AudioFormat(AudioFormat.Encoding.PCM_SIGNED, 44100, 16, 2, 4, 44100, false);
		
		
		DataLine.Info info = new DataLine.Info(TargetDataLine.class, format);
		
		if(!AudioSystem.isLineSupported(info)) {
			
			System.err.println("Line is not supported");
			
		}
	
		this.targetLine = (TargetDataLine) AudioSystem.getLine(info);
		this.targetLine.open();
		
		area.appendText("Started Recording\n");
		targetLine.start();
		
		}
		
		catch(LineUnavailableException lue) {
			
			lue.printStackTrace();
			
		}
		
	}

	
	public void start(String name, TextArea area) throws InterruptedException {
		
		try {

		Thread thread = new Thread() {
	    String temp = name;
	    //String fileName;
			
		 public void run()  {
				
				AudioInputStream audioStream = new AudioInputStream(targetLine);
				String fileName;
				fileName = temp + ".wav";
				
				
				File audioFile = new File("TalkBox/Audio/" + fileName);
				
				area.appendText("The Recording is being saved as: ");
				area.appendText(filename);
				//System.out.println("The recording is being saved as:");
				
			//	System.out.println(fileName);
				try {
					
					AudioSystem.write(audioStream, AudioFileFormat.Type.WAVE, audioFile);

				}
				catch(Exception ioe) {
					
					ioe.printStackTrace();
				}
				area.appendText("\nStopped Recording");
				//System.out.println("Stopped Recording");
				
				
			}
		 	
		 
		};
		
		this.filename=name;
		thread.start();
		area.appendText("\nRecording");
		}
		catch(Exception ie) {
			
			ie.printStackTrace();
		}
		
	}
	
	public void stop(TextArea area) {	
		this.targetLine.stop();
		this.targetLine.close();
	}
	
	public String getFileName() {
		
		return this.filename;
	}
	
	public TargetDataLine getTargetLine() {
		
		return this.targetLine;
	}
	
}	