package model;

import java.util.ArrayList;

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
	private ArrayList<PiraProject> project;
	
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
		project = new ArrayList<PiraProject>();
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
		attacktimer++;
		super.actions();
	if (lives==0) {state=DEATH;}
	if(attacktimer>=60) {
	PiraProject newAmo;
	newAmo = new PiraProject(posX, posY, app);
	if(rightAnimation==true) {newAmo.setDirection(true);}
	if(rightAnimation==false) {newAmo.setDirection(false);}
	project.add(newAmo);
	state = SHOOT;
	attacktimer = 0;}
	}

	@Override
	public void drawEenemy() {
	movement();
	actions();
	for(int i=0;i< project.size();i++) {project.get(i).draw();}
	switch(state) {
	case STILL:
	if(rightAnimation==true) {app.image(still, posX, posY);}
	if(rightAnimation==false) {app.image(stillL, posX, posY);}
	break;
	case SHOOT:	
	if(rightAnimation==true) {
	if(attacktimer>=0&&attacktimer<1) {app.image(attack[0], posX, posY);}
	if(attacktimer>=1&&attacktimer<3) {app.image(attack[1], posX, posY);}
	if(attacktimer>=3) {app.image(attack[2], posX, posY);}}
	if(rightAnimation==false) {
		for(int i=0; i < attackL.length;i++) {
			if(attacktimer>=0&&attacktimer<1) {app.image(attackL[0], posX, posY);}
			if(attacktimer>=1&&attacktimer<3) {app.image(attackL[1], posX, posY);}
			if(attacktimer>=3) {app.image(attackL[2], posX, posY);}}}
	if(attacktimer==5) {	state=STILL;}
		
	break;
	case DEATH:
		time++;
		if(died==false) {
		for(int i=0; i < death.length;i++) {
		if(time==i) {app.image(death[i], posX, posY);}
		//died = true;
		if(time==death.length) {died=true;}
		}}
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
	public int getPlayerX() {
		return playerX;
	}
	
	
}
