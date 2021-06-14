package controller;

import processing.core.PApplet;
import processing.core.PImage;

public class EnterNameScreen {
	
	private PImage nameScreen;
	private PApplet app;
	
	private String username;
	
	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public EnterNameScreen(PApplet app) {
		this.app = app;
		
		nameScreen = app.loadImage("data/usernameScreen.png");
		
	}
	
	public void draw(){
		
		app.image(nameScreen, 960, 450);
		
	}
	
	

}
