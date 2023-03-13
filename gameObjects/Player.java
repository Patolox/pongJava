package gameObjects;

import java.awt.Color;
import java.awt.Graphics;

import interfaces.DrawableObject;

public class Player implements DrawableObject{

	private int xPos;
	private int yPos;
	private boolean up;
	private boolean down;
	private int playerWidth;
	private int playerHeight;
	private Color playerColor;

	public Player(int xPos, int yPos, int playerWidth, int playerHeight, Color playerColor) {
		this.xPos = xPos;
		this.yPos = yPos;
		this.playerWidth = playerWidth;
		this.playerHeight = playerHeight;
		this.playerColor = playerColor;
	}

	public void setyPos(int yPos) {
		this.yPos = yPos;
	}

	public int getyPos() {
		return this.yPos;
	}

	public int getxPos() {
		return this.xPos;
	}
	
	public void setColor(Color color) {
		this.playerColor = color;
	}
	
	public Color getColor() {
		return this.playerColor;
	}
	
	public void setPlayerWidth(int width) {
		this.playerWidth = width;
	}
	
	public void setPlayerHeight(int height) {
		this.playerHeight = height;
	}
	
	public int getPlayerWidth() {
		return this.playerWidth;
	}
	
	public int getPlayerHeight() {
		return this.playerHeight;
	}
	
	public boolean isUp() {
		return up;
	}
	
	public void setUp(boolean up) {
		this.up = up;
	}
	
	public boolean isDown() {
		return down;
	}
	
	public void setDown(boolean down) {
		this.down = down;
	}
	
	@Override
	public void Draw(Graphics g) {
		g.setColor(this.playerColor);
		g.fillRect(xPos, yPos, playerWidth, playerHeight);
	}

	
}
