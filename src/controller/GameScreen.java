package controller;

import model.Level1;
import model.Level2;
import model.Level3;
import processing.core.PApplet;
import processing.core.PImage;

public class GameScreen {
	

	private PApplet app;
	
	private Level1 level1;
	private Level2 level2;
	private Level3 level3;
	
	private int levelNumber;
	
	private boolean changeLevel1, changeLevel2, changeLevel3;
	
	
	
	public GameScreen(PApplet app) {
		this.app = app;
		
		levelNumber = 1; //1 = level 1, 2 = level 2, 3 = level 3
		
		level1 = new Level1(app);
		level2 = new Level2(app);
		level3 = new Level3(app);
		
	}
	
	public void drawLevel() {
		
		switch (levelNumber) {
		case 1:
			level1.draw();
			break;

		default:
			break;
		};
		
	}

}
