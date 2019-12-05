package com;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import com.GOL.GOL;

class Rule2Test {

	@Test
	void test() {
		//Testing with known stable configartions from wiki page
		//the block
		// 0 0 0 0
		// 0 x x 0
		// 0 x x 0
		// 0 0 0 0

		int[][] test_grid_start = new int[4][4];
		test_grid_start[0][0] = 0;
		test_grid_start[0][1] = 0;
		test_grid_start[0][2] = 0;
		test_grid_start[0][3] = 0;

		test_grid_start[1][0] = 0;
		test_grid_start[1][1] = 1;
		test_grid_start[1][2] = 1;
		test_grid_start[1][3] = 0;

		test_grid_start[2][0] = 0;
		test_grid_start[2][1] = 1;
		test_grid_start[2][2] = 1;
		test_grid_start[2][3] = 0;

		test_grid_start[3][0] = 0;
		test_grid_start[3][1] = 0;
		test_grid_start[3][2] = 0;
		test_grid_start[3][3] = 0;

		//expected result
		int[][] test_grid_result = new int[4][4];
		test_grid_result[0][0] = 0;
		test_grid_result[0][1] = 0;
		test_grid_result[0][2] = 0;
		test_grid_result[0][3] = 0;

		test_grid_result[1][0] = 0;
		test_grid_result[1][1] = 1;
		test_grid_result[1][2] = 1;
		test_grid_result[1][3] = 0;

		test_grid_result[2][0] = 0;
		test_grid_result[2][1] = 1;
		test_grid_result[2][2] = 1;
		test_grid_result[2][3] = 0;

		test_grid_result[3][0] = 0;
		test_grid_result[3][1] = 0;
		test_grid_result[3][2] = 0;
		test_grid_result[3][3] = 0;

		//set grid
		GOL gol_test = new GOL(test_grid_start);

		//gol_test.printGol(test);
		//run simulation	

		for(int i = 0; i < 100; i++) {
			gol_test.printGol();
			System.out.println(" ");
			gol_test.advanceGol();
			assert(gol_test.Equals(gol_test.getGolGrid(), test_grid_result));
		}


	}

}
