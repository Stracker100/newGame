package Entity;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.geom.Line2D;
import java.awt.geom.Rectangle2D;


public class Bricks {
	
	private int brickX, brickY, brickWidth, brickHeight;
	private Rectangle brick;
	private Graphics2D g;
	private Line2D lineLeft, lineTop, lineRight;
	
	public Bricks(int brickX, int brickY, int brickWidth, int brickHeight) {
		this.brickX = brickX;
		this.brickY = brickY;
		this.brickWidth = brickWidth;
		this.brickHeight = brickHeight;
		
		brick = new Rectangle(brickX, brickY, brickWidth, brickHeight);
		lineLeft = new Line2D.Double(brickX, brickY, brickX, (brickY + brickHeight));
		lineTop = new Line2D.Double(brickX, brickY, (brickX + brickWidth), brickY);
		lineRight = new Line2D.Double((brickX + brickWidth), brickY, (brickX + brickWidth), (brickY + brickHeight));

		
	
	}
	
	public void render(Graphics2D g) {
		g.setColor(Color.RED);
		g.draw(brick);
		g.setColor(Color.ORANGE);
		g.draw(lineLeft);
		g.draw(lineTop);
		g.draw(lineRight);
	}
	
	public Rectangle getBrick() {
		return brick;
	}
	
	public void setBrickY(int y) {
		brick.y = y;
	}
	
	public int getBrickY() {
		return brick.y;
	}
	public void setBrickX(int x) {
		brick.x = x;
	}
	
	public int getBrickX() {
		return brick.x;
	}
	
	public Line2D getLeftLine() {
		return lineLeft;
	}
	public Line2D getTopLine() {
		return lineTop;
	}
	public Line2D getRightLine() {
		return lineRight;
	}
	
	public int getBrickWidth() {
		return brickWidth;
	}
	

}
