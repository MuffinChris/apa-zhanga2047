//(c) A+ Computer Science
//www.apluscompsci.com
//Name -

import java.awt.Color;
import java.awt.Graphics;

public class Ball extends Block
{
  private int xSpeed;
  private int ySpeed;

  public Ball()
  {
    super(200,200);
    xSpeed = 3;
    ySpeed = 1;
  }

  //add the other Ball constructors
  public Ball(int xPos) {
	  this(xPos, 150, 10, 10, Color.BLACK, 3, 1);
  }
  
  public Ball(int xPos, int yPos) {
	  this(xPos, yPos, 10, 10, Color.BLACK, 3, 1);
  }
  
  public Ball(int xPos, int yPos, int width) {
	  this(xPos, yPos, width, 10, Color.BLACK, 3, 1);
  }
	
  public Ball(int xPos, int yPos, int width, int height) {
	  this(xPos, yPos, width, height, Color.BLACK, 3, 1);
  }
  
  public Ball(int xPos, int yPos, int width, int height, Color color) {
	  this(xPos, yPos, width, height, color, 3, 1);
  }
  
  public Ball(int xPos, int yPos, int width, int height, Color color, int xSpeed) {
	  this(xPos, yPos, width, height, color, xSpeed, 1);
  }
  
  public Ball(int xPos, int yPos, int width, int height, Color color, int xSpeed, int ySpeed) {
	  setX(xPos);
	  setY(yPos);
	  setWidth(width);
	  setHeight(height);
	  setColor(color);
	  this.xSpeed = xSpeed;
	  this.ySpeed = ySpeed;
  }

	   
  //add the set methods
  public void setXSpeed(int xs) {
	  xSpeed = xs;
  }
  public void setYSpeed(int ys) {
	  ySpeed = ys;
  }

  public void moveAndDraw(Graphics window)
  {
    //draw a white ball at old ball location
	  window.setColor(Color.WHITE);
	  window.fillOval(getX(), getY(), getWidth(), getHeight());

    setX(getX()+xSpeed);
    //setY
    setY(getY()+ySpeed);
    //draw the ball at its new location

	  window.setColor(getColor());
	  window.fillOval(getX(), getY(), getWidth(), getHeight());
  }
   
  public boolean equals(Object obj)
  {
	Ball b = (Ball) obj;
	return (super.equals(obj) && b.getXSpeed() == getXSpeed() && b.getYSpeed() == getYSpeed());
  }   

  //add the get methods
  public int getXSpeed() {
	  return xSpeed;
  }
  public int getYSpeed() {
	  return ySpeed;
  }

  //add a toString() method
  public String toString() {
	  return super.toString() + " " + getXSpeed() + " " + getYSpeed();
  }
}