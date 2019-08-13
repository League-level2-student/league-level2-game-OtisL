package twoPlayerSnake;

import java.awt.Color;
import java.awt.Rectangle;

public class Segment {
	int x;
	int y;
	final int SEGMENTWIDTH = 10;
	final int SEGMENTHEIGHT = 10;
	Rectangle collisionBox;
	Color color;
	Segment(int x, int y, Color color){
		this.x=x;
		this.y=y;
		this.color=color;
		collisionBox=new Rectangle(this.x, this.y, SEGMENTWIDTH, SEGMENTHEIGHT);
	}
	void update() {
		collisionBox.setBounds(x, y, SEGMENTWIDTH, SEGMENTHEIGHT);
	}
}
