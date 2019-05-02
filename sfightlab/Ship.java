//(c) A+ Computer Science
//www.apluscompsci.com
//Name -

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import javax.imageio.ImageIO;

public class Ship extends MovingThing
{
  private int speed;
  private Image image;
  private boolean cooldown = true;
  private int cdticker;
  
  
  private int scd = 200;
  
  public int getSCD() {
	  return scd;
  }
  
  public void setSCD(int s) {
	  scd = s;
  }
  
  private int basecd = 50;

  public Ship()
  {
    this(10,10,10,10,10);
  }

  public Ship(int x, int y)
  {
    //add code here
	  super(x,y);
	  image = getImage();
  }

  public Ship(int x, int y, int s)
  {
    //add code here
	  super(x,y);
	  speed = s;
	  image = getImage();
  }

  public Ship(int x, int y, int w, int h, int s)
  {
    super(x, y, w, h);
    cdticker = basecd;
    speed=s;/*try
    {
    URL url = getClass().getResource("ship.jpg");
    image = ImageIO.read(url);
  }
  catch(Exception e)
  {
    //feel free to do something here
  	e.printStackTrace();
  }*/
    image = getImage();
  }
  
  public Image getImage() {
	  Image im = null;
	  File imgPath = new File("ship.jpg");
	    try {
			im = ImageIO.read(imgPath);
		} catch (IOException e) {
			e.printStackTrace();
		}
	    return im;
  }


  public void setSpeed(int s)
  {
    //add more code
	  speed = s;
  }
  
  public int getTicker() {
	  return cdticker;
  }
  
  public void setTicker(int i) {
	  cdticker = i;
  }
  
  public boolean getCD() {
	  return cooldown;
  }
  
  public void toggleCD() {
	  cooldown =! cooldown;
  }
  
  public void setbasecd(int i) {
	  basecd = i;
  }
  
  public int getSpeed()
  {
    return speed;
  }

  public void move(String direction)
  {
    //add code here
	  if (direction.equalsIgnoreCase("LEFT")) {
		  if (getX() > 0) {
			  setPos(getX() - speed, getY());
		  }
	  }
	  if (direction.equalsIgnoreCase("RIGHT")) {
		  if (getX() < StarFighter.WIDTH) {
			  setPos(getX() + speed, getY());
		  }
	  }
	  if (direction.equalsIgnoreCase("UP")) {
		  if (getY() > 0) {
			  setPos(getX(), getY() - speed);
		  }
	  }
	  if (direction.equalsIgnoreCase("DOWN")) {
		  if (getY() < StarFighter.HEIGHT) {
			  setPos(getX(), getY() + speed);
		  }
	  }
  }
  
  public void shoot(Graphics window) {
	  if (cooldown) {
		  toggleCD();
		  cdticker = basecd;
	  }
  }

  public void draw( Graphics window )
  {
    window.drawImage(image,getX(),getY(),getWidth(),getHeight(),null);
  }

  public String toString()
  {
    return super.toString() + getSpeed();
  }
}
