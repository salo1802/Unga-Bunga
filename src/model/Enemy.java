package model;

import processing.core.PApplet;
import processing.core.PImage;

public class Enemy {

	private String sound; // contiene URL al archivo de sonido
	private int posX;
	private int posY;
	private int value;
	private int lives;
	private boolean muerte;
	private int enemyType;
	PImage enemypng;
	PApplet app;

	public Enemy(String sound, int posX, int posY, int value, int lives, boolean muerte, int enemyType, PImage enemypng, PApplet app) {
		
		this.sound = sound;
		this.posX = posX;
		this.posY = posY;
		this.value = value;
		this.lives = lives;
		this.muerte = muerte;
		this.enemyType = enemyType;
		this.app = app;
		this.enemypng = enemypng;
	}
	
	


	public String getSound() {
		return sound;
	}

	public void setSound(String sound) {
		this.sound = sound;
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

	public int getLives() {
		return lives;
	}

	public void setLives(int lives) {
		this.lives = lives;
	}

	public boolean isMuerte() {
		return muerte;
	}

	public void setMuerte(boolean muerte) {
		this.muerte = muerte;
	}

	public int getEnemyType() {
		return enemyType;
	}

	public void setEnemyType(int enemyType) {
		this.enemyType = enemyType;
	}

	public PImage getEnemypng() {
		return enemypng;
	}

	public void setEnemypng(PImage enemypng) {
		this.enemypng = enemypng;
	}

	public PApplet getApp() {
		return app;
	}

	public void setApp(PApplet app) {
		this.app = app;
	}
	
}
