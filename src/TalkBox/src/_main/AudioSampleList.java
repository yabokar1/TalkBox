package _main;

import java.util.ArrayList;
import java.util.List;

import io.AudioFileIO;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.scene.control.ListView;
import javafx.scene.layout.VBox;

import java.util.Observable;

public class AudioSampleList extends Observable {
	
	
	private ListView<String> privateListView;
	public List<String> list;
	public List<String> Testerlist;
	
	public AudioSampleList() {
		//privateListView = new ListView<String>();
		list = new ArrayList<String>();
		Testerlist= new ArrayList<String>();
	}

	
	/*
	 * 
	 * This method loads the audioFiles from their location  on the computer to the AudioPanel
	 * The method this.AudioSampleSizeIncrement(String e) is used as a test method to actually see if the items are
	 * being added and it seems that privateListView is adding the same amount of strings as 
	 * AudioSampleSizeIncrement(String e) is used as a test method to actually see if the items are added.
	 * 
	 */

	public void loadFromDisk() {

		AudioFileIO io = new AudioFileIO();
		privateListView = new ListView<String>();
		try {

			this.list = io.getAudioNames();

			for (String e : this.list) {

				this.privateListView.getItems().add(e);
				this.AudioSampleSizeIncrement(e);  // Test Method
			}

			this.privateListView.setMinSize(200, 175);

		} catch (Exception e) {
		
		
		}

	}
	
	
	public void AudioSampleSizeIncrement(String e) {   //This method is used to check if the privateListView increased by
											  //using the ist<String> list as a test replacement
			this.Testerlist.add(e);
			
			
		}
		
	public int getAudioSampleSizeIncrement() {
		
		
		return this.Testerlist.size();
	}
	

	public void notifyButtonPanel(String audioSampleName) {

		setChanged();
		notifyObservers(audioSampleName);

	}

	
	public int getSize() {
		
		return this.list.size();
	}

	
	public void attachListener() {

		this.privateListView.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<Object>() {

			@Override
			public void changed(ObservableValue observable, Object oldValue, Object newValue) {

				notifyButtonPanel(newValue.toString());

			}
		});
	}

	public ListView<String> getList() {
		attachListener();
		return this.privateListView;
	}

	public VBox getView() {
		attachListener();
		VBox listview = new VBox(this.privateListView);
		return new VBox(this.privateListView);

	}

}
