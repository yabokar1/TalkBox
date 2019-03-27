package _main;

import java.io.IOException;
import java.nio.file.LinkOption;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Observable;

import javafx.scene.control.TreeItem;

public class TalkBoxConfig    {

	public static final long serialVersionUID = 1L;
	public int NumOfAudioButtons;
	public int NumOfAudioSets;
	public  int NumOfButtons;
	public Path PathToAudioFiles;
	public String[][] AudioName;
	public String[] Profiles;
	public _main.ProfileList ProfileList;
	private ArrayList<TreeItem<String>> tbcprofileSet;
	private ArrayList<ArrayList<TreeItem<String>>> tbcprofiles = new ArrayList<ArrayList<TreeItem<String>>>();
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
	
		Path path = Paths.get("/TalkBox");
		try {
		this.PathToAudioFiles = path.toRealPath(LinkOption.NOFOLLOW_LINKS);
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		return this.PathToAudioFiles;
	
		
		
	}
	
	
	public void setProfileList(ProfileList profile) {
		
		this.ProfileList = profile;
		this.tbcprofiles = this.ProfileList.getProfiles();
		
	}

	public void  getAudioFileNames() {

		
		System.out.println(this.tbcprofiles.size());
		
		for(int i=0;i<=this.tbcprofiles.size()-1;i++) {
			
			 // System.out.println(this.tbcprofiles.get(i).toString());
			
		}
		
		
		
		
		
		
		
		
	}

	public String[] getProfile() {
		ProfileList profiles = new ProfileList();
		int size = profiles.getAudioSets();
		String [] AudioProfiles = new String[size];
		
		for(int i=0; i<size; i++) {
			
			AudioProfiles[i] = profiles.getRoot().getChildren().get(i).getValue();
		}
	
		return AudioProfiles;
	}

	public String path() {
		// TODO Auto-generated method stub
		return null;
	}
	
	

	
	

}
