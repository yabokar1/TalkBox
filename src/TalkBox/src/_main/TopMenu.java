package _main;

import java.io.File;
import java.util.Observable;
import java.util.Observer;

import audio_players.AudioClipWav;
import io.ImportFiles;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseButton;
import javafx.scene.input.MouseEvent;

public class TopMenu extends MenuBar implements Observer{

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
		ImportAudioListener();
		ImportProfiles();
	}
	
	public MenuBar getMenu() {
		return this.mb;
	}
	
	private void ImportAudioListener() {
		this.ImportAudio.setOnAction(e->{
			ImportFiles ia = new ImportFiles();
			ia.open("sound_samples/");	
});};

	private void ImportProfiles() {
		this.LoadProfile.setOnAction(e ->{
			System.out.println("Not yet implemented");
		});
	}

	@Override
	public void update(Observable o, Object arg) {
		// TODO Auto-generated method stub
		
	}

}
