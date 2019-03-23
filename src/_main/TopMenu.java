package _main;

import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;

public class TopMenu extends MenuBar {

	private MenuBar mb;
	private Menu menu;
	private MenuItem ImportAudio;
	private MenuItem LoadProfile;
	
	
	public TopMenu() {
		mb = new MenuBar();
		menu = new Menu("File");
		ImportAudio = new MenuItem("Import Audio");
		LoadProfile = new MenuItem("Load Profile");
		menu.getItems().addAll(ImportAudio,LoadProfile);
		mb.getMenus().addAll(menu);
		mb.setMaxWidth(65);
	}
	
	public MenuBar getMenu() {
		return this.mb;
	}
}
