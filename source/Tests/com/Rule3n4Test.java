package com;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import com.GOL.GOL;

class Rule3n4Test {

	@Test
	void test() {

		//Start value 
		// 0 x 0
		// x x x
		// 0 x 0
		int[][] test_grid_start = new int[3][3];
		test_grid_start[0][0] = 0;
		test_grid_start[0][1] = 1;
		test_grid_start[0][2] = 0;

		test_grid_start[1][0] = 1;
		test_grid_start[1][1] = 1;
		test_grid_start[1][2] = 1;

		test_grid_start[2][0] = 0;
		test_grid_start[2][1] = 1;
		test_grid_start[2][2] = 0;

		//set grid
		GOL gol_test = new GOL(test_grid_start);
		
		//expected result next generation
		// x x x
		// x 0 x
		// x x x
		int[][] test_grid_result = new int[3][3];
		test_grid_result[0][0] = 1;
		test_grid_result[0][1] = 1;
		test_grid_result[0][2] = 1;

		test_grid_result[1][0] = 1;
		test_grid_result[1][1] = 0;
		test_grid_result[1][2] = 1;

		test_grid_result[2][0] = 1;
		test_grid_result[2][1] = 1;
		test_grid_result[2][2] = 1;

		//run simulation
		gol_test.advanceGol();
		//test
		assert(gol_test.Equals(gol_test.getGolGrid(), test_grid_result));
////////////////////////////////
		
		//expected result next generation
		// x 0 x
		// 0 0 0
		// x 0 x	
		test_grid_result[0][0] = 1;
		test_grid_result[0][1] = 0;
		test_grid_result[0][2] = 1;

		test_grid_result[1][0] = 0;
		test_grid_result[1][1] = 0;
		test_grid_result[1][2] = 0;

		test_grid_result[2][0] = 1;
		test_grid_result[2][1] = 0;
		test_grid_result[2][2] = 1;

		//run simulation
		gol_test.advanceGol();

		//test
		assert(gol_test.Equals(gol_test.getGolGrid(), test_grid_result));
////////////////////////////////////
		
		//expected result next generation
		// 0 0 0 
		// 0 0 0
		// 0 0 0
		test_grid_result[0][0] = 0;
		test_grid_result[0][1] = 0;
		test_grid_result[0][2] = 0;

		test_grid_result[1][0] = 0;
		test_grid_result[1][1] = 0;
		test_grid_result[1][2] = 0;

		test_grid_result[2][0] = 0;
		test_grid_result[2][1] = 0;
		test_grid_result[2][2] = 0;
		
		//run simulation
		gol_test.advanceGol();;

		assert(gol_test.Equals(gol_test.getGolGrid(), test_grid_result));
	}

}
