package model;

import processing.core.PApplet;
import processing.core.PImage;

public class Levels {
	
	private PImage level1A; //up left
	private PImage level1B; //up right
	private PImage level1C; //down left
	private PImage level1D; //down right
	
	private PImage nextLevel;
	
	private int changeLevel;
	
	private boolean change;
	
	private PApplet app;
	private Obstacle obX;
	private Dinasour dino;
	private Plant pira;
	private Therodactyl thero;
	private Player player;
	private Obstacle[] obstacles;
	
	private int changeEggTimer;
	private int changeEggX, changeEggY;
	
	private boolean toachEgg;
	private int endGame;
	
	public Levels(PApplet app, Player p) {
		
		player = p;
		this.app = app;
		
		level1A = app.loadImage("data/nivel1A.png");
		level1B = app.loadImage("data/nivel1B.png");
		level1C = app.loadImage("data/nivel1C.png");
		level1D = app.loadImage("data/nivel1D.png");
		
		nextLevel = app.loadImage("data/bonusEgg.png");
		
		obstacles = new Obstacle[3];

		
		changeEggTimer = 1200;
		
		changeLevel = 0; // 0 = C, 1 = D, 2 = A, 3 = B
		
		changeEggX = 1750;
		changeEggY = 490;
		
		toachEgg = false;
		endGame = 10;
		
		/*obX = new Obstacle(790, 620, 305, 180, app);
		pira = new Plant(-100, -200, 0, 0, app);
		dino = new Dinasour(1000, 750, 50, 1, app, 0);
		thero = new Therodactyl(300, 100, 0, 5, app);*/
		
		loadInitialLevel();
	}
	
	private void loadInitialLevel() {
		obstacles[0] = new Obstacle(790, 620, 305, 300, app);
		obstacles[1] = new Obstacle(1740, 620, 305, 300, app);
		obstacles[2] = new Obstacle(1200, 470, 510, 160, app);
		dino = new Dinasour(1300, 750, 50, 1, app, 0);
		thero = new Therodactyl(300, 100, 0, 5, app);
		pira = new Plant(-100, -200, 0, 0, app);
	}

	public void draw() {
		
		switch (changeLevel) {
		case 0: // down left
			app.image(level1C, 960, 450);
			//loadInitialLevel();
			verifyTrex();
			
			changeEggTimer --;
			if(changeLevel == 0 && changeEggTimer <= 0) {
				app.image(nextLevel, changeEggX, changeEggY);
				toachEgg = true;
				changeEggTimer = 1200;
			}

			break;
		case 1: // down right
			setChangeEggX(1400);
			setChangeEggY(360);
			
			app.image(level1D, 960, 450);
			if(!change) {
				updateLevel2();
				change = true;
			}
			changeEggTimer --;	
			if(changeLevel == 1 && changeEggTimer <= 0) {
				app.image(nextLevel, changeEggX, changeEggY);
				toachEgg = true;
			}	
			break;
		case 2: // up left
			setChangeEggX(1790);
			setChangeEggY(730);
			
			app.image(level1A, 960, 450);
				updateLevel1();	
	
				if(!change) {
					updateLevel2();
					change = true;
				}
				changeEggTimer --;	
				if(changeLevel == 2 && changeEggTimer <= 0) {
					app.image(nextLevel, changeEggX, changeEggY);
					toachEgg = true;
				}	
			break;
		case 3: // up right
			setChangeEggX(1600);
			setChangeEggY(635);
			
			app.image(level1B, 960, 450);
			updateLevel3();
			
			changeEggTimer --;	
			if(changeLevel == 3 && changeEggTimer <= 0) {
				app.image(nextLevel, changeEggX, changeEggY);
				toachEgg = true;
			}
			break;

		default:
			break;
		}
		for (int i = 0; i < obstacles.length; i++) {
			//obstacles[i].drawObstacle();
		}
		
		//obX.drawObstacle();
		dino.drawEenemy();
		thero.drawEenemy();
		pira.drawEenemy();
		
		changeLevel();
		
	}
	
