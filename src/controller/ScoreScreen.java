package controller;

import controlP5.ControlP5;
import processing.core.PApplet;
import processing.core.PImage;

public class ScoreScreen {
	
	private PImage score;
	private PApplet app;
	private ControlP5 cp5;
	
	public ScoreScreen(PApplet app) {
		this.app = app;
		
		score = app.loadImage("data/highscoresScreen.png");
		cp5 = new ControlP5(app);
		
	}
	
	public void draw() {
		
		app.image(score, 960, 450);
		
	}
	

}
