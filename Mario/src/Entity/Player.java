package Entity;

import java.awt.Graphics2D;
import java.awt.Rectangle;



public class Player{

	private Rectangle player;
	private int playerX, playerY, gravity;
	
	private Graphics2D g;
	boolean up = false, down = false, left = false, right = false;
	
	
	public Player(int playerX, int playerY) {
		this.playerX = playerX;
		this.playerY = playerY;
		player = new Rectangle(playerX, playerY, 20 , 20);
		gravity = 10;
				
	}
	
	public void tick() {
		if(up) {
			player.y -= 20;
			
		}
		if(down) {
			player.y += 1; 
		}
		if(left) {
			player.x -= 2; 
		}
		if(right) {
			player.x += 2; 
		}
		
		
		
	}
	
	public void render(Graphics2D g) {

		g.draw(player);
	}
	
	public void gravity() {
		player.y += gravity;
	}
	
	public void setPlayerUp() {
		up = true;
	}
	
	public void setPlayerUpBack() {
		up = false;
	}
	public void setPlayerDown() {
		down = true;
	}
	
	public void setPlayerDownBack() {
		down = false;
	}
	public void setPlayerLeft() {
		left = true;
	}
	
	public void setPlayerLeftBack() {
		left = false;
	}
	public void setPlayerRight() {
		right = true;
	}
	
	public void setPlayerRightBack() {
		right = false;
	}
	
	public Rectangle getPlayer() {
		return player;
	}
	
	public void setPlayerY(int y) {
		player.y = y;
	}
	
	public int getPlayerY() {
		return player.y;
	}

	public void setPlayerX(int x) {
		player.x = x;
	}
	
	public int getPlayerX() {
		return player.x;
	}
}
