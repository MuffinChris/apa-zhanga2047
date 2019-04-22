//(c) A+ Computer Science
//www.apluscompsci.com
//Name -

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Canvas;
import java.awt.event.KeyListener;
import java.awt.event.KeyEvent;
import static java.lang.Character.*;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.List;

public class Breakout extends Canvas implements KeyListener, Runnable
{
  private Ball ball;
  private Paddle paddle;
  private boolean[] keys;
  private BufferedImage back;
  private int pscore = 0;
  private Wall topWall;
  private Wall botWall;
  private Wall rightWall;
  private Wall leftWall;
  private Score score;
  private int width;
  private int height;
  private List<Block> bricks;
  private boolean gameactive = true;

  public Breakout(int width, int height)
  {
	  bricks = new ArrayList<Block>();
	  int x = 80;
	  int y = 80;
	  for (int z = 0; z < 4; z++) {
		  for (int i = 0; i < 17; i++) {
			  Block brick = new Block(x + (i * 50), y + (z * 40), 49, 38, Color.LIGHT_GRAY);
			  bricks.add(brick);
		  }
	  }
	  
	  
    //set up all variables related to the game
	// USE WITH AIDENS PC
	int brokenOffsetX = (int) (width * 0.02);
	int brokenOffsetY = (int) (height * 0.05);
	//int brokenOffsetX = 0;
	//int brokenOffsetY = 0;
	
	this.width = width;
	this.height = height;
	ball = new Ball(400, 300, (int) Math.ceil(0.0125 * width), (int) Math.ceil(0.0125 * width), Color.BLACK, 6, -3);
	int paddleY = (int) (height * 0.75);
	int paddleWidth = (int) (0.1 * width);
	int paddleHeight = (int) (0.05 * height);
	int paddleSpeed = (int) (0.00833333 * width);
	
	paddle = new Paddle(width / 2, paddleY, paddleWidth, paddleHeight, paddleSpeed);
	
	int wallHeight = (int) (width * 0.0375);
	int botWallY = height - wallHeight;
	topWall = new Wall(0, 0, width, wallHeight, Color.GRAY);
	botWall = new Wall(0, botWallY - brokenOffsetY, width, wallHeight, Color.CYAN);

	int rightWallX = width - wallHeight;
	int lrWallHeight = (botWallY - (wallHeight) - brokenOffsetY);
	leftWall = new Wall(0, wallHeight, wallHeight, lrWallHeight, Color.GRAY);
	rightWall = new Wall(rightWallX - brokenOffsetX, wallHeight, wallHeight + 100, lrWallHeight, Color.GRAY);
	score = new Score(Color.BLACK, Color.BLUE);

    keys = new boolean[2];

    setBackground(Color.WHITE);
    setVisible(true);
		
    new Thread(this).start();
    addKeyListener(this);
  }
	
  public void update(Graphics window){
    paint(window);
  }

  public void paint(Graphics window)
  {
    Graphics2D twoDGraph = (Graphics2D)window;
    if(back==null)
      back = (BufferedImage)(createImage(getWidth(),getHeight()));
    Graphics graphToBack = back.createGraphics();
    
    ball.moveAndDraw(graphToBack);
    paddle.draw(graphToBack);
    topWall.draw(graphToBack);
    botWall.draw(graphToBack);
    rightWall.draw(graphToBack);
    leftWall.draw(graphToBack);
    score.draw(graphToBack, pscore, width, height);
    for (Block b : bricks) {
    	if (b.getColor() != Color.WHITE) {
    		b.draw(graphToBack);
	        if ((ball.didCollideBottom(b) || ball.didCollideTop(b) || ball.didCollideRight(b) || ball.didCollideLeft(b))) {
	        	pscore++;
	        	score.updateScore(graphToBack, pscore, width, height);
	        	b.setColor(Color.WHITE);
	        	b.draw(graphToBack);
	        	if (ball.didCollideBottom(b) || ball.didCollideTop(b)) {
				    ball.setYSpeed(-ball.getYSpeed());
				    ball.moveAndDraw(graphToBack);
				    ball.moveAndDraw(graphToBack);
	        	} else {
	        		ball.setXSpeed(-ball.getXSpeed());
	        		ball.moveAndDraw(graphToBack);
	        		ball.moveAndDraw(graphToBack);
	        	}
	        	if (ball.didCollideTop(b)) {
		        	System.out.println("X " + b.getX());
		        	System.out.println("CX " + b.getCX());
		        	System.out.println("Y " + b.getY());
		        	System.out.println("CY " + b.getCY());
		        	System.out.println(ball);
	        	}
			    break;
	        }
    	}
    }
    
    boolean check = true;
    for (Block b : bricks) {
    	if (b.getColor() == Color.WHITE) {
    		check = true;
    	} else {
    		check = false;
    		break;
    	}
    }
    
    if (check) {
    	score.updateScore(graphToBack, pscore, width, height);
        graphToBack.setColor(Color.GREEN);
        graphToBack.drawString("GAME WON!", 400, 500);
        gameactive = false;
    }
    
    if (ball.didCollideBottom(topWall)) {
        ball.setYSpeed(-ball.getYSpeed());
    }
    if (ball.didCollideRight(rightWall)) {
    	ball.setXSpeed(-ball.getXSpeed());
    }
    if (ball.didCollideLeft(leftWall)) {
    	ball.setXSpeed(-ball.getXSpeed());
    }
    if (ball.didCollideRight(paddle)) {
    	ball.setXSpeed(-ball.getXSpeed());
    }
    if (ball.didCollideLeft(paddle)) {
    	ball.setXSpeed(-ball.getXSpeed());
    }
    
    if (ball.didCollideTop(botWall)) {
    	score.updateScore(graphToBack, pscore, width, height);
        ball.setYSpeed(-ball.getYSpeed());
        graphToBack.setColor(Color.RED);
        graphToBack.drawString("GAME OVER", 400, 500);
        gameactive = false;
    }

    if (ball.didCollideTop(paddle)) {
    	ball.setYSpeed(-ball.getYSpeed());
    }
    
    if (ball.didCollideBottom(paddle)) { 
    	ball.setYSpeed(-ball.getYSpeed());
    }
    
	if (keys[0])
    {
	    if (paddle.getX() >= leftWall.getCX()) {
	      paddle.moveLeftAndDraw(graphToBack);
	    }
    }
    if (keys[1])
    {
    	if (paddle.getCX() <= rightWall.getX()) {
    		paddle.moveRightAndDraw(graphToBack);
    	}
    }

    twoDGraph.drawImage(back, null, 0, 0);
  }

  public void keyPressed(KeyEvent e)
  {
    switch(toUpperCase(e.getKeyChar()))
    {
    case 'F' : keys[0]=true; break;
    case 'G' : keys[1]=true; break;
    }
  }

  public void keyReleased(KeyEvent e)
  {
    switch(toUpperCase(e.getKeyChar()))
    {
    case 'F' : keys[0]=false; break;
    case 'G' : keys[1]=false; break;
    }
  }

  public void keyTyped(KeyEvent e){}
	
  public void run()
  {
    try
    {
      while(gameactive)
      {
	Thread.currentThread().sleep(8);
	repaint();
      }
    }catch(Exception e)
    {
    }
  }	
}