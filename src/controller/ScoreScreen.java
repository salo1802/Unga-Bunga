package controller;

import processing.core.PApplet;
import processing.core.PImage;

public class ScoreScreen {
	
	private PImage score;
	private PApplet app;
	
	public ScoreScreen(PApplet app) {
		this.app = app;
		
		score = app.loadImage("data/highscoresScreen.png");
		
		
	}
	
	public void draw() {
		
		app.image(score, 960, 450);
		
	}
	

}
