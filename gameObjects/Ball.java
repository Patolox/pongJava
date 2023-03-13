package gameObjects;

import java.awt.Color;
import java.awt.Graphics;

import interfaces.DrawableObject;

public class Ball implements DrawableObject{

	private int xPos;
	private int yPos;
	private int ballWidth;
	private int ballHeight;
	private int ballXVelocity;
	private int ballYVelocity;
	private int ballVelocity;
	private Color ballColor;

	public Ball(int xPos, int yPos, int ballWidth, int ballHeight, int ballVelocity, Color ballColor) {
		this.xPos = xPos;
		this.yPos = yPos;
		this.ballWidth = ballWidth;
		this.ballHeight = ballHeight;
		this.ballColor = ballColor;
		this.ballVelocity = ballVelocity;
		this.ballXVelocity = ballVelocity;
		this.ballYVelocity = ballVelocity;
		
	}
	
	public int getxPos() {
		return xPos;
	}

	public void setxPos(int xPos) {
		this.xPos = xPos;
	}

	public int getyPos() {
		return yPos;
	}

	public void setyPos(int yPos) {
		this.yPos = yPos;
	}

	public int getBallWidth() {
		return ballWidth;
	}

	public void setBallWidth(int ballWidth) {
		this.ballWidth = ballWidth;
	}

	public int getBallHeight() {
		return ballHeight;
	}

	public void setBallHeight(int ballHeight) {
		this.ballHeight = ballHeight;
	}

	public Color getBallColor() {
		return ballColor;
	}

	public void setBallColor(Color ballColor) {
		this.ballColor = ballColor;
	}
	
	public int getBallXVelocity() {
		return ballXVelocity;
	}
	
	public void setBallXVelocity(int ballXVelocity) {
		this.ballXVelocity = ballXVelocity;
	}

	public int getBallYVelocity() {
		return ballYVelocity;
	}
	
	public void setBallYVelocity(int ballYVelocity) {
		this.ballYVelocity = ballYVelocity;
	}
	
	public int getBallVelocity() {
		return ballVelocity;
	}
	
	public void setBallVelocity(int ballVelocity) {
		this.ballVelocity = ballVelocity;
	}

	@Override
	public void Draw(Graphics g) {
		g.setColor(this.ballColor);
		g.fillOval(xPos, yPos, ballWidth, ballHeight);
	}



}
