package main;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.BufferStrategy;

import Entity.Bricks;
import Entity.Player;

public class Game implements Runnable, KeyListener {
	
	private int width, height, playerX, playerY;
	private String title;
	private boolean running = false;
	
	private Thread thread;
	private Display display;
	
	private Graphics g;
	private BufferStrategy bs;
	
	private Game game;

	
	//Entity
	private Player player;
	private Bricks brick, ground;
	
	//Input
	
	public Game(String title, int width, int height) {
		this.title = title;
		this.width = width;
		this.height = height;
		
	}

	private void init() {
		display = new Display(title, width, height);
		display.getFrame().addKeyListener(this);
		player = new Player(200, 200);
		brick = new Bricks(300, (height / 2) - 100, 50, 100);
		ground = new Bricks(0, height / 2, width, height / 2);
		System.out.println(brick.getBrickY() + brick.getBrickWidth() + 1);
		
	}
	
	private void tick() {
		player.tick();
		
		if(player.getPlayer().intersects(ground.getBrick()))
			player.setPlayerY(ground.getBrickY() - 20);
		
		if((player.getPlayerY() + 20) != ground.getBrickY())
			player.gravity();
		
		if(player.getPlayer().intersectsLine(brick.getLeftLine()))
			player.setPlayerX(brick.getBrickX() - 21);
		
		if(player.getPlayer().intersectsLine(brick.getTopLine()))
			player.setPlayerY(brick.getBrickY() - 21);
		
		if(player.getPlayer().intersectsLine(brick.getRightLine()))
			player.setPlayerX(brick.getBrickX() + brick.getBrickWidth() + 1);
	}
	
	private void render() {
		bs = display.getCanvas().getBufferStrategy();
		if(bs == null) {
			display.getCanvas().createBufferStrategy(3);
			return;
		}
		g = bs.getDrawGraphics();
		g.clearRect(0, 0, width, height);
		// draw
		
		g.setColor(Color.BLACK);
		g.fillRect(0, 0, width, height);

		g.setColor(Color.CYAN);
		player.render((Graphics2D) g);
		brick.render((Graphics2D) g);
		ground.render((Graphics2D) g);
		
		//end draw
		bs.show();
		g.dispose();
		
	}


	public void run() {
		init();
		int fps = 60;
		double timePerTick = 1000000000 / fps;
		double delta = 0;
		long now;
		long lastTime = System.nanoTime();
		long timer = 0;
		int ticks = 0;
		
		while(running) {
			now = System.nanoTime();
			delta += (now - lastTime) / timePerTick;
			timer += now- lastTime;
			lastTime = now;
			
			if(delta >= 1) {
				tick();
				render();
				ticks++;
				delta--;
			}
			
			if(timer >= 1000000000) {
				System.out.println("ticks: " + ticks);
				ticks = 0;
				timer = 0;
				
			}
		}
		stop();
		
	}
	
	public synchronized void start() {
		if(running)
			return;
		running = true;
		thread = new Thread(this);
		thread.start();
	}
	
	public synchronized void stop() {
		if(!running)
			return;
		running = false;
		try {
			thread.join();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	@Override
	public void keyPressed(KeyEvent e) {
		if(e.getKeyCode() == KeyEvent.VK_UP)
			player.setPlayerUp();
		if(e.getKeyCode() == KeyEvent.VK_DOWN)
			player.setPlayerDown();
		if(e.getKeyCode() == KeyEvent.VK_LEFT)
			player.setPlayerLeft();
		if(e.getKeyCode() == KeyEvent.VK_RIGHT)
			player.setPlayerRight();
		
	}

	@Override
	public void keyReleased(KeyEvent e) {
		if(e.getKeyCode() == KeyEvent.VK_UP)
			player.setPlayerUpBack();
		if(e.getKeyCode() == KeyEvent.VK_SPACE)
			player.setPlayerUpBack();
		if(e.getKeyCode() == KeyEvent.VK_DOWN)
			player.setPlayerDownBack();
		if(e.getKeyCode() == KeyEvent.VK_LEFT)
			player.setPlayerLeftBack();
		if(e.getKeyCode() == KeyEvent.VK_RIGHT)
			player.setPlayerRightBack();
		
	}

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}
	

	

}
