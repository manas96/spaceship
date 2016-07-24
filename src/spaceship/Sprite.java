package spaceship;

import java.awt.Image;

import javax.swing.ImageIcon;

public class Sprite {
	protected Image image;
	protected int width, height;
	protected int x, y, dx, dy;
	protected int accln =3;

	Sprite(String s) {
		ImageIcon p = new ImageIcon(s);
		image = p.getImage();
		width = image.getWidth(null);
		height = image.getHeight(null);
		x = y = 0;
		dx = dy = 1;
	}

	Image getImage() {
		return image;
	}

	int getWidth() {
		return width;
	}

	int getHeight() {
		return height;
	}

	int getX() {
		return x;
	}

	int getY() {
		return y;
	}
}
