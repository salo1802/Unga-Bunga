package model;

import processing.core.PApplet;
import processing.core.PImage;

public class Obstacle {
	
	private PApplet app;
	private PImage obstacles;
	
	private int posX, posY, lenght, height;
	
	private boolean contact, visibility;
	
	public Obstacle(int posX, int posY, int l, int h, PApplet app) {
		this.posX = posX;
		this.posY = posY;
		this.app = app;
		lenght = l;
		height = h;
		
	}
	
	public void drawObstacle() {
		app.fill(100,100,100);
		app.rect(posX, posY, lenght, height);
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

	public int getLenght() {
		return lenght;
	}

	public void setLenght(int lenght) {
		this.lenght = lenght;
	}

	public int getHeight() {
		return height;
	}

	public void setHeight(int height) {
		this.height = height;
	}
	
	

}
