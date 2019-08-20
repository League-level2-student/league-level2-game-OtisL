package twoPlayerSnake;

import java.awt.Color;
import java.awt.Graphics;
import java.util.ArrayList;

public class Snake extends Segment{
	ArrayList<Segment> tail = new ArrayList<Segment>();
	int direction = 0;
	public Snake(int x, int y, Color color) {
		// TODO Auto-generated constructor stub
		super(x,y,color);
	}
	void update() {
		super.update();
	}
	void draw(Graphics g, Food f) {
		//this.y+=1;
		g.setColor(this.color);
		g.fillRect(this.x, this.y, SEGMENTWIDTH, SEGMENTHEIGHT);
		manageTail();
		for (int i=0; i<tail.size(); i++) {
		    Segment current = tail.get(i);
		    g.fillRect(current.x, current.y, 10, 10);
		}
		eat(f);
		move();
		update();
	}
	void manageTail() {
		  tail.add(new Segment(this.x, this.y, this.color)); 
		  //tail.add(new Segment(this.x, this.y, this.color)); 
		  tail.remove(0);
		  checkTailCollision();
		}
	void checkTailCollision() {
		for(int i=0; i<tail.size(); i++){
		    Segment current = tail.get(i);
		    if(this.x==current.x && this.y == current.y){
		      //eaten=1;
		    	System.out.println("oofed");
		    	tail = new ArrayList<Segment>();
		    	tail.add(new Segment(this.x, this.y, this.color));
		    }
		  }

	}
	void move() {
		/*
		 0 is UP
		 1 is RIGHT
		 2 is DOWN
		 3 is LEFT
		 */
		  switch(direction) {
		  case 0: 
		    this.y-=10;
		    break;
		  case 2: 
		    this.y+=10;
		    break;
		  case 3:
		    this.x-=10;
		    break;
		  case 1:
		    this.x+=10;
		    break;
		  }
	}
	void eat(Food f) {
		if (this.x==f.x && this.y==f.y) {
		    //eaten++;
		    f.isEaten=true;
		    tail.add(new Segment(this.x, this.y, this.color));
		  }
	}
}
