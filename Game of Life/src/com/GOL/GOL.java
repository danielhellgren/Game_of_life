package com.GOL;

import java.util.Random;

public class GOL {

	private int columns = 0;
	private int rows = 0;
	private int[][] gol_grid = new int[0][0];


	public GOL(int[][] grid) {

		this.gol_grid = grid;
		this.columns = grid.length;
		//assumes that the grid is uniform
		this.rows = grid[0].length;
	}

	public GOL(int rows, int columns) {

		this.columns = columns;
		this.rows = rows;
		this.gol_grid = createGrid(rows, columns);

	}

	//Creates a "matrix"
	private static int[][] createGrid(int rows, int columns) {

		int[][] grid = new int[rows][];
		for(int i = 0; i < rows; i++) {

			grid[i] = new int[columns];
		}

		return grid;
	}

	//Advances GOL once generation
	public void advanceGol() {

		//create new grid so we dont overwrite during scan
		this.gol_grid = getNextState();
	}

	//applies rules to get next state
	private int[][] getNextState(){

		int new_grid[][] = new int[rows][columns];

		//convert lengths to max coordinate
		int row = this.gol_grid.length-1;
		int col = this.gol_grid[0].length-1;

		for(int i = 0; i <= row; i++) {
			//here we are at a row
			for( int j = 0; j <= col; j++) {
				//here we are at a node row, column
				
				//get amount of neighbours for node
				int neighbours = countNeighbours(i, j);

				/*
				 	1 Any live cell with fewer than two live neighbors dies, as if by underpopulation.
					2 Any live cell with two or three live neighbors lives on to the next generation.
					3 Any live cell with more than three live neighbors dies, as if by overpopulation.
					4 Any dead cell with exactly three live neighbors becomes a live cell, as if by reproduction.
				 */
				//Rule 1 & 3
				if((neighbours < 2 || neighbours > 3) && this.gol_grid[i][j] == 1) { 
					new_grid[i][j] = 0;
				}
				//Rule 2
				if((neighbours >= 2 && neighbours <= 3) && this.gol_grid[i][j] == 1) { 
					new_grid[i][j] = 1;
				}
				//Rule 4
				if(neighbours == 3 && this.gol_grid[i][j] == 0) {
					new_grid[i][j] = 1;
				}

			}
		}
		return new_grid;
	}

	private int countNeighbours(int pos_row, int pos_col) {
		
		//convert lengths to max coordinate
		int row = this.gol_grid.length-1;
		int col = this.gol_grid[0].length-1;
		int neighbours = 0;
		
		//check surrounding 8 nodes
		//except if at edge
		if(pos_row > 0) {
			
			if(pos_col > 0) {
				neighbours += this.gol_grid[pos_row-1][pos_col-1];
			}
			if(pos_col < col) {				
				neighbours += this.gol_grid[pos_row-1][pos_col+1];
			}
			
			neighbours += this.gol_grid[pos_row-1][pos_col];
		}
		
		if(pos_row < row) {		
			
			if(pos_col > 0) {				
				neighbours += this.gol_grid[pos_row+1][pos_col-1];
			}			
			if(pos_col < col) {				
				neighbours += this.gol_grid[pos_row+1][pos_col+1];
			}
			
			neighbours += this.gol_grid[pos_row+1][pos_col];
		}
		
		if(pos_col > 0) {
			
			neighbours += this.gol_grid[pos_row][pos_col-1];
		}
		
		if(pos_col < col) {
			
			neighbours += this.gol_grid[pos_row][pos_col+1];
		}
		
		return neighbours;
	}



	//Fills 2dArray with random 1 0
	public void randomizeGol(){

		for(int i = 0; i < this.rows; i++) {

			for( int j = 0; j < this.columns; j++) {

				this.gol_grid[i][j] = new Random().nextInt(2);
			}
		}
	}

	//fancy print for grid
	public  void printGol() {

		System.out.print("==");
		for(int i = 0; i < this.columns; i++) {
			
			System.out.print("==");
		}
		
		System.out.println('=');

		for(int i = 0; i < this.rows; i++) {

			System.out.print("| ");
			for( int j = 0; j < this.columns; j++) {

				System.out.print(this.gol_grid[i][j] + " ");
			}
			System.out.println('|');
		}

		System.out.print("==");
		for(int i = 0; i < this.columns; i++) {
			
			System.out.print("==");
		}
		
		System.out.println("=");
	}


	public void setGol(int[][] gol_grid_new){

		this.gol_grid = gol_grid_new;
		this.columns = gol_grid_new[0].length;
		//assumes that the grid is uniform
		this.rows = gol_grid_new.length;
	}

	public int[][] getGolGrid(){

		return this.gol_grid;
	}

	public Boolean Equals(int[][] grid1, int[][] grid2) {
		
		if(grid1.length != grid2.length) {
			
			return false;
		}
		for (int i = 0; i < grid1.length; i++) {
			
			if(grid1[i].length != grid2[i].length) {

				return false;
			}
			for(int j = 0; j < grid1[1].length; j++) {
				
				if(grid1[i][j] != grid2[i][j]) {
					
					return false;
				}
			}
		}
		
		return true;
	}
}
