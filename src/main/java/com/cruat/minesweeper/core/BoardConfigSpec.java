package com.cruat.minesweeper.core;

import java.util.Random;;

public interface BoardConfigSpec {

	int getLength();

	int getHeight();

	int getBombCount();
	
	Random getNumberGenerator();
}
