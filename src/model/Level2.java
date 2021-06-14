package model;

import processing.core.PApplet;
import processing.core.PImage;

public class Level2 {
	
	private PImage level2A; //up left
	private PImage level2B; //up right
	private PImage level2C; //down left
	private PImage level2D; //down right
	
	private int changeLevel2;
	
	private PApplet app;
	
	public Level2(PApplet app) {
		
		this.app = app;
		
		level2A = app.loadImage("data/nivel2A.png");
		level2B = app.loadImage("data/nivel2B.png");
		level2C = app.loadImage("data/nivel2C.png");
		level2D = app.loadImage("data/nivel2D.png");
		
		changeLevel2 = 0; // 0 = C, 1 = D, 2 = A, 3 = B
		
	}
	
	public void draw() {
		
		switch (changeLevel2) {
		case 0: // down left
			app.image(level2C, 960, 450);
			break;
		case 1: // down right
			app.image(level2D, 960, 450);
			break;
		case 2: // up left
			app.image(level2A, 960, 450);
			break;
		case 3: // up right
			app.image(level2B, 960, 450);
			break;

		default:
			break;
		}
		
	}

}
