package _main;

import java.io.IOException;

import io.TalkBoxLogger;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;


public class TalkBoxSimMenu {

	private TalkBoxConfig tbc;
	private MenuBar mb;
	private Menu menu;
	private MenuItem Config;
	private Menu Profiles;
	private int row;
	
	public TalkBoxSimMenu(GridPane p) throws Exception {
		tbc=(TalkBoxConfig) Serializer.Load("TalkBox/TalkBoxData/TalkBoxData.tbc");
		mb = new MenuBar();
		menu = new Menu("Configurator");
		Profiles = new Menu("Profiles");
		Config = new MenuItem("Return To Configurator");
		menu.getItems().addAll(Config);
		mb.getMenus().addAll(menu,Profiles);
		ProfileAdder(p);
		ActionListener();
	}
	
	public VBox mainVBox(HBox H) {
		VBox main = new VBox();
		main.getChildren().addAll(mb,H);
		return main;
	}
	
	public void ProfileAdder(GridPane p) {
		for(String temp : this.tbc.getProfile()){
			MenuItem item = new MenuItem(temp);
			item.setId(String.format("%d", row));
			Profiles.getItems().add(item);
			item.setOnAction(e ->{
				TalkBoxSimProfiles tbsp;
				try {
					tbsp = new TalkBoxSimProfiles();
					tbsp.getProfiles(p, item.getId());
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			});
			row++;
		}
	}

	
	public void ActionListener() {
		Config.setOnAction(e -> {
			TalkBoxLogger.logMenuPressEvent(e);
			_TalkBox Gui = new _TalkBox();
			try {
				Gui.start(new Stage());
			} catch (IOException e1) {
				e1.printStackTrace();
			}
		});
	}
	
}
