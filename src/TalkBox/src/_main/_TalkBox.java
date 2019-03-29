package _main;


import java.io.File;
import java.io.FileNotFoundException;

import java.io.IOException;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TreeItem;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.shape.Path;
import javafx.stage.Stage;
import io.TalkBoxLogger;


public class _TalkBox extends Application {
	
   	
	public static void main(String[] args) {
       
		launch(args);
		
    }
   //
	
	
	private VBox buttonPanel;
	private File TalkBoxDataPath;
	
	
    @Override
    public void start(Stage primaryStage) throws IOException {
        
    
    	TalkBoxLogger.setupLogger(TalkBoxDataPath, "config-log");
    	
    	primaryStage.setTitle(Names.TITLE);
        
        RootView root = new RootView(); // This is really an hbox
        
        
    	ProfileList observer2 = new ProfileList();
    	
        
        ButtonPanel observer = initializeButtonPanel(root,observer2.getRoot()); 
    	
    	LaunchButton(observer2,observer,root);
    	
    	AddProfileBox(root,observer,observer2);
    	
    	//LaunchButton(observer2,observer,root);
        
    	
        Scene scene = new Scene(root, Names.SCENE_WIDTH, Names.SCENE_HEIGHT);
        
        primaryStage.setScene(scene);
        
        primaryStage.show();
       
        
    }

    
    

   private ButtonPanel initializeButtonPanel(RootView root, TreeItem<String> Profile) {


        ButtonPanel  buttonPanel = new ButtonPanel();
        
        VBox first =  this.addButtonPanelAndLabel(this.addScrollPane(buttonPanel),buttonPanel, Profile); // Fix this
        
        root.getChildren().add(first);  
        
        return buttonPanel;
	}

    
    
    
    
	
	private AudioSampleList AudioSample(ButtonPanel panel,ProfileList profile) {

	    AudioSampleList sampleList = new AudioSampleList();
	   
	    
	    sampleList.addObserver(panel);  //This is for the observer of the buttonPanel
	    
	    sampleList.addObserver(profile);
	    
	    sampleList.loadFromDisk();
	    
	    return sampleList;
	    }
	
	private ProfileList Profiles() {
		ProfileList Profiles = new ProfileList();
		return Profiles;
	}

	
	
	public void AddProfileBox(RootView root, ButtonPanel panel,ProfileList profile) throws FileNotFoundException {

		VBox section2 = new VBox();
		HBox Set = new HBox();
		//Button SetProfile = new Button("Set Profile");
		//Set.getChildren().addAll(profile.getTree(),SetProfile);
		profile.setProfileParameters();
		TalkBoxButtons button = new TalkBoxButtons();
		section2.getChildren().addAll(new Label("Profiles"),profile.getTree(),button.enterProfileTextField(profile),new Label("Audio"),this.AudioSample(panel,profile).getList(),button.addRecordArea());
		root.addChildView(section2);
	}
	
	


	public VBox addButtonPanelAndLabel(ScrollPane scrollpane,GridPane gp, TreeItem<String> Profile) {
    	
    	 this.buttonPanel = new VBox(10);
    	 TalkBoxButtons button = new TalkBoxButtons();
         this.buttonPanel.getChildren().addAll(button.Menu(gp,Profile).getMenu(),button.headerLabel(),scrollpane);
         return this.buttonPanel;
    }
	
	
	public VBox getButtonPanel() {
		
		return this.buttonPanel;
	}
	
	
	public void LaunchButton(ProfileList profile,ButtonPanel button,RootView root) {
		
		TalkBoxButtons launchButton = new TalkBoxButtons();
		this.getButtonPanel().getChildren().add(launchButton.addLaunchButton(button,profile));
	
		
	}
    
	public ScrollPane addScrollPane(ButtonPanel buttonpanel) {
		
		   ScrollPane scrollpane = new ScrollPane();
		  
		   buttonpanel.setHgap(10);
		   
		   buttonpanel.setVgap(5);
		   
		   scrollpane.setContent(buttonpanel);
		   
		   scrollpane.setHbarPolicy(ScrollPane.ScrollBarPolicy.NEVER); // size of the scroll bar
		   
		   scrollpane.setVbarPolicy(ScrollPane.ScrollBarPolicy.AS_NEEDED);
		   
		   scrollpane.setMinSize(800, 300);
		   scrollpane.setMaxSize(800, 300);
		   return scrollpane;
	}
	

 

}