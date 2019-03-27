package _main;

import java.io.IOException;
import java.nio.file.LinkOption;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Observable;

import javafx.scene.control.TreeItem;

public class TalkBoxConfig {

	public static final long serialVersionUID = 1L;
	public int NumOfAudioButtons;
	public int NumOfAudioSets;
	public  int NumOfButtons;
	public Path PathToAudioFiles;
	public String[][] AudioName;
	public String[] Profiles;
	public ProfileList ProfileList;
	public String path;
	
	
	
	public void setNumberofAudioButtons(ButtonPanel audiobutton) {
		
		    this.NumOfAudioButtons = audiobutton.getNumofButtonsArray();
		
	}
	
	
	public int getNumberOfAudioButtons() {
	    
		
		return this.NumOfAudioButtons;
	
	}
	
	
	
	public void setNumberofAudioSets(ProfileList profiles) {
		
		this.NumOfAudioSets = profiles.getAudioSets();
		
	}
	

	public int getNumberOfAudioSets() {
		

		return this.NumOfAudioSets;
	
	}

	public int getTotalNumberOfButtons() {
		
		this.NumOfButtons= this.getNumberOfAudioButtons() + 3; // temporary
		return this.NumOfButtons;
 	}

	public Path getRelativePathToAudioFiles() {
	
		Path path = Paths.get("TalkBox/src");
		try {
		this.PathToAudioFiles = path.toRealPath(LinkOption.NOFOLLOW_LINKS);
		} catch (IOException e) {
			e.printStackTrace();
		}
	//	System.out.println(path.toString());
		return this.PathToAudioFiles;

	}
	
	
	public void setProfileList(ProfileList profile) {
		
		this.ProfileList = profile;
	}

	public String[][]  getAudioFileNames() {
		int length = this.ProfileList.getRoot().getChildren().size();
		int largest = this.ProfileList.LargestAudioSet();
		String [][] temp = new String[length][largest];
		for(int i = 0; i < length; i++) {
			int numofAudio = this.ProfileList.getRoot().getChildren().get(i).getChildren().size();
			for(int j = 0; j < numofAudio; j++) {
				temp[i][j] = this.ProfileList.getRoot().getChildren().get(i).getChildren().get(j).toString();
			}
		}
		return temp;
	}

	public String[] getProfile() {
		int size = this.ProfileList.getAudioSets();
		String [] AudioProfiles = new String[size];
		for(int i=0; i<size; i++) {
			AudioProfiles[i] = this.ProfileList.getRoot().getChildren().get(i).getValue();
		}
		return AudioProfiles;
	}

}
