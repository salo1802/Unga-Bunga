package model;

import processing.core.PApplet;
import processing.core.PImage;

public class Plant extends Enemy implements EnemyCommonActions{

	
	private PImage attack[];
	private PImage attackL[];
	private PImage death[];
	private PImage still;
	private PImage stillL;
	private final static String SHOOT= "shoot";
	private final static String STILL= "still";
	private final static String DEATH= "death";
	public String state;
	private boolean rightAnimation;
	public boolean died;
	private int playerX;
	private int time=0;
	private int attacktimer=60;
	PiraProject projectile;
	
	public Plant(int posX, int posY, int value, int lives, PApplet app) {
		super(posX, posY, value, lives, app);
		app.frameRate = 60;
		attack = new PImage[3];
		attackL = new PImage[3];
		death = new PImage[9];
		loadImages();
		state = SHOOT;
		rightAnimation = true;
		died = false;
		playerX = 0;
		projectile = new PiraProject(posX, posY, app);
	}
	public void loadImages() {
		still = app.loadImage("data/piranaPlant.png");
		stillL = app.loadImage("data/piranaPlantL.png");
		for(int i=0;i<death.length;i++) {
		death[i] = app.loadImage("data/piranaDie"+ (i+1) +".png");}
		for(int i=0;i<attackL.length;i++) {
			attack[i] = app.loadImage("data/piranaAttack"+ (i+1) +".png");}
		for(int i=0;i<attackL.length;i++) {
			attackL[i] = app.loadImage("data/piranaAttack"+ (i+1) +"L.png");}
	}
	
	
	@Override
	public void actions() {
		super.actions();
	if (lives==0) {state=DEATH;}
	attacktimer--;
	if(attacktimer==60) {
	projectile.setPosX(posX);
	if(rightAnimation==true) {projectile.setDirection(true);}
	if(rightAnimation==false) {projectile.setDirection(false);}
	attacktimer = 0;}
	projectile.draw();
	}

	@Override
	public void drawEenemy() { 
	movement();
	actions();
	switch(state) {
	case STILL:
	if(rightAnimation==true) {app.image(still, posX, posY);}
	if(rightAnimation==false) {app.image(stillL, posX, posY);}
	break;
	case SHOOT:
	if(app.frameCount%9==0) {time=0;}
	if(app.frameCount%3==0) {time++;}
	if(rightAnimation==true) {
	if(time==1) {app.image(attack[0], posX, posY);}
	if(time==2) {app.image(attack[1], posX, posY);}
	if(time==3) {app.image(attack[2], posX, posY);}}
	if(rightAnimation==false) {
		for(int i=0; i < attackL.length;i++) {
			if(time==1) {app.image(attackL[0], posX, posY);}
			if(time==2) {app.image(attackL[1], posX, posY);}
			if(time==3) {app.image(attackL[2], posX, posY);}}}
		state=STILL;
		
	break;
	case DEATH:
		if(app.frameCount%20==0) {time = 0;}
		if(app.frameCount%2==0) {time++;}
		if(died==false) {
		for(int i=0; i < death.length;i++) {
		if(time==i) {app.image(death[i], posX, posY);}
		died = true;}}
		break;}
		
	}

	@Override
	public void movement() {
		if (playerX>posX) {rightAnimation = true;}
		if (playerX<posX) {rightAnimation = false;}
	
		
	}
	
	@Override
	public void setLives(int lives) {
		// TODO Auto-generated method stub
		super.setLives(lives);
	}
	
	public void setPlayerX(int playerX) {
		this.playerX = playerX;
	}
	
	public void setState(String state) {
		this.state = state;
	}

	@Override
	public int getLives() {
		// TODO Auto-generated method stub
		return super.getLives();
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
	public int getValue() {
		// TODO Auto-generated method stub
		return super.getValue();
	}
}
