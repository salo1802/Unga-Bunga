package model;

import processing.core.PApplet;
import processing.core.PImage;

public class TheroProject extends Projectile{
	
	private PImage theroProjectile;

	public TheroProject(int posX, int posY, PApplet app) {
		super(posX, posY, app);
		
		theroProjectile = app.loadImage("data/pEggs.png");

	}

	@Override
	public void draw() {

		app.image(theroProjectile, posX, posY);
		
		movement();
	}

	@Override
	public void movement() {

		posY += 5;
	}

}
