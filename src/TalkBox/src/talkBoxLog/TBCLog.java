package talkBoxLog;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

public class TBCLog extends Application {

	@Override
	public void start(Stage primaryStage) throws Exception {
	TBCLogStage t = new TBCLogStage();
	HBox main = new HBox();
	main.getChildren().addAll(t.ImportLog());
	Scene scene = new Scene(main,500,500);
	primaryStage.setScene(scene);
	primaryStage.show();
		}
	
	
public static void main(String[] args) {
	launch(args);
	}
	
	

}
