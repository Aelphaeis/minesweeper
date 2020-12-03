package com.cruat.minesweeper.ui;

import java.awt.Dimension;
import java.awt.GridLayout;

import javax.swing.JPanel;

import com.cruat.minesweeper.core.Board;

public class BoardPanel extends JPanel {

	private static final long serialVersionUID = 1L;
	private final Board board;

	public BoardPanel(Board b) {
		super(new GridLayout(b.getLength(), b.getHeight(), 0, 0));
		this.board = b;
		
		for (int y = 0; y < board.getHeight(); y++) {
			for (int x = 0; x < board.getLength(); x++) {
				this.add(new GameButton());
			}
		}

		int width = GameButton.MIN_LENGTH * board.getLength();
		int height = GameButton.MIN_HEIGHT * board.getHeight();
		this.setMinimumSize(new Dimension(width, height));
		this.setSize(getMinimumSize());
	}
}
