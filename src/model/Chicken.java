package model;

import processing.core.PApplet;
import processing.core.PImage;

public class Chicken extends PowerUps{
	
	private PImage pollito;

	public Chicken(int posX, int posY, PApplet app) {
		super(posX, posY, app);
		
		pollito = app.loadImage("data/food.png");

	}

	@Override
	public void drawPowerUps() {
		
		app.image(pollito, posX, posY);

	}
	
}
