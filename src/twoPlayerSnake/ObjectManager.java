package twoPlayerSnake;

import java.awt.Color;
import java.awt.Graphics;
import java.util.ArrayList;
import java.util.Random;

public class ObjectManager {
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
		one = new Snake(1,1,Color.GREEN);
		two = new Snake(20,1,Color.BLUE);
	}
	void draw(Graphics g) {
		one.draw(g, food);
		two.draw(g, food);
		g.setColor(food.color);
		g.fillRect(food.x, food.y, food.SEGMENTWIDTH, food.SEGMENTHEIGHT);
	}
	public void dropFood() {
		if (food.isEaten) {
			food.isEaten=false;
			randomX = randy.nextInt(TwoPlayerSnake.WIDTH);
			food.x = randomX;
			randomY = randy.nextInt(TwoPlayerSnake.HEIGHT);
			food.y = randomY;
		}
	}
	void up() {
		one.direction=0;
	}
	void down() {
		one.direction=2;
	}
	void left() {
		one.direction=3;
	}
	void right() {
		one.direction=1;
	}
}
