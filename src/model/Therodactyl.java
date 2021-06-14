package model;

import java.util.ArrayList;

import processing.core.PApplet;
import processing.core.PImage;

public class Therodactyl extends Enemy implements EnemyCommonActions{
	
	private int changeTime;
	
	private int dirX;
	private int speed;
	
	private PImage thero;
	private PImage theroLeft;
	
	private ArrayList<TheroProject> theroProject;
	private int eggTimer;

	public Therodactyl(int posX, int posY, int value, int lives, PApplet app) {
		super(posX, posY, value, lives, app);
		
		changeTime = 60;
		dirX = (int) app.random(1, 2);
		speed = 5;
		
		thero = app.loadImage("data/pterodactyl.png");
		theroLeft = app.loadImage("data/pterodactylL.png");
		
		theroProject = new ArrayList<TheroProject>();
		eggTimer = 60;
		
	}
	
	public void actions() { // add eggs
		
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

	@Override
	public void drawEenemy() {
		
		actions();
		
		for (int i = 0; i < theroProject.size(); i++) {
			theroProject.get(i).draw();
		}
		
		app.fill(200,50,100);
		app.ellipse(posX, posY, 100, 25);
		
		switch (dirX) {
		case 1:
			app.image(thero, posX, posY, 200, 90);
			break;
		case 2:
			app.image(theroLeft, posX, posY, 200, 90);
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

	@Override
	public void movement() {
		

		switch (dirX) {
		case 1:
			posX += speed;
			break;
		case 2:
			posX -= speed;
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
