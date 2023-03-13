package game;

import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JPanel;

import interfaces.DrawableObject;

public class GamePanel extends JPanel implements Runnable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private DrawableObject gameObjects[];
	private int screenWidth;
	private int screenHeight;
	
	public GamePanel(DrawableObject gameObjects[], int screenWidth, int screenHeight) {
		this.gameObjects = gameObjects;
		this.screenHeight = screenHeight;
		this.screenWidth = screenWidth;
	}
	
	@Override
	public void paint(Graphics g) {
		g.clearRect(0, 0, screenWidth, screenHeight);
		g.setColor(Color.BLACK);
		g.fillRect(0, 0, screenWidth, screenHeight);
		for(DrawableObject obj : gameObjects) {
			obj.Draw(g);
		}
		g.drawLine(screenWidth/2, 0, screenWidth/2, screenHeight);
		
	}

	@Override
	public void run() {
		int TARGET_TICKS = 30;
		final long OPTIMAL_TIME = 1000000000/TARGET_TICKS;
		while(true) {
			long start_time = System.nanoTime();
			long next_tick = start_time + OPTIMAL_TIME;
			this.repaint();
			long delayT = (next_tick - System.nanoTime())/1000000;
			try {
				Thread.sleep(delayT);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
	
}
