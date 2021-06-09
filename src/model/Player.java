package model;

import processing.core.PApplet;
import processing.core.PImage;

public class Player implements Comparable<Player>{
	
	private PApplet app;
	private PImage player;
	
	private int posX, posY, score, lifes, vel;
	
	private boolean gameOver;
	
	public Player(int posX, int posY, int score, int lifes, int vel, PApplet app) {
		this.app = app;
		this.posX = posX;
		this.posY = posY;
		this.score = score;
		this.lifes = lifes;
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

	public int getLifes() {
		return lifes;
	}

	public void setLifes(int lifes) {
		this.lifes = lifes;
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
