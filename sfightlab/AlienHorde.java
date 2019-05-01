//(c) A+ Computer Science
//www.apluscompsci.com
//Name -

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.io.File;
import javax.imageio.ImageIO;
import java.util.ArrayList;
import java.util.List;

public class AlienHorde
{
  private List<Alien> aliens;
  int size;

  public int getSize() {
	  return size;
  }
  
  public AlienHorde(int size)
  {
	  aliens = new ArrayList<Alien>(size);
	  this.size = size;
	  populate();
  }

  public void add(Alien al)
  {
	  aliens.add(al);
  }

  public void drawEmAll( Graphics window )
  {
	  for (Alien al : aliens) {
		  al.draw(window);
	  }
  }

  public void moveEmAll()
  {
	  for (Alien al : aliens) {
		  al.move();
	  }
  }
  
  public void populate() {
	  int basex = 25;
	  int basey = 100;
	  int iterx = 50;
	  int xcnt = 0;
	  int ycnt = 0;
	  int itery = 75;
	  int speed = 1;
	  for (int i = 0; i < size; i++) {
			  if (basex + iterx * xcnt > StarFighter.WIDTH - basex * 2) {
				  ycnt++;
				  xcnt = 0;
				  speed = -speed;
			  }
			  Alien al = new Alien(basex + iterx * xcnt, basey + itery * ycnt, 50, 50, speed);
			  xcnt++;
			  aliens.add(al);
	  }
  }
  
  public void removeDeadOnes(List<Ammo> shots)
  {
	  for (Ammo a : shots) {
	    	for (Alien al : getList()) {
	    		if (a.getColor() != Color.RED) {
	    			if (al.getLife()) {
			    		if (a.getY() <= al.getY() + al.getHeight() && a.getY() + a.getHeight() >= al.getY()) {
				    		if ((a.getX() >= al.getX() && a.getX() + a.getWidth() <= al.getX() + al.getWidth())) {
				    			al.die();
				    		}
			    		}
			    		}
	    		}
	    	}
	    }
	  size = 1;
	  for (Alien al : aliens) {
		  if (!al.getLife()) {
			  al.setSpeed(0);
			  al.setY(-300);
		  } else {
			  size++;
		  }
	  }
	  size-=1;
  }
  
  public List<Alien> getList() {
	  return aliens;
  }

  public String toString()
  {
    return "";
  }
}
