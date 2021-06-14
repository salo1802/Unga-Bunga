package model;

import processing.core.PApplet;
import processing.core.PImage;

public class Level3 {
	
	private PImage level3A; //up left
	private PImage level3B; //up right
	private PImage level3C; //down left
	private PImage level3D; //down right
	
	private PApplet app;
	
	private int changeLevel3;
	
	public Level3(PApplet app) {
		
		this.app = app;
		
		level3A = app.loadImage("data/nivel3A.png");
		level3B = app.loadImage("data/nivel3B.png");
		level3C = app.loadImage("data/nivel3C.png");
		level3D = app.loadImage("data/nivel3D.png");
		
		changeLevel3 = 0; // 0 = C, 1 = D, 2 = A, 3 = B
		
	}
	
	public void draw() {
		
		switch (changeLevel3) {
		case 0: // down left
			app.image(level3C, 960, 450);
			break;
		case 1: // down right
			app.image(level3D, 960, 450);
			break;
		case 2: // up left
			app.image(level3A, 960, 450);
			break;
		case 3: // up right
			app.image(level3B, 960, 450);
			break;

		default:
			break;
		}
		
	}

}
