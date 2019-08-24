package twoPlayerSnake;

import java.awt.Color;
import java.awt.Graphics;

public class Bomb extends Segment{
	Bomb(int x, int y, Color color) {
		super(x, y, color);
		// TODO Auto-generated constructor stub
	}
	void draw(Graphics g) {
		g.setColor(this.color);
		g.fillRect(this.x, this.y, SEGMENTWIDTH, SEGMENTHEIGHT);
	}
}
