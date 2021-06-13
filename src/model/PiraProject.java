package model;

import processing.core.PApplet;
import processing.core.PImage;

public class PiraProject extends Projectile {
	
	private PImage piraProjectile;

	public PiraProject(int posX, int posY, PApplet app) {
		super(posX, posY, app);
		
		piraProjectile = app.loadImage("data/thorns.png");
		
	}

	@Override
	public void draw() {

		
	}

	@Override
	public void movement() {

		
	}

}
