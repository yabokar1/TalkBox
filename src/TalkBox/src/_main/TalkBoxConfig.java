package _main;

import java.io.Serializable;
import java.util.ArrayList;

import javafx.scene.image.Image;

public class TalkBoxConfig implements Serializable{

	public static final long serialVersionUID = 1L;
	public int NumOfAudioButtons;
	public int NumOfAudioSets;
	public  int NumOfButtons;
	public String[][] AudioName;
	public String[][] newnames;
	public String[] Audio;
	public String[] Profiles;
	public ArrayList<ArrayList<String>> images;
	public ArrayList<ArrayList<String>> rename;
	public String path;
	public int row;
	
	
	
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
	

	public String[][] getAudioFileNames() {
		return this.AudioName;
	}
	
	public int getrow() {
		return this.row;
	}
	public String[] getAudio() {
		return this.Audio;
	}

	public String[] getProfile() {
		return this.Profiles;
	}
	
	public ArrayList<ArrayList<String>> getrename(){
		return this.rename;
	}
	
	public ArrayList<ArrayList<String>> getImages() {
		return this.images;
	}
	
	public String[][] getNewName(){
		return this.newnames;
	}
}
