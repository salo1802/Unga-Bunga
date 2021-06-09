package model;

import java.util.Date;

import processing.core.PApplet;
import processing.core.PImage;

public class Player {

	private String sound; // contiene URL al archivo de sonido
	private int posX;
	private int posY;
	private int score;
	private int lives;
	private int vel;
	private boolean gameOver;
	private PImage Helga;
	private PApplet app;
	private Date gameDate;
	private int playTime;
	private String username;

	/*
	 * Esta variable cuando el juego inicie se le va a asignar el valor del metodo
	 * System.currentTimeMillis(), y cuando el player pierda va a ser usada para
	 * determinar el tiempo de juego.
	 */
	private long startGameTime;
	private long endGameTime;

	public Player(String sound, int posX, int posY, int score, int lives, int vel, boolean gameOver, PImage helga,
			PApplet app, Date gameDate, int playTime, long startGameTime, long endGameTime, String username) {
		super();
		this.sound = sound;
		this.posX = posX;
		this.posY = posY;
		this.score = score;
		this.lives = lives;
		this.vel = vel;
		this.gameOver = gameOver;
		Helga = helga;
		this.app = app;
		this.gameDate = gameDate;
		this.playTime = playTime;
		this.startGameTime = startGameTime;
		this.endGameTime = endGameTime;
		this.username = username;
	}

	
	
	public String getUsername() {
		return username;
	}



	public void setUsername(String username) {
		this.username = username;
	}



	public long getStartGameTime() {
		return startGameTime;
	}



	public void setStartGameTime(long startGameTime) {
		this.startGameTime = startGameTime;
	}



	public long getEndGameTime() {
		return endGameTime;
	}



	public void setEndGameTime(long endGameTime) {
		this.endGameTime = endGameTime;
	}



	public String getSound() {
		return sound;
	}

	public void setSound(String sound) {
		this.sound = sound;
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
		this.lives = lives;
	}

	public int getVel() {
		return vel;
	}

	public void setVel(int vel) {
		this.vel = vel;
	}

	public boolean isGameOver() {
		return gameOver;
	}

	public void setGameOver(boolean gameOver) {
		this.gameOver = gameOver;
	}

	public PImage getHelga() {
		return Helga;
	}

	public void setHelga(PImage helga) {
		Helga = helga;
	}

	public PApplet getApp() {
		return app;
	}

	public void setApp(PApplet app) {
		this.app = app;
	}

	public Date getGameDate() {
		return gameDate;
	}

	public void setGameDate(Date gameDate) {
		this.gameDate = gameDate;
	}

	/*
	 * El método getPlayTime va a retornar el tiempo transcurrido de la partida
	 * después de finalizada. Si la partida no ha finalizado, éste retornará -1.
	 */
	public int getPlayTime() {
		
		// variable de control
		int retorno = 0;
		
		if (gameOver) {
			retorno = (int) startGameTime - (int) endGameTime;
		}else {
			retorno = -1;
		}
		
		playTime = retorno;
		return playTime;
	}

	public void setPlayTime(int playTime) {
		this.playTime = playTime;
	}

}
