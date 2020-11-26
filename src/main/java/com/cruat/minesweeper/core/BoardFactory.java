package com.cruat.minesweeper.core;

import java.util.Objects;
import java.util.Random;

public class BoardFactory {

	public Board build(BoardConfigSpec conf) {
		Random random = Objects.requireNonNull(conf.getNumberGenerator());

		boolean[][] panels = new boolean[conf.getLength()][conf.getHeight()];
		int panelCount = conf.getLength() * conf.getHeight();
		for (int i = 0; i < conf.getBombCount(); i++) {
			boolean retry = false;
			do {
				int bombLocation = random.nextInt(panelCount);
				int y = bombLocation / conf.getHeight();
				int x = bombLocation % conf.getLength();

				retry = panels[x][y];
				panels[x][y] = true;

			} while (retry);
		}
		return new GenericBoard(panels);
	}
}
