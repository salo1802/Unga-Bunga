package controller;

import processing.core.PApplet;
import processing.core.PImage;

public class GameScreen {
	
	private Level level;
	private PApplet app;
	
	public GameScreen(PApplet app) {
		this.app = app;
		
		level = new Level(app);
		
	}
	
	public void drawLevel() {
		
		level.drawLevel();
		
	}

}
