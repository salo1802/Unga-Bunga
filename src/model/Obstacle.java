package model;

import processing.core.PApplet;
import processing.core.PImage;

public class Obstacle {

	private int posX;
	private int posY;
	PImage obstacles;
	PApplet app;
	private boolean contact;
	private boolean visibility;

	public Obstacle(int posX, int posY, PImage obstacles, PApplet app, boolean contact, boolean visibility) {
		super();
		this.posX = posX;
		this.posY = posY;
		this.obstacles = obstacles;
		this.app = app;
		this.contact = contact;
		this.visibility = visibility;
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

	public PImage getObstacles() {
		return obstacles;
	}

	public void setObstacles(PImage obstacles) {
		this.obstacles = obstacles;
	}

	public PApplet getApp() {
		return app;
	}

	public void setApp(PApplet app) {
		this.app = app;
	}

	public boolean isContact() {
		return contact;
	}

	public void setContact(boolean contact) {
		this.contact = contact;
	}

	public boolean isVisibility() {
		return visibility;
	}

	public void setVisibility(boolean visibility) {
		this.visibility = visibility;
	}

}
