package com.GUI;

import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class Drawer extends JFrame {
	
	private int height;
	private int width;
	private int scale;
	private int spacing;
	private GridWindow window;
	
	public Drawer(int width, int height, int scale, int spacing, int[][]grid) {
		
		//acount for spacing in width and height
		this.height = height;
		this.width = width;
		this.scale = scale;
		this.spacing = spacing;
		
		//init window
		this.setTitle("Drawer 1.0");
		this.setSize(this.width, this.height);
		this.setVisible(true);
		this.setResizable(false);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		//set contents
		GridWindow window = new GridWindow(grid);
		this.setContentPane(window);
		this.window = window;
	}
	
	public class GridWindow extends JPanel{
		
		private int[][] grid;
		
		public GridWindow(int[][] grid) {
			this.grid = grid;
		}
		
		//paints squares
		@Override
		public void paintComponent(Graphics g) {
			
			//background
			g.setColor(Color.BLACK);
			g.fillRect(0, 0, width, height);
			
			int rows = grid.length;
			int cols = grid[0].length;
			
			//paint the gol
			for(int i = 0; i < rows; i++) {
				
				for(int j = 0; j < cols; j++) {
					//Dead
					g.setColor(Color.gray);
					if(grid[i][j] == 1) {
						//Alive
						g.setColor(Color.YELLOW);
						
					}
					
					g.fillRect(spacing + scale * i, spacing +  scale * j , scale - 2*spacing, scale - 2*spacing);
				}
			}
		}

		public void setGrid(int[][] grid) {
			
			this.grid = grid;
			
		}
	
	}
	
	//draws the grid
	public void drawGrid(int[][] grid) {
		
		this.window.setGrid(grid);
		//this.grid = grid;
		this.repaint();
		
	}
}
