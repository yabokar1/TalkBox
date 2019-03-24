package _main;

import java.util.Observable;
import java.util.Observer;

import audio_players.AudioClip;
import audio_players.AudioClipWav;
import io.AudioFileIO;
import io.ImportFiles;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.ContextMenu;
import javafx.scene.control.MenuItem;
import javafx.scene.control.ScrollPane;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseButton;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Priority;

public class ButtonPanel extends GridPane implements Observer{
	
	
		int currentRow = 0;
		
		int currentCol = 0;
		
		
		
		
		private static final int BTN_WIDTH = 90;
		
		private static final int BTN_HEIGHT = 90;
		
		private static final int MAX_COL = 6;
		
	
		
		
	
		public void addButton(String name) {
			
		   Button button = new Button(name);
		   button.setMinSize(BTN_WIDTH, BTN_HEIGHT);
		   button.setMaxSize(BTN_WIDTH, BTN_HEIGHT);
		   this.setHgrow(button, Priority.ALWAYS);
		   this.setHgrow(button, Priority.ALWAYS);
		   this.setVgap(20);
		   button.setPadding(new Insets(10,10,10,10));
		   
		   
		   attachClickListener(name, button);

		   this.add(button, currentCol, currentRow);

		   currentCol++;
		   
		   if(currentCol > MAX_COL) {
			 
			   currentCol = 0;
			 
			   currentRow++;
		   }
			
		}
		
		

		private void attachClickListener(String name, Button b) {
			b.setOnMouseClicked(new EventHandler<MouseEvent>() {
				private AudioClipWav clip = null;
	            @Override
	            public void handle(MouseEvent event) {
	                MouseButton button = event.getButton();
	                if(button==MouseButton.PRIMARY) {
						clip = new AudioClipWav(name);
						clip.play();
	                }else if(button==MouseButton.SECONDARY){
	                ImportFiles image = new ImportFiles();
	                image.open("Images/");
	                Image pic = new Image(image.file.toURI().toString());
	                ImageView iv = new ImageView(pic);
	                iv.fitWidthProperty().bind(b.widthProperty());
	                iv.fitHeightProperty().bind(b.heightProperty());
	                b.setGraphic(iv);
	                }
	            }
	        });
		}


		@Override
		public void update(Observable o, Object arg) {
			
			String buttonName = (String) arg;
	
			addButton(buttonName);
			
			
		}



}
