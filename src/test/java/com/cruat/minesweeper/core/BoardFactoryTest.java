package com.cruat.minesweeper.core;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.stringContainsInOrder;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import org.junit.jupiter.api.RepeatedTest;

public class BoardFactoryTest {

	@RepeatedTest(100)
	void build_62o10x_boardBuilt() {
		BoardConfig conf = new BoardConfig().setBombCount(10)
				.setHeight(9)
				.setLength(8);

		BoardFactory factory = new BoardFactory();
		Board board = factory.build(conf);

		assertEquals(9, board.getHeight());
		assertEquals(8, board.getLength());

		int count = 0;
		for (int y = 0; y < board.getHeight(); y++) {
			for (int x = 0; x < board.getLength(); x++) {
				if (board.isBomb(x, y)) {
					count++;
				}
			}
		}
		assertEquals(10, count);

		List<String> x = IntStream.range(0, 10)
				.mapToObj(p -> "x")
				.collect(Collectors.toList());
		String result = BoardHelper.printBoard(board);
		assertThat(result, stringContainsInOrder(x));
	}
}
