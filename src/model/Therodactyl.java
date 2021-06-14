package model;

import java.util.ArrayList;

import processing.core.PApplet;
import processing.core.PImage;

public class Therodactyl extends Enemy implements EnemyCommonActions{
	
	private int changeTime;
	
	private int dirX, flyTime, dieTime;
	private int speed;
	
	private PImage[] flyR;
	private PImage[] flyL;
	private PImage[] theroDeathR;
	private PImage[] theroDeathL;
	
	private ArrayList<TheroProject> theroProject;
	private int eggTimer;

	public Therodactyl(int posX, int posY, int value, int lives, PApplet app) {
		super(posX, posY, value, lives, app);
		
		changeTime = 60;
		dirX = (int) app.random(1, 2);
		speed = 5;
		
		flyR = new PImage[2];
		theroDeathR = new PImage[3];
		flyL = new PImage[2];
		theroDeathL = new PImage[3];
		
		theroProject = new ArrayList<TheroProject>();
		eggTimer = 60;
		loadImages();
	}
	
	private void loadImages() {
		for (int i = 0; i < flyL.length; i++) {
			flyR[i] = app.loadImage("data/i-pterodactylFly"+(i+1)+".png");
		}
		for (int i = 0; i < flyR.length; i++) {
			flyL[i] = app.loadImage("data/d-pterodactylFly"+(i+1)+".png");
		}
		for (int i = 0; i < theroDeathL.length; i++) {
			theroDeathL[i] = app.loadImage("data/i-pterodactylDie"+(i+1)+".png");
		}
		for (int i = 0; i < theroDeathR.length; i++) {
			theroDeathR[i] = app.loadImage("data/d-pterodactylDie"+(i+1)+".png");
		}
	}

	public void actions() { // add eggs
		if(lives > 0) {
			eggTimer --;
			if(eggTimer <= 0) {
				
				TheroProject newTP = new TheroProject(posX, posY, app);
				
				theroProject.add(newTP);
				
				eggTimer = 60;
				}
			
			for (int i = 0; i < theroProject.size(); i++) {
				
				if(theroProject.get(i).getPosY() > 920) {
					theroProject.remove(i);
				}
			}
		}
		}

	@Override
	public void drawEenemy() {
		
		actions();
		
		for (int i = 0; i < theroProject.size(); i++) {
			theroProject.get(i).draw();
		}
		
		//app.fill(200,50,100);
		//app.ellipse(posX, posY, 100, 25);
		
		if(lives == 0 && dirX == 1) {
			dirX = 3;
		}else if(lives == 0 && dirX == 2) {
			dirX = 4;
		}
		
		switch (dirX) {
		case 1:
			animFlyL();
			break;
		case 2:
			animFlyR();
			break;
		case 3:
			animDieL();
			break;
		case 4:
			animDieR();
			break;
		default:
			break;
		}

		
		movement();
		
		changeTime ++;
		if(changeTime == 60) {
			dirX = 1;
		}else if(changeTime == 120) {
			dirX = 2;
			changeTime = 0;
		}
	}

	private void animDieR() {
		dieTime++;
		if(dieTime >= 0 && dieTime < 25) {
			app.image(theroDeathR[0], posX, posY);
		}else if(dieTime >= 25 && dieTime < 50) {
			app.image(theroDeathR[1], posX, posY);
		}else{
			app.image(theroDeathR[2], posX, posY);
		}
		
	}

	private void animDieL() {
		dieTime++;
		if(dieTime >= 0 && dieTime < 25) {
			app.image(theroDeathR[0], posX, posY);
		}else if(dieTime >= 25 && dieTime < 50) {
			app.image(theroDeathR[1], posX, posY);
		}else{
			app.image(theroDeathR[2], posX, posY);
		}
	}

	private void animFlyL() {
		flyTime++;
		if(flyTime >= 0 && flyTime < 12) {
			app.image(flyL[0], posX, posY);
		}else if(flyTime >= 12 && flyTime <= 24) {
			app.image(flyL[1], posX, posY);
		}
		
		if(flyTime == 24) {
			flyTime = 0;
		}
	}

	private void animFlyR() {
		flyTime++;
		if(flyTime >= 0 && flyTime < 12) {
			app.image(flyR[0], posX, posY);
		}else if(flyTime >= 12 && flyTime <= 24) {
			app.image(flyR[1], posX, posY);
		}
		
		if(flyTime == 24) {
			flyTime = 0;
		}
	}

	@Override
	public void movement() {
		
		
		switch (dirX) {
		case 1:
			posX += speed;
			break;
		case 2:
			posX -= speed;
			break;
		case 3:
		case 4:
			if(posY <800) {
				posY+=3*speed;
			}			
			break;
		default:
			break;
		}
		
	}

	public ArrayList<TheroProject> getTheroProject() {
		return theroProject;
	}

	public void setTheroProject(ArrayList<TheroProject> theroProject) {
		this.theroProject = theroProject;
	}
	
	

}
