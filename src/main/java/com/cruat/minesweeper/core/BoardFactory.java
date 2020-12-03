package com.cruat.minesweeper.core;

import java.util.Objects;
import java.util.Random;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class BoardFactory {

	private static final Logger logger = LogManager.getLogger();

	public Board build(BoardConfigSpec conf) {
		Random random = Objects.requireNonNull(conf.getNumberGenerator());
		int b = conf.getBombCount();
		int h = conf.getHeight();
		int l = conf.getLength();

		logger.info("creating [{}x{}] board with [{}] bombs", l, h, b);

		boolean[][] panels = new boolean[l][h];
		int panelCount = l * h;

		for (int i = 0; i < conf.getBombCount(); i++) {
			boolean retry = false;
			do {
				int bombLoc = random.nextInt(panelCount);
				logger.trace("created bombLocation {}", bombLoc);

				int x = bombLoc / conf.getHeight();
				logger.trace("resolved x = {} from {}", x, bombLoc);

				int y = bombLoc % conf.getHeight();
				logger.trace("resolved y = {} from {}", y, bombLoc);

				retry = panels[x][y];
				panels[x][y] = true;
				logger.trace("Bomb placed at [{}, {}]: {}", x, y, !retry);

			} while (retry);
		}
		return new GenericBoard(panels);
	}
}
