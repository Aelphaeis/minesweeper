package com.cruat.minesweeper.core;

import java.util.Random;

public class BoardConfig implements BoardConfigSpec {

	private int length;
	private int height;
	private int bombCount;
	private Random numberGenerator;

	public int getLength() {
		return length;
	}

	public BoardConfig setLength(int length) {
		this.length = length;
		return this;
	}

	public int getHeight() {
		return height;
	}

	public BoardConfig setHeight(int height) {
		this.height = height;
		return this;
	}

	public int getBombCount() {
		return bombCount;
	}

	public BoardConfig setBombCount(int bombCount) {
		this.bombCount = bombCount;
		return this;

	}

	public Random getNumberGenerator() {
		return numberGenerator;
	}

	public BoardConfig setNumberGenerator(Random numberGenerator) {
		this.numberGenerator = numberGenerator;
		return this;
	}
}
