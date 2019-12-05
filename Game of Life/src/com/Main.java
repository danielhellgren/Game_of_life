package com;

import com.GOL.*;
import com.GUI.*;

public class Main {
	
	//Change here if you want different scales
	private static final int WINDOW_WIDTH = 900;
	private static final int WINDOW_HEIGHT = 900;
	private static final int SQUARE_SCALE = 10;
	private static final int SQUARE_SPACING = 1;
	

	public static void main(String[] args) throws InterruptedException {
		
		//calculate how many nodes fit with that scale 
		int col = WINDOW_WIDTH / (SQUARE_SCALE );
		int row = WINDOW_HEIGHT / (SQUARE_SCALE  );	
				
		//create game object
		GOL gol = new GOL(row, col);
		//randomize start state
		gol.randomizeGol();
		
		//create gui drawer
		Drawer drawer = new Drawer((WINDOW_WIDTH), (WINDOW_HEIGHT), SQUARE_SCALE, SQUARE_SPACING, gol.getGolGrid());
		
		//run simulation
		while(true) {
			
			//draw gol
			drawer.drawGrid(gol.getGolGrid());
			//print gamestate if you want
			//gol.printGol();
			//System.out.println(" ");
			
			//advance gol one generation
			gol.advanceGol();
			
			//sleep timer
			Thread.sleep(250);  
		}	 
	}
	
	

}
