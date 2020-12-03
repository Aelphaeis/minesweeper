package com.cruat.minesweeper.ui;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

public class GameButton extends JButton {

	private static final long serialVersionUID = 1L;

	public GameButton() {
		super("");
		setMinimumSize(new Dimension(30, 30));
		addActionListener(this.new DisableButtonListener());
	}
	
	

	private class DisableButtonListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			GameButton.this.setEnabled(false);
			GameButton.this.removeActionListener(this);
		}
	}
}
