package controller;

import model.EmptyFieldException;
import model.InvalidInputException;
import model.Logic;
import processing.core.PApplet;
import processing.core.PImage;

public class EnterNameScreen {
	
	public final static int NAME_LENGTH = 20;
	private PImage nameScreen;
	private PApplet app;
	
	private String username;
	
	private Logic logic;
	
	public EnterNameScreen(PApplet app, Logic logic) {
		this.app = app;
		
		nameScreen = app.loadImage("data/usernameScreen.png");
	}
	
	public void draw(){
		
		app.image(nameScreen, 960, 450);
		
	}
	
	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public boolean verifyInputText() throws EmptyFieldException, InvalidInputException {
		boolean added = true;
		
		if(username.isEmpty()) {
			throw new EmptyFieldException(username);
		}
		if(username.length() > NAME_LENGTH) {
			throw new InvalidInputException(NAME_LENGTH, username.length());
		}
		//Player p = logic.searchPlayer(username);
		
		return added;
	}


}
