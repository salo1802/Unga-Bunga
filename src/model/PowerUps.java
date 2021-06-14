package model;

import processing.core.PApplet;
import processing.core.PImage;

public class PowerUps {
	
	private PApplet app;
	
	private int posX, posY;
	
	public PowerUps(int posX, int posY, PApplet app) {
		this.posX = posX;
		this.posY = posY;
		this.app = app;
		
	}
	
	public void drawPowerUps() {
		
	}

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
