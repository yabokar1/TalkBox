package _main;

import javafx.scene.Node;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;

public class RootView extends HBox {

	public void addChildView(Node e) {
		this.getChildren().add(e);
	}

}
