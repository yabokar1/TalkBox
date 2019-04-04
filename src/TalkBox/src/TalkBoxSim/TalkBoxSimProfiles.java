package TalkBoxSim;


import java.util.ArrayList;
import java.util.Arrays;

import _main.Names;
import _main.Serializer;
import _main.TalkBoxConfig;
import audio_players.AudioClipWav;
import io.ImportFiles;
import io.TalkBoxLogger;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.control.TreeItem;
import javafx.scene.control.TreeView;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseButton;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundImage;
import javafx.scene.layout.BackgroundPosition;
import javafx.scene.layout.BackgroundRepeat;
import javafx.scene.layout.BackgroundSize;
import javafx.scene.layout.GridPane;

public class TalkBoxSimProfiles {
	
	private TalkBoxConfig tbc;
	public String profilename;
	public TreeItem<String> root;
	int currentRow = 0;
	int currentCol = 0;
	AudioClipWav clip;
	boolean collide = false;
	
	public TalkBoxSimProfiles() throws Exception {
		this.tbc=(TalkBoxConfig) Serializer.Load("TalkBoxData/TalkBoxData.tbc");
	}

	
	/*
	 * This method basically launches a display panel of the profile names that were used on the configurator
	 * 
	 */
	
	public void getProfiles(GridPane p, String row) {	
		p.getChildren().clear();
		String[][] audioname = this.tbc.AudioName;
		ArrayList<ArrayList<String>> image = this.tbc.images;
		ArrayList<ArrayList<String>> rename = this.tbc.rename;
	//	System.out.println(rename);
		int ctr = 0;
		int size = Integer.parseInt(row);
		for(String temp : audioname[size]) {
			if(temp == null) {
				break;
			}
			Button b = new Button(temp);
			b.setMaxSize(150, 150);
			b.setMinSize(150, 150);
			attachClickListener(temp,b);
			 p.add(b, currentCol, currentRow);
			   currentCol++;
			   try {
			   if(image.get(size).get(ctr) != null) {
			   
				Image im = new Image(image.get(size).get(ctr));

				 BackgroundImage bImage = new BackgroundImage(im, BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.CENTER, new BackgroundSize(b.getWidth(), b.getHeight(), true, true, true, false));
	             Background backGround = new Background(bImage);
	             b.setBackground(backGround);
		       }
			   else {
				   try {
					   if(rename.get(size).get(ctr) != null) {
						   b.setText(rename.get(size).get(ctr));
					   }
			   }
			   catch(Exception e) {
				  
			   			}
			   		}
			   }
			   catch(Exception e1) {
				   
			 }
			   ctr++;
			   }
		}
	
	

	private void attachClickListener(String name, Button b) {
		b.setOnAction(e ->{
			if(this.collide == true) {
				this.clip.stop();
			}
			clip = new AudioClipWav(name);
			this.clip.play();
			this.collide = true;
		});
	}
	
	
	public TreeItem<String> getRoot() {
		
		return this.root;
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