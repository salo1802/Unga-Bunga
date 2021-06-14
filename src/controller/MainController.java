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
			gamescreen.drawLevel();
			if(gamescreen.getP().getLives() == 0) {
				screen = 3;
				gamescreen.getP().setLives(1);
			}
			break;
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
	
	public void changeScreens(int mouseX, int mouseY) {
		
		
		//Menu Screen --> Score Screen
		if (screen == 0 && mouseX > (615 - (440 / 2))
				&& mouseX < (615 + (440 / 2))
				&& mouseY > (680 - (100 / 2))
				&& mouseY < (680 + (100 / 2))) {
			screen = 4;
		}
		
		//Menu Screen --> Intro Screen
		if (screen == 0 && mouseX > (1080 - (300 / 2))
				&& mouseX < (1080 + (300 / 2))
				&& mouseY > (680 - (100 / 2))
				&& mouseY < (680 + (100 / 2))) {
			screen = 1;
		}
		
		//Intro Screen --> Game Screen
		if (screen == 1 && mouseX > (840 - (300 / 2))
				&& mouseX < (840 + (300 / 2))
				&& mouseY > (730 - (100 / 2))
				&& mouseY < (730 + (100 / 2))) {
			screen = 2;
		}
		
		//name Screen --> score Screen
		if (screen == 3 && mouseX > (840 - (300 / 2))
			&& mouseX < (840 + (300 / 2))
			&& mouseY > (680 - (100 / 2))
			&& mouseY < (680 + (100 / 2))) {
			screen = 4;
		}
	}

	public GameScreen getGamescreen() {
		return gamescreen;
	}

	public void setGamescreen(GameScreen gamescreen) {
		this.gamescreen = gamescreen;
	}

	
}
