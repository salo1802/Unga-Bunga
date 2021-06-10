package model;

import java.util.ArrayList;

import processing.core.PImage;

public class Level {

	private Player player;
	private ArrayList<Enemy> enemies;
	private ArrayList<Tile> tiles;
	private ArrayList<Obstacle> obstacles;
	private ArrayList<PowerUp> powerUp;
	PImage nivelpng;
	private int level;
	
	
	public Level(Player player, ArrayList<Enemy> enemies, ArrayList<Tile> tiles, ArrayList<Obstacle> obstacles,
			ArrayList<PowerUp> powerUp, PImage nivelpng, int level) {
		super();
		this.player = player;
		this.enemies = enemies;
		this.tiles = tiles;
		this.obstacles = obstacles;
		this.powerUp = powerUp;
		this.nivelpng = nivelpng;
		this.level = level;
	}
	
	
	public Player getPlayer() {
		return player;
	}
	public void setPlayer(Player player) {
		this.player = player;
	}
	public ArrayList<Enemy> getEnemies() {
		return enemies;
	}
	public void setEnemies(ArrayList<Enemy> enemies) {
		this.enemies = enemies;
	}
	public ArrayList<Tile> getTiles() {
		return tiles;
	}
	public void setTiles(ArrayList<Tile> tiles) {
		this.tiles = tiles;
	}
	public ArrayList<Obstacle> getObstacles() {
		return obstacles;
	}
	public void setObstacles(ArrayList<Obstacle> obstacles) {
		this.obstacles = obstacles;
	}
	public ArrayList<PowerUp> getPowerUp() {
		return powerUp;
	}
	public void setPowerUp(ArrayList<PowerUp> powerUp) {
		this.powerUp = powerUp;
	}
	public PImage getNivelpng() {
		return nivelpng;
	}
	public void setNivelpng(PImage nivelpng) {
		this.nivelpng = nivelpng;
	}
	public int getLevel() {
		return level;
	}
	public void setLevel(int level) {
		this.level = level;
	}
	

	

}
