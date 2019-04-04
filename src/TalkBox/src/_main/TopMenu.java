package _main;

import java.util.Observable;
import java.util.Observer;
import io.ImportFiles;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;

public class TopMenu extends MenuBar implements Observer{

	private MenuBar mb;
	private Menu menu;
	private MenuItem ImportAudio;
	

	public TopMenu() {
		mb = new MenuBar();
		menu = new Menu("File");
		ImportAudio = new MenuItem("Import Audio");
		menu.getItems().addAll(ImportAudio);
		mb.getMenus().addAll(menu);
		mb.setMaxWidth(65);
	}
	
	public MenuBar getMenu() {
		return this.mb;
	}
	
	public MenuItem getImport() {
		return this.ImportAudio;
	}

	
	public void ImportAudioListener(MenuItem item) {
			ImportFiles ia = new ImportFiles();
			ia.open("TalkBox/src/Audio/");	
};
	
	public void update(Observable o, Object arg) {
		// TODO Auto-generated method stub
		
	}

}
