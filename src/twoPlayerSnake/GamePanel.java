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
	int currentState = MENU;
	Font titleFont;
	Font menuOptions;
	Font scoreFont;
	Timer frameDraw;
	Food food;
	ObjectManager manager;
	public static BufferedImage image;
	public static boolean needImage = true;
	public static boolean gotImage = false;	
	GamePanel(){
		titleFont = new Font("Arial", Font.PLAIN, 48);
		menuOptions = new Font("Arial", Font.PLAIN, 30);
		scoreFont = new Font("Arial", Font.PLAIN, 20);
		frameDraw = new Timer(1000/60, this);
		frameDraw.start();
		food=new Food(1,1,Color.RED);
		manager=new ObjectManager(food);
	}
	public void paintComponent(Graphics g){
		if(currentState == MENU){
		    drawMenuState(g);
		}else if(currentState == GAME){
		    drawGameState(g);
		}else if(currentState == END){
		    drawEndState(g);
		}
	}
	void drawMenuState(Graphics g) { 
		g.setColor(Color.BLUE);
		g.fillRect(0, 0, TwoPlayerSnake.WIDTH, TwoPlayerSnake.HEIGHT);
		g.setFont(titleFont);
		g.setColor(Color.YELLOW);
		g.drawString("Two Player Snake", 50, 50);
		g.setFont(menuOptions);
		g.drawString("Press 'ENTER' to start", 95, 200);
	}
	void drawGameState(Graphics g) { 
		g.setColor(Color.BLACK);
		g.fillRect(0, 0, TwoPlayerSnake.WIDTH, TwoPlayerSnake.HEIGHT);
	}
	void drawEndState(Graphics g)  { 
		g.setColor(Color.RED);
		g.fillRect(0, 0, TwoPlayerSnake.WIDTH, TwoPlayerSnake.HEIGHT);
	}
	void updateMenuState() {  
		
	}
	void updateGameState() {  
		
	}
	void updateEndState()  {  
		
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(currentState == MENU){
		    updateMenuState();
		}else if(currentState == GAME){
		    updateGameState();
		}else if(currentState == END){
		    updateEndState();
		}
		repaint();
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
		        
		    } else /*if(currentState==MENU)*/{
		        currentState++;
		    }
		}
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

}
