package model;

import processing.core.PApplet;

public class PowerUp {
	
	private int posX;
	private int posY;
	String sound;
	PApplet app;
	private boolean use;
	private int powerUpType;
	
	
	public PowerUp(int posX, int posY, String sound, PApplet app, boolean use, int powerUpType) {
		super();
		this.posX = posX;
		this.posY = posY;
		this.sound = sound;
		this.app = app;
		this.use = use;
		this.powerUpType = powerUpType;
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
	public String getSound() {
		return sound;
	}
	public void setSound(String sound) {
		this.sound = sound;
	}
	public PApplet getApp() {
		return app;
	}
	public void setApp(PApplet app) {
		this.app = app;
	}
	public boolean isUse() {
		return use;
	}
	public void setUse(boolean use) {
		this.use = use;
	}
	public int getPowerUpType() {
		return powerUpType;
	}
	public void setPowerUpType(int powerUpType) {
		this.powerUpType = powerUpType;
	}
	
	
}
