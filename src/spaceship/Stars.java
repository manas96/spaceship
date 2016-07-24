package spaceship;

import java.util.Random;

public class Stars extends Sprite {
	Random random;
	Stars(String s,Random r) {
		super(s);
		random=r;
		y=random.nextInt(501);
		x=1000;
	}
	public void move(){
		if(x>-20){
			x=x-5;
		}
	}
	
	
}
