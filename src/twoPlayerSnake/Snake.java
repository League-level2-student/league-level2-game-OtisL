package twoPlayerSnake;

import java.awt.Color;
import java.awt.Graphics;
import java.util.ArrayList;

public class Snake extends Segment{
	ArrayList<Segment> tail = new ArrayList<Segment>();
	int direction = 0;
	int score = 0;
	boolean active = true;
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
		checkBorders();
		update();
	}
	void manageTail() {
		  checkTailCollision();
		  tail.add(new Segment(this.x, this.y, this.color)); 
		  //tail.add(new Segment(this.x, this.y, this.color)); 
		  tail.remove(0);
		}
	void checkTailCollision() {
		for(int i=0; i<tail.size(); i++){
		    Segment current = tail.get(i);
		    if(this.x==current.x && this.y == current.y){
		    	System.out.println("oofed");
		    	active = false;
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
		    score++;
		    f.isEaten=true;
		    tail.add(new Segment(this.x, this.y, this.color));
		  }
	}
	void checkBorders() {
		if(this.x<0) {
			this.active=false;
		}
		if(this.x>500) {
			this.active=false;
		}
		if(this.y<0) {
			this.active=false;
		}
		if(this.y>500) {
			this.active=false;
		}
	}
}
