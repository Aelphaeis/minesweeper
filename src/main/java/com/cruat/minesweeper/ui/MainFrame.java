package com.cruat.minesweeper.ui;

import javax.swing.JFrame;

import com.cruat.minesweeper.core.Board;
import com.cruat.minesweeper.core.BoardConfigPresets;
import com.cruat.minesweeper.core.BoardConfigSpec;
import com.cruat.minesweeper.core.BoardFactory;

public class MainFrame extends JFrame {

	private static final long serialVersionUID = 1L;
	private final BoardFactory boardFactory;

	public MainFrame() {
		super("Minesweeper by Aelphaeis");
		this.boardFactory = new BoardFactory();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	public void createGame() {
		createGame(BoardConfigPresets.BEGINNER);
	}

	public void createGame(BoardConfigSpec specification) {
		Board board = boardFactory.build(specification);
		BoardPanel panel = new BoardPanel(board);
		this.setMinimumSize(panel.getSize());;
		this.setSize(panel.getSize());
		this.add(panel);
	}
}
