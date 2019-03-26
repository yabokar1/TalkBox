package _main;

import java.util.List;

import io.AudioFileIO;
import javafx.beans.InvalidationListener;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.geometry.Pos;
import javafx.scene.control.ListView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

import java.util.Observable;

public class AudioSampleList extends Observable {
	
	
	private ListView<String> privateListView = new ListView<String>();

	public void loadFromDisk() {

		AudioFileIO io = new AudioFileIO();

		try {

			List<String> list = io.getAudioNames();

			for (String e : list) {

				privateListView.getItems().add(e);
			}

			privateListView.setMinSize(200, 175);

		} catch (Exception e) {

			e.printStackTrace();
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
