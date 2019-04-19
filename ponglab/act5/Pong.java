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

public class Pong extends Canvas implements KeyListener, Runnable
{
  private Ball ball;
  private Paddle leftPaddle;
  private Paddle rightPaddle;
  private boolean[] keys;
  private BufferedImage back;
  private int redScore = 0;
  private int blueScore = 0;
  private Wall topWall;
  private Wall botWall;
  private Wall rightWall;
  private Wall leftWall;
  private Score score;
  private int width;
  private int height;

  public Pong(int width, int height)
  {
    //set up all variables related to the game
	  // USE WITH AIDENS PC
	int brokenOffsetX = (int) (width * 0.02);
	int brokenOffsetY = (int) (height * 0.05);
	//int brokenOffsetX = 0;
	//int brokenOffsetY = 0;
	
	this.width = width;
	this.height = height;
	ball = new SpeedUpBall(width/2, height/2, (int) Math.ceil(0.0125 * width), (int) Math.ceil(0.0125 * width));
	System.out.println(ball.getWidth());
	int paddleX = (int) (width * 0.125);
	int paddleY = (int) (height * 0.5);
	int paddleWidth = (int) (0.0125 * width);
	int paddleHeight = (int) (0.1 * height);
	int paddleSpeed = (int) (0.00833333 * height);
	
	leftPaddle = new Paddle(paddleX, paddleY, paddleWidth, paddleHeight, Color.BLUE, paddleSpeed);
	rightPaddle = new Paddle(width - paddleX - paddleWidth, paddleY, paddleWidth, paddleHeight, Color.RED, paddleSpeed);
	
	int wallHeight = (int) (width * 0.0375);
	int botWallY = height - wallHeight;
	topWall = new Wall(0, 0, width, wallHeight, Color.GRAY);
	botWall = new Wall(0, botWallY - brokenOffsetY, width, wallHeight, Color.GRAY);

	int rightWallX = width - wallHeight;
	int lrWallHeight = (botWallY - (wallHeight) - brokenOffsetY);
	leftWall = new Wall(0, wallHeight, wallHeight, lrWallHeight, Color.CYAN);
	rightWall = new Wall(rightWallX - brokenOffsetX, wallHeight, wallHeight, lrWallHeight, Color.CYAN);
	score = new Score(Color.BLACK, Color.BLUE, Color.RED);

    keys = new boolean[4];

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
    leftPaddle.draw(graphToBack);
    rightPaddle.draw(graphToBack);
    topWall.draw(graphToBack);
    botWall.draw(graphToBack);
    rightWall.draw(graphToBack);
    leftWall.draw(graphToBack);
    score.draw(graphToBack, redScore, blueScore, width, height);

    if(ball.didCollideRight(rightWall) || ball.didCollideLeft(leftWall))
    {
    	if(ball.didCollideLeft(leftWall))
        {
          redScore++;
        } else {
          blueScore++;
        }
	    	score.updateScore(graphToBack, redScore, blueScore, width, height);
	    	Ball clearb = new Ball(ball.getX(), ball.getY(), ball.getWidth(), ball.getHeight(), Color.WHITE);
	    	ball.reset(width, height);
	    	clearb.draw(graphToBack);
		    ball.setXSpeed(-ball.getXSpeed());
		    ball.setYSpeed((int) (Math.random() * 2 + 1));
    }

    if (ball.didCollideTop(topWall)) {
        ball.setYSpeed(-ball.getYSpeed());
    	
    }
    
    if (ball.didCollideBottom(botWall)) {
        ball.setYSpeed(-ball.getYSpeed());
    	
    }

    if (ball.didCollideLeft(leftPaddle)) {
    	if (ball.getX() <= leftPaddle.getCX() - Math.abs(ball.getXSpeed())) {
			ball.setYSpeed(-ball.getYSpeed());
		} else {
			ball.setXSpeed(-ball.getXSpeed());
		}
    }
    
    if (ball.didCollideRight(rightPaddle)) { 
    	if (ball.getX() >= rightPaddle.getX() + Math.abs(ball.getXSpeed())) {
			ball.setYSpeed(-ball.getYSpeed());
		} else {
			ball.setXSpeed(-ball.getXSpeed());
		}
    }
    
	if (keys[0])
    {
	    if (leftPaddle.getY() >= topWall.getCY()) {
	      leftPaddle.moveUpAndDraw(graphToBack);
	    }
    }
    if (keys[1])
    {
    	if (leftPaddle.getCY() <= botWall.getY()) {
    		leftPaddle.moveDownAndDraw(graphToBack);
    	}
    }
    if (keys[2])
    {
    	if (rightPaddle.getY() >= topWall.getCY()) {
  	      rightPaddle.moveUpAndDraw(graphToBack);
  	    }
    	
    }
    if (keys[3])
    {
    	if (rightPaddle.getCY() <= botWall.getY()) {
    		rightPaddle.moveDownAndDraw(graphToBack);
    	}
    }

    twoDGraph.drawImage(back, null, 0, 0);
  }

  public void keyPressed(KeyEvent e)
  {
    switch(toUpperCase(e.getKeyChar()))
    {
    case 'W' : keys[0]=true; break;
    case 'S' : keys[1]=true; break;
    case 'I' : keys[2]=true; break;
    case 'K' : keys[3]=true; break;
    }
  }

  public void keyReleased(KeyEvent e)
  {
    switch(toUpperCase(e.getKeyChar()))
    {
    case 'W' : keys[0]=false; break;
    case 'S' : keys[1]=false; break;
    case 'I' : keys[2]=false; break;
    case 'K' : keys[3]=false; break;
    }
  }

  public void keyTyped(KeyEvent e){}
	
  public void run()
  {
    try
    {
      while(true)
      {
	Thread.currentThread().sleep(8);
	repaint();
      }
    }catch(Exception e)
    {
    }
  }	
}