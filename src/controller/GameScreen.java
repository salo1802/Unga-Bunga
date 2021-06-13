package controller;

import model.Level1;
import model.Level2;
import model.Level3;
import model.Player;
import model.TheroProject;
import model.Therodactyl;
import processing.core.PApplet;

public class GameScreen {
	

	private PApplet app;
	
	private Level1 level1;
	private Level2 level2;
	private Level3 level3;
	private Player p;
	private Therodactyl thero;
	private TheroProject tp;
	
	boolean moveR, moveL;
	
	private int levelNumber;
	
	private boolean changeLevel1, changeLevel2, changeLevel3;
	
	
	public GameScreen(PApplet app) {
		this.app = app;
		
		levelNumber = 1; //1 = level 1, 2 = level 2, 3 = level 3
		
		level1 = new Level1(app);
		level2 = new Level2(app);
		level3 = new Level3(app);

		thero = new Therodactyl(300, 50, 0, 5, app);
		p = new Player(50, 100, 0, 5, 3, app, this);
		
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
		
		int opx = level1.getObX().getPosX();
		int length = level1.getObX().getLenght()/2;
		int opy = level1.getObX().getPosY();
		int height = level1.getObX().getHeight()/2;
		int playerPX = p.getPosX();
		int playerPY = p.getPosY();
		
		if(moveL) {					
			if(playerPX-5 < opx+length && playerPY < opy+height && playerPY > opy-height && playerPX > opx-length) {
				
			}else {
				p.movement(-5);
			}			
		}
		if(moveR) {
			if(playerPX+5 > opx-length && playerPY < opy+height && playerPY > opy-height && playerPX < opx+length) {
				//p.setPosX(p.getPosX()-1);
			}else {
				p.movement(5);
			}
		}
		
		thero.drawEenemy();
		
		damagePlayer();
		
	}
	
	public void damagePlayer() {
		
		//eggs damage
		
//		if((int) PApplet.dist(p.getPosX(), p.getPosY(), tp.getPosX(), tp.getPosY()) < 25) {
//			p.setLives(p.getLives()-1);
//		}
		
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

	public Level1 getLevel1() {
		return level1;
	}

	public void setLevel1(Level1 level1) {
		this.level1 = level1;
	}
	
	
}
