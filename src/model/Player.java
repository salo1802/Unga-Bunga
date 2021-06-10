package model;

import processing.core.PApplet;
import processing.core.PImage;

public class Player implements Comparable<Player>, Runnable{
	
	private PApplet app;
	private PImage player;
	
	private int posX, posY, score, lives, vel;
	//
	private int gravity;
	private int fallTime;

	//
	
	private boolean jumpJump;
	private float jumpTime;
	
	private boolean gameOver;
	
	public Player(int posX, int posY, int score, int lives, int vel, PApplet app) {
		this.app = app;
		this.posX = posX;
		this.posY = posY;
		this.score = score;
		this.lives = lives;
		this.vel = vel;
		gravity = 3;
		
		gameOver = false;
		
		jumpJump = false;
		jumpTime = 0;
		
	}
	
	public void drawPlayer() {
		app.circle(posX, posY, 50);
		jump();
	}
	
	public void movement(int vel) {
		posX+=vel;

	}
	
	public void jump() {
		
		if(jumpJump) {
			posY -=40;
			jumpTime ++;
		}else {
			posY +=5;
		}

	}
	
	public void manageGravity() {
		if(posY < 800) {
			try {
				fallTime++;
				if(fallTime==15) {
					gravity+=gravity/2;
					fallTime= 0;
					System.out.println("GOTTA GO FAST");
				}
				
				posY+=gravity;
				Thread.sleep(10);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
	
	@Override
	public void run() {
		
		jump();
		try {
			Thread.sleep(200);
			jumpJump = false;
		} catch (InterruptedException  e) {
			e.printStackTrace();
		}
		
	}
	
	public void actions() {
		
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

	public int getScore() {
		return score;
	}

	public void setScore(int score) {
		this.score = score;
	}

	public int getLives() {
		return lives;
	}

	public void setLives(int lives) {
		this.lives = lives;
	}

	public int getVel() {
		return vel;
	}

	public void setVel(int vel) {
		this.vel = vel;
	}

	@Override
	public int compareTo(Player o) {
		
		return 0;
	}

	public int getGravity() {
		return gravity;
	}

	public void setGravity(int gravity) {
		this.gravity = gravity;
	}

	public boolean isJumpJump() {
		return jumpJump;
	}

	public void setJumpJump(boolean jumpJump) {
		this.jumpJump = jumpJump;
	}

	
	//////////////////////
	
	
	

}
