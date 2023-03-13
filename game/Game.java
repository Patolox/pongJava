package game;

import java.awt.Color;
import java.util.Random;

import javax.swing.JFrame;

import gameHandlers.InputHandler;
import gameObjects.Ball;
import gameObjects.Player;
import interfaces.DrawableObject;

public class Game implements Runnable{
	private int collision_type = 0;
	GamePanel gamePanel;
	Player p1;
	Player p2;
	Ball ball;

	public Game(JFrame mainScreen) {
		p1 = new Player(10, mainScreen.getHeight()/2, 10, 100, Color.WHITE);
		p2 = new Player(780, mainScreen.getHeight()/2, 10, 100, Color.WHITE);
		ball = new Ball(mainScreen.getWidth()/2, mainScreen.getHeight()/2, 10, 10, 10, Color.WHITE);
		DrawableObject gameObjects[] = new DrawableObject[3];
		gameObjects[0] = p1;
		gameObjects[1] = p2;
		gameObjects[2] = ball;
		InputHandler ih = new InputHandler(p1);
		gamePanel = new GamePanel(gameObjects, 800, 600);
		mainScreen.add(gamePanel);
		gamePanel.addKeyListener(ih);
		gamePanel.setFocusable(true);
		gamePanel.requestFocus();
		gamePanel.requestFocusInWindow();

		Thread gamePanelThread = new Thread(gamePanel);
//		gamePanelThread.start();
	
	}

	private void update() {
		int ballX;
		int ballY;
		int p1Y;
		int p2Y;

		
		p1Y = p1.getyPos();
		p2Y = p2.getyPos();
		
		ballX = ball.getxPos();
		ballY = ball.getyPos();
		
		if(p1.isUp() && p1Y > 0) {
			p1.setyPos(p1.getyPos() - 10);
		}else if(p1.isDown() && (p1Y + p1.getPlayerHeight()) < gamePanel.getHeight()) {
			p1.setyPos(p1.getyPos() + 10);
		}
//		p1.setyPos((int) (ballY - p1.getPlayerHeight()*0.50));
		p2.setyPos((int) (ballY - p2.getPlayerHeight()*0.50));
		
		if(ballCollide()) {
			ball.setBallXVelocity(-ball.getBallXVelocity());
			if(collision_type == 1) { // p1 collision
				int pHeight = p1.getPlayerHeight();
				int reboundCoeff = (int) Math.abs(ballY - p1Y + pHeight*0.25);
				if(reboundCoeff <= pHeight*0.5) {
					ball.setBallYVelocity(ball.getBallVelocity()*-1);
				}else {
					ball.setBallYVelocity(ball.getBallVelocity());
				}
			}else if(collision_type == 2) { // p2 collision
				int pHeight = p2.getPlayerHeight();
				int reboundCoeff = (int) Math.abs(ballY - p2Y + pHeight*0.25);
				if(reboundCoeff <= pHeight*0.5) {
					ball.setBallYVelocity(ball.getBallVelocity()*-1);
				}else {
					ball.setBallYVelocity(ball.getBallVelocity());
				}
			}else if(collision_type == 3) { // upper/down walls collision
				ball.setBallXVelocity(ball.getBallXVelocity()*-1);
				ball.setBallYVelocity(ball.getBallYVelocity()*-1);
			}
		}

		if(ball.getxPos() <= 0 || ball.getxPos() >= gamePanel.getWidth()) {
			reset();
		}else {
			ball.setyPos(ball.getBallYVelocity() + ballY);
			ball.setxPos(ball.getBallXVelocity() + ballX);
		}
	}
	
	private void reset() {
		Random rnd = new Random();
		boolean side = rnd.nextBoolean();
		if(side) {
			ball.setBallXVelocity(ball.getBallVelocity());
		}else {
			ball.setBallXVelocity(ball.getBallVelocity()*-1);	
		}
		ball.setBallYVelocity(0);
		ball.setxPos(gamePanel.getWidth()/2);
		ball.setyPos(gamePanel.getHeight()/2);
	}

	private boolean ballCollide() {
		int ballX;
		int ballY;
		int p1X;
		int p1Y;
		int p2X;
		int p2Y;
		
		p1X = p1.getxPos();
		p1Y = p1.getyPos();
		
		p2X = p2.getxPos();
		p2Y = p2.getyPos();
		
		ballX = ball.getxPos();
		ballY = ball.getyPos();

		if((ballX <= p1X + p1.getPlayerWidth() && ballX + ball.getBallWidth() >= p1X) && (ballY + ball.getBallHeight() >= p1Y && ballY <= p1Y + p1.getPlayerHeight())) {
			collision_type = 1;
			return true;
		}
		if((ballX <= p2X + p2.getPlayerWidth() && ballX + ball.getBallWidth() >= p2X) && (ballY + ball.getBallHeight() >= p2Y && ballY <= p2Y + p2.getPlayerHeight())) {
			collision_type = 2;
			return true;
		}
		
		if(ballY > gamePanel.getHeight() - ball.getBallHeight() || ballY < 0) {
			collision_type = 3;
			return true;
		}

		collision_type = 0;
		return false;
	}

	@Override
	public void run() {
		int TARGET_TICKS = 30;
		final long OPTIMAL_TIME = 1000000000/TARGET_TICKS;
		while(true) {
			long start_time = System.nanoTime();
			long next_tick = start_time + OPTIMAL_TIME;
			update();
			gamePanel.repaint();
			long delayT = (next_tick - System.nanoTime())/1000000;
			try {
				Thread.sleep(delayT);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

}
