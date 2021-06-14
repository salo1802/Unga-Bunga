package model;

import processing.core.PApplet;
import processing.core.PImage;

public class Dinasour extends Enemy implements EnemyCommonActions, Runnable{

	private int state;
	private int objX; //Position on X axis of player
	private int speed;
	private int walTimer, attackTimer, dieTimer;
	private boolean dir;
	private PImage dinoPic;
	private PImage[] dinoWalkR;
	private PImage[] dinoWalkL;
	private PImage[] dinoAttackR;
	private PImage[] dinoAttackL;
	private PImage[] dinoDieR;
	private PImage[] dinoDieL;
	
	public Dinasour(int posX, int posY, int value, int lives, PApplet app, int objX) {
		super(posX, posY, value, lives, app);
		this.objX = objX;
		speed = 3;
		dinoPic = app.loadImage("data/trex.png");
		
		state = 1;
		dinoWalkR = new PImage[2];
		dinoAttackR = new PImage[3];
		dinoDieR = new PImage[4];
		
		dinoWalkL = new PImage[2];
		dinoAttackL = new PImage[3];
		dinoDieL = new PImage[4];
		
		loadImages();
	}
	
	private void loadImages() {
		for (int i = 0; i < dinoAttackR.length; i++) {
			dinoAttackR[i] = app.loadImage("data/d-trexAttack"+(i+1)+".png");
		}
		for (int i = 0; i < dinoAttackL.length; i++) {
			dinoAttackL[i] = app.loadImage("data/i-trexAttack"+(i+1)+".png");
		}
		for (int i = 0; i < dinoWalkR.length; i++) {
			dinoWalkR[i] = app.loadImage("data/d-trexWalk"+(i+1)+".png");
		}
		for (int i = 0; i < dinoWalkL.length; i++) {
			dinoWalkL[i] = app.loadImage("data/i-trexWalk"+(i+1)+".png");
		}
		for (int i = 0; i < dinoDieR.length; i++) {
			dinoDieR[i] = app.loadImage("data/d-trexDie"+(i+1)+".png");
		}
		for (int i = 0; i < dinoDieL.length; i++) {
			dinoDieL[i] = app.loadImage("data/i-trexDie"+(i+1)+".png");
		}
	}

	@Override
	public void drawEenemy() {
		//app.fill(200,50,100);
		///app.circle(posX, posY, 50);
		if(lives == 0) {
			state = 3;
		}
		
		switch(state) {
		case 0:
			app.image(dinoPic, posX, posY);
			break;
		case 1:
			if(dir) {
				walkRAnimation();
			}else {
				walkLAnimation();
			}
			break;
		case 2:
			if(dir) {
				attackAnimationR();
			}else {
				attackAnimationL();
			}
			break;
		case 3:
			if(dir) {
				dieAnimR();
			}else {
				dieAnimL();
			}
			break;
		}
		movement();
	}

	private void dieAnimR() {
		dieTimer++;
		if(dieTimer >= 0 && dieTimer < 15) {
			app.image(dinoDieR[0], posX, posY);
		}else if(dieTimer >= 15 && dieTimer < 30) {
			app.image(dinoDieR[1], posX, posY);
		}if(dieTimer >= 30 && dieTimer < 45) {
			app.image(dinoDieR[2], posX, posY);
		}else if(dieTimer >= 45){
			app.image(dinoDieR[3], posX, posY);
		}
	}

	private void dieAnimL() {
		dieTimer++;
		if(dieTimer >= 0 && dieTimer < 15) {
			app.image(dinoDieL[0], posX, posY);
		}else if(dieTimer >= 15 && dieTimer < 30) {
			app.image(dinoDieL[1], posX, posY);
		}if(dieTimer >= 30 && dieTimer < 45) {
			app.image(dinoDieL[2], posX, posY);
		}else if(dieTimer >= 45){
			app.image(dinoDieL[3], posX, posY);
		}
	}

	private void attackAnimationL() {
		attackTimer++;
		if(attackTimer >= 0 && attackTimer < 7) {
			app.image(dinoAttackL[0], posX, posY);
		}else if(attackTimer >= 7 && attackTimer < 14) {
			app.image(dinoAttackL[1], posX, posY);
		}if(attackTimer >= 14 && attackTimer <= 21) {
			app.image(dinoAttackL[2], posX, posY);
		}
		
		if(attackTimer == 21) {
			attackTimer = 0;
			state = 1;
		}
	}

	private void attackAnimationR() {
		attackTimer++;
		if(attackTimer >= 0 && attackTimer < 7) {
			app.image(dinoAttackR[0], posX, posY);
		}else if(attackTimer >= 7 && attackTimer < 14) {
			app.image(dinoAttackR[1], posX, posY);
		}if(attackTimer >= 14 && attackTimer <= 21) {
			app.image(dinoAttackR[2], posX, posY);
		}
		
		if(attackTimer == 21) {
			attackTimer = 0;
			state = 1;
		}
	}

	private void walkLAnimation() {
		walTimer++;
		if(walTimer >= 0 && walTimer < 12) {
			app.image(dinoWalkL[0], posX, posY);
		}else if(walTimer >= 12 && walTimer <= 24) {
			app.image(dinoWalkL[1], posX, posY);
		}
		if(walTimer == 24) {
			walTimer = 0;
		}
	}

	private void walkRAnimation() {
		walTimer++;
		if(walTimer >= 0 && walTimer < 12) {
			app.image(dinoWalkR[0], posX, posY);
		}else if(walTimer >= 12 && walTimer <= 24) {
			app.image(dinoWalkR[1], posX, posY);
		}
		if(walTimer == 24) {
			walTimer = 0;
		}
	}

	@Override
	public void movement() {
		if(state != 3) {
			if(Math.abs(posX-objX) < 200) {
				state = 2;
			}
			if(posX < objX) {
				posX+=speed;
				dir = true;
			}else if(posX > objX){
				posX-=speed;
				dir = false;
			}
		}
	}


	public int getObjX() {
		return objX;
	}


	public void setObjX(int objX) {
		this.objX = objX;
	}

	@Override
	public void run() {
		
	}

	
}
