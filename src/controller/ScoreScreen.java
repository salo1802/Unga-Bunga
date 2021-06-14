package controller;

import model.Logic;
import processing.core.PApplet;
import processing.core.PImage;

public class ScoreScreen {
	
	private PImage score;
	private PApplet app;
	private Logic logic;
	
	public ScoreScreen(PApplet app, Logic logic) {
		this.app = app;
		this.logic = logic;
		score = app.loadImage("data/highscoresScreen.png");
	}
	
	public void draw() {
		
		app.image(score, 960, 450);
		app.textSize(30);
		app.fill(0);
		for (int i = 0; i < logic.getPlayers().size(); i++) {
			app.text(logic.getPlayers().get(i).toString(), 400, (i*100)+400);
		}
	}
	

}
