package model;

import java.util.ArrayList;

import processing.core.PApplet;
import processing.core.PImage;

public class Therodactyl extends Enemy implements EnemyCommonActions{
	
	private int changeTime;
	
	private int dirX;
	private int speed;
	
	private PImage thero;
	
	private ArrayList<TheroProject> theroProject;
	private int eggTimer;

	public Therodactyl(int posX, int posY, int value, int lives, PApplet app) {
		super(posX, posY, value, lives, app);
		
		changeTime = 60;
		dirX = (int) app.random(1, 2);
		speed = 5;
		
		thero = app.loadImage("data/pterodactyl.png");
		
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
		}

	@Override
	public void drawEenemy() {
		
		actions();
		
		for (int i = 0; i < theroProject.size(); i++) {
			theroProject.get(i).draw();
		}
		
		app.fill(200,50,100);
		app.ellipse(posX, posY, 100, 50);
		app.image(thero, posX, posY, 200, 90);
		
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

}
