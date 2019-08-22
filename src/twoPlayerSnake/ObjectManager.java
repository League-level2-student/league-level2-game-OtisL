package twoPlayerSnake;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Random;

public class ObjectManager implements ActionListener{
	Food food;
	Snake one;
	Snake two;
	ArrayList<Segment> tailOne = new ArrayList<Segment>();
	ArrayList<Segment> tailTwo = new ArrayList<Segment>();
	Random randy = new Random();
	int randomX;
	int randomY;
	ObjectManager(Food f){
		this.food=f;
		one = new Snake(50,250,Color.GREEN);
		two = new Snake(400,250,Color.BLUE);
	}
	void draw(Graphics g) {
		one.draw(g, food);
		two.draw(g, food);
		checkIntersection();
		dropFood();
		g.setColor(food.color);
		g.fillRect(food.x, food.y, food.SEGMENTWIDTH, food.SEGMENTHEIGHT);
		
	}
	public void dropFood() {
		if (food.isEaten) {
			food.isEaten=false;
			randomX = randy.nextInt(50);
			randomX*=10;
			food.x = randomX;
			randomY = randy.nextInt(50);
			randomY*=10;
			food.y = randomY;
		}
	}
	void oneUp() {
		if (one.direction!=2) {
			one.direction=0;
		}
	}
	void oneDown() {
		one.direction=2;
	}
	void oneLeft() {
		one.direction=3;
	}
	void oneRight() {
		one.direction=1;
	}
	void twoUp() {
		two.direction=0;
	}
	void twoDown() {
		two.direction=2;
	}
	void twoLeft() {
		two.direction=3;
	}
	void twoRight() {
		two.direction=1;
	}
	boolean gameOver() {
		if(!one.active) {
			return true;
		}else if(!two.active) {
			return true;
		}else {
			return false;
		}	
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}
	void checkIntersection() {
		for(int i=0;i<one.tail.size();i++) {
			Segment current = one.tail.get(i);
			for(int j=0;j<two.tail.size();j++) {
				Segment current2 = two.tail.get(i);
				if(current.collisionBox.intersects(current2.collisionBox)) {
					one.active=false;
					two.active=false;
				}
			}
		}
	}
}
