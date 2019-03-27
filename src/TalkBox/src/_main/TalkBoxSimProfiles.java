package _main;


import java.util.ArrayList;
import javafx.scene.control.TreeItem;
import javafx.scene.control.TreeView;

public class TalkBoxSimProfiles {
	
	private TalkBoxConfig tbc;
	public int row;
	public String profilename;
	public TreeItem<String> root;
	
	
	public TalkBoxSimProfiles() throws Exception {
		this.tbc=(TalkBoxConfig) Serializer.Load("TalkBox/TalkBoxData/TalkBoxData.tbc");
	}

	
	/*
	 * This method basically launches a display panel of the profile names that were used on the configurator
	 * 
	 */
	
	@SuppressWarnings({ "rawtypes", "unused" })
	public TreeView<String> getProfiles() {

		this.root = new TreeItem<String>(); // This is used to create the profile and root and branches are									// added
		root.setExpanded(false);
		ArrayList<TreeItem> TItems = new ArrayList<>(); // creating profile
		TreeView<String> Tree = new TreeView<>(root); // put item in tree
		Tree.setShowRoot(false);
		Tree.getSelectionModel().selectedItemProperty().addListener((v, oldValue, NewValue) -> {
			if (NewValue != null) {
				row = Tree.getRow(NewValue); // row is the position of the file name
				profilename = NewValue.getValue(); // Gets the profile name of the clicked profile
			}
		});
		Tree.setMinSize(200, 250);

		String[] profile = this.tbc.getProfile();
		String[][] audioname = this.tbc.getAudioFileNames();
		TreeItem<String> parent = new TreeItem<String>();
		for (int i = 0; i <= profile.length - 1; i++) {

			int column = audioname[i].length;
			String profilename = profile[i];
			this.SetProfile(profilename, root);

			for (int j = 0; j <= column - 1; j++) {

				TreeItem<String> item = new TreeItem<>(profilename);

				if (audioname[i][j] != null) {
					this.SetProfile(audioname[i][j].substring(18, audioname[i][j].length() - 2),
							root.getChildren().get(i));

				}
			}
		}
		return Tree;
	}
	
	
	
	public TreeItem<String> getRoot() {
		
		return this.root;
	}
	
	
	public int getRow() {
		
		return this.row;
	} 
	
	public String getProfilename() {
		
		return this.profilename;
	}
	/*
	 * This method allows many profiles to concantanate into the profile display panel
	 */

	public void SetProfile(String title, TreeItem<String> parent) {
			  TreeItem<String> item = new TreeItem<>(title);
			  item.setExpanded(false);
			  parent.getChildren().add(item);
	}

}