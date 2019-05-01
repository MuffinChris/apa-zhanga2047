//(c) A+ Computer Science
//www.apluscompsci.com
//Name -

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.io.File;
import javax.imageio.ImageIO;

public class Ammo extends MovingThing
{
  private int speed;
  private int xspeed;
  private Color color;

  public Ammo()
  {
    this(0,0,0, Color.YELLOW, 0);
  }

  public Ammo(int x, int y)
  {
    //add code
	  this(x,y,3, Color.YELLOW, 0);
  }

  public Ammo(int x, int y, int s, Color color, int xspeed)
  {
    //add code
	  setX(x);
	  setY(y);
	  setSpeed(s);
	  this.xspeed = xspeed;
	  this.color = color;
  }

  public void setSpeed(int s)
  {
    //add code
	  speed = s;
  }
  
  public void setxSpeed(int s) {
	  xspeed = s;
  }

  public int getSpeed()
  {
    return speed;
  }

  public void draw( Graphics window )
  {
    //add code to draw the ammo
	  window.setColor(color);
	  window.fillRect(getX(),getY(),getWidth(),getHeight());
  }
        
        
  public void move( String direction )
  {
    //add code to draw the ammo
	  if (direction.equalsIgnoreCase("UP")) {
		  setY(getY() + speed);
		  setX(getX() + xspeed);
	  }
  }

  public String toString()
  {
    return "";
  }

	public Color getColor() {
		return color;
	}
}
