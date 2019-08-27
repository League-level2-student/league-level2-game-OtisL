package twoPlayerSnake;

import java.awt.Color;
import java.awt.Graphics;
import javax.swing.Timer;

public class Bomb extends Segment{
	Timer runOut;
	Bomb(int x, int y, Color color) {
		super(x, y, color);
		//**NEED to get timer for bomb explosion WORKING**
	}
	void draw(Graphics g) {
		g.setColor(this.color);
		g.fillRect(this.x, this.y, SEGMENTWIDTH, SEGMENTHEIGHT);
	}
}
