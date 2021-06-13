package model;

import processing.core.PApplet;

public abstract class Projectile {
	
	protected PApplet app;
	
	protected int posX, posY;
	
	public Projectile(int posX, int posY, PApplet app) {
		this.posX = posX;
		this.posY = posY;
		this.app = app;
		
	}
	
	public abstract void draw();
	
	public abstract void movement();

	public int getPosX() {
		return posX;
	}

	public void setPosX(int posX) {
		this.posX = posX;
	}

	public int getPosY() {
		return posY;
	}

	public void setPosY(int posY) {
		this.posY = posY;
	}

}
