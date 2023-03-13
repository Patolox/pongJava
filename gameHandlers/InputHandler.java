package gameHandlers;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import gameObjects.Player;

public class InputHandler implements KeyListener{
	Player player;
	
	public InputHandler(Player player) {
		this.player = player;
	}
	
	@Override
	public void keyPressed(KeyEvent arg0) {
		System.out.println(arg0.getKeyCode());
		if(arg0.getKeyCode() == KeyEvent.VK_W) {
			player.setUp(true);
		}else if(arg0.getKeyCode() == KeyEvent.VK_S) {
			player.setDown(true);
		}
	}

	@Override
	public void keyReleased(KeyEvent arg0) {
		if(arg0.getKeyCode() == KeyEvent.VK_W) {
			player.setUp(false);
		}else if(arg0.getKeyCode() == KeyEvent.VK_S) {
			player.setDown(false);
		}
	}

	@Override
	public void keyTyped(KeyEvent arg0) {
		// TODO Auto-generated method stub
		
	}

}
