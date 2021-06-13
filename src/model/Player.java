package model;

import processing.core.PApplet;
import processing.core.PImage;

public class Player implements Comparable<Player>, Runnable{
	
	public final static String WALK = "walk";
	public final static String JUMP = "jump";
	public final static String CLIMB = "climb";
	public final static String DEFAULT = "default";
	
	private PApplet app;
	private PImage playerStand;
	private PImage[] imagesRunning;
	private PImage[] imagesCliming;
	private PImage[] imagesjumping;
	
	private int posX, posY, score, lives, vel;
	//
	private int gravity, jumpFactor;
	private int fallTime;
	private int invulnerableTime;
	private String state;
	private int movTimer, runTimer, climbTimer;
	
	private boolean jumpJump;
	private boolean gameOver;
	private boolean rightAnimation;
	
	
	public Player(int posX, int posY, int score, int lives, int vel, PApplet app) {
		this.app = app;
		this.posX = posX;
		this.posY = posY;
		this.score = score;
		this.lives = lives;
		this.vel = vel;
		gravity = 3;
		state = DEFAULT;
		
		gameOver = false;
		fallTime = 0;
		
		jumpJump = false;
		rightAnimation = true;
		
		movTimer = 0;
		runTimer = 0;
		climbTimer = 0;
		imagesjumping = new PImage[6];
		imagesCliming = new PImage[2];
		imagesRunning = new PImage[4];
		loadImages();
	}
	
	private void loadImages() {
		playerStand = app.loadImage("data/stand.png");
		
		for (int i = 0; i < imagesCliming.length; i++) {
			imagesCliming[i] = app.loadImage("data/climb"+(i+1)+".png");
		}
		
		for (int i = 0; i < imagesjumping.length; i++) {
			imagesjumping[i] = app.loadImage("data/jump"+(i+1)+".png");
		}
		
		for (int i = 0; i < imagesRunning.length; i++) {
			imagesRunning[i] = app.loadImage("data/walk"+(i+1)+".png");
		}
	}

	public void drawPlayer() {
		
		switch(state) {
		case WALK:
			walkAnimation();
			break;
		case JUMP:
			jumpAnimation();
			break;
		case CLIMB:
			climbAnimation();
			break;
		default:
			app.image(playerStand, posX, posY);
			break;
		}
		
		if(invulnerableTime > 0) {
			invulnerableTime --;
		}
		
		//app.fill(220);
		//app.circle(posX, posY, 50);
	}
	
	private void climbAnimation() {
		if(climbTimer >=0 && climbTimer <20) {
			app.image(imagesCliming[0], posX, posY);
		}else if(climbTimer >=20 && climbTimer < 40) {
			app.image(imagesCliming[1], posX, posY);
		}
		climbTimer++;
		
		if(climbTimer == 40) {
			climbTimer = 0;
			state = DEFAULT;
		}
	}

	private void jumpAnimation() {
		if(rightAnimation ==true) {
		if(movTimer >=0 && movTimer <20) {
			app.image(imagesjumping[0], posX, posY);
		}else if(movTimer >=20 && movTimer < 40) {
			app.image(imagesjumping[1], posX, posY);
		}else if(movTimer >=40 && movTimer <55) {
			app.image(imagesjumping[2], posX, posY);
		}else if(movTimer >=55 && movTimer <70) {
			app.image(imagesjumping[3], posX, posY);
		}else if(movTimer >=70 && movTimer <85) {
			app.image(imagesjumping[4], posX, posY);
		}else if(movTimer >=85 && movTimer <100) {
			app.image(imagesjumping[5], posX, posY);
		}}
		
		if(rightAnimation ==false) {
			app.push();
			app.rotateY(180);
			if(movTimer >=0 && movTimer <20) {
				app.image(imagesjumping[0], posX, posY);
			}else if(movTimer >=20 && movTimer < 40) {
				app.image(imagesjumping[1], posX, posY);
			}else if(movTimer >=40 && movTimer <55) {
				app.image(imagesjumping[2], posX, posY);
			}else if(movTimer >=55 && movTimer <70) {
				app.image(imagesjumping[3], posX, posY);
			}else if(movTimer >=70 && movTimer <85) {
				app.image(imagesjumping[4], posX, posY);
			}else if(movTimer >=85 && movTimer <100) {
				app.image(imagesjumping[5], posX, posY);
			app.pop();}}
		
		movTimer++;
		
		if(movTimer>100) {
			movTimer = 0;
			state = DEFAULT;
		}
	}

	private void walkAnimation() {
		if(runTimer >=0 && runTimer < 10) {
			if(rightAnimation==true) {
			app.image(imagesRunning[0], posX, posY);
		}else if(runTimer >=10 && runTimer < 20) {
			app.image(imagesRunning[1], posX, posY);
		}else if(runTimer >=20 && runTimer <30) {
			app.image(imagesRunning[2], posX, posY);
		}else if(runTimer >=30 && runTimer <40) {
			app.image(imagesRunning[3], posX, posY);
		}}
		
		if(runTimer >=0 && runTimer < 10) {
			if(rightAnimation==false) {
			app.push();
			app.rotateY(180);
			app.image(imagesRunning[0], posX, posY);
		}else if(runTimer >=10 && runTimer < 20) {
			app.image(imagesRunning[1], posX, posY);
		}else if(runTimer >=20 && runTimer <30) {
			app.image(imagesRunning[2], posX, posY);
		}else if(runTimer >=30 && runTimer <40) {
			app.image(imagesRunning[3], posX, posY);
		app.pop();}}
		
		runTimer++;
		
		if(runTimer == 40) {
			runTimer = 0;
			state = DEFAULT;
		}
	}

	public void movement(int vel) {
		posX+=vel;

	}
	
	public void jump() {
		jumpFactor = -10;
		gravity = 3;
		fallTime = 0;
	}
	
	public void manageGravity() {
		if(posY < 800) {
			fallTime++;
			if(fallTime==15) {
				gravity+=gravity/2;
				fallTime= 0;
			}
			posY+=gravity+jumpFactor;
		}else {
			posY=799;
			gravity = 0;
			jumpFactor = 0;
		}
	}
	
	@Override
	public void run() {
		manageGravity();		
	}
	
	public void actions() {
		
	}

	public int getPosX() {
		return posX;
	}

	public void setPosX(int posX) {
		this.posX = posX;
	}

	public int getPosY() {
		return posY;
	}

	public void setPosY(int posY) {
		this.posY = posY;
	}

	public int getScore() {
		return score;
	}

	public void setScore(int score) {
		this.score = score;
	}

	public int getLives() {
		return lives;
	}

	public void setLives(int lives) {
		if(invulnerableTime == 0) {
			this.lives = lives;
			invulnerableTime = 60;
		}
		
	}

	public int getVel() {
		return vel;
	}

	public void setVel(int vel) {
		this.vel = vel;
	}

	@Override
	public int compareTo(Player o) {
		
		return 0;
	}

	public int getGravity() {
		return gravity;
	}

	public void setGravity(int gravity) {
		this.gravity = gravity;
	}

	public boolean isJumpJump() {
		return jumpJump;
	}

	public void setJumpJump(boolean jumpJump) {
		this.jumpJump = jumpJump;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public int getMovTimer() {
		return movTimer;
	}

	public void setMovTimer(int movTimer) {
		this.movTimer = movTimer;
	}
	public void setRightAnimation(boolean rightAnimation) {
		this.rightAnimation = rightAnimation;
	}
}
