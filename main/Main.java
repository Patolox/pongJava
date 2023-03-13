package main;

import javax.swing.JFrame;

import game.Game;

public class Main extends JFrame{

	private static final long serialVersionUID = 1L;

	public Main() {
		setTitle("Pong");
		setResizable(false);
		setSize(800, 600);
		setVisible(true);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Thread game = new Thread(new Game(this));
		game.start();
	}
	
	public static void main(String[] args) {
		new Main();
	}

}
