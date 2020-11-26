package com.cruat.minesweeper.core;

public class BoardHelper {

	public static String printBoard(Board board) {

		StringBuilder resultBuilder = new StringBuilder();
		for (int y = 0; y < board.getHeight(); y++) {
			StringBuilder rowBuilder = new StringBuilder();
			for (int x = 0; x < board.getLength(); x++) {
				if (board.isBomb(x, y)) {
					rowBuilder.append("x");
				}
				else {
					rowBuilder.append("o");
				}
				rowBuilder.append(" ");
			}
			rowBuilder.setLength(rowBuilder.length() - 1);
			resultBuilder.append(rowBuilder);
			resultBuilder.append(System.lineSeparator());
		}
		return resultBuilder.toString();
	}

	private BoardHelper() {
		throw new UnsupportedOperationException("utility class");
	}
}
