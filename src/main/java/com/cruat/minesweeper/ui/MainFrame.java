package com.cruat.minesweeper.ui;

import java.awt.GridLayout;

import javax.swing.JFrame;
import javax.swing.JPanel;

import com.cruat.minesweeper.core.Board;
import com.cruat.minesweeper.core.BoardConfigPresets;
import com.cruat.minesweeper.core.BoardConfigSpec;
import com.cruat.minesweeper.core.BoardFactory;

public class MainFrame extends JFrame {
	
	private static final int BTN_LENGTH = 30;
	private static final int BTN_HEIGHT = 30;


	private static final long serialVersionUID = 1L;
	private final BoardFactory boardFactory;

	public MainFrame() {
		super("Minesweeper by Aelphaeis");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		

		this.boardFactory = new BoardFactory();
	}

	public void createGame() {
		createGame(BoardConfigPresets.EXPERT);
	}

	public void createGame(BoardConfigSpec specification) {
		Board board = boardFactory.build(specification);

		int rows = board.getHeight();
		int cols = board.getLength();

		GridLayout layout = new GridLayout(rows, cols);
		JPanel panel = new JPanel(layout);

		for (int x = 0; x < board.getLength(); x++) {
			for (int y = 0; y < board.getHeight(); y++) {
				panel.add(new GameButton());
			}
		}
		
		
		setSize(cols * BTN_LENGTH, rows * BTN_HEIGHT);
		setMinimumSize(getSize());
		this.add(panel);

	}
}
