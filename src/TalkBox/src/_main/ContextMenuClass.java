package _main;

import java.util.ArrayList;

import io.ImportFiles;
import javafx.scene.control.Button;
import javafx.scene.control.ContextMenu;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class ContextMenuClass {

	ContextMenu cm;
	MenuItem LoadImage;
	MenuItem Rename;

	public ContextMenuClass(Button b, ProfileList list,String s,int row) {
		cm = new ContextMenu();
		LoadImage = new MenuItem("Load Image");
		Rename = new MenuItem("Rename");
		cm.getItems().addAll(LoadImage,Rename);
		
	}
	
	public void attachImageAdder(Button b, ProfileList list,int row) {
			 b.setId("image");
			 ImportFiles image = new ImportFiles();
             image.open("Images/");
             Image pic = new Image(image.file.toURI().toString());  
             list.ImageSet.get(row).add(image.file.toURI().toString());
             list.RenameSet.get(row).add(null);
             ImageView iv = new ImageView(pic);
             iv.fitWidthProperty().bind(b.widthProperty());
             iv.fitHeightProperty().bind(b.heightProperty());
             b.setGraphic(iv);
}
	public void rename(Button b,String s,ProfileList list, int row) {
	    b.setText(s);
		list.RenameSet.get(row).add(s);
		list.ImageSet.get(row).add(null);
	}
}


