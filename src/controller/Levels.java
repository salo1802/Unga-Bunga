package controller;

import processing.core.PApplet;
import processing.core.PImage;

public class Levels {
	
	private PImage level1;
	private PApplet app;
	
	private int levelNumber;
	
	private boolean changeLevel1, changeLevel2, changeLevel3;
	
	public Levels(PApplet app) { // idk if we should use inheritance
		this.app = app;
		
		levelNumber = 1; //1 = level 1, 2 = level 2, 3 = level 3
		
		level1 = app.loadImage("data/nivel1.png");
	}
	
	public void drawLevels() {
		
		switch (levelNumber) {
		case 1:
			app.image(level1, 0, 0);
			break;

		default:
			break;
		}
	}
	
	public void changeLevels() {
		
	}

}
