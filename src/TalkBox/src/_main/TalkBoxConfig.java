package _main;

import java.io.IOException;
import java.nio.file.LinkOption;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Observable;

public class TalkBoxConfig    {

	private static final long serialVersionUID = 1L;
	private int NumOfAudioButtons;
	private int NumOfAudioSets;
	private  int NumOfButtons;
	private Path PathToAudioFiles;
	private String[][] AudioName;
	private String[] Profiles;
	private String path;
	
	
	
	
	
	
	
	public int getNumberOfAudioButtons() {
	    
		ButtonPanel audioButtonList = new ButtonPanel();
		this.NumOfAudioButtons = audioButtonList.getNumofButtonsArray();
		return this.NumOfAudioButtons;
	
	}

	public int getNumberOfAudioSets() {
		
		ProfileList audioset = new ProfileList();
		this.NumOfAudioSets = audioset.getAudioSets();
		return this.NumOfAudioSets;
	}

	public int getTotalNumberOfButtons() {
		
		this.NumOfButtons= this.getNumberOfAudioButtons() + 3; // temporary
		return  this.NumOfButtons;
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

	public String[][] getAudioFileNames() {

		ProfileList profiles = new ProfileList();
		int size = profiles.getAudioSets();
		this.AudioName = new String[size][];
		for(int i = 0; i<size; i++) {
			
			for(int j=0; i<profiles.getRoot().getChildren().get(i).getChildren().size() ; j++) {
			
				this.AudioName[i][j] = profiles.getRoot().getChildren().get(i).getChildren().get(j).getValue() ;
					
			}	
		}
		
		return this.AudioName;
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
	
	
	public void TalkBoxConfigController() {
		
		
		System.out.println("Fcuk");
		
	}
	

}
