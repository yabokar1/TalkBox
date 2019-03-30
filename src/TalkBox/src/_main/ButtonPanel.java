package _main;

import java.util.ArrayList;
import java.util.Observable;
import java.util.Observer;
import java.util.logging.Level;

import audio_players.AudioClipWav;
import io.ImportFiles;
import io.TalkBoxLogger;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseButton;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Priority;

public class ButtonPanel extends GridPane implements Observer{
	
	
		private int currentRow = 0;
		
		private int currentCol = 0;
		
		private int numOfAudioButtons = 0;
		
		private static final int BTN_WIDTH = 90;
		
		private static final int BTN_HEIGHT = 90;
		
		private ArrayList<String> ImageList;
		private ArrayList<Button> ButtonList;
		
		public ButtonPanel() {
			ImageList = new ArrayList<String>();
			ButtonList = new ArrayList<Button>();
		}
		
		public void resetRow() {
			
			this.currentRow=0;
		}
		
		
		public void resetColumn() {
			
			this.currentCol=0;
		}
		
		public ArrayList<String> getImageList(){
			return this.ImageList;
		}
		
		public ArrayList<Button> getButton() {
			return this.ButtonList;
		}
	
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
		   
		   if(currentCol > Names.MAX_COL) {
			 
			   currentCol = 0;
			 
			   currentRow++;
		   }
		   this.numOfAudioButtons++;
			
		}
		

		public int getNumofButtonsArray() {
			
			
			return this.numOfAudioButtons;
		}
		
		public void imageArray(String temp) {
				ImageList.add(temp);
		}
		

		private void attachClickListener(String name, Button b) {
			b.setOnMouseClicked(new EventHandler<MouseEvent>() {
				
			private AudioClipWav clip = null;
	            @Override
	        public void handle(MouseEvent event) {
	               
	            	TalkBoxLogger.logMousePressEvent(event);
	            	
	            	MouseButton button = event.getButton();
	               
	                if(button==MouseButton.PRIMARY) {
						
	                	clip = new AudioClipWav(name);
						
						clip.play();
	                }
	                
	                else if(button==MouseButton.SECONDARY){
	                
	                ImportFiles image = new ImportFiles();
	                
	                image.open("Images/");
	                
	                Image pic = new Image(image.file.toURI().toString());
	                
	                imageArray(image.file.toURI().toString());
	                
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
		
			//System.out.println(this.numOfAudioButtons);
			
			
		}



}