//(c) A+ Computer Science
//www.apluscompsci.com
//Name -

import java.awt.Color;
import java.awt.Graphics;

public class Block implements Locatable
{
  private int xPos;
  private int yPos;
  private int width;
  private int height;

  private Color color;

  public Block()
  {
	  
	  this(100, 150, 10, 10, Color.BLACK);

  }

  //add other Block constructors - x , y , width, height, color
	
  public Block(int xPos) {
	  this(xPos, 150, 10, 10, Color.BLACK);
  }
  
  public Block(int xPos, int yPos) {
	  this(xPos, yPos, 10, 10, Color.BLACK);
  }
  
  public Block(int xPos, int yPos, int width) {
	  this(xPos, yPos, width, 10, Color.BLACK);
  }
	
  public Block(int xPos, int yPos, int width, int height) {
	  this(xPos, yPos, width, height, Color.BLACK);
  }
  
  public Block(int xPos, int yPos, int width, int height, Color color) {
	  this.xPos = xPos;
	  this.yPos = yPos;
	  this.width = width;
	  this.height = height;
	  this.color = color;
  }

  //add the other set methods
   

  public void setColor(Color col)
  {

	  color = col;
  }
  
  public void setX(int x) {
	  xPos = x;
  }
  
  public void setY(int y) {
	  yPos = y;
  }
  
  public void setWidth(int w) {
	  width = w;
  }
  
  public void setHeight(int h) {
	  height = h;
  }
  
  public int getX() {
	return xPos;  
  }
  public int getY() {
		return yPos;  
	  }
  public int getWidth() {
		return width;  
	  }
  public int getHeight() {
		return height;  
  }
  public Color getColor() {
	  return color;
  }
  

  public void draw(Graphics window)
  {
    //uncomment after you write the set and get methods
    //window.setColor(color);
    //window.fillRect(getX(), getY(), getWidth(), getHeight());
	  window.setColor(color);
	  window.fillRect(getX(), getY(), getWidth(), getHeight());
  }

  public void draw(Graphics window, Color col)
  {
	  window.setColor(col);
	  window.fillRect(getX(), getY(), getWidth(), getHeight());

  }
   
  public boolean equals(Object obj)
  {
	  Block b = (Block) obj;
	  
	  return (b.getX() == getX() && b.getY() == getY() && b.getWidth() == getWidth() 
			  && b.getHeight() == getHeight() && b.getColor() == getColor());
  }   

  //add the other get methods
    

  //add a toString() method  - x , y , width, height, color
  public String toString() {
	  return (getX() + " " + getY() + " " + getWidth() + " " + getHeight() + " " + getColor());
  }

	@Override
	public void setPos(int x, int y) {
		setX(x);
		setY(y);
		
	}
}