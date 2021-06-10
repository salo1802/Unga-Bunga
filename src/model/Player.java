package model;

import processing.core.PApplet;
import processing.core.PImage;

public class Player implements Comparable<Player>{
	
	private PApplet app;
	private PImage player;
	
	private int posX, posY, score, lives, vel;
	
	private boolean gameOver;
	
	public Player(int posX, int posY, int score, int lives, int vel, PApplet app) {
		this.app = app;
		this.posX = posX;
		this.posY = posY;
		this.score = score;
		this.lives = lives;
		this.vel = vel;
		
		gameOver = false;
		
	}
	
	public void drawPlayer() {
		
	}
	
	public void movement() {
		
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

}
