package com.cruat.minesweeper.core;

import java.util.Objects;

/**
 * This class represents a generic board.
 */
public class GenericBoard implements Board {

	private final int length;
	private final int height;
	private final boolean[][] panels;

	public GenericBoard(boolean[][] panels) {
		Objects.requireNonNull(panels);

		if (panels.length <= 0) {
			String err = "Length must be greater than 0";
			throw new IllegalArgumentException(err);
		}

		if (panels[0].length <= 0) {
			String err = "Height must be greater than 0";
			throw new IllegalArgumentException(err);
		}

		int expected = panels[0].length;
		for (int i = 0; i < panels.length; i++) {
			if (panels[i].length != expected) {
				String fmt = "Expected column [%s] len to be [%s]. Got: [%s]";
				String err = String.format(fmt, i, expected, panels[i].length);
				throw new IllegalArgumentException(err);
			}
		}

		this.length = panels.length;
		this.height = expected;
		this.panels = panels;
	}

	@Override
	public boolean isBomb(int x, int y) {
		return panels[x][y];
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
	public String toString() {
		return new StringBuilder().append("GenericBoard [length=")
				.append(length)
				.append(", height=")
				.append(height)
				.append("]")
				.toString();
	}
}
