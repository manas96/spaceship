package spaceship;

public class Projectile extends Sprite {

	private boolean shot;
	Player player;
	Projectile(Player p) {
		super("res\\bulletTransperent.png");
		//super("E:\\eclipse workspace\\spaceship\\res\\bulletTransperent.png");
		x = p.getX() + p.getWidth();
		y = p.getY() + (p.getHeight() / 2) - 6;
		shot = false;
		player=p;
	}
																									
	void shoot() {		//moves the bullet
		// TODO Auto-generated method stub
		if (x > 1000) {
			shot = false;
			return;
		}
		x = x + 10;

	}

	public void bulletShot() {

		shot = true;
		player.decAmmo();

	}

	public boolean isShot() {
		// TODO Auto-generated method stub
		return shot;
	}

}
