package talkBoxLog;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

import io.ImportFiles;
import javafx.scene.control.Button;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TextArea;
import javafx.scene.control.TreeItem;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;
import javafx.scene.layout.VBox;

public class TBCLogStage {
	
	private ImportFiles ImportFile;
	private VBox main;
	private MenuBar mb;
	private Menu menu;
	private MenuItem ImportLog;
	private TextArea text;
	
	
	public TBCLogStage() {
		ImportFile = new ImportFiles();
		main = new VBox();
		text = new TextArea();
	}

	public TextArea text() {
		text.setEditable(false);
		VBox.setVgrow(text, Priority.ALWAYS);
		return text;
	}
	
	
	public MenuBar setMenuBar() {
		mb = new MenuBar();
		menu = new Menu("File");
		ImportLog = new MenuItem("Load Log File");
		ImportLog.setOnAction(e ->{
			Load(ImportFile.LoggerOpen(),text());
		});
		menu.getItems().addAll(ImportLog);
		mb.getMenus().addAll(menu);
		return mb;
	}
	
	public VBox ImportLog() {
		setMenuBar();
		main.getChildren().addAll(mb,text);
		return main;
	}
	
	public void Load(File s,TextArea text) {
		try (BufferedReader reader = new BufferedReader(new FileReader(s))) {
	        String line;
	        while ((line = reader.readLine()) != null) {
	        text.appendText(line + "\n");	
	        }
	    } catch (IOException e) {
	        e.printStackTrace();
	    }
	}		

	
}
