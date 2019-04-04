package _main;


import java.util.ArrayList;

import javafx.scene.control.TreeItem;
import javafx.scene.control.TreeView;


public class Load {
	TalkBoxConfig tbc;
	private ArrayList<String> profile;
	TreeView<String> Tree;
	private int row;
	ArrayList<ArrayList<TreeItem<String>>> holder;
	String[] NameHolder;

	
	Load() throws Exception{
		tbc = (TalkBoxConfig) Serializer.Load("TalkBoxData/TalkBoxData.tbc");
		profile = tbc.Profiles;
		holder = new ArrayList<ArrayList<TreeItem<String>>>();
	}
	
	public void Loader(TreeItem<String> root) throws Exception {
	
		String[][] audioname = tbc.AudioName;
	
	
	
	this.Tree = new TreeView<String>(root);
	
	for (int i = 0; i <= profile.size()- 1; i++) {
		int column = audioname[i].length;
		String profilename = profile.get(i);
		ArrayList<TreeItem<String>> profilearray = new ArrayList<TreeItem<String>>();
		this.branch(profilename, root);
		for (int j = 0; j <= column - 1; j++) {
			if (audioname[i][j] != null) {
			profilearray.add(this.branch(audioname[i][j], root.getChildren().get(i)));
			}
		}
		root.getChildren().size();
		holder.add(profilearray);
}
	}
	
	
	public void setProfileParameters(ProfileList profileList) {

		Tree.getSelectionModel().selectedItemProperty().addListener((v, oldValue, NewValue) -> {
			if (NewValue != null) {
				this.row = Tree.getRow(NewValue); // row is the position of the file name
				
			}

		});
	}	

	
	public TreeItem getTreeItem(int i,TreeItem<String> root) {
		return root.getChildren().get(i);
	}
	
	
	public TreeItem<String> branch(String title, TreeItem<String> parent) {
		TreeItem<String> item = new TreeItem<>(title);
		item.setExpanded(false);
		parent.getChildren().add(item);
		return item;
	}
}