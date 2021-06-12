package controller;

import processing.core.PApplet;
import processing.core.PImage;

public class GameScreen {
	
	private Levels levels;
	private PApplet app;
	
	public GameScreen(PApplet app) {
		this.app = app;
		
		levels = new Levels(app);
		
	}
	
	public void drawLevels() {
		
		levels.drawLevels();
		
	}

}
