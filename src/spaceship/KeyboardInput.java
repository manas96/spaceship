package spaceship;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;

public class KeyboardInput implements KeyListener {

	Player player;
	Projectile bullet;
	Board board;
	ArrayList<Projectile> bulletList;
	KeyboardInput(Player p, Board b,ArrayList<Projectile> l) {
		player = p;
		board = b;
		bulletList=l;
	}

	@Override
	public void keyPressed(KeyEvent e) { 
		// TODO Auto-generated method stub
		int key = e.getKeyCode();
		if (key == KeyEvent.VK_A) {
			player.addKey('a');
			player.move();
	
		}
		if (key == KeyEvent.VK_D) {
			player.addKey('d');
			player.move();
			
		}
		if (key == KeyEvent.VK_S) {
			player.addKey('s');
			player.move();
			
		}
		if (key == KeyEvent.VK_W) {
			player.addKey('w');
			player.move();
			
		}
		if (key == KeyEvent.VK_SPACE) {
			if(player.getAmmo()>0){
			bullet=new Projectile(player);
			bullet.bulletShot();
			bulletList.add(bullet);
			
			}
		}

	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		int key = e.getKeyCode();
		if (key == KeyEvent.VK_A) {
			player.resetAcclerationX();
			player.resetKeyPressed('a');
		}
		if (key == KeyEvent.VK_D) {
			player.resetAcclerationX();
			player.resetKeyPressed('d');
		}
		if (key == KeyEvent.VK_W) {
			player.resetAcclerationY();
			player.resetKeyPressed('w');
		}
		if (key == KeyEvent.VK_S) {
			player.resetAcclerationY();
			player.resetKeyPressed('s');
		}

	}

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub

	}

}
