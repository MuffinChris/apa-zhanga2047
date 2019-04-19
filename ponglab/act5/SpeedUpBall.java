//(c) A+ Computer Science
//www.apluscompsci.com
//Name -

import java.awt.Color;
import java.awt.Graphics;
import java.util.Random;

class SpeedUpBall extends Ball
{

  //instance variables
	private int smod = 0;
	private int cnter = 0;
	private int defx;
	private int defy;

  public SpeedUpBall()
  {
	  super();

  }

  public SpeedUpBall(int x, int y)
  {
	  super(x,y);

  }


  public SpeedUpBall(int x, int y, int xSpd, int ySpd)
  {

	  super(x,y,10, 10, Color.BLACK, (int) (xSpd/10), (int) (ySpd/10));
	  defx = xSpd/10;
	  defy = ySpd/10;
  }

  public SpeedUpBall(int x, int y, int wid, int ht, int xSpd, int ySpd)
  {
	  super(x,y,wid,ht,Color.BLACK,(int) (xSpd/10),(int) (ySpd/10));
	  defx = xSpd/10;
	  defy = ySpd/10;

  }


  public SpeedUpBall(int x, int y, int wid, int ht, Color col, int xSpd, int ySpd)
  {
	  super(x,y,wid,ht,col,(int) (xSpd/10),(int) (ySpd/10));
	  defx = xSpd/10;
	  defy = ySpd/10;


  }
  
  public void reset(int w, int h) {
	  setPos(w/2, h/2);
	  smod = 0;
	  defx = -defx;
	  defy = -defy;
	  super.setXSpeed(defx);
	  super.setYSpeed(defy);
  }

  public void setXSpeed( int xSpd )
  {
	  cnter++;
	  if (cnter == 5) {
		  smod+=1;
		  if (xSpd > 0) {
			  super.setXSpeed(xSpd + smod);
		  } else {
			  super.setXSpeed(xSpd - smod);
		  }
		  cnter = 0;
	  } else {
		  super.setXSpeed(xSpd);
	  }

  }

  public void setYSpeed( int ySpd )
  {
	  cnter++;
	  if (cnter == 5) {
		  smod+=1;
		  if (ySpd > 0) {
			  super.setYSpeed(ySpd + smod);
		  } else {
			  super.setYSpeed(ySpd - smod);
		  }
		  cnter = 0;
	  } else {
		  super.setYSpeed(ySpd);
	  }
  }
}

