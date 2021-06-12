package controller;

import processing.core.PApplet;

public class MainController {
	
	private PApplet app;
	
	//screens
	private MenuScreen menuscreen;
	private IntroScreen introscreen;
	private GameScreen gamescreen;
	private EnterNameScreen namescreen;
	private ScoreScreen scorescreen;
	
	//change screens
	private int screen;
	
	public MainController(PApplet app) {
		this.app = app;
		
		screen = 0;
		
		menuscreen = new MenuScreen(app);
		introscreen = new IntroScreen(app);
		gamescreen = new GameScreen(app);
		namescreen = new EnterNameScreen(app);
		scorescreen = new ScoreScreen(app);
	}
	
	public void drawScreens() {
		
		switch (screen) {
		case 0:
			menuscreen.draw();
			break;
		case 1:
			introscreen.draw();
			break;
		case 2:
			gamescreen.drawLevels();
		case 3:
			namescreen.draw();
			break;
		case 4:
			scorescreen.draw();
			break;

		default:
			break;
		}
		
	}
	
	public void changeScreens() {
		
	}

}
