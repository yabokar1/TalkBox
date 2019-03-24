package _main;
import java.io.IOException;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.MenuBar;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextField;
import javafx.scene.control.TreeView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;


public class _TalkBox extends Application {
   
	
	
	public static void main(String[] args) {
       
		launch(args);
    }
    
	
	
	
    @Override
    public void start(Stage primaryStage) throws IOException {
        
    	
    	primaryStage.setTitle(Names.TITLE);
        
        RootView root = new RootView(); // This is really an hbox
        
        
        ButtonPanel observer = initializeButtonPanel(root);  // extends GridPane
        
       AddProfileBox(root,observer);
        
        
       
        Scene scene = new Scene(root, Names.SCENE_WIDTH, Names.SCENE_HEIGHT);
        
        primaryStage.setScene(scene);
        
        primaryStage.show();
       
        
    }

    
    
/*
 * 
 * initializeButtonPanel method is used initialize buttonpanel 
 * 
 * */
    


	private ButtonPanel initializeButtonPanel(RootView root) {  


        ButtonPanel  buttonPanel = new ButtonPanel();
        
        VBox first =  this.addButtonPanelAndLabel(this.addScrollPane(buttonPanel));
        
        root.getChildren().add(first);  
        
        return buttonPanel;
	}

    
    
    
    
	
	private AudioSampleList AudioSample(ButtonPanel panel) {

	    AudioSampleList sampleList = new AudioSampleList();
	    
	    ProfileList profile = new ProfileList();
	    
	    
	     sampleList.addObserver(panel);
	     sampleList.addObserver(profile);
	     
	    
	    
	    sampleList.loadFromDisk();
	    
	    return sampleList;
	    }
	
	
	

	
	private ProfileList Profiles() {
		ProfileList Profiles = new ProfileList();
		return Profiles;
	}
	
	public void AddProfileBox(RootView root, ButtonPanel panel) {
		VBox section2 = new VBox();
		ProfileList profile = new ProfileList();
	
		section2.getChildren().addAll(new Label("Profiles"),profile,this.enterProfileTextField(),new Label("Audio"),this.AudioSample(panel).getList()); //Trainwreck Fix that
		root.addChildView(section2);
	}

	
	public TextField enterProfileTextField() {
		
		TextField enterProfile = new TextField("Enter Profile");
		enterProfile.setOnMouseClicked(e -> enterProfile.clear());
		enterProfile.setOnAction(e -> {
		ProfileList profile = new ProfileList();
		profile.addProfileItem(enterProfile.getText());
			
				
				   });
		return enterProfile;
	
	}
	
	public Button addLaunchButton(int width, int length) {
		
		Button Launch = new Button("Launch Button");
		Launch.setMinSize(width, length);
		return Launch;
		
	}
   

    public Label headerLabel() {
    	Label talkBoxLabel = new Label(Names.TITLE);
    	talkBoxLabel.setStyle("-fx-font-family: TRON; -fx-font-size: 20;");
    	return talkBoxLabel;
    }
    
    public VBox addButtonPanelAndLabel(ScrollPane scrollpane) {
    	
    	 VBox section1 = new VBox(10);
         section1.getChildren().addAll(Menu().getMenu(),this.headerLabel(),scrollpane,this.addLaunchButton(40, 40));
         return section1;
         
    	
    	
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
	

	public TopMenu Menu(){
		TopMenu menu = new TopMenu();
		return menu;
		
	}
 

}