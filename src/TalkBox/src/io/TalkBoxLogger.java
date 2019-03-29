package io;

import java.awt.event.ActionEvent;
import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.FileHandler;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;

import javax.swing.JButton;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import javafx.scene.control.Button;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TreeItem;
import javafx.scene.input.MouseEvent;

public class TalkBoxLogger {

	static Logger logger;

	public static void setupLogger(File talkBoxDataPath, String logsDirRel) {

		logger = Logger.getGlobal();

		File logsDir = new File(talkBoxDataPath, logsDirRel);
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd-HH-mm-ss");
		String dateString = format.format(new Date());
		String now = dateString + "-log.txt";
		File logFile = new File(logsDir, now);
		try {
			logsDir.mkdirs();
			logFile.createNewFile();
			FileHandler fh;
			fh = new FileHandler(logFile.toString(), true);
			logger.addHandler(fh);
			logger.setLevel(Level.ALL);
			SimpleFormatter formatter = new SimpleFormatter();
			fh.setFormatter(formatter);
		} catch (Exception e) {
			e.printStackTrace();
		}

		logger.info("Start of Log");
	}

	public static void logProfilePressEvent(ChangeEvent e) {
		if (e.getSource() instanceof TreeItem<?>) {
			TreeItem<?> btn = (TreeItem<?>) e.getSource();
			logger.log(Level.INFO, "Pressed {0}", new Object[] { btn.getValue()});
		}
	}
	
	public static void logMenuPressEvent(javafx.event.ActionEvent e) {
		if (e.getSource() instanceof MenuItem) {
			MenuItem btn = (MenuItem) e.getSource();
			logger.log(Level.INFO, "Pressed {0} MenuItem", new Object[] { btn.getText()});
		}
	}
	public static void logMousePressEvent(MouseEvent e) {
		if (e.getSource() instanceof Button) {
			Button btn = (Button) e.getSource();
			System.out.println(btn.getText());
			logger.log(Level.INFO, "Pressed {0} button", new Object[] {btn.getText()});
		}
	}
}