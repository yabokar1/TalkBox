package _main;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

public class TalkBoxButtons {
	
	
	
	
	public TalkBoxButtons() {
		
		
	}
	
	
	
	
	public Button addLaunchButton(ButtonPanel button,ProfileList profile) {
		TalkBoxConfig  config = new TalkBoxConfig();
		Button Launch = new Button("Launch Button");
		Launch.setMinSize(Names.LAUNCHBUTTON_WIDTH, Names.LAUNCHBUTTON_HEIGHT);
		Launch.setOnAction(e -> {
			config.setNumberofAudioButtons(button);
			config.setNumberofAudioSets(profile);
			config.setProfileList(profile);
			config.getProfile();
			config.getAudioFileNames();
		//System.out.println(config.getNumberOfAudioButtons());
		//System.out.println(config.getNumberOfAudioSets());
		});
		return Launch;
		
	}
	
	public TextField enterProfileTextField(ProfileList profile) {
		
		TextField enterProfile = new TextField("Enter Profile");
		enterProfile.setOnMouseClicked(e -> enterProfile.clear());
		enterProfile.setOnAction(e -> {
		profile.setProfileTitle(enterProfile.getText());
		
			
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
    	start.setMinSize(Names.STARTBUTTON_WIDTH, Names.STARTBUTTON_HEIGHT);
    	v.getChildren().addAll(start,new TextField("Enter Filename"));
    	return v;
    }

    
    
    public HBox addRecordArea() throws FileNotFoundException {

        
 

    	HBox RecordingArea = new HBox();
    	Button Record = new Button();
    	Image image = new Image("/Image/recorderImage.png");
    	ImageView imageView = new ImageView();
    	imageView.setImage(image);
    	imageView.setFitHeight(90);
    	imageView.setFitWidth( 90);
    	Record.setMinSize(Names.RECORDBUTTON_HEIGHT, Names.RECORDBUTTON_WIDTH);
    	Record.setGraphic(imageView);
    	RecordingArea.getChildren().addAll(Record,FileandStart());
    	return RecordingArea;
    }
    
	public TopMenu Menu(){
		TopMenu menu = new TopMenu();
		return menu;
		
	}
	
	

}
