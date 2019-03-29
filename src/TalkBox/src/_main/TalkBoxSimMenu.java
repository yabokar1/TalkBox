package _main;

import java.io.IOException;

import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class TalkBoxSimMenu {

	
	private MenuBar mb;
	private Menu menu;
	private MenuItem Config;
	
	
	public TalkBoxSimMenu() {
		mb = new MenuBar();
		menu = new Menu("Configurator");
		Config = new MenuItem("Return To Configurator");
		menu.getItems().addAll(Config);
		mb.getMenus().addAll(menu);
		ActionListener();
	}
	
	public VBox mainVBox(HBox H) {
		VBox main = new VBox();
		main.getChildren().addAll(mb,H);
		return main;
	}
	
	public void ActionListener() {
		Config.setOnAction(e -> {
			_TalkBox Gui = new _TalkBox();
			try {
				Gui.start(new Stage());
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		});
	}
	
}
