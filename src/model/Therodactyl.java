package model;

import processing.core.PApplet;
import processing.core.PImage;

public class Therodactyl extends Enemy implements EnemyCommonActions{
	
	private int dir;
	private int dirX;
	private int vel;
	
	private PImage thero;

	public Therodactyl(int posX, int posY, int value, int lives, PApplet app) {
		super(posX, posY, value, lives, app);
		
		dir = (int) app.random(1,2);
		dirX = (int) app.random(-1,1);
		vel = 5;
		
		thero = app.loadImage("data/pterodctyl.png");
		
	}

	@Override
	public void drawEenemy() {
		
		app.fill(200,50,100);
		app.ellipse(posX, posY, 100, 50);
		
		//movement();

		
	}

	@Override
	public void movement() {
		
		posX += dirX * vel;
		
		switch (dir) {
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
