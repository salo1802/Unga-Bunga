package model;

import processing.core.PApplet;
import processing.core.PImage;

public class PlayerProject extends Projectile{
	
	private PImage playerBaseProjectile;
	private PImage playerSuperProjectile;

	public PlayerProject(int posX, int posY, PApplet app) {
		super(posX, posY, app);
		
		playerBaseProjectile = app.loadImage("data/weapon1.png");
		playerSuperProjectile = app.loadImage("data/weapon2.png");
	}

	@Override
	public void draw() {

		
	}

	@Override
	public void movement() {

		
	}

}
