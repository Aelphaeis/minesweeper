package com.cruat.minesweeper;

import java.time.LocalTime;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.cruat.minesweeper.ui.MainFrame;

public class Program {
	private static final Logger logger = LogManager.getLogger();
	public static void main(String[] args) {
		logger.info("Starting minesweeper by Aelphaeis at {}", LocalTime.now());
		MainFrame frame = new MainFrame();
		frame.createGame();
		frame.setVisible(true);
	}
}
