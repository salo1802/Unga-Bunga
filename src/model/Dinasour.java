package model;

import processing.core.PApplet;

public class Dinasour extends Enemy implements EnemyCommonActions{

	private int objX; //Position on X axis of player
	private int speed;
	
	public Dinasour(int posX, int posY, int value, int lives, PApplet app, int objX) {
		super(posX, posY, value, lives, app);
		this.objX = objX;
		speed = 6;
	}
	

	@Override
	public void drawEenemy() {
		app.fill(200,50,100);
		app.circle(posX, posY, 50);
		movement();
	}

	@Override
	public void movement() {
		if(posX < objX) {
			posX+=speed;
		}else if(posX > objX){
			posX-=speed;
		}
	}


	public int getObjX() {
		return objX;
	}


	public void setObjX(int objX) {
		this.objX = objX;
	}

	
}
