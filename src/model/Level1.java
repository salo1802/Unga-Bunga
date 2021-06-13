package model;

import processing.core.PApplet;
import processing.core.PImage;

public class Level1 {
	
	private PImage level1;
	private PApplet app;
	private Obstacle obX;
	
	public Level1(PApplet app) {
		
		this.app = app;
		
		level1 = app.loadImage("data/nivel1.png");
		obX = new Obstacle(500, 600, app);
		
	}
	
	public void draw() {
		//app.fill(200);
		//app.rect(0, 0, 3240, 1840);
		obX.drawObstacle();
		//app.image(level1, 0, 460, 6251, 920);
	}

	public Obstacle getObX() {
		return obX;
	}

	public void setObX(Obstacle obX) {
		this.obX = obX;
	}

	
}
