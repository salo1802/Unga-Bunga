package model;

import processing.core.PApplet;
import processing.core.PImage;

public class Enemies {
	
	private PApplet app;
	private PImage enemies; // there will be more than 1 enemie type, idk if we should use inheritance
	
	private int posX, posY, value, lifes; 
	
	private int enemieType;
	
	private boolean death;
	
	public Enemies(int posX, int posY, int value, int lifes, int tyenemieTypepe, PApplet app) {
		this.app = app;
		this.posX = posX;
		this.posY = posY;
		this.value = value;
		this.lifes = lifes;
		this.enemieType = enemieType; // idk if this int should be in the constructor 
		
		death = false;
	}
	
	public void drawEnemies() { // maybe use a switch here with enemy type as the key
		
	}
	
	public void movement() {
		
	}
	
	public void actions() {
		
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

	public int getValue() {
		return value;
	}

	public void setValue(int value) {
		this.value = value;
	}

	public int getLifes() {
		return lifes;
	}

	public void setLifes(int lifes) {
		this.lifes = lifes;
	}

	public int getEnemieType() {
		return enemieType;
	}

	public void setEnemieType(int enemieType) {
		this.enemieType = enemieType;
	}
	
	

}
