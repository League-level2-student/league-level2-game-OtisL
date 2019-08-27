package twoPlayerSnake;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.BufferedImage;

import javax.swing.JPanel;
import javax.swing.Timer;

public class GamePanel extends JPanel implements ActionListener, KeyListener{
	final int MENU = 0;
	final int GAME = 1;
	final int END = 2;
	final int INSTRUCTIONS = 3;
	int currentState = MENU;
	int oneLastScore = 0;
	int twoLastScore = 0;
	Font titleFont;
	Font menuOptions;
	Font instructionFont;
	Timer frameDraw;
	Timer bombDrop;
	Food food;
	ObjectManager manager;
	public static BufferedImage image;
	public static boolean needImage = true;
	public static boolean gotImage = false;	
	GamePanel(){
		titleFont = new Font("Arial", Font.PLAIN, 43);
		menuOptions = new Font("Arial", Font.PLAIN, 26);
		instructionFont = new Font("Arial", Font.PLAIN, 15);
		food=new Food(1,1,Color.RED);
		manager=new ObjectManager(food);
		manager.dropFood();
		frameDraw = new Timer(1000/10, this);
		frameDraw.start();
		bombDrop = new Timer(60000, manager);
		
	}
	public void paintComponent(Graphics g){
		if(currentState == MENU){
		    drawMenuState(g);
		}else if(currentState == GAME){
		    drawGameState(g);
		}else if(currentState == END){
		    drawEndState(g);
		}else if(currentState == INSTRUCTIONS) {
			drawInstructionState(g);
		}
	}
	//Add Space=Instructions
	void drawMenuState(Graphics g) { 
		g.setColor(Color.BLUE);
		g.fillRect(0, 0, TwoPlayerSnake.WIDTH, TwoPlayerSnake.HEIGHT);
		g.setFont(titleFont);
		g.setColor(Color.YELLOW);
		g.drawString("Two Player Snake", 25, 50);
		g.setFont(menuOptions);
		g.drawString("Press 'ENTER' to start", 65, 150);
		g.drawString("Press 'SPACE' for instructions", 33, 230);
	}
	void drawGameState(Graphics g) { 
		g.setColor(Color.BLACK);
		g.fillRect(0, 0, TwoPlayerSnake.WIDTH, TwoPlayerSnake.HEIGHT);
		manager.draw(g);
	}
	void drawEndState(Graphics g)  { 
		g.setColor(Color.RED);
		g.fillRect(0, 0, TwoPlayerSnake.WIDTH, TwoPlayerSnake.HEIGHT);
		g.setFont(titleFont);
		g.setColor(Color.YELLOW);
		g.drawString("Game Over!", 80, 50);
		g.setFont(menuOptions);
		g.drawString("Snake One (Green) scored "+oneLastScore, 40, 110);
		g.drawString("Snake Two (Blue) scored "+twoLastScore, 45, 160);
		g.drawString("one day this will contain a end reason", 45, 230);
	}
	void drawInstructionState(Graphics g) {
		g.setColor(Color.BLUE);
		g.fillRect(0, 0, TwoPlayerSnake.WIDTH, TwoPlayerSnake.HEIGHT);
		g.setFont(titleFont);
		g.setColor(Color.YELLOW);
		g.drawString("Two Player Snake", 25, 50);
		g.setFont(instructionFont);
		g.drawString("Welcome! In this game you will be one of two snakes", 5, 80);
		g.drawString("Move the head of your snake around by using your controls.", 5, 100);
		g.drawString("Eat food (red) to grow longer and get more points.", 5, 120);
		g.drawString("Your tail will follow the path you moved around.", 5, 140);
		g.drawString("If you hit a side, hit your own tail, or hit the other snake", 5, 160);
		g.drawString("your snake dies and the game ends", 5, 180);
		g.drawString("Avoid the bombs as well! (yellow) After x seconds they will", 5, 200);
		g.drawString("detonate a 3x3 square (1 square = size of food, snake head)", 5, 220);
		g.drawString("around them, if your snake is in the area then it dies.", 5, 240);
		g.drawString("Controls:", 5, 260);
		g.drawString("Snake One (Green): Arrow Keys (Up, Down, Left, Right)", 10, 280);
		g.drawString("Snake Two (Blue): WASD (W up, A left, S down, D right)", 10, 300);
		g.drawString("Press the key and it will turn. (no need to hold it)", 5, 320);
		g.drawString("No reversing too. (ex. While going up you can't go down)", 5, 340);
		g.setFont(menuOptions);
		g.drawString("Press 'SPACE' to go back", 55, 380);
	}
	void updateMenuState() {  
		
	}
	void updateGameState() {  
		boolean oof = manager.gameOver();
		if(oof) {
			oneLastScore = manager.one.score;
			twoLastScore = manager.two.score;
			currentState++;
			manager = new ObjectManager(food);
			manager.dropFood();
		}
	}
	void updateEndState()  {  
		
	}
	void updateInstructionState() {
		
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource()==bombDrop) {
			manager.dropBomb();
		}else if (e.getSource()==frameDraw) {
			if(currentState == MENU){
				updateMenuState();
			}else if(currentState == GAME){
				updateGameState();
			}else if(currentState == END){
				updateEndState();
			}else if(currentState == INSTRUCTIONS) {
				updateInstructionState();
			}
			repaint();
		}
	}

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub
		if (e.getKeyCode()==KeyEvent.VK_ENTER) {
		    if (currentState == END) {
		        currentState = MENU;
		    } else if(currentState==MENU){
		        currentState++;
		    }
		}
		if (e.getKeyCode()==KeyEvent.VK_SPACE) {
			if (currentState == MENU) {
		        currentState = INSTRUCTIONS;
		    } else if(currentState == INSTRUCTIONS){
		        currentState = MENU;
		    }
		}
		if (e.getKeyCode()==KeyEvent.VK_UP) {
			manager.oneUp();
		}
		if (e.getKeyCode()==KeyEvent.VK_DOWN) {
			manager.oneDown();
		}
		if (e.getKeyCode()==KeyEvent.VK_LEFT) {
			manager.oneLeft();
		}
		if (e.getKeyCode()==KeyEvent.VK_RIGHT) {
			manager.oneRight();
		}
		if (e.getKeyCode()==KeyEvent.VK_W) {
			manager.twoUp();
		}
		if (e.getKeyCode()==KeyEvent.VK_S) {
			manager.twoDown();
		}
		if (e.getKeyCode()==KeyEvent.VK_A) {
			manager.twoLeft();
		}
		if (e.getKeyCode()==KeyEvent.VK_D) {
			manager.twoRight();
		}
	}
	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

}
