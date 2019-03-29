package _main;

import java.io.Serializable;

public class TalkBoxConfig implements Serializable{

	public static final long serialVersionUID = 1L;
	public int NumOfAudioButtons;
	public int NumOfAudioSets;
	public  int NumOfButtons;
	public String[][] AudioName;
	public String[] Audio;
	public String[] Profiles;
	public String path;
	
	
	
	public void setNumberofAudioButtons(ButtonPanel audiobutton) {
		
		    this.NumOfAudioButtons = audiobutton.getNumofButtonsArray();
		
	}
	
	
	public int getNumberOfAudioButtons() {
	    
		
		return this.NumOfAudioButtons;
	
	}
	

	public int getNumberOfAudioSets() {
		

		return this.NumOfAudioSets;
	
	}

	public int getTotalNumberOfButtons() {
		
		this.NumOfButtons= this.getNumberOfAudioButtons() + 3; // temporary
		return this.NumOfButtons;
 	}

	
	public String  getRelativePathToAudioFiles() {
		return "TalkBox/";
	}
	

	public String[][]  getAudioFileNames() {
		return this.AudioName;
	}
	
	public String[] getAudio() {
		return this.Audio;
	}

	public String[] getProfile() {
		return this.Profiles;
	}

}
