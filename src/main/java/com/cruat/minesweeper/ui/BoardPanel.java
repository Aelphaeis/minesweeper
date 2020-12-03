package com.cruat.minesweeper.ui;

import java.awt.Component;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JPanel;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.cruat.minesweeper.core.Board;

public class BoardPanel extends JPanel {

	private static final Logger logger = LogManager.getLogger();
	private static final long serialVersionUID = 1L;
	private final Board board;

	public BoardPanel(Board b) {
		super(new GridLayout(b.getLength(), b.getHeight(), 0, 0));
		this.board = b;

		for (int y = 0; y < board.getHeight(); y++) {
			for (int x = 0; x < board.getLength(); x++) {
				GameButton btn = new GameButton(x, y);
				if (board.isBomb(x, y)) {
					btn.addActionListener(this.new BombButtonActionListener());
				}
				else {
					btn.addActionListener(this.new SafeButtonActionListener());
				}
				this.add(btn);
			}
		}

		int width = GameButton.MIN_LENGTH * board.getLength();
		int height = GameButton.MIN_HEIGHT * board.getHeight();
		this.setSize(new Dimension(width, height));
		this.setMinimumSize(new Dimension(width, height));
	}

	private void clickButton(int x, int y) {
		for(Component c : getComponents()) {
			if(!(c instanceof GameButton)) {
				continue;
			}
			GameButton btn = (GameButton) c;
			int bx = btn.getBoardX();
			int by = btn.getBoardY();
			
			if(bx == x && by == y && btn.isEnabled()) {
				btn.doClick();
			}
		}
	}

	private class SafeButtonActionListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			Object source = e.getSource();
			if (!(source instanceof GameButton)) {
				return;
			}
			GameButton btn = ((GameButton) source);
			btn.setEnabled(false);

			int x = btn.getBoardX();
			int y = btn.getBoardY();
			logger.info("button ({}, {}) clicked", x, y);


			List<int[]> investigated = new ArrayList<>();
			int b = 0;

			logger.trace("calculating value for ({}, {})", x, y);
			for (int xo = -1; xo < 2; xo++) {
				for (int yo = -1; yo < 2; yo++) {
					if (yo == 0 && xo == 0) {
						// this is currently clicked button
						continue;
					}

					int cx = x + xo;
					int cy = y + yo;
					
					investigated.add(new int[] { cx, cy });

					if (withinXBound(cx) && withinYBound(cy)) {
						if (BoardPanel.this.board.isBomb(cx, cy)) {
							logger.trace("({}, {}) is a bomb", cx, cy);
							b++;
						}
						else {
							logger.trace("({}, {}) is not a bomb", cx, cy);
						}
					}
					else {
						logger.trace("({}, {}) is an invalid location", cx, cy);
					}
				}
			}

			logger.trace("({}, {}) is {}", x, y, investigated.size());
			if (b == 0) {
				for (int[] cord : investigated) {
					BoardPanel.this.clickButton(cord[0], cord[1]);
				}
			}
			else {
				btn.setText(String.valueOf(b));
			}

		}

		private boolean withinXBound(int n) {
			int max = BoardPanel.this.board.getLength();
			return n >= 0 && n < max;
		}

		private boolean withinYBound(int n) {
			int max = BoardPanel.this.board.getHeight();
			return n >= 0 && n < max;
		}
	}

	private class BombButtonActionListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			Object source = e.getSource();
			if (!(source instanceof GameButton)) {
				return;
			}
			((GameButton) source).setEnabled(false);
			((GameButton) source).setText("*");

		}
	}
}
