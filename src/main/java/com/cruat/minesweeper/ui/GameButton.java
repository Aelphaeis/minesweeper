package com.cruat.minesweeper.ui;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

public class GameButton extends JButton {

	private static final long serialVersionUID = 1L;
	
	public static final int MIN_LENGTH = 30;
	public static final int MIN_HEIGHT = 30;

	public GameButton() {
		super("");
		addActionListener(this.new DisableButtonListener());
		setMinimumSize(new Dimension(MIN_LENGTH, MIN_HEIGHT));
	}
	
	private class DisableButtonListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			GameButton.this.setEnabled(false);
			GameButton.this.removeActionListener(this);
		}
	}
}
