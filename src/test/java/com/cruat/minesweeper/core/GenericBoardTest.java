package com.cruat.minesweeper.core;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.function.Executable;

public class GenericBoardTest {

	@Test
	public void ctor_null_npe() {
		Executable executable = () -> new GenericBoard(null);
		assertThrows(NullPointerException.class, executable);
	}

	@Test
	public void ctor_noLength_iae() {
		boolean[][] panels = new boolean[0][0];
		Executable executable = () -> new GenericBoard(panels);
		Exception e = assertThrows(IllegalArgumentException.class, executable);
		assertEquals("Length must be greater than 0", e.getMessage());
	}

	@Test
	public void ctor_noHeight_iae() {
		boolean[][] panels = new boolean[10][0];
		Executable executable = () -> new GenericBoard(panels);
		Exception e = assertThrows(IllegalArgumentException.class, executable);
		assertEquals("Height must be greater than 0", e.getMessage());
	}

	@Test
	public void ctor_inconsistentHeight_iae() {
		boolean[][] panels = new boolean[2][2];
		boolean[] column = new boolean[5];
		panels[1] = column;

		Executable executable = () -> new GenericBoard(panels);
		Exception e = assertThrows(IllegalArgumentException.class, executable);

		String fmt = "Expected column [%s] len to be [%s]. Got: [%s]";
		String exp = String.format(fmt, 1, 2, 5);
		assertEquals(exp, e.getMessage());
	}

	@Test
	public void ctor_panels_notNull() {
		boolean[][] panels = new boolean[2][3];
		GenericBoard board = new GenericBoard(panels);
		
		assertEquals(2, board.getLength());
		assertEquals(3, board.getHeight());
	}
}