	public void changeLevel() {
		if(changeLevel == 0) {
			
			if((int) PApplet.dist(player.getPosX(), player.getPosY(),
					changeEggX, changeEggY) < 25) {
				if(toachEgg == true) {
					changeLevel = 1;
					player.setPosX(100);
					player.setPosY(200);
					toachEgg = false;
				}
			}
		}
		
		if(changeLevel == 1) {
				
			if((int) PApplet.dist(player.getPosX(), player.getPosY(),
					changeEggX, changeEggY) < 25) {
				if(toachEgg == true) {
					changeLevel = 2;
					player.setPosX(100);
					player.setPosY(200);
					toachEgg = false;
				}
			}
		}
		if(changeLevel == 2) {
			
			if((int) PApplet.dist(player.getPosX(), player.getPosY(),
					changeEggX, changeEggY) < 25) {
				if(toachEgg == true) {
					changeLevel = 3;
					player.setPosX(100);
					player.setPosY(200);
					toachEgg = false;
				}
			}
		}
		if(changeLevel == 3) {
			
			if((int) PApplet.dist(player.getPosX(), player.getPosY(),
					changeEggX, changeEggY) < 25) {
				System.out.println("touch");
				endGame = 0;
			}
		}
	}

	private void updateLevel3() {
		obstacles[0] = new Obstacle(875, 700, 1650, 160, app);
		obstacles[1] = new Obstacle(520, 450, 305, 260, app);
		obstacles[2] = new Obstacle(1280, 450, 305, 260, app);	
		thero.setLives(5);
		thero.setEggC(25);
		dino.setPosY(-300);
		pira.setPosX(940);
		pira.setLives(4);
		pira.setPosY(640);
	}

	private void updateLevel2() {
		obstacles[0] = new Obstacle(330, 225, 510, 160, app);
		obstacles[1] = new Obstacle(625, 440, 510, 160, app);
		obstacles[2] = new Obstacle(1325, 430, 710, 160, app);	
		dino = new Dinasour(-100, -300, 50, 0, app, 0);
		thero = new Therodactyl(300, 100, 0, 5, app);
		pira = new Plant(200, 155, 0, 2, app);
	}

	private void updateLevel1() {
		obstacles[0] = new Obstacle(580, 585, 970, 160, app);
		obstacles[1] = new Obstacle(1305, 515, 470, 160, app);
		obstacles[2] = new Obstacle(0, 0, 0, 0, app);		
		//dino = new Dinasour(-100, -300, 50, 0, app, 0);
		//thero = new Therodactyl(300, 100, 0, 5, app);
		//pira = new Plant(1495, 450, 0, 3, app);
		dino.setPosY(-300);
		thero.setLives(3);
		pira.setLives(3);
		pira.setPosX(1495);
		pira.setPosY(450);
	}

	@SuppressWarnings("static-access")
	private void verifyTrex() {
		if(app.dist(player.getPosX(), player.getPosY(), dino.getPosX(), dino.getPosY()) < 50) {
			player.setLives(player.getLives()-1);
		}
		
	}

	public Obstacle getObX() {
		return obX;
	}

	public void setObX(Obstacle obX) {
		this.obX = obX;
	}

	public Dinasour getDino() {
		return dino;
	}

	public void setDino(Dinasour dino) {
		this.dino = dino;
	}

	public Therodactyl getThero() {
		return thero;
	}

	public void setThero(Therodactyl thero) {
		this.thero = thero;
	}

	public int getChangeLevel() {
		return changeLevel;
	}

	public void setChangeLevel(int changeLevel) {
		this.changeLevel = changeLevel;
	}

	public Obstacle[] getObstacles() {
		return obstacles;
	}

	public void setObstacles(Obstacle[] obstacles) {
		this.obstacles = obstacles;
	}

	public Plant getPira() {
		return pira;
	}

	public void setPira(Plant pira) {
		this.pira = pira;
	}

	public Player getPlayer() {
		return player;
	}

	public void setPlayer(Player player) {
		this.player = player;
	}

	public int getChangeEggX() {
		return changeEggX;
	}

	public void setChangeEggX(int changeEggX) {
		this.changeEggX = changeEggX;
	}

	public int getChangeEggY() {
		return changeEggY;
	}

	public void setChangeEggY(int changeEggY) {
		this.changeEggY = changeEggY;
	}

	public int getChangeEggTimer() {
		return changeEggTimer;
	}

	public void setChangeEggTimer(int changeEggTimer) {
		this.changeEggTimer = changeEggTimer;
	}

	public int getEndGame() {
		return endGame;
	}

	public void setEndGame(int endGame) {
		this.endGame = endGame;
	}
	
}
