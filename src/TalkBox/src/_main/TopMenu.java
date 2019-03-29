package _main;

import java.util.Observable;
import java.util.Observer;
import io.ImportFiles;
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
	
	
	public TopMenu(ButtonPanel gp, TreeItem<String> Profile) {
		mb = new MenuBar();
		menu = new Menu("File");
		ImportAudio = new MenuItem("Import Audio");
		LoadProfile = new MenuItem("Load Profile");
		menu.getItems().addAll(ImportAudio,LoadProfile);
		mb.getMenus().addAll(menu);
		mb.setMaxWidth(65);
		ImportAudioListener();
		ImportProfiles(gp,Profile);
	}
	
	public MenuBar getMenu() {
		return this.mb;
	}
	
	private void ImportAudioListener() {
		this.ImportAudio.setOnAction(e->{
			ImportFiles ia = new ImportFiles();
			ia.open("TalkBox/");	
});};

	private void ImportProfiles(ButtonPanel panel, TreeItem<String> Profile) {
		this.LoadProfile.setOnAction(e ->{
			try {
				Load Load = new Load();
				Load.Loader(panel, Profile);
			} catch (Exception e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			
		});
	}

	@Override
	public void update(Observable o, Object arg) {
		// TODO Auto-generated method stub
		
	}

}
