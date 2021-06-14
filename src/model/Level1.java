package model;

import processing.core.PApplet;
import processing.core.PImage;

public class Level1 {
	
	private PImage level1A; //up left
	private PImage level1B; //up right
	private PImage level1C; //down left
	private PImage level1D; //down right
	
	private int changeLevel;
	
	private PApplet app;
	private Obstacle obX;
	private Dinasour dino;
	private Therodactyl thero;
	
	public Level1(PApplet app) {
		
		this.app = app;
		
		level1A = app.loadImage("data/nivel1A.png");
		level1B = app.loadImage("data/nivel1B.png");
		level1C = app.loadImage("data/nivel1C.png");
		level1D = app.loadImage("data/nivel1D.png");
		
		changeLevel = 0; // 0 = C, 1 = D, 2 = A, 3 = B
		
		obX = new Obstacle(500, 600, app);
		dino = new Dinasour(1000, 650, 50, 1, app, 0);
		thero = new Therodactyl(300, 50, 0, 5, app);
	}
	
	public void draw() {
		
		switch (changeLevel) {
		case 0: // down left
			app.image(level1C, 960, 450);
			break;
		case 1: // down right
			app.image(level1D, 960, 450);
			break;
		case 2: // up left
			app.image(level1A, 960, 450);
			break;
		case 3: // up right
			app.image(level1B, 960, 450);
			break;

		default:
			break;
		}
		
		obX.drawObstacle();
		dino.drawEenemy();
		thero.drawEenemy();
	}

	public Obstacle getObX() {
		return obX;
	}

	public void setObX(Obstacle obX) {
		this.obX = obX;
	}

	public Dinasour getDino() {
		return dino;
	}

	public void setDino(Dinasour dino) {
		this.dino = dino;
	}

	public Therodactyl getThero() {
		return thero;
	}

	public void setThero(Therodactyl thero) {
		this.thero = thero;
	}

	public int getChangeLevel() {
		return changeLevel;
	}

	public void setChangeLevel(int changeLevel) {
		this.changeLevel = changeLevel;
	}

}
