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
import javafx.scene.control.TextField;
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
		
		public String newname;
		
		public ProfileList list;
		
		public ButtonPanel() {
			
		}
		
		public void resetRow() {
			this.currentRow=0;
		}
		
		public void resetColumn() {
			
			this.currentCol=0;
		}
	
		public void setProfileList(ProfileList temp) {
			this.list = temp;
		}
		public void setnewName(String s) {
			this.newname = s;
		}
		
		public String newName() {
			return this.newname;
		}
		
		

		public void addButton(String name) {
			
		   Button button = new Button(name);
		   
		   button.setMinSize(BTN_WIDTH, BTN_HEIGHT);
		   
		   button.setMaxSize(BTN_WIDTH, BTN_HEIGHT);
		   
		   ButtonPanel.setHgrow(button, Priority.ALWAYS);
		   
		   ButtonPanel.setHgrow(button, Priority.ALWAYS);
		   
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
	                	
	                	rightClick(event,b);
	      
	                }
	                }
	        });
		}

		
		public void rightClick(MouseEvent event,Button button) {
			
			
            ContextMenuClass right = new ContextMenuClass(button,list,newName(),list.getRow());
            
            right.cm.show(button, event.getScreenX(), event.getScreenY());
            
            right.LoadImage.setOnAction(e ->{
       			
            right.attachImageAdder(button, list, list.getRow());
                
            System.out.println(list.ImageSet);
                
            System.out.println(list.RenameSet);
       		});
            right.Rename.setOnAction(e ->{
            right.rename(button, newName(), list, list.getRow());
            System.out.println(list.ImageSet);
              System.out.println(list.RenameSet);
            	});
			
			
			
		}
		

		@Override
		public void update(Observable o, Object arg) {
			
			String buttonName = (String) arg;
	
			addButton(buttonName);
			
		}



}