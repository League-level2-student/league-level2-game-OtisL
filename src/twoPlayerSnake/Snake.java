package twoPlayerSnake;

import java.awt.Color;
import java.awt.Graphics;

public class Snake extends Segment{
	
	public Snake(int x, int y, Color color) {
		// TODO Auto-generated constructor stub
		super(x,y,color);
	}
	void update() {
		
		super.update();
	}
	void draw(Graphics g) {
		g.setColor(this.color);
		g.drawRect(this.x, this.y, SEGMENTWIDTH, SEGMENTHEIGHT);
		update();
	}
}
