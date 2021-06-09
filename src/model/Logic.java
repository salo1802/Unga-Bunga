package model;

import processing.core.*;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
//import java.io.PrintWriter;
import java.util.ArrayList;
import processing.core.PApplet;


public class Logic {

	private Player player;
	private Enemies enemies;
	private Tiles tiles;
	private Obstacles obstacles;
	private PowerUp powerup;

	private ArrayList<Player> highscores;

	public final static String URL_SAVE_HIGHSCORES = "./txts/highcores.txt";

	//private PrintWriter escribir;
	


	public Logic(Player player, Enemies enemies, Tiles tiles, Obstacles obstacles, PowerUp powerup,
			ArrayList<Player> highscores) {
		super();
		this.player = player;
		this.enemies = enemies;
		this.tiles = tiles;
		this.obstacles = obstacles;
		this.powerup = powerup;
		this.highscores = highscores;
	}

	public void addHighscore(Player a) {
		highscores.add(a);
	}

	public void saveHighscoreTxt() throws IOException {

		
		FileWriter escribir = new FileWriter(URL_SAVE_HIGHSCORES);
		BufferedWriter buffer = new BufferedWriter(escribir);

		for (int i = 0; i < highscores.size(); i++) {
			String linea = highscores.get(i).getUsername() + "," + highscores.get(i).getScore() + ","
					+ highscores.get(i).getPlayTime() + "," + highscores.get(i).getGameDate().toString();
			try {
				buffer.write(linea);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

		try {
			buffer.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public Player getPlayer() {
		return player;
	}

	public void setPlayer(Player player) {
		this.player = player;
	}

	public Enemies getEnemies() {
		return enemies;
	}

	public void setEnemies(Enemies enemies) {
		this.enemies = enemies;
	}

	public Tiles getTiles() {
		return tiles;
	}

	public void setTiles(Tiles tiles) {
		this.tiles = tiles;
	}

	public Obstacles getObstacles() {
		return obstacles;
	}

	public void setObstacles(Obstacles obstacles) {
		this.obstacles = obstacles;
	}

	public PowerUp getPowerup() {
		return powerup;
	}

	public void setPowerup(PowerUp powerup) {
		this.powerup = powerup;
	}

	public ArrayList<Player> getHighscores() {
		return highscores;
	}

	public void setHighscores(ArrayList<Player> highscores) {
		this.highscores = highscores;
	}

	public void Sort() {

	}

}
