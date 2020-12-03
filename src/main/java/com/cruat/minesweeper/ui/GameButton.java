package com.cruat.minesweeper.ui;

import java.awt.Dimension;

import javax.swing.JButton;

public class GameButton extends JButton {

	private static final long serialVersionUID = 1L;
	public static final int MIN_LENGTH = 50;
	public static final int MIN_HEIGHT = 50;
	private final int boardX;
	private final int boardY;

	public GameButton(int boardX, int boardY) {
		this.boardX = boardX;
		this.boardY = boardY;

		setMinimumSize(new Dimension(MIN_LENGTH, MIN_HEIGHT));
	}

	public int getBoardX() {
		return boardX;
	}

	public int getBoardY() {
		return boardY;
	}
}
