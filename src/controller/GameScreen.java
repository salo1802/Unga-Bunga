package controller;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

import model.Levels;
import model.Player;
import model.TheroProject;
import model.Therodactyl;
import processing.core.PApplet;

public class GameScreen {

	private PApplet app;
	
	private Levels level1;
	
	private Player p;

	boolean moveR, moveL;
	
	private int levelNumber;
	
	private boolean changeLevel1, changeLevel2, changeLevel3;
	
	private ArrayList<Player> highscores;
	public final static String URL_SAVE_HIGHSCORES = "./data/users.txt";
	
	private long startTime;
	private long stopTime;
	
	
	public GameScreen(PApplet app) {
		this.app = app;
		
		levelNumber = 1; //1 = level 1, 2 = level 2, 3 = level 3
		startTime = System.currentTimeMillis();
		
		highscores = new ArrayList<>();
		
		p = new Player(50, 100, 0, 5, 3, app, this, 0, "user");
		level1 = new Levels(app, p);
		try {
			loadHighscore();
		} catch (NumberFormatException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public long calculatePlayTime() {
		
		p.setScore((int)(stopTime - startTime)*2);
		return stopTime - startTime;
		
	}
	
	
	// este método se usa solo cuando se ha finalizado el juego y sirve para agregar 
	// el jugador anterior o la tabla de highscores
	public void addPlayerToHighscore() {
		
		highscores.add(p);
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
		
		for (int i = 0; i < getLevels().getObstacles().length; i++) {
			int opx = level1.getObstacles()[i].getPosX();
			int length = level1.getObstacles()[i].getLenght()/2;
			int opy = level1.getObstacles()[i].getPosY();
			int height = level1.getObstacles()[i].getHeight()/2;
			int playerPX = p.getPosX();
			int playerPY = p.getPosY();
			
			if(moveL) {					
				if(playerPX-5 < opx+length && playerPY < opy+height && playerPY > opy-height && playerPX > opx-length) {
					
				}else {
					p.movement(-2);
				}			
			}
			if(moveR) {
				if(playerPX+5 > opx-length && playerPY < opy+height && playerPY > opy-height && playerPX < opx+length) {
					
				}else {
					p.movement(2);
				}
			}
		}
		
		
		damagePlayer();
		
	}
	
	public void damagePlayer() {
		
		//eggs damage
		for (int i = 0; i < level1.getThero().getTheroProject().size(); i++) {
		
			if((int) PApplet.dist(p.getPosX(), p.getPosY(), 
					level1.getThero().getTheroProject().get(i).getPosX(), 
					level1.getThero().getTheroProject().get(i).getPosY()) < 25) {
				p.setLives(p.getLives()-1);
				level1.getThero().getTheroProject().remove(i);
			}
		}
		
		//pirana damage
		for (int i = 0; i < level1.getPira().getProject().size(); i++) {
			
			if((int) PApplet.dist(p.getPosX(), p.getPosY(), 
					level1.getPira().getProject().get(i).getPosX(), 
					level1.getPira().getProject().get(i).getPosY()) < 25) {
				p.setLives(p.getLives()-1);
				level1.getPira().getProject().remove(i);
			}
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

	public Levels getLevels() {
		return level1;
	}

	public void setLevels(Levels level1) {
		this.level1 = level1;
	}
	public long getStartTime() {
		return startTime;
	}

	public void setStartTime(long startTime) {
		this.startTime = startTime;
	}

	public long getStopTime() {
		return stopTime;
	}

	public void setStopTime(long stopTime) {
		this.stopTime = stopTime;
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
	
	public void resetP() {
		p = new Player(50, 100, 0, 5, 3, app, this, 0, "user");
		level1.setPlayer(p);
	}

}
