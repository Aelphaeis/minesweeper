package com.cruat.minesweeper.core;

import java.security.SecureRandom;
import java.util.Random;

public enum BoardConfigPresets implements BoardConfigSpec {

	BEGINNER(9, 9, 10), INTERMEDIATE(16, 16, 40), EXPERT(30, 16, 99);

	private Random numberGenerator;
	private int bombCount;
	private int length;
	private int height;

	private BoardConfigPresets(int len, int height, int bombCount) {
		this.numberGenerator = new SecureRandom();
		this.bombCount = bombCount;
		this.height = height;
		this.length = len;
	}

	@Override
	public int getLength() {
		return length;
	}

	@Override
	public int getHeight() {
		return height;
	}

	@Override
	public int getBombCount() {
		return bombCount;
	}

	@Override
	public Random getNumberGenerator() {
		return numberGenerator;
	}
}
