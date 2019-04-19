//(c) A+ Computer Science
//www.apluscompsci.com
//Name -

import java.awt.Color;
import java.awt.Graphics;

public class Paddle extends Block
{
  //instance variables
  private int speed;

  public Paddle()
  {
    super(10,10);
    speed =5;
  }


  //add the other Paddle constructors
  public Paddle(int xPos) {
	  this(xPos, 150, 10, 10, Color.BLACK, 5);
  }
  
  public Paddle(int xPos, int yPos) {
	  this(xPos, yPos, 10, 10, Color.BLACK, 5);
  }
  
  public Paddle(int xPos, int yPos, int speed) {
	  this(xPos, yPos, 10, 10, Color.BLACK, speed);
  }
	
  public Paddle(int xPos, int yPos, int width, int height) {
	  this(xPos, yPos, width, height, Color.BLACK, 5);
  }
  
  public Paddle(int xPos, int yPos, int width, int height, int speed) {
	  this(xPos, yPos, width, height, Color.BLACK, speed);
  }
  
  public Paddle(int xPos, int yPos, int width, int height, Color color, int speed) {
	  setX(xPos);
	  setY(yPos);
	  setWidth(width);
	  setHeight(height);
	  setColor(color);
	  this.speed = speed;
  }
  
  public void setSpeed(int s) {
	  speed = s;
  }

  public void moveLeftAndDraw(Graphics window)
  {
	//draw a white paddle at old paddle location
	  window.setColor(Color.WHITE);
	  window.fillRect(getX(), getY(), getWidth(), getHeight());
    //setY
    setX(getX()-speed);
    //draw the ball at its new location

	  window.setColor(getColor());
	  window.fillRect(getX(), getY(), getWidth(), getHeight());

  }

  public void moveRightAndDraw(Graphics window)
  {
	//draw a white paddle at old paddle location
	  window.setColor(Color.WHITE);
	  window.fillRect(getX(), getY(), getWidth(), getHeight());
    //setY
    setX(getX()+speed);
    //draw the ball at its new location

	  window.setColor(getColor());
	  window.fillRect(getX(), getY(), getWidth(), getHeight());

  }

  //add get methods
   public int getSpeed() {
	   return speed;
   }
   
  //add a toString() method
   public String toString() {
	   return super.toString() + " " + speed;
   }
}