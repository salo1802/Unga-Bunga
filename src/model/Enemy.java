package model;

import processing.core.PApplet;
import processing.core.PImage;

public class Enemy {
	
	protected PApplet app;
	protected PImage baseSprite;
	
	protected int posX, posY, value, lives, invulnerableTime; 
	
	protected boolean death;
	
	public Enemy(int posX, int posY, int value, int lives, PApplet app) {
		this.app = app;
		this.posX = posX;
		this.posY = posY;
		this.value = value;
		this.lives = lives;		
		death = false;
	}
	
	public void actions() {
		
	}

	//
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

	public int getValue() {
		return value;
	}

	public void setValue(int value) {
		this.value = value;
	}

	public int getLives() {
		return lives;
	}

	public void setLives(int lives) {
		if(invulnerableTime == 0) {
			this.lives = lives;
			invulnerableTime = 45;
		}
	}
	

}
