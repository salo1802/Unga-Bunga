package controller;

import processing.core.PApplet;
import processing.core.PImage;

public class IntroScreen {
	
	private PImage intros;
	private PApplet app;
	
	public IntroScreen(PApplet app) {
		this.app = app;
		
		intros = app.loadImage("data/controlsScreen.png");		
	}
	
	public void draw() {
		
		app.image(intros, 0, 0, 1080, 920);
		
	}

}
