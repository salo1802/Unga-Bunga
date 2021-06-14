package model;

import processing.core.PApplet;
import processing.core.PImage;

public class Spear extends PowerUps{
	
	private PImage spear;

	public Spear(int posX, int posY, PApplet app) {
		super(posX, posY, app);
		
		spear = app.loadImage("data/weapon2.png");

	}

	@Override
	public void drawPowerUps() {
		
		app.image(spear, posX, posY);
		
	}

}
