package twoPlayerSnake;

import javax.swing.JFrame;

public class TwoPlayerSnake {
	JFrame frame;
	GamePanel panel;
	public static final int WIDTH = 400;
	public static final int HEIGHT = 400;
	public static void main(String[] args) {
		TwoPlayerSnake oof = new TwoPlayerSnake();
		oof.setup();
	}
	TwoPlayerSnake() {
		// TODO Auto-generated constructor stub
		panel=new GamePanel();
		frame=new JFrame();
	}
	void setup() {
		frame.add(panel);
		frame.setSize(WIDTH, HEIGHT+20);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
		frame.addKeyListener(panel);
		
	}
}
