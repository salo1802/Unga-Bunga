package model;

import processing.core.*;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

//import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Date;

import processing.core.PApplet;


public class Logic {

	private Player player;
	private Enemy enemies;
	private Tile tiles;
	private Obstacle obstacles;
	private PowerUp powerup;

	private ArrayList<Player> highscores;

	public final static String URL_SAVE_HIGHSCORES = "./data/users.txt";

	//private PrintWriter escribir;
	


	public Logic(Player player, Enemy enemies, Tile tiles, Obstacle obstacles, PowerUp powerup,
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

	
	/*
	 * Este método se utiliza para producir el archivo de texto plano con los datos del jugador
	 */
	public void saveHighscoreTxt() throws IOException {

		
		FileWriter escribir = new FileWriter(URL_SAVE_HIGHSCORES);
		BufferedWriter buffer = new BufferedWriter(escribir);

		for (int i = 0; i < highscores.size(); i++) {
			String linea = highscores.get(i).getUsername() + "," + highscores.get(i).getScore() + ","
					+ highscores.get(i).getPlayTime() + "," + highscores.get(i).getGameDate();
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
	
	
	/*
	 * En este método de FileReader se utiliza para transformar el texto plano en arreglo
	 */
	public void loadHighscore() throws NumberFormatException, IOException {
		
		BufferedReader br = new BufferedReader(new FileReader(URL_SAVE_HIGHSCORES));
		
		String r;
		while((r = br.readLine()) != null) {
			String[] g = r.split(",");
			Player w = new Player(g[0], Integer.parseInt(g[1]), Integer.parseInt(g[2]), g[3]);
			highscores.add(w);
			
		}
		
	
		try {
			br.close();
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

	public Enemy getEnemies() {
		return enemies;
	}

	public void setEnemies(Enemy enemies) {
		this.enemies = enemies;
	}

	public Tile getTiles() {
		return tiles;
	}

	public void setTiles(Tile tiles) {
		this.tiles = tiles;
	}

	public Obstacle getObstacles() {
		return obstacles;
	}

	public void setObstacles(Obstacle obstacles) {
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
