package _main;

import java.util.Observable;
import java.util.Observer;

import javafx.scene.Node;
import javafx.scene.control.TreeItem;
import javafx.scene.control.TreeView;

public class ProfileList extends TreeView implements Observer  {

	private TreeView<String> Tree;
	private TreeItem<String> root;
	private int row;
	private String profilename;
	public ProfileList() {
		this.root = new TreeItem<String>("He");
		this.root.setExpanded(true);
		this.Tree = new TreeView<String>(this.root);
		this.Tree.setRoot(this.root);
		this.Tree.setShowRoot(false);
		
	}
	
	public TreeView<String> getTree() {
		
		return this.Tree;
	}
	

	

	

	public void addProfileItem(String e) {
	TreeItem<String> newItem = new TreeItem<String>(e);
	newItem.setExpanded(true);
	this.root.getChildren().add(newItem);
	this.Tree.setRoot(this.root);
	System.out.println(this.root.getChildren().get(0));
	}
	
	
	public void RemoveProfileItem(int i) {
		root.getChildren().remove(i);
	}

	@Override
	

	public void update(Observable o, Object arg) {
		
		String buttonName = (String) arg;
		this.addProfileItem(buttonName);
		
		//System.out.println(buttonName);
		
}
		
	

	
}
