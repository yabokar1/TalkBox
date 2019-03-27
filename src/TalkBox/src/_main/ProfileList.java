package _main;

import java.util.ArrayList;
import java.util.Observable;
import java.util.Observer;

import javafx.scene.Node;
import javafx.scene.control.TreeItem;
import javafx.scene.control.TreeView;

public class ProfileList implements Observer {

	private TreeView<String> Tree;
	private TreeItem<String> root;
	private int row;
	private String profilename;
	private int numofAudioSets;
	private int numofAudioFiles;
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
			this.maxProfileSet();

		}

		this.counter++;
		System.out.println(this.counter);
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

	public void displayAllProfiles() {

		for (int i = 0; i <= this.profiles.size() - 1; i++) {

			for (int j = 0; j <= this.profiles.get(i).size() - 1; j++) {

				//System.out.println(this.profiles.get(i).get(j).getValue());
			}

		}

	}
	
	public  ArrayList<ArrayList<TreeItem<String>>>  getProfiles() {
		
		return this.profiles;
	}

	public void maxProfileSet() {

		int max = 0;
		int temp = 0;
		for (int i = 0; i <= this.profiles.size() - 1; i++) {

			temp = this.profiles.get(i).size() - 1;
			if (temp > max) {

				max = this.profiles.get(i).size() - 1;
				// System.out.println(max+"is the maximum");
			}

		}

		//System.out.println(max + "is the maximum");

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
				// System.out.println(this.row+"Yes");
			}

		});

	}

	public void RemoveProfileItem(int i) {
		root.getChildren().remove(i);
	}

	@Override

	public void update(Observable o, Object arg) {

		String buttonName = (String) arg;
		this.setProfileParameters();
		this.setProfileItem(buttonName);

	}

}
