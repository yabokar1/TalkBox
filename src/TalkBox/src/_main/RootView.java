package _main;

import javafx.scene.Node;
import javafx.scene.layout.HBox;

public class RootView extends HBox {

	public void addChildView(Node e) {
		this.getChildren().add(e);
	}

}
