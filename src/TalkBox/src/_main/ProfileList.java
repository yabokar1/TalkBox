package _main;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Observable;
import java.util.Observer;

import io.TalkBoxLogger;
import javafx.scene.Node;
import javafx.scene.control.TreeItem;
import javafx.scene.control.TreeView;

public class ProfileList implements Observer,Serializable {

	public static final long serialVersionUID = 1L;
	private TreeView<String> Tree;
	private TreeItem<String> root;
	private int row;
	private String profilename;
	private int numofAudioSets = 0;
	private ArrayList<TreeItem<String>> profileSet;
	private ArrayList<ArrayList<TreeItem<String>>> profiles = new ArrayList<ArrayList<TreeItem<String>>>();
	private int counter = 0;
	

	public ProfileList() {

		this.root = new TreeItem<String>();
		this.root.setExpanded(false);
		this.Tree = new TreeView<String>(this.root);
		this.Tree.setShowRoot(false);

	}

	public TreeView<String> getTree() {

		return this.Tree;
	}

	public TreeItem<String> getRoot() {

		return this.root;
	}

	public int getAudioSets() {

	   return this.numofAudioSets;
	}
	


	public void setProfileTitle(String e) {

		if (this.counter > 0) {

			profiles.add(this.profileSet);

			// this.displayAllProfiles();
		

		}

		this.counter++;

		TreeItem<String> newItem = new TreeItem<String>(e);

		this.setProfileArray();

		this.profileSet.add(newItem);

		newItem.setExpanded(false);

		this.root.getChildren().add(newItem);

		this.numofAudioSets++;

	}

	public void setProfileArray() {

		this.profileSet = new ArrayList<TreeItem<String>>();
	}


	
	public  ArrayList<ArrayList<TreeItem<String>>>  getProfile() {
		
		return this.profiles;
	}



	public void setProfileItem(String e) {

		TreeItem<String> newItem = new TreeItem<String>(e);

		newItem.setExpanded(false);

		this.root.getChildren().get(this.row).getChildren().add(newItem);

		this.profileSet.add(newItem);

	}

	public void setProfileParameters() {

		Tree.getSelectionModel().selectedItemProperty().addListener((v, oldValue, NewValue) -> {
			if (NewValue != null) {
				this.row = Tree.getRow(NewValue); // row is the position of the file name
				this.profilename = NewValue.getValue(); // Gets the profile name of the clicked profile
			}

		});

	}

	public void RemoveProfileItem(int i) {
		this.root.getChildren().remove(i);
	}
	
	
	public String getProfileName(int i) {
		return this.root.getChildren().get(i).getValue().toString();
	}
	
	
	
	
	
	public int LargestAudioSet() {
		int length = this.root.getChildren().size();
		int max=0;
		for(int i = 0; i < length; i++) {
			int audioSetSize = 0;
			int numofAudio = this.root.getChildren().get(i).getChildren().size();
			for(int j = 0; j < numofAudio; j++) {
				audioSetSize++;
			}
			if(audioSetSize > max) {
				max = audioSetSize;
			}
		}	
		return max;
	}
	
	
	


	public String[][] getAudioFileNames() {
		int length = this.root.getChildren().size();
		int largest = LargestAudioSet();
		String [][] temp = new String[length][largest];
		for(int i = 0; i < length; i++) {
			int numofAudio = this.getRoot().getChildren().get(i).getChildren().size();
			for(int j = 0; j < numofAudio; j++) {
				String audio = this.getRoot().getChildren().get(i).getChildren().get(j).toString();
				if(audio == null) {
					continue;
					}
				temp[i][j] = audio;
			}
		}
		return temp;
	}
	
	
	
	public String[] getAudio() {
		int length = this.root.getChildren().get(this.row).getChildren().size();
		String[] temp = new String[length];
		for(int i = 0; i < length; i++) {
			temp[i] = this.root.getChildren().get(this.row).getChildren().get(i).getValue();
		}
		return temp;
	}
	
	public String[] getProfiles() {
		int size = this.getAudioSets();
		String [] AudioProfiles = new String[size];
		for(int i=0; i<size; i++) {
			AudioProfiles[i] = this.getRoot().getChildren().get(i).getValue();
		}
		return AudioProfiles;
	}
	
	@Override
	public void update(Observable o, Object arg) {

		String buttonName = (String) arg;
		this.setProfileParameters();
		this.setProfileItem(buttonName);

	}

}
