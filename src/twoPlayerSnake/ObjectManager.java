package twoPlayerSnake;

import java.awt.Color;
import java.util.ArrayList;

public class ObjectManager {
	Food food;
	Snake one;
	Snake two;
	ArrayList<Segment> tailOne = new ArrayList<Segment>();
	ArrayList<Segment> tailTwo = new ArrayList<Segment>();
	ObjectManager(Food f){
		this.food=f;
		one = new Snake(1,1,Color.GREEN);
		two = new Snake(1,1,Color.BLUE);
	}
}
