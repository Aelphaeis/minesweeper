package com.cruat.minesweeper.core;

import java.util.Random;;

public interface BoardConfig {

	int getLength();

	int getHeight();

	int getBombCount();
	
	Random getNumberGenerator();
}
