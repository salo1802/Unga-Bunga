package controller;

import processing.core.PApplet;
import processing.core.PImage;

public class EnterNameScreen {
	
	private PImage nameScreen;
	private PApplet app;
	
	public EnterNameScreen(PApplet app) {
		this.app = app;
		
		nameScreen = app.loadImage("data/usernameScreen.png");
		
	}
	
	public void draw(){
		
		app.image(nameScreen, 960, 450);
		
	}

}
