//(c) A+ Computer Science
//www.apluscompsci.com
//Name -

import java.io.File;
import java.net.URL;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import javax.imageio.ImageIO;

public class Alien extends MovingThing
{
  private int speed;
  private Image image;
  private boolean life;
  private int hp;

  public Alien()
  {
    this(0,0,30,30,0, 1);
  }

  public Alien(int x, int y)
  {
    //add code here
	  this(x, y, 50, 50, 3, 1);
  }

  public Alien(int x, int y, int s)
  {
    //add code here
	  this(x, y, 50, 50, s, 1);
  }

  public Alien(int x, int y, int w, int h, int s, int hp)
  {
    super(x, y, w,h);
    speed=s;
    life = true;
    this.hp = hp;
    try
    {
      URL url = getClass().getResource("alien.jpg");
      image = ImageIO.read(url);
    }
    catch(Exception e)
    {
      //feel free to do something here
    	e.printStackTrace();
    }
  }

  public void setSpeed(int s)
  {
    //add code
	  speed = s;
  }
  
  public void die() {
	  hp--;
	  if (hp <= 0) {
		  life = false;
	  }
  }
  
  public boolean getLife() {
	  return life;
  }

  public int getHp() {
	  return hp;
  }
  
  public int getSpeed()
  {
    return speed;
  }

  public void move()
  {
    //add code here
	  setX(getX() + speed);
	  if (getX() < -25 || getX() > StarFighter.WIDTH) {
		  setY(getY() + 75);
		  setSpeed(-speed);
	  }
  }

  public void draw( Graphics window )
  {
    window.drawImage(image,getX(),getY(),getWidth(),getHeight(),null);
  }

  public String toString()
  {
    return "";
  }

@Override
public void move(String direction) {
	//this is wrong lol
	
}
}
