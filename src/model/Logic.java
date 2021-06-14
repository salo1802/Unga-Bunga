package model;

import java.util.ArrayList;

import processing.core.PApplet;

public class Logic {
	
	private ArrayList<Player> players;
	private PApplet app;
	
	public Logic(PApplet app) {
		this.app = app;
		players = new ArrayList<>();
	}
	
	public void draw() {
		
	}
	
	public void sortScores() {
		
	}

	public Player searchPlayer(String username) {
		Player p = null;
		for (int i = 0; i < players.size() && p == null; i++) {
			if(players.get(i).getUsername().equals(username)) {
				p = players.get(i);
			}
		}
		return p;
		
	}

	public ArrayList<Player> getPlayers() {
		return players;
	}

	public void setPlayers(ArrayList<Player> players) {
		this.players = players;
	}

}
