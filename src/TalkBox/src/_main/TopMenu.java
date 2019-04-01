package _main;

import java.util.Observable;
import java.util.Observer;
import io.ImportFiles;
import io.TalkBoxLogger;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TreeItem;
import javafx.scene.layout.GridPane;

public class TopMenu extends MenuBar implements Observer{

	private MenuBar mb;
	private Menu menu;
	private MenuItem ImportAudio;
	private MenuItem LoadProfile;
	private MenuItem refresh;
	
	

	public TopMenu() {
		mb = new MenuBar();
		menu = new Menu("File");
		ImportAudio = new MenuItem("Import Audio");
		LoadProfile = new MenuItem("Load Profile");
		refresh = new MenuItem("refresh");
		menu.getItems().addAll(ImportAudio,LoadProfile,refresh);
		mb.getMenus().addAll(menu);
		mb.setMaxWidth(65);
	}
	
	public MenuBar getMenu() {
		return this.mb;
	}
	
	public MenuItem getImport() {
		return this.ImportAudio;
	}
	
	public MenuItem getLoad() {
		return this.LoadProfile;
	}
	
	public MenuItem getrefresh() {
		return this.refresh;
	}
	
	
	public void ImportAudioListener(MenuItem item) {
			ImportFiles ia = new ImportFiles();
			ia.open("TalkBox/");	
};
	

	public void ImportProfiles(MenuItem item, TreeItem<String> Profile) {
		item.setOnAction(e ->{
			try {
				TalkBoxLogger.logMenuPressEvent(e);
				Load Load = new Load();
				Load.Loader(Profile);
			} catch (Exception e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		});
	}


	public void update(Observable o, Object arg) {
		// TODO Auto-generated method stub
		
	}

}
