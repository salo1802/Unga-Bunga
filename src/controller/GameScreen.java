package controller;

import model.Levels;
import model.Player;
import model.TheroProject;
import model.Therodactyl;
import processing.core.PApplet;

public class GameScreen {

	private PApplet app;
	
	private Levels level1;
	
	private Player p;

	boolean moveR, moveL;
	
	private int levelNumber;
	
	private boolean changeLevel1, changeLevel2, changeLevel3;
	
	
	public GameScreen(PApplet app) {
		this.app = app;
		
		levelNumber = 1; //1 = level 1, 2 = level 2, 3 = level 3
		p = new Player(50, 100, 0, 5, 3, app, this);
		level1 = new Levels(app, p);		
	}
	
	public void drawLevel() {
		
		
		switch (levelNumber) {
		case 1:
			level1.draw();
			break;
		default:
			break;
		}
		
		app.text(p.getLives(), 50, 50);
		p.drawPlayer();
		new Thread(p).start();
		
		for (int i = 0; i < getLevels().getObstacles().length; i++) {
			int opx = level1.getObstacles()[i].getPosX();
			int length = level1.getObstacles()[i].getLenght()/2;
			int opy = level1.getObstacles()[i].getPosY();
			int height = level1.getObstacles()[i].getHeight()/2;
			int playerPX = p.getPosX();
			int playerPY = p.getPosY();
			
			if(moveL) {					
				if(playerPX-5 < opx+length && playerPY < opy+height && playerPY > opy-height && playerPX > opx-length) {
					
				}else {
					p.movement(-2);
				}			
			}
			if(moveR) {
				if(playerPX+5 > opx-length && playerPY < opy+height && playerPY > opy-height && playerPX < opx+length) {
					
				}else {
					p.movement(2);
				}
			}
		}
		
		
		damagePlayer();
		
	}
	
	public void damagePlayer() {
		
		//eggs damage
		for (int i = 0; i < level1.getThero().getTheroProject().size(); i++) {
		
			if((int) PApplet.dist(p.getPosX(), p.getPosY(), 
					level1.getThero().getTheroProject().get(i).getPosX(), 
					level1.getThero().getTheroProject().get(i).getPosY()) < 25) {
				p.setLives(p.getLives()-1);
				level1.getThero().getTheroProject().remove(i);
			}
		}
	}
	
	public Player getP() {
		return p;
	}

	public void setP(Player p) {
		this.p = p;
	}

	public boolean isMoveR() {
		return moveR;
	}

	public void setMoveR(boolean moveR) {
		this.moveR = moveR;
	}

	public boolean isMoveL() {
		return moveL;
	}

	public void setMoveL(boolean moveL) {
		this.moveL = moveL;
	}

	public Levels getLevels() {
		return level1;
	}

	public void setLevels(Levels level1) {
		this.level1 = level1;
	}
	
	
}
