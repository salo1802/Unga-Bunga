package model;

import processing.core.PApplet;
import processing.core.PImage;

public class Level1 {
	
	private PImage level1;
	private PApplet app;
	
	public Level1(PApplet app) {
		
		this.app = app;
		
		level1 = app.loadImage("data/nivel1.png");
		
	}
	
	public void draw() {
		
		app.image(level1, 0, 460, 6251, 920);
	}

}
