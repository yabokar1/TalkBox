package _main;

import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

public class TalkBoxButtons {
	
	
	
	
	public TalkBoxButtons() {
		
		
	}
	
	
	
	
	public Button addLaunchButton() {
		
		Button Launch = new Button("Launch Button");
		Launch.setMinSize(Names.LAUNCHBUTTON_WIDTH, Names.LAUNCHBUTTON_HEIGHT);
		return Launch;
		
	}
	
	public TextField enterProfileTextField(ProfileList profile) {
		
		TextField enterProfile = new TextField("Enter Profile");
		enterProfile.setOnMouseClicked(e -> enterProfile.clear());
		enterProfile.setOnAction(e -> {
		
		profile.addProfileTitle(enterProfile.getText());
		
			
		 });
		return enterProfile;
	
	}
	
    public Label headerLabel() {
    	Label talkBoxLabel = new Label(Names.TITLE);
    	talkBoxLabel.setStyle("-fx-font-family: TRON; -fx-font-size: 20;");
    	return talkBoxLabel;
    }
    
    public VBox FileandStart() {
    	VBox v = new VBox();
    	Button start = new Button("Start");
    	start.setMinSize(50, 25);
    	v.getChildren().addAll(start,new TextField("Enter Filename"));
    	return v;
    }
        
    public HBox addRecordArea() {
    	HBox RecordingArea = new HBox();
    	Button Record = new Button("Record");
    	Record.setMinSize(75, 75);
    	RecordingArea.getChildren().addAll(Record,FileandStart());
    	return RecordingArea;
    }
    
	public TopMenu Menu(){
		TopMenu menu = new TopMenu();
		return menu;
		
	}
	
	

}
