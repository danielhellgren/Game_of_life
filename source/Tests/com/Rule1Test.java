package com;

import com.GOL.*;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class Rule1Test {

	@Test
	void test() {

		//Rule 1 Any live cell with fewer than two live neighbors dies, as if by underpopulation.


		//Start value 
		// x 0 0
		// 0 x 0
		// 0 0 x
		
		int[][] test_grid_start = new int[3][3];
		test_grid_start[0][0] = 1;
		test_grid_start[0][1] = 0;
		test_grid_start[0][2] = 0;

		test_grid_start[1][0] = 0;
		test_grid_start[1][1] = 1;
		test_grid_start[1][2] = 0;

		test_grid_start[2][0] = 0;
		test_grid_start[2][1] = 0;
		test_grid_start[2][2] = 1;

		//All should be dead after 2 generations
		int[][] test_grid_result = new int[3][3];
		test_grid_result[0][0] = 0;
		test_grid_result[0][1] = 0;
		test_grid_result[0][2] = 0;

		test_grid_result[1][0] = 0;
		test_grid_result[1][1] = 0;
		test_grid_result[1][2] = 0;

		test_grid_result[2][0] = 0;
		test_grid_result[2][1] = 0;
		test_grid_result[2][2] = 0;

		//set grid
		GOL gol_test = new GOL(test_grid_start);
		//run simulation
		gol_test.advanceGol();
		gol_test.advanceGol();

		//test
		assert(gol_test.Equals(gol_test.getGolGrid(), test_grid_result));


	}
	
	
}
