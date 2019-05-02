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
  
  public void setSize(int s) {
	  size = s;
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
	  int basey = -50;
	  int iterx = 50;
	  int xcnt = 0;
	  int ycnt = 0;
	  int itery = 75;
	  int speed = 1;
	  String type = "Alien";
	  for (int i = 0; i < size; i++) {
		  int z = (int) (Math.random() * 7);
		  if (z <= 4) {
			  type = "alien";
		  } else if (z > 4 && z < 6) { 
			  type = "railgun";
		  } else { 
			  type = "fast";
		  }
			  if (basex + iterx * xcnt > StarFighter.WIDTH - basex * 2) {
				  ycnt++;
				  xcnt = 0;
				  speed = -speed;
			  }
			  Alien al = new Alien(basex + iterx * xcnt, basey + itery * ycnt, 50, 50, speed, 1, type);
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
				    			if (al.getHp() > 1) {
				    				al.die();
				    				if (!al.getLife()) {
					    				
						    			al.setSpeed(0);
					    				al.setY(-600);
					    				
					    			}
				    				a.setSpeed(0);
				    				a.setxSpeed(0);
				    				a.setY(-100);
				    			} else {
					    			al.die();
					    			if (!al.getLife()) {
						    			al.setSpeed(0);
					    				al.setY(-300);
					    			}
				    			}
				    		}
			    		}
			    		}
	    		}
	    	}
	    }
	  for (int i = aliens.size() - 1; i >= 0; i--) {
		  Alien al = aliens.get(i);
		  if (!al.getLife()) {
		      al.setSpeed(0);
			  al.setY(-300);
			  size--;
			  aliens.remove(i);
		  }
	  }
  }
  
  public List<Alien> getList() {
	  return aliens;
  }

  public String toString()
  {
    return "";
  }
}
