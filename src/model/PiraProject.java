package model;

import processing.core.PApplet;
import processing.core.PImage;

public class PiraProject extends Projectile {
	
	private PImage piraProjectile;
	private PImage piraProjectileL;
	private boolean direction;

	public PiraProject(int posX, int posY, PApplet app) {
		super(posX, posY, app);
		
		piraProjectile = app.loadImage("data/thorns.png");
		piraProjectileL = app.loadImage("data/thornsL.png");
		
	}

	@Override
	public void draw() {
		movement();
	if(direction==true) {
	app.image(piraProjectile, posX, posY);}
	if(direction==false) {
		app.image(piraProjectileL, posX, posY);}
		
	}

	@Override
	public void movement() {
		if(direction==true) {posX+=5;}
		if(direction==false) {posX-=5;}
		
		
	}
	public void setDirection(boolean direction) {
	this.direction = direction;
}
	@Override
	public int getPosX() {
		// TODO Auto-generated method stub
		return super.getPosX();
	}
	@Override
	public int getPosY() {
		// TODO Auto-generated method stub
		return super.getPosY();
	}
	
	@Override
	public void setPosX(int posX) {
		// TODO Auto-generated method stub
		super.setPosX(posX);
	}
}
