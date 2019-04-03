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

// Inherits from Application 
public class _TalkBox extends Application {
	
   	
	public static void main(String[] args) {
       
		launch(args);
		
    }
   	
	private VBox buttonPanel;
	private File TalkBoxDataPath;
	private AudioSampleList sampleList;
	private TalkBoxButtons button;

	
	
	
	
	
    @Override
    public void start(Stage primaryStage) throws IOException {
        
    
    	TalkBoxLogger.setupLogger(TalkBoxDataPath, "config-log"); //This is for the logger
        
    	button =  new TalkBoxButtons(); // this instance is to add the buttons to the view(Gui)
    	
    	primaryStage.setTitle(Names.TITLE);
        
        RootView root = new RootView(); // This is really an hbox
        
        ProfileList observer2 = new ProfileList();
        
        ButtonPanel observer = initializeButtonPanel(root,observer2); 
        
        observer2.setButtonPanel(observer);
        
        observer.list = observer2; // I don't know what this is for
        
    	AddProfileBox(root,observer,observer2);
    	button.list = this.sampleList; // I don't know what this is for 
    	LaunchButton(observer2,observer,root);
        AudioSample(observer,observer2);

        
        Scene scene = new Scene(root, Names.SCENE_WIDTH, Names.SCENE_HEIGHT);
        
        primaryStage.setScene(scene);
        
        primaryStage.show();
       
        
    }

    
    

   private ButtonPanel initializeButtonPanel(RootView root, ProfileList Profile) {


        ButtonPanel  buttonPanel = new ButtonPanel();
        
        VBox first =  this.addButtonPanelAndLabel(this.addScrollPane(buttonPanel),buttonPanel, Profile); // Fix this
        
        root.getChildren().add(first);  
        
        return buttonPanel;
	}

    
    
    
    
	
	private AudioSampleList AudioSample(ButtonPanel panel,ProfileList profile) {

	    this.sampleList = new AudioSampleList();
	   
	    this.sampleList.addObserver(panel);  //This is for the observer of the buttonPanel
	    
	    this.sampleList.addObserver(profile);
	    
	    this.sampleList.loadFromDisk();
	    
	    return sampleList;
	    }
		
	
	public void AddProfileBox(RootView root, ButtonPanel panel,ProfileList profile) throws FileNotFoundException {

		
		profile.setProfileParameters(panel);
		HBox section3 = new HBox();
		section3.getChildren().add(this.button.setProfile(panel, profile));
		root.addChildView(this.audioAndSetPanel(panel, profile));
		root.addChildView(section3);
	}
	
	public VBox audioAndSetPanel( ButtonPanel panel,ProfileList profile) throws FileNotFoundException { //Right side of the Gui
		VBox section2 = new VBox();
		section2.getChildren().add(new Label("Profiles"));
		section2.getChildren().add(profile.getTree());
		section2.getChildren().add(this.button.enterProfileTextField(profile,panel));
		section2.getChildren().add(new Label("Audio"));
		section2.getChildren().add(this.AudioSample(panel,profile).getList());
		section2.getChildren().add(this.button.addRecordArea(this.sampleList));
		return section2;
		
		
	}


	public VBox addButtonPanelAndLabel(ScrollPane scrollpane,ButtonPanel gp, ProfileList Profile) {
    	
    	 this.buttonPanel = new VBox(10);
         this.buttonPanel.getChildren().addAll(button.Menu(Profile),button.headerLabel(),scrollpane);
         return this.buttonPanel;
    }
	
	
	public VBox getButtonPanel() {
		
		return this.buttonPanel;
	}
	
	
	public void LaunchButton(ProfileList profile,ButtonPanel buttonp,RootView root) {
		
		
		this.getButtonPanel().getChildren().addAll(button.addLaunchButton(buttonp,profile),button.Rename(buttonp));
	
		
	}

    
	public ScrollPane addScrollPane(ButtonPanel buttonpanel) {
		
		   ScrollPane scrollpane = new ScrollPane();
		  
		   buttonpanel.setHgap(10);
		   
		   buttonpanel.setVgap(5);
		   
		   scrollpane.setContent(buttonpanel);
		   
		   scrollpane.setHbarPolicy(ScrollPane.ScrollBarPolicy.AS_NEEDED); // size of the scroll bar
		   
		   scrollpane.setMinSize(800, 300);
		   scrollpane.setMaxSize(800, 300);
		   return scrollpane;
	}
	

 

}