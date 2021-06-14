package model;

import processing.core.PApplet;
import processing.core.PImage;

public class Level1 {
	
	private PImage level1;
	private int posX, posY;
	private PApplet app;
	private Obstacle obX;
	private Dinasour dino;
	
	public Level1(PApplet app) {
		
		this.app = app;
		
		level1 = app.loadImage("data/nivel1.png");
		obX = new Obstacle(500, 600, app);
		dino = new Dinasour(1000, 650, 50, 1, app, 0);
		posX = 200;
		posY = 200;
	}
	
	public void draw() {
		//app.fill(200);
		//app.rect(0, 0, 3240, 1840);
		
		//app.image(level1, 1000, 900);
		obX.drawObstacle();
		dino.drawEenemy();
	}

	public Obstacle getObX() {
		return obX;
	}

	public void setObX(Obstacle obX) {
		this.obX = obX;
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

	public Dinasour getDino() {
		return dino;
	}

	public void setDino(Dinasour dino) {
		this.dino = dino;
	}

	
}
