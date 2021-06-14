package model;

import processing.core.PApplet;
import processing.core.PImage;

public class Levels {
	
	private PImage level1A; //up left
	private PImage level1B; //up right
	private PImage level1C; //down left
	private PImage level1D; //down right
	
	private int changeLevel;
	
	private PApplet app;
	private Obstacle obX;
	private Dinasour dino;
	private Therodactyl thero;
	private Player player;
	private Obstacle[] obstacles;
	
	public Levels(PApplet app, Player p) {
		
		player = p;
		this.app = app;
		
		level1A = app.loadImage("data/nivel1A.png");
		level1B = app.loadImage("data/nivel1B.png");
		level1C = app.loadImage("data/nivel1C.png");
		level1D = app.loadImage("data/nivel1D.png");
		obstacles = new Obstacle[3];
		changeLevel = 2; // 0 = C, 1 = D, 2 = A, 3 = B
		
		obX = new Obstacle(790, 620, 305, 180, app);
		
		obstacles[0] = new Obstacle(790, 620, 305, 300, app);
		obstacles[1] = new Obstacle(1740, 620, 305, 300, app);
		obstacles[2] = new Obstacle(1200, 470, 510, 160, app);
		
		dino = new Dinasour(1000, 750, 50, 1, app, 0);
		thero = new Therodactyl(300, 100, 0, 5, app);
	}
	
	public void draw() {
		
		switch (changeLevel) {
		case 0: // down left
			app.image(level1C, 960, 450);
			verifyTrex();
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
		for (int i = 0; i < obstacles.length; i++) {
			obstacles[i].drawObstacle();
		}
		
		obX.drawObstacle();
		dino.drawEenemy();
		thero.drawEenemy();
	}

	private void verifyTrex() {
		if(app.dist(player.getPosX(), player.getPosY(), dino.getPosX(), dino.getPosY()) < 50) {
			player.setLives(player.getLives()-1);
		}
		
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

	public Obstacle[] getObstacles() {
		return obstacles;
	}

	public void setObstacles(Obstacle[] obstacles) {
		this.obstacles = obstacles;
	}

}
