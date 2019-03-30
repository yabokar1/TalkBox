package _main;

import java.io.File;

import io.TalkBoxLogger;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class TalkBoxSim extends Application{
	
	private File TalkBoxDataPath;
	
	public static void main(String[] args) {
		launch(args);
	}

	@Override
	public void start(Stage primaryStage) throws Exception {
	  	TalkBoxLogger.setupLogger(TalkBoxDataPath, "simulator-log");
	  	GridPane p = new GridPane();
		HBox HBox = mainHbox(p);
		VBox root = new VBox();
		TalkBoxSimMenu main = new TalkBoxSimMenu(p);
		root.getChildren().add(main.mainVBox(HBox));
		Scene scene = new Scene(root,800,300);
		primaryStage.setScene(scene);
		primaryStage.show();	
	}
	
	public HBox mainHbox(GridPane ButtonP) throws Exception {
	HBox main = new HBox();
	ScrollPane ScrollP = addScrollPane(ButtonP);
	main.getChildren().addAll(ScrollP);
	return main;
	}
	
	public ScrollPane addScrollPane(GridPane buttonpanel) {
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
