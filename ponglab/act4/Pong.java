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
	  this.width = width;
	  this.height = height;
	ball = new Ball(width/2, height/2, (int) Math.ceil(0.0125 * width), (int) Math.ceil(0.0125 * width));
	System.out.println(ball.getWidth());
	int paddleWidth = (int) (width * 0.125);
	int paddleHeight = (int) (height * 0.5);
	int paddleDWidth = (int) (0.0125 * width);
	int paddleDHeight = (int) (0.1 * height);
	
	leftPaddle = new Paddle(paddleWidth, paddleHeight, paddleDWidth, paddleDHeight, Color.BLUE, 5);
	rightPaddle = new Paddle(width - paddleWidth - paddleDWidth, paddleHeight, paddleDWidth, paddleDHeight, Color.RED, 5);
	
	int wallHeight = (int) (width * 0.0375);
	int botWallY = (int) Math.ceil(height * 0.8566666);
	topWall = new Wall(0, 0, width, wallHeight, Color.GRAY);
	botWall = new Wall(0, botWallY, width, wallHeight * 2, Color.GRAY);
	
	int visWidth = botWallY;
	int rightWallX = width - wallHeight - 1;
	int lrWallHeight = (visWidth - (wallHeight));
	leftWall = new Wall(0, wallHeight, wallHeight, lrWallHeight, Color.CYAN);
	rightWall = new Wall(rightWallX, wallHeight, wallHeight, lrWallHeight, Color.CYAN);
	System.out.println(rightWall.getX());
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
          blueScore++;
        } else {
          redScore++;
        }
	    	score.updateScore(graphToBack, redScore, blueScore, width, height);
	    	Ball clearb = new Ball(ball.getX(), ball.getY(), ball.getWidth(), ball.getHeight(), Color.WHITE);
	    	ball.setPos(width/2, height/2);
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