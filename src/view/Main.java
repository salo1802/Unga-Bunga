package view;

import controller.MainController;
import model.Dinasour;
import model.Obstacle;
import model.Player;
import processing.core.PApplet;

public class Main extends PApplet{

	
	MainController controller;
	
	public static void main(String[] args) {
		PApplet.main("view.Main");
	}
	
	@Override
	public void settings() {
		size(1080,920);
	}
	
	@Override
	public void setup() {
		controller = new MainController(this);
	}
	
	@Override
	public void draw() {
		//System.out.println(mouseX + "," + mouseY);
		imageMode(CENTER);
		rectMode(CENTER);
		background(40);	
		//controller.drawScreens();

		textSize(20);
		fill(255);
		//if(p.isFalling()) {
		
		//}
		
		/*if(dist(p.getPosX(), p.getPosY(), d.getPosX(), d.getPosY()) < 30) {
			p.setLives(p.getLives()-1);
		}*/
		controller.drawScreens();

		//controller.drawScreens();

	}
	
	@Override
	public void keyPressed() {
		
		switch(key) {
		case 'a': 
			if(!controller.getGamescreen().getP().getState().equals(controller.getGamescreen().getP().JUMP)) {
				controller.getGamescreen().getP().setState(controller.getGamescreen().getP().WALK);
				controller.getGamescreen().getP().setRightAnimation(false);
			}			
			controller.getGamescreen().setMoveL(true);
			break;
		case 'd':
			if(!controller.getGamescreen().getP().getState().equals(controller.getGamescreen().getP().JUMP)) {
				controller.getGamescreen().getP().setState(controller.getGamescreen().getP().WALK);
				controller.getGamescreen().getP().setRightAnimation(true);
			}
			controller.getGamescreen().setMoveR(true);
			break;
		case 'w':
			controller.getGamescreen().getP().setState(controller.getGamescreen().getP().CLIMB);
			break;
		case 32:
			if(!controller.getGamescreen().getP().getState().equals(controller.getGamescreen().getP().CLIMB)) {
				controller.getGamescreen().getP().setMovTimer(0);
				controller.getGamescreen().getP().setState(controller.getGamescreen().getP().JUMP);
				controller.getGamescreen().getP().jump();
			}
			break;
		}
		//update dinos objective
	}
	
	@Override
	public void keyReleased() {
		switch(key) {
		case 'a': 
			controller.getGamescreen().setMoveL(false);
			break;
		case 'd':
			controller.getGamescreen().setMoveR(false);
			break;
		}
	}
	
	@Override
	public void mousePressed() {
		controller.changeScreens(mouseX, mouseY);
	}
	
	@Override
	public void mouseDragged() {
		
	}
	
	@Override
	public void mouseReleased() {
		
	}

}


