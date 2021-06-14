package model;

import processing.core.PApplet;
import processing.core.PImage;

public class Plant extends Enemy implements EnemyCommonActions{


	private PImage attack[];
	private PImage attackL[];
	private PImage death[];
	private PImage still;
	private String SHOOT= "shoot";
	private String STILL= "still";
	private String DEATH= "death";
	public String state;
	
	
	public Plant(int posX, int posY, int value, int lives, PApplet app) {
		super(posX, posY, value, lives, app);
		attack = new PImage[3];
		attackL = new PImage[3];
		death = new PImage[9];
		loadImages();
	}
	public void loadImages() {
		for(int i=0;i<death.length;i++) {
		death[i] = app.loadImage("data/piranaDie"+ (i+1) +".png");}
		for(int i=0;i<attack.length;i++) {
			attack[i] = app.loadImage("data/piranaAttack"+ (i+1) +".png");}
		for(int i=0;i<attack.length;i++) {
			attack[i] = app.loadImage("data/piranaAttack"+ (i+1) +"L.png");}
	}
	
	
	@Override
	public void actions() {
		super.actions();
	
	}

	@Override
	public void drawEenemy() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void movement() {
		// TODO Auto-generated method stub
		
	}

	
}
