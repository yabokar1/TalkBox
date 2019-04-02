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
	
	public AudioSampleList() {
		privateListView = new ListView<String>();
		list = new ArrayList<String>();
	}


	public void loadFromDisk() {

		AudioFileIO io = new AudioFileIO();

		try {

			this.list = io.getAudioNames();

			for (String e : this.list) {

				this.privateListView.getItems().add(e);
			}

			this.privateListView.setMinSize(200, 175);

		} catch (Exception e) {
			System.out.println("hi");
		//	e.printStackTrace();
		}

	}
	

	public void notifyButtonPanel(String audioSampleName) {

		setChanged();
		notifyObservers(audioSampleName);

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
