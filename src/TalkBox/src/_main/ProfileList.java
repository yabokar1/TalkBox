package _main;

import java.util.Observable;
import java.util.Observer;

import javafx.scene.Node;
import javafx.scene.control.TreeItem;
import javafx.scene.control.TreeView;

public class ProfileList  implements Observer {

	
	private TreeView<String> Tree;
	private TreeItem<String> root;
	private int row;
	private String profilename;
	private int numofAudioSets;
	private TreeItem<String> audioSet;
	private TreeItem<String> audioFiles;
	private int audioSetSize[];
	
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
	
	TreeItem<String> newItem = new TreeItem<String>(e);
	
	newItem.setExpanded(false);
	
	this.root.getChildren().add(newItem);

	
	this.numofAudioSets++;
	
	
}
	
	

	
	public void setProfileItem(String e) {
		
		TreeItem<String> newItem = new TreeItem<String>(e);
		
		newItem.setExpanded(false);
		
		this.root.getChildren().get(this.row).getChildren().add(newItem);
		
		//System.out.println(newItem.getValue());
		
	}
	
	
	
	
	public void setProfileParameters() {
		
		Tree.getSelectionModel().selectedItemProperty().addListener((v, oldValue, NewValue) -> {

			if (NewValue != null) {

				this.row = Tree.getRow(NewValue); // row is the position of the file name
				this.profilename = NewValue.getValue(); // Gets the profile name of the clicked profile
				System.out.println(this.row+"Yes");
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
		
		//System.out.println(buttonName);
		
}
		
	

	
}
