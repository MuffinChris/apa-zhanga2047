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

public class Bullets
{
  private List<Ammo> ammo;

  public Bullets()
  {
	  ammo = new ArrayList<Ammo>();
  }

  public void add(Ammo al)
  {
	  ammo.add(al);
  }

  //post - draw each Ammo
  public void drawEmAll( Graphics window )
  {
	  for (Ammo a : ammo) {
		  a.draw(window);
	  }
  }

  public void moveEmAll()
  {
	  for (Ammo a : ammo) {
		  a.move("up");
	  }
  }

  public void cleanEmUp()
  {
	  for (int i = ammo.size() - 1; i >= 0; i--) {
		  Ammo a = ammo.get(i);
		  if ((a.getY() < 0 || a.getY() > StarFighter.HEIGHT + 500) || (a.getX() <= -500 || a.getX() >= StarFighter.WIDTH + 500)) {
			  a.setSpeed(0);
			  a.setxSpeed(0);
			  a.setY(-50);
			  ammo.remove(i);
		  }
	  }
  }

  public List<Ammo> getList()
  {
    return ammo;
  }

  public String toString()
  {
    return "";
  }
}
