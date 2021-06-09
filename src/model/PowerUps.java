package model;

import processing.core.PApplet;
import processing.core.PImage;

public class PowerUps {
	
	private PApplet app;
	private PImage tiles; // there will be more than 1 typo of tile
	
	private int posX, posY;
	
	private int powerUpType;
	
	private boolean usedIt;
	
	public PowerUps(int posX, int posY, int powerUpType, PApplet app) {
		this.posX = posX;
		this.posY = posY;
		this.powerUpType = powerUpType;
		this.app = app;
		
	}
	
	public void drawPowerUps() { // switch?
		
	}
	
	public void interaction() {
		
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

	public int getPowerUpType() {
		return powerUpType;
	}

	public void setPowerUpType(int powerUpType) {
		this.powerUpType = powerUpType;
	}
	
	

}
