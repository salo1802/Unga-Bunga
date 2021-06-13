package model;

import processing.core.PApplet;
import processing.core.PImage;

public class Obstacle {
	
	private PApplet app;
	private PImage obstacles; // there will be more than 1 typo of obstacles
	
	private int posX, posY;
	
	private boolean contact, visibility;
	
	public Obstacle(int posX, int posY, PApplet app) {
		this.posX = posX;
		this.posY = posY;
		this.app = app;
		
	}
	
	public void drawObstacle() {
		app.fill(100,100,100);
		app.rect(posX, posY, 200, 50);
	}
	
	public void interactions() { 
		
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
