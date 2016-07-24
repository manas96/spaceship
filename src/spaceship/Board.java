package spaceship;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.RenderingHints;
import java.util.ArrayList;
import java.util.Random;

import javax.swing.JFrame;
import javax.swing.JPanel;

@SuppressWarnings("serial")
public class Board extends JPanel {
	static JFrame frame;
	static Player player;
	static Enemy enemy;
	Random r = new Random();
	ArrayList<Stars> stars = new ArrayList<Stars>();
	static ArrayList<Projectile> bulletList= new ArrayList<Projectile>();//TODO
	int randomCounter;
	Board() {
		setBackground(Color.black);
	}

	@Override
	protected void paintComponent(Graphics g) {
		// TODO Auto-generated method stub
		super.paintComponent(g);
		Graphics2D g2d = (Graphics2D) g;
		g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
		g2d.setColor(Color.WHITE);
		
		//for background:
		randomCounter=r.nextInt(10);
		if(randomCounter>=0 && randomCounter<5){
			stars.add(new Stars("",r));
			
		}
		for(int i=0;i<stars.size();i++){
			if(stars.get(i).getX()<0){
				stars.remove(i);
				continue;
			}
		
			g2d.fillOval(stars.get(i).getX(),stars.get(i).getY(),2, 2);
			stars.get(i).move();
		}
		//render spaceship:
		g2d.drawImage(player.getImage(), player.getX(), player.getY(), this);
		g2d.drawImage(enemy.getImage(), enemy.getX(), enemy.getY(), this);
		//ammo:
		g2d.drawString("Ammo:"+player.getAmmo(), 110, 10);
		//healthbar:
		g2d.setColor(Color.RED);
		g2d.drawRect(0, 0, 100, 10);
		g2d.setColor(Color.GREEN);
		g2d.fillRect(0, 0, player.getHealth(), 10);
		g2d.setColor(Color.YELLOW);
		g2d.drawString(player.getHealth()+"%", 50, 10);
		//for projectiles:
		if(bulletList.isEmpty()!=true){
			for(int i=0;i<bulletList.size();i++){
					if(bulletList.get(i).isShot()==false){
						bulletList.remove(i);
						continue;
					}
				g2d.drawImage(bulletList.get(i).getImage(), bulletList.get(i).getX(), bulletList.get(i).getY(), this);
				bulletList.get(i).shoot();
			}
			
		}
		
	
		

	}

	public static void main(String[] args) throws Exception {
		frame = new JFrame("Spaceship game");
		player = new Player();
		Board board = new Board();
		KeyboardInput k = new KeyboardInput(player, board,bulletList);
		enemy=new Enemy();
		frame.setSize(1000, 500);
		frame.setVisible(true);
		frame.setFocusable(true);
		frame.addKeyListener(k);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.add(board);

		Thread t = new Thread(new Runnable() {

			@Override
			public void run() {
				// TODO Auto-generated method stub
				while (true) {
					board.repaint();
					try {
						Thread.sleep(10);
					} catch (Exception e) {
						e.printStackTrace();
					}
				}

			}
		});
		t.start();

	}

	

}
