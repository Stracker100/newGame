package Entity;

import java.awt.Graphics2D;
import java.awt.Rectangle;


import main.Handler;

public class Player{

	private Rectangle player;
	private int playerX, playerY;
	private Graphics2D g;

	protected Handler handler;

	
	
	public Player(int playerX, int playerY) {
		this.playerX = playerX;
		this.playerY = playerY;
		player = new Rectangle(playerX, playerY, 20 , 20);
		
				
	}
	
	public void tick() {
		getInput();
		
	}
	
	public void render(Graphics2D g) {
		g.draw(player);
	}
	
	private void getInput() {
		
		if(handler.getKeyManager().up)
			//playerY ++;
			System.out.println("up");
		if(handler.getKeyManager().down)
			System.out.println("down");
			//playerY --;
		if(handler.getKeyManager().left)
			System.out.println("left");
			//playerX --;
		if(handler.getKeyManager().right)
			System.out.println("right");
			//playerX ++;
	}
}
