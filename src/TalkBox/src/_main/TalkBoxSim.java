package _main;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class TalkBoxSim extends Application{
	
	public static void main(String[] args) {
		launch(args);
	}

	@Override
	public void start(Stage primaryStage) throws Exception {
		HBox root = mainHbox();
		Scene scene = new Scene(root,1050,300);
		primaryStage.setScene(scene);
		primaryStage.show();
		
		
	}
	
	public HBox mainHbox() throws Exception {
	HBox main = new HBox();
	ButtonPanel ButtonP = new ButtonPanel();
	ScrollPane ScrollP = addScrollPane(ButtonP);
	main.getChildren().addAll(ScrollP,ProfileandSet());
	return main;
	}
	
	public VBox ProfileandSet() throws Exception {
		VBox ProfileandSetBox = new VBox();
		TalkBoxSimProfiles Profile = new TalkBoxSimProfiles();
		Button SetProfile = new Button("Set Profile");
		SetProfile.setMinSize(250, 50);
		ProfileandSetBox.getChildren().addAll(Profile.getProfiles(),SetProfile);
		return ProfileandSetBox;
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
