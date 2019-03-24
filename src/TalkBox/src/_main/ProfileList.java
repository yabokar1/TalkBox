package _main;

import java.util.Observable;
import java.util.Observer;

import javafx.scene.Node;
import javafx.scene.control.TreeItem;
import javafx.scene.control.TreeView;

public class ProfileList  implements Observer     {

	private TreeView<String> Tree;
	private TreeItem<String> root;
	private int row;
	private String profilename;
	
	public ProfileList() {
	this.root = new TreeItem<String>();
	this.root.setExpanded(true);
	this.Tree = new TreeView<String>(this.root);
	this.Tree.setShowRoot(false);
		
	}
	
	
	
	
    public TreeView<String> getTreeItem() {
    	
    	
    	return this.Tree;
    }

	

	

	public void addProfileTitle(String e) {
	
	TreeItem<String> newItem = new TreeItem<String>(e);
	
	newItem.setExpanded(true);
	
	this.root.getChildren().add(newItem);
	
	System.out.println(this.row);
	
	
	
	}
	
	
	public void addProfileItem(String e) {
		
		TreeItem<String> newItem = new TreeItem<String>(e);
		
		newItem.setExpanded(true);
		
		this.root.getChildren().get(row).getChildren().add(newItem);
		
		System.out.println(newItem.getValue());
		
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
		root.getChildren().remove(i);
	}

	@Override
	

	public void update(Observable o, Object arg) {
		
		String buttonName = (String) arg;
		this.setProfileParameters();
		this.addProfileItem(buttonName);
		
		//System.out.println(buttonName);
		
}
		
	

	
}
