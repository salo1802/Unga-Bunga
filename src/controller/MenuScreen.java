package controller;

import processing.core.PApplet;
import processing.core.PImage;

public class MenuScreen {
	
	private PImage menu;
	private PApplet app;
	
	public MenuScreen(PApplet app) {
		this.app = app;
		
		menu = app.loadImage("data/startScreen.png");
		
	}
	
	public void draw(){
		
		app.image(menu, 0, 0, 1080, 920);
		
	}

}
