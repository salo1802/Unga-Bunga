package controller;

import model.EmptyFieldException;
import model.InvalidInputException;
import model.Logic;
import model.Player;
import model.RepeatedUserException;
import processing.core.PApplet;
import processing.core.PImage;
import controlP5.ControlP5;
import controlP5.Textfield;

public class EnterNameScreen {

	public final static int NAME_LENGTH = 20;

	private PImage nameScreen;
	private PApplet app;
	private ControlP5 cp5;
	private int colorbtnL;
	private int colorbtnCA;
	private int colorbtnLHov;
	private int colorbtnCAHov;
	private int colorbntLPress;
	private int colorbntCAPress;
	
	private String username;
	
	private Logic logic;

	public EnterNameScreen(PApplet app, Logic logic) {
		this.app = app;
		this.logic = logic;
		nameScreen = app.loadImage("data/usernameScreen.png");
		cp5 = new ControlP5(app);
		
		colorbtnL = app.color(100,200,120);
		colorbtnLHov = app.color(95,217,172);
		colorbtnCA = app.color(60,150,100);
		colorbtnCAHov = app.color(85,194,154);
		colorbntLPress = app.color(40,140,80);
		colorbntCAPress = app.color(35,124,74);
		
		
		cp5.addTextfield("txtUser")
	     .setPosition(782,280)
	     .setColorBackground(0)
	     .setSize(340,35)
	     .setFocus(true)
	     .setColor(app.color(14,88,62))
	     .setColorActive(app.color(182,250,78))
	     .setCaptionLabel("")
	     .getValueLabel().setSize(14)
	     ;
	}
	
	public void drawScreem() {
		app.textSize(30);
		app.fill(200);
		//app.text(username, 300, 300);		
	}


	public void deleteTextField() {
		cp5.get(Textfield.class, "txtUser").hide();
	}
	
	public void showTextField() {
		cp5.get(Textfield.class, "txtUser").show();
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

	public boolean verifyInputText() throws EmptyFieldException, InvalidInputException, RepeatedUserException {
		boolean added = true;
		
		if(username.isEmpty()) {
			throw new EmptyFieldException(username);
		}
		if(username.length() > NAME_LENGTH) {
			throw new InvalidInputException(NAME_LENGTH, username.length());
		}
		Player p = logic.searchPlayer(username);
		if(p != null) {
			throw new RepeatedUserException(username);
		}
		
		return added;
	}


	public String getText() {
		String t = cp5.get(Textfield.class, "txtUser").getText();
		return t;
	}

	
}
