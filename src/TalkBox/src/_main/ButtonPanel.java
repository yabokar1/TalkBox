package _main;

import java.util.Observable;
import java.util.Observer;
import audio_players.AudioClipWav;
import io.TalkBoxLogger;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.input.MouseButton;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Priority;

public class ButtonPanel extends GridPane implements Observer{
	
	
		private int currentRow = 0;
		
		private int currentCol = 0;
		
		private int numOfAudioButtons = 0;
		
		private static final int BTN_WIDTH = 150;
		
		private static final int BTN_HEIGHT = 150;
		
		public String newname;
		
		public ProfileList list;
		
		public int buttonnum = 0;
		
	
		
		public ButtonPanel() {
			
		}
		
		public void resetRow() {
			this.currentRow=0;
		}
		
		public void resetColumn() {
			
			this.currentCol=0;
		}
		
		public int getColumn() {
			
			return this.currentCol;
		}
		
		public int getRow() {
			
			return this.currentRow;
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

		   this.numOfAudioButtons++;
			
		}
		

		public int getNumofAudioButtons() {
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
	                	
	                	int ctr = 0;
	                	
	                for(Node temp : b.getParent().getChildrenUnmodifiable()) {
	                		
	                	if(b != b.getParent().getChildrenUnmodifiable().get(ctr)) {
	                		ctr++;
	                		//System.out.println(ctr);
	                		}
	                	}
	                	rightClick(event,b,ctr);
	                }
	               }
	        });
		}

		
		public void rightClick(MouseEvent event,Button button,int location) {
			
            ContextMenuClass right = new ContextMenuClass(button,list,newName(),list.getRow());
            
            right.cm.show(button, event.getScreenX(), event.getScreenY());
            right.LoadImage.setOnAction(e ->{   
            	TalkBoxLogger.logMenuPressEvent(e);
            	if(list.ImageSet.get(list.getRow()).size() <= location) {
            		for(int i = 0; i <= location - list.ImageSet.get(list.getRow()).size(); i++) {
            			list.RenameSet.get(list.getRow()).add(null);
            			list.ImageSet.get(list.getRow()).add(null);

            		}
            	}
         right.attachImageAdder(button, list, list.getRow(),location);
               
       	});
            right.Rename.setOnAction(e ->{
            	TalkBoxLogger.logMenuPressEvent(e);
            	if(list.ImageSet.get(list.getRow()).size() <= location) {
            		for(int i = 0; i <= location - list.RenameSet.get(list.getRow()).size(); i++) {
            			list.ImageSet.get(list.getRow()).add(null);
            			list.RenameSet.get(list.getRow()).add(null);
            		}
            	}
            right.rename(button, newName(), list, list.getRow(),location);
            	});
		}
		

		@Override
		public void update(Observable o, Object arg) {
			
			String buttonName = (String) arg;
	
			addButton(buttonName);
			
		}



}