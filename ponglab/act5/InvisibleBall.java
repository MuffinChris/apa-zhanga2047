import java.awt.Color;
import java.awt.Graphics;

public class InvisibleBall extends Ball {
	
	private int ticktime = 300;
	private boolean tickinvis = false;
	
	public InvisibleBall(int x, int y, int wid, int h) {
		super (x, y, wid, h);
	}
	
	public InvisibleBall(int x, int y, int wid, int h, Color col) {
		super (x, y, wid, h, col);
	}
	
	public InvisibleBall(int x, int y, int wid, int h, Color col, int xs, int ys) {
		super (x, y, wid, h, col, xs, ys);
	}
	
	public void moveAndDraw(Graphics window)
	  {
		System.out.println(ticktime);
		ticktime--;
		if (ticktime == 0) {
			if (tickinvis) {
				ticktime = (int) (Math.random() * 400);
			} else {
				ticktime = (int) (Math.random() * 100);
			}
			tickinvis = !tickinvis;
		}
	    //draw a white ball at old ball location
		  window.setColor(Color.WHITE);
		  window.fillOval(getX(), getY(), getWidth(), getHeight());

	    setX(getX()+getXSpeed());
	    //setY
	    setY(getY()+getYSpeed());
	    //draw the ball at its new location
	    if (tickinvis) {
	    	window.setColor(Color.WHITE);
	    } else {
	    	window.setColor(getColor());
	    }
		  window.fillOval(getX(), getY(), getWidth(), getHeight());
	  }

}
