package view;

import controller.MainController;
import model.Dinasour;
import model.Enemy;
import model.Player;
import processing.core.PApplet;

public class Main extends PApplet{

	Player p;
	Dinasour d;
	MainController controller;
	
	boolean moveR, moveL;
	
	public static void main(String[] args) {
		PApplet.main("view.Main");
	}
	
	@Override
	public void settings() {
		size(1080,920);
	}
	
	@Override
	public void setup() {
		p = new Player(50, 100, 0, 5, 3, this);
		d = new Dinasour(100, 800, 20, 1, this, 50);
		
		controller = new MainController(this);
	}
	
	@Override
	public void draw() {
		
		//System.out.println(mouseX + "," + mouseY);
		
		background(40);	
		textSize(20);
		fill(255);
		text(p.getLives(), 50, 50);
		p.drawPlayer();
		d.drawEenemy();
		//if(p.isFalling()) {
		new Thread(p).start();
		//}
		if(moveL) {
			p.movement(-5);
		}
		if(moveR) {
			p.movement(5);
		}
		
		if(dist(p.getPosX(), p.getPosY(), d.getPosX(), d.getPosY()) < 30) {
			p.setLives(p.getLives()-1);
		}
		
		//controller.drawScreens();
	}
	
	@Override
	public void keyPressed() {
		
		switch(key) {
		case 'a': 
			if(!p.getState().equals(p.JUMP)) {
				p.setState(p.WALK);
			}			
			moveL = true;
			break;
		case 'd':
			if(!p.getState().equals(p.JUMP)) {
				p.setState(p.WALK);
			}
			moveR = true;
			break;
		case 32:
			p.setMovTimer(0);
			p.setState(p.JUMP);
			p.jump();
			break;
		}
		d.setObjX(p.getPosX());
	}
	
	@Override
	public void keyReleased() {
		switch(key) {
		case 'a': 
			moveL = false;
			break;
		case 'd':
			moveR = false;
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


