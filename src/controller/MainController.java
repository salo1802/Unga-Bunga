package controller;

import java.io.IOException;

import model.EmptyFieldException;
import model.InvalidInputException;
import model.Logic;
import processing.core.PApplet;

public class MainController {
	
	private PApplet app;
	
	//screens
	private MenuScreen menuscreen;
	private IntroScreen introscreen;
	private GameScreen gamescreen;
	private EnterNameScreen namescreen;
	private ScoreScreen scorescreen;
	private Logic logic;
	
	//change screens
	private int screen;
	
	public MainController(PApplet app) {
		this.app = app;
		
		screen = 0;
		
		logic = new Logic(app);
		menuscreen = new MenuScreen(app);
		introscreen = new IntroScreen(app);
		gamescreen = new GameScreen(app);
		namescreen = new EnterNameScreen(app, logic);
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
				gamescreen.setStopTime(System.currentTimeMillis());
				gamescreen.calculatePlayTime();
			}
			
			
			break;
		case 3:
			namescreen.draw();
			
			
			// en la clase namescreen existe una variable con el username del usuario
			// luego de dibujar el namescreen, se guardará el nombre del usuario en el objeto player
			
			// ***posible punto de fallo***  (debe asegurarse primero que el usuario ingrese 
			// el username antes de asignarlo en la siguiente linea)
			gamescreen.getP().setUsername(namescreen.getUsername());
			gamescreen.addPlayerToHighscore();
			try {
				gamescreen.saveHighscoreTxt();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
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
		
		//Name Screen --> Score Screen
		if (screen == 3 && mouseX > (840 - (300 / 2))
			&& mouseX < (840 + (300 / 2))
			&& mouseY > (680 - (100 / 2))
			&& mouseY < (680 + (100 / 2))) {
			boolean added = true;
			try {
				added = namescreen.verifyInputText();
			} catch (EmptyFieldException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (InvalidInputException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			if(added) {
				screen = 4;
			}
			
		}
		
		//Score Screen --> Menu Screen
		if (screen == 4 && mouseX > (170 - (290 / 2))
				&& mouseX < (170 + (290 / 2))
				&& mouseY > (90 - (100 / 2))
				&& mouseY < (90 + (100 / 2))) {
				screen = 0;
			}
	}

	public GameScreen getGamescreen() {
		return gamescreen;
	}

	public void setGamescreen(GameScreen gamescreen) {
		this.gamescreen = gamescreen;
	}

	
}
