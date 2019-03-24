package io;


import java.io.File;
import java.io.FileInputStream;
import java.io.FilenameFilter;
import java.io.IOException;
import java.util.ArrayList;



public class AudioFileIO {

	
	
	public static final  String WAV_FILE_PATH = "TalkBox/";
	
	ArrayList<String> audioNames;
	
	
	
	
	
	public AudioFileIO() {

		
		this.audioNames = new ArrayList<String>();
	}
	
	
	

	public ArrayList<String> getAudioNames() throws IOException {

		try {
			
			for (File temp : this.getWavFiles(WAV_FILE_PATH)) {
				
				StringBuilder sb = new StringBuilder();
				
				sb.append(temp.getName());
				
				sb = removeFileExtension(sb);
				
				this.audioNames.add(sb.toString());
			}
		}
		catch(Exception e) {
			
			e.printStackTrace();
		}

		
		
		return this.audioNames;
	}

	
	
	
	
	private StringBuilder removeFileExtension(StringBuilder sb) {
		
		
		return sb.delete(sb.length() - 4, sb.length()); 
	}
	
	
	
	/**
	 * 
	 * @return all the wav audio files in the given directory.
	 */
	public File[] getWavFiles(String dirName) throws IOException {
	
	

		try {
			
			File directoryPath = new File(dirName);
			
			File[] files = directoryPath.listFiles(new FilenameFilter() {
	
				@Override
				public boolean accept(File dir, String name) {    
			
					return name.endsWith(".wav");}
				});
			
			
			if(files == null) {
				
			
				throw new IOException("That path does not exist.");
			}
			   
			return files;
		}
		catch(NullPointerException e) {
			
			return new File[0];
		}
	}

	
	
	
	
	
	
	public static FileInputStream getWavFile(String fileName) throws Exception {
		
		File f = new File(fileName);
		
		if(f.exists()) {
			
			return new FileInputStream(f);
		}
		else {
			
			throw new Exception("Audio clip path does not exist");
		}
		
	}
	
}
