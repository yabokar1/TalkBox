package io;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.FileHandler;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;
import _main.ProfileList;
import javafx.beans.value.ChangeListener;
import javafx.event.ActionEvent;
import javafx.scene.control.Button;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;

public class TalkBoxLogger {

	public static Logger TBlogger;

	public static void setupTBlogger(File Path, String OutputDir) {

		TBlogger = Logger.getGlobal();

		File logsDir = new File(Path, OutputDir);
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd-HH-mm-ss");
		String dateString = format.format(new Date());
		File logFile = new File(logsDir, dateString);
		try {
			logsDir.mkdirs();
			logFile.createNewFile();
			FileHandler filehandle = new FileHandler(logFile.toString(), true);
			TBlogger.addHandler(filehandle);
			TBlogger.setLevel(Level.ALL);
			SimpleFormatter formatter = new SimpleFormatter();
			filehandle.setFormatter(formatter);
		} catch (Exception e) {
			e.printStackTrace();
		}
		TBlogger.info("Start of Log");
	}

	public static void logProfilePressEvent(javafx.event.ActionEvent e,ProfileList p) {
		if (e.getSource() instanceof Button) {
			TBlogger.log(Level.INFO, "Set {0}", new Object[] {p.getProfileName(p.getRow())});
		}
	}
	
	public static void logTextFieldEvent(javafx.event.ActionEvent e) {
		if (e.getSource() instanceof TextField) {
			TextField t = (TextField) e.getSource();
			TBlogger.log(Level.INFO, "Set {0} Text", new Object[] {t.getText()});
		}
	}
	
	public static void logMenuPressEvent(javafx.event.ActionEvent e) {
		if (e.getSource() instanceof MenuItem) {
			MenuItem btn = (MenuItem) e.getSource();
			TBlogger.log(Level.INFO, "Pressed {0} MenuItem", new Object[] { btn.getText()});
		}
	}
	
	public static void logButtonPressEvent(ActionEvent e) {
		if(e.getSource() instanceof Button) {
			Button btn = (Button) e.getSource();
			TBlogger.log(Level.INFO, "Pressed {0} Button", new Object[] {btn.getText()});
		}
	}
	
	public static void logMousePressEvent(MouseEvent e) {
		if (e.getSource() instanceof Button) {
			Button btn = (Button) e.getSource();
			System.out.println(btn.getText());
			TBlogger.log(Level.INFO, "Pressed {0} button", new Object[] {btn.getText()});
		}
	}
}