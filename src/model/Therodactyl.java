package model;

import processing.core.PApplet;
import processing.core.PImage;

public class Therodactyl extends Enemy implements EnemyCommonActions{
	
	private int changeDir;
	private int changeTime;
	
	private int dirX;
	private int speed;
	
	private PImage thero;

	public Therodactyl(int posX, int posY, int value, int lives, PApplet app) {
		super(posX, posY, value, lives, app);
		
		changeDir = (int) app.random(1,2);
		changeTime = 60;
		dirX = (int) app.random(-1,1);
		speed = 5;
		
		thero = app.loadImage("data/pterodctyl.png");
		
	}

	@Override
	public void drawEenemy() {
		
		app.fill(200,50,100);
		app.ellipse(posX, posY, 100, 50);
		app.image(thero, posX, posY, 200, 90);
		
		movement();
		
		if(changeTime > 0) {
			changeTime --;
		}
		
		if(changeTime == 0) {
			changeDir = (int) app.random(1,2);
			changeTime = 60;
		}
		
	}

	@Override
	public void movement() {
		
		posX += dirX * speed;
		
		switch (changeDir) {
		case 1:
			dirX = 1;
			break;
		case 2:
			dirX = -1;
			break;

		default:
			break;
		}

		
	}

}
