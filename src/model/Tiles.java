package model;

import processing.core.PApplet;
import processing.core.PImage;

public class Tiles {
	
	private PApplet app;
	private PImage tiles; // there will be more than 1 typo of tile
	
	private int posX, posY;
	
	private int tileType;
	
	private boolean contact;
	
	public Tiles(int posX, int posY, int tileType, PApplet app) {
		this.posX = posX;
		this.posY = posY;
		this.tileType = tileType;
		this.app = app;
		
		contact = false;
		
	}
	
	public void drawTile() { // same here as enemies maybe use a switch with tileType as key
		
	}
	
	public void interactions() {
		
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

	public int getTileType() {
		return tileType;
	}

	public void setTileType(int tileType) {
		this.tileType = tileType;
	}
	
	

}
