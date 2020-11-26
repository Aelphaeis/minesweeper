package com.cruat.minesweeper.core;

public interface Board {

	int getLength();

	int getHeight();

	boolean isBomb(int x, int y);
}
