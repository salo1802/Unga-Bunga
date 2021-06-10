package view;
import model.Player;
import processing.core.PApplet;

public class Main extends PApplet{

	Player p;
	
	
	public static void main(String[] args) {
		PApplet.main("view.Main");
	}
	
	@Override
	public void settings() {
		size(1080,920);
	}
	
	@Override
	public void setup() {
		p = new Player(50, 100, 0, 5, 5, this);
	}
	
	@Override
	public void draw() {
		background(40);	
		p.drawPlayer();
		if(p.isFalling()) {
			new Thread(p).start();
		}
		
	}
	
	@Override
	public void keyPressed() {
		
		switch(key) {
		case 'a':
			p.movement(-10);
			break;
		case 'd':
			p.movement(10);
			break;
		case 32:
			p.setFalling(false);
			p.setGravity(10);
			p.jump();
			p.setFalling(true);
			break;
		}
	}
	
	@Override
	public void mousePressed() {
		
	}
	
	@Override
	public void mouseDragged() {
		
	}
	
	@Override
	public void mouseReleased() {
		
	}

	}


