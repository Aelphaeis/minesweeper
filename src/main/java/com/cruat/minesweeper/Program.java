package com.cruat.minesweeper;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.cruat.minesweeper.ui.MainFrame;

public class Program {
	private static final Logger logger = LogManager.getLogger();
	public static void main(String[] args) {
		MainFrame frame = new MainFrame();
		frame.setVisible(true);
		logger.info("Hello World");
	}
}
