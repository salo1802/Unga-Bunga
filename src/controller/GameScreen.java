package controller;

import model.Level1;
import model.Level2;
import model.Level3;
import model.Player;
import processing.core.PApplet;
import processing.core.PImage;

public class GameScreen {
	

	private PApplet app;
	
	private Level1 level1;
	private Level2 level2;
	private Level3 level3;
	private Player p;
	boolean moveR, moveL;
	
	private int levelNumber;
	
	private boolean changeLevel1, changeLevel2, changeLevel3;
	
	
	public GameScreen(PApplet app) {
		this.app = app;
		
		levelNumber = 1; //1 = level 1, 2 = level 2, 3 = level 3
		
		level1 = new Level1(app);
		level2 = new Level2(app);
		level3 = new Level3(app);
		p = new Player(50, 100, 0, 5, 3, app);
		
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
		
		if(moveL) {
			p.movement(-5);
		}
		if(moveR) {
			p.movement(5);
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

	
}
