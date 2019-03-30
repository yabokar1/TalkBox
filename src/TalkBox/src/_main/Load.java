package _main;


import javafx.scene.control.TreeItem;
import javafx.scene.control.TreeView;


public class Load {
	TalkBoxConfig tbc;
	private int size;
	private String[] profile;
	TreeView<String> Tree;
	private int row;
	
	Load() throws Exception{
		tbc = (TalkBoxConfig) Serializer.Load("TalkBox/TalkBoxData/TalkBoxData.tbc");
		profile = tbc.Profiles;
	}
	
	public void Loader(TreeItem<String> root) throws Exception {
	String[][] audioname = tbc.AudioName;
	 this.Tree = new TreeView<String>(root);
	for (int i = 0; i <= profile.length - 1; i++) {
		int column = audioname[i].length;
		String profilename = profile[i];
		this.branch(profilename, root);
		for (int j = 0; j <= column - 1; j++) {
			TreeItem<String> item = new TreeItem<>(profilename);
			if (audioname[i][j] != null) {
				this.branch(audioname[i][j],
						root.getChildren().get(i));
			}
		}
		size = root.getChildren().size();
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