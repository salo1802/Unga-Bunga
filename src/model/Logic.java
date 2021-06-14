package model;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
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
	
	public void loadList() {
		String text[];
		String[] lines;
		ArrayList <String> words;
		words = new ArrayList<>();
		text = app.loadStrings("data/List.txt");
		for (int i = 0; i < text.length; i++) {
			lines = PApplet.split(text[i], " ");
			for (int j = 0; j < lines.length; j++) {
				words.add(lines[j]);}}
	for(int i=0; i<words.size();i++) {
		if(i%4==0) {
		String actualname = words.get(i-3);
		long actualScore = Long.parseLong(words.get(i-2));
		long actualTime = Long.parseLong(words.get(i-1));
		String actualDate = words.get(i);
		Player p = new Player(actualname, actualScore, actualTime, actualDate);
		}
	}
	}
	
	public void addPlayer(Player actual) {
		players.add(actual);
		File file1 = new File ("data/List.txt");
		try {
			FileWriter fw = new FileWriter(file1);
			BufferedWriter bw = new BufferedWriter(fw);
			for(int i=0;i<players.size();i++) {
				bw.write(players.get(i).getUsername()+"    "+players.get(i).getScore()+"    "+players.get(i).getPlayTime()+" "
						+players.get(i).getGameDate());
				bw.newLine();
			}
			bw.close();}
			catch(IOException e) {
				
			}
	}

	public ArrayList<Player> getPlayers() {
		return players;
	}

	public void setPlayers(ArrayList<Player> players) {
		this.players = players;
	}

}
