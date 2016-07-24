package spaceship;

public class Player extends Sprite {
	
	boolean isWPressed,isAPressed,isSPressed,isDPressed;
	int health;
	int ammo;
	Player() {
		super("res\\playerTransperent.png");
		
		isWPressed=false;
		isAPressed=false;
		isSPressed=false;
		isDPressed=false;
		x=10;
		y=50;
		health=100;
		ammo=30;
	}
	public int getAmmo(){
		return ammo;
	}
	public int getHealth(){
		return health;
	}
	public void move() { // UNUSED TODO:ADD MULTIKEY movement..done
	if(isWPressed)
		moveUp();
	if(isAPressed)
		moveLeft();
	if(isSPressed)
		moveDown();
	if(isDPressed)
		moveRight();
	
	}

	public void moveLeft() {
		// TODO Auto-generated method stub
		if (x > 0) {
			x = x - dx;
			dx = dx + accln;
		
		}
	}

	public void moveRight() {
		// TODO Auto-generated method stub
		if (x + width < 1000) {
			x = x + dx;
			
			dx = dx + accln;
		}
	}

	public void moveUp() {
		// TODO Auto-generated method stub
		if (y > 0) {
			y = y - dy; 
			dy = dy + accln;
			
		}
	}

	public void moveDown() {
		// TODO Auto-generated method stub
		if (y + height< 500) {
			y = y + dy;
			dy = dy + accln;
		
		}
	}

	public void resetAcclerationY() {
		// TODO Auto-generated method stub
		dy = 2;

	}

	public void resetAcclerationX() {
		// TODO Auto-generated method stub
		dx = 2;
	}

	public void addKey(char c) { //  TODO:ADD MULTIKEY SUPPORT DONE
		// TODO Auto-generated method stub
		switch(c){
		case 'w':
			isWPressed=true;
			break;
		case 'a':
			isAPressed=true;
			break;
		case 's':
			isSPressed=true;
			break;
		case 'd':
			isDPressed=true;
			break;
		}
		

	}

	public void resetKeyPressed(char c) { //   TODO:ADD MULTIKEY SUPPORT DONE
		// TODO Auto-generated method stub
		switch(c){
		case 'w':
			isWPressed=false;
			break;
		case 'a':
			isAPressed=false;
			break;
		case 's':
			isSPressed=false;
			break;
		case 'd':
			isDPressed=false;
			break;
		}
	}
	public void decAmmo() {
		// TODO Auto-generated method stub
		ammo--;
		
	}

}
