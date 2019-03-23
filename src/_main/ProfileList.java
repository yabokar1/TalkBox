package _main;

import javafx.scene.Node;
import javafx.scene.control.TreeItem;
import javafx.scene.control.TreeView;

public class ProfileList extends TreeView<String> {

	TreeView<String> Tree;
	TreeItem<String> root = new TreeItem<String>();
	
	public ProfileList() {
		Tree = new TreeView<String>(root);
	}
	
	
	public void addTreeItem(TreeItem<String> e) {
	root.getChildren().add(e);
	}
	
	
	public void RemoveTreeItem(int i) {
		root.getChildren().remove(i);
	}
	
	
	
	
}
