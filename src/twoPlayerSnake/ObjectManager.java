package twoPlayerSnake;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Random;

import javax.swing.Timer;

public class ObjectManager implements ActionListener{
	/* DO THE 
	END REASON!!!!!!!
	ITS WHAT YOU NEED TO DO!!!!
	 */
	Food food;
	Snake one;
	Snake two;
	Bomb bomb;
	Timer bombDrop;
	Timer bombExplode;
	Random randy = new Random();
	int randomX;
	int randomY;
	String reason;
	ObjectManager(Food f){
		this.food=f;
		one = new Snake(350,250,Color.GREEN, "One");
		two = new Snake(50,250,Color.BLUE, "Two");
		bombDrop = new Timer(5000, this);
		bombExplode = new Timer(2500, this);
		bombDrop.start();
	}
	void draw(Graphics g) {
		one.draw(g, food);
		two.draw(g, food);
		if(bomb!=null) {
			bomb.draw(g);
		}
		checkIntersection();
		dropFood();
		g.setColor(food.color);
		g.fillRect(food.x, food.y, food.SEGMENTWIDTH, food.SEGMENTHEIGHT);
	}
	public void dropFood() {
		if (food.isEaten) {
			food.isEaten=false;
			randomX = randy.nextInt(40);
			randomX*=10;
			food.x = randomX;
			randomY = randy.nextInt(40);
			randomY*=10;
			food.y = randomY;
		}
	}
	void dropBomb() {
		int rand = randy.nextInt(40);
		rand*=10;
		int rand1 = randy.nextInt(40);
		rand1*=10;
		bomb = new Bomb(rand,rand1,Color.YELLOW);
	}
	void checkExplosionArea() {
		int newX=bomb.x-10;
		int newY=bomb.y-10;
		checkBombIntersection(newX, newY);
		bomb=null;
	}
	void oneUp() {
		if (one.direction!=2) {
			one.direction=0;
		}
	}
	void oneDown() {
		if (one.direction!=0) {
			one.direction=2;
		}
	}
	void oneLeft() {
		if (one.direction!=1) {
			one.direction=3;
		}
	}
	void oneRight() {
		if (one.direction!=3) {
			one.direction=1;
		}
	}
	void twoUp() {
		if (two.direction!=2) {
			two.direction=0;
		}
	}
	void twoDown() {
		if (two.direction!=0) {
			two.direction=2;
		}
	}
	void twoLeft() {
		if (two.direction!=1) {
			two.direction=3;
		}
	}
	void twoRight() {
		if (two.direction!=3) {
			two.direction=1;
		}
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
		if(e.getSource().equals(bombDrop)) {
			dropBomb();
			bombExplode.start();
		}else if(e.getSource().equals(bombExplode)) {
			bombExplode.stop();
			checkExplosionArea();
		}
	}
	void checkIntersection() {
		if(one.collisionBox.intersects(two.collisionBox)){
			System.out.println("collided heads");
			reason="The snakes hit each other";
			one.active=false;
			two.active=false;
		}
		for(int i=0;i<one.tail.size();i++) {
			Segment current = one.tail.get(i);
			for(int j=0;j<two.tail.size();j++) {
				Segment current2 = two.tail.get(j);
				if(current.collisionBox.intersects(current2.collisionBox)) {
					System.out.println("collided tails");
					reason="The snakes hit each other";
					one.active=false;
					two.active=false;
				}
			}
		}
	}
	void checkBombIntersection(int x, int y) {
		Rectangle collisionArea = new Rectangle(x, y, 30, 30);
		for(int i=0;i<one.tail.size();i++) {
			Segment current = one.tail.get(i);
			if(current.collisionBox.intersects(collisionArea)) {
					System.out.println("oofed via explosion");
					reason="Snake One was blown up";
					one.active=false;
				}
			}
		for(int j=0;j<two.tail.size();j++) {
			Segment current = two.tail.get(j);
			if(current.collisionBox.intersects(collisionArea)) {
					System.out.println("oofed via explosion");
					reason="Snake Two was blown up";
					two.active=false;
				}
			}
		if(one.collisionBox.intersects(collisionArea)) {
			System.out.println("oofed via explosion");
			reason="Snake One was blown up";
			one.active=false;
		}
		if(two.collisionBox.intersects(collisionArea)) {
			System.out.println("oofed via explosion");	
			reason="Snake Two was blown up";
			two.active=false;
		}
	}
}