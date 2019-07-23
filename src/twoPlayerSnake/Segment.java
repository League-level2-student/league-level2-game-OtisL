package twoPlayerSnake;

import java.awt.Rectangle;

public class Segment {
	int x;
	int y;
	final int SEGMENTWIDTH = 10;
	final int SEGMENTHEIGHT = 10;
	Rectangle collisionBox;
	Segment(int x, int y){
		this.x=x;
		this.y=y;
		collisionBox=new Rectangle(this.x, this.y, SEGMENTWIDTH, SEGMENTHEIGHT);
	}
	void update() {
		collisionBox.setBounds(x, y, SEGMENTWIDTH, SEGMENTHEIGHT);
	}
}
